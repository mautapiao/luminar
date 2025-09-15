package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.Button
import androidx.compose.ui.Alignment
import cl.duocuc.lumina2.data.interfaces.PasswordGenerator
import cl.duocuc.lumina2.utils.BasePasswordGenerator
import cl.duocuc.lumina2.utils.StrongPasswordGenerator
import cl.duocuc.lumina2.data.repository.UserRepository
import cl.duocuc.lumina2.utils.Globals


/**
 * Info es una vista para dar información básica para usuario
 * de la fuerza de contraseña
 * además permite que pueda generar contraseñas
 * para su uso
 */
@Composable
fun Info(userName: String, onBack: () -> Unit) {

    var displayedText by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    // trimIndent() función de Kotlin utilizada para eliminar
    // una cantidad constante de espacios en blanco al principio
    // de cada línea de una cadena multilínea
    //
    // La idea era hacer una marquesina tipo años 2000 pero se me
    // paso el tiempo

    val email = Globals.userEmail;
    val passwordAux = UserRepository.userPasswordSecurity(email.toString())
    val info = UserRepository.userInfo(email.toString())

    val fullText = """
    $info
    $passwordAux
    
""".trimIndent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .padding(16.dp)
            .clickable { onBack() },

        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Recomendador de Contraseñas",
            fontSize = 40.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            lineHeight = 56.sp
        )

        Spacer(Modifier.height(25.dp))

        Text(
            text = fullText,
            fontSize = 30.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 50.sp
            )
        )

        Button(onClick = {
            // CREA ONJETO de la clase StrongPasswordGenerator
            // pasa el 10 al constructor, esto define que la contraseña tedrá un largo de 10
            // caracteres
            // Guarda el objeto en generator
            val generator = StrongPasswordGenerator(10)

            // Llama al metodo generate() del objeto generator
            // este metodo devuelve un String con la contraseña generada
            // el valor se asigna a la variable password
            password = generator.generate()

            // Polimorfismo: aunque el tipo es PasswordGenerator,
            // en tiempo de ejecución se comporta distinto.
            val simpleGen: PasswordGenerator = BasePasswordGenerator(8)    // Constructor (8)
            val strongGen: PasswordGenerator = StrongPasswordGenerator(12) // Constructor (12)

            println("Contraseña simple: ${simpleGen.generate()}")
            println("Contraseña fuerte: ${strongGen.generate()}")

        }) {
            Text("Generar Contraseña", fontSize = 30.sp)
        }

        Spacer(modifier = Modifier.height(30.dp))

        if (password.isNotEmpty()) {
            Text(
                text = "Le recomendamos esta contraseña",
                fontSize = 30.sp,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = 50.sp
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "$password",
                fontSize = 35.sp,
                color = Color.White.copy(alpha = 0.9f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyLarge.copy(
                    lineHeight = 50.sp
                )
            )

        }


    }

}

@Preview(showBackground = true)
@Composable
fun PreviewMarqueeText() {
    Info("Juan", onBack = {})
}
