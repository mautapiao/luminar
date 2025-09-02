package cl.duocuc.lumina2.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.duocuc.lumina2.ui.screens.lumina.SimpleTopBar
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT_LABEL
import cl.duocuc.lumina2.ui.theme.FontSizes.TEXT_SIZE_INPUT
import cl.duocuc.lumina2.utils.runAllValidations

@Composable
fun RecuperarPasswordScreen(onBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    var validationResults by remember { mutableStateOf(listOf<String>()) }
    var linkEnviado by remember { mutableStateOf(false) }

    Scaffold(
        topBar = { SimpleTopBar(title = "Regresar", showBack = true, onBack = onBack) }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            // espacio que ayuda que no quede debajo de la topbar
            Spacer(Modifier
                .height(85.dp)
                .fillMaxWidth())

            // texto adecuado para la lectura
            Text("Recuperar contraseña", style = MaterialTheme.typography.headlineMedium)

            Spacer(Modifier.height(16.dp))

            // input de correo label incrementado
            OutlinedTextField(
                value = email,
                onValueChange = { email = it.lowercase() },
                // Etiqueta que aparece como placeholder y se anima al escribir
                label = { Text("Correo", fontSize = BUTTON_TEXT_LABEL.sp) },
                textStyle = LocalTextStyle.current.copy(fontSize = TEXT_SIZE_INPUT.sp),
                modifier = Modifier.fillMaxWidth(),

            )

            Spacer(Modifier.height(26.dp))

            Button(
                onClick = {
                    val results = runAllValidations(email)
                    validationResults = results // Para mostrar en pantalla

                    // Condición: que todas las validaciones contengan "."
                    // validar en la funcion y retornar true o false
                    // ta que estoy validando por contenido del texto etc.
                    val allValid = results.all { it.contains("Resultado") }


                    if (allValid) {

                        // aqui irian una logica para enviar un link
                        // y recuperar la clave
                        // aunque creo que para el caso real esta opción no sería relevante
                        // es una persona que tiene un condicion y lo que menos necesita son
                        // trabas y resulte que la app se vuelva poco practiva

                        println("Enviar email: $email")

                        linkEnviado = true
                        // ejecutar función
                        // onBack()

                    } else {
                        println("No se puede enviar, hay errores")
                    }

                },
                enabled = !linkEnviado,
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
               // Text("ENVIAR LINK", fontSize = BUTTON_TEXT.sp)
                Text(if (linkEnviado) "REVISE SU EMAIL" else "ENVIAR LINK", fontSize = BUTTON_TEXT.sp)
            }

            Spacer(Modifier.height(16.dp))

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
                Text("LOGIN", fontSize = BUTTON_TEXT.sp)
            }


            Spacer(modifier = Modifier.height(16.dp))

            // Mostrar cada resultado como una lista
            Column {
                validationResults.forEach { result ->
                    Text(
                        text = result,
                        style = MaterialTheme.typography.headlineMedium,
                        color = if (result.contains("Resultado")) Color.Green else Color.Red
                    )
                }
            }
        }




    }
}
