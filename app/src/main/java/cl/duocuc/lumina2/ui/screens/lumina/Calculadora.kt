package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT

// Paleta
val FondoPrincipal   = Color(0xFF121212) // gris oscuro
val TextoPrimario    = Color(0xFFFFFFFF) // blanco
val BotonNumerico    = Color(0xFF1E1E1E) // gris más claro
val BotonOperacion   = Color(0xFF2196F3) // azul
val BotonResultado   = Color(0xFFFFEB3B) // amarillo

val BotonOpcion  = Color(0xFF1B263B) // Azul Gris

/**
 * Calculadora básica accecible con numeros grandes etc
 * Falta validar el largo de los números al sobrepasar el
 * ancho de la ventana etc. se solapa la fila
 * se trabaaja es eso
 * Considerar que se trabaja considerando la discapacidad
 */
@Composable
fun Calculadora(onBack: () -> Unit) {
    var display by remember { mutableStateOf("0") }
    var currentNumber by remember { mutableStateOf("") }
    var operator by remember { mutableStateOf("") }
    var previousNumber by remember { mutableStateOf("") }

    // tecla B
    fun limpiar(){
        display = "0"
        currentNumber = ""
        operator = ""
        previousNumber = ""
    }

    // tecla C
    fun borrarUltimo() {
        // Si el display solo tiene un carácter, lo dejo en "0"
        if (display.length == 1) {
            display = "0"
            currentNumber = ""
        } else {
            // Quitar el último carácter del display
            display = display.dropLast(1)
            currentNumber = display
        }
    }

    // agregar un número
    fun agregarNumero(numero: String) {
        // si el display es 0 display es igual al numero
        // numeroActual es igual al numero
        if (display == "0") {
            display = numero
            currentNumber = numero
        } else {

            // de lo contrario diaplay "concadena" el
            // nuevo numero y Numero Actual es igualmente

            display += numero
            currentNumber += numero
        }
    }


    fun agregarOperador(op: String) {
        if (currentNumber.isNotEmpty()) {
            previousNumber = currentNumber
            operator = op
            currentNumber = ""
            display += " $op "
        }
    }

    // función para igual
    fun calcular() {
        // Verificar que este todo lo necesario para calcular
        if (previousNumber == "") return
        if (currentNumber == "") return
        if (operator == "") return

        // Convertir los textos a números
        val numero1 = previousNumber.toDouble()
        val numero2 = currentNumber.toDouble()

        // Hacer la operación según el operador
        var resultado = 0.0

        if (operator == "+") {
            resultado = numero1 + numero2
        }
        if (operator == "-") {
            resultado = numero1 - numero2
        }
        if (operator == "×") {
            resultado = numero1 * numero2
        }
        if (operator == "÷") {
            if (numero2 != 0.0) {
                resultado = numero1 / numero2
            } else {
                resultado = 0.0  // No dividir por cero
            }
        }

        // Mostrar el resultado en pantalla
        // Si es un número entero, no mostrar decimales
        if (resultado == resultado.toInt().toDouble()) {
            display = resultado.toInt().toString()
        } else {
            display = resultado.toString()
        }

        // Preparar para la siguiente operación
        currentNumber = display
        previousNumber = ""
        operator = ""
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Pantalla de resultado
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(bottom = 16.dp),
            contentAlignment = Alignment.BottomEnd
        ) {
            Text(
                text = display, // valor inicial
                fontSize = 86.sp,
                fontWeight = FontWeight.Bold,
                color = TextoPrimario,
                lineHeight = 96.sp // aquí control el "alto de la fila"
                                   // ahora controlar el número  máximo
            )
        }

        // Teclado numérico y operaciones
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalcButton("B", BotonOpcion,onClick = { limpiar() })
                CalcButton("C", BotonOpcion,onClick = { borrarUltimo() })
                CalcButton("", BotonOpcion,onClick = { limpiar() })
                CalcButton("÷", BotonOperacion,onClick = { agregarOperador("÷") })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalcButton("7", BotonNumerico,onClick = { agregarNumero("7") })
                CalcButton("8", BotonNumerico,onClick = { agregarNumero("8")})
                CalcButton("9", BotonNumerico,onClick = { agregarNumero("9") })
                CalcButton("×", BotonOperacion,onClick = { agregarOperador("×") })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalcButton("4", BotonNumerico,onClick = { agregarNumero("4") })
                CalcButton("5", BotonNumerico,onClick = { agregarNumero("5") })
                CalcButton("6", BotonNumerico,onClick = { agregarNumero("6") })
                CalcButton("-", BotonOperacion,onClick = { agregarOperador("-") })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalcButton("1", BotonNumerico,onClick = { agregarNumero("1") })
                CalcButton("2", BotonNumerico,onClick = { agregarNumero("2") })
                CalcButton("3", BotonNumerico,onClick = { agregarNumero("3") })
                CalcButton("+", BotonOperacion,onClick = { agregarOperador("+") })
            }
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                CalcButton(".", BotonNumerico,onClick = { agregarNumero(".")  })
                CalcButton("0", BotonNumerico, onClick = { agregarNumero("0")  },Modifier.weight(2f))
                CalcButton("=", BotonResultado,onClick = { calcular() })
               // CalcButton("+", BotonOperacion)
            }

            Spacer(Modifier.height(1.dp))

            Button(
                onClick = onBack,
                //  modifier = Modifier.fillMaxWidth()
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Text("MENÚ PRINCIPAL", fontSize = BUTTON_TEXT.sp)
            }

        }
    }

}
/**
 *
 * .weight() solo funciona dentro de Row/Column
 * lo mas breve es declarar CalcButton como un RowScope.
 * Si se quiere usar dentro del botón → la función
 * debe ser RowScope.CalcButton, de  lo contrario no funciona weight(1f)
 *
 */
@Composable
fun RowScope.CalcButton(
    text: String,
    color: Color,
    onClick: () -> Unit, // Función simple sin parámetros
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = color,
            contentColor = if (color == BotonResultado) Color.Black else TextoPrimario
        ),
        shape = RoundedCornerShape(12.dp),
        modifier = modifier
            .weight(1f) // si no incluyo RowScope esta propiedad no funciona
            .height(64.dp)
    ) {
        Text(
            text = text,
            fontSize = 42.sp,
           // fontWeight = FontWeight.Bold
        )
    }
}

// preview
@Preview(
    showBackground = true,
    showSystemUi = true,
    name = "Calculadora Preview"
)
@Composable
fun CalculadoraPreview() {
    Calculadora({})
}