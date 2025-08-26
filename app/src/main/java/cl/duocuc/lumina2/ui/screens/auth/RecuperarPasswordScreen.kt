package cl.duocuc.lumina2.ui.screens.auth

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.duocuc.lumina2.ui.screens.lumina.SimpleTopBar
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT_LABEL
import cl.duocuc.lumina2.ui.theme.FontSizes.TEXT_SIZE_INPUT

@Composable
fun RecuperarPasswordScreen(onBack: () -> Unit) {
    var email by remember { mutableStateOf("") }
    Scaffold(
        topBar = { SimpleTopBar(title = "Regresar", showBack = true, onBack = onBack) }
    ) { padding ->
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        // espacio que ayuda que no quede debajo de la topbar
        Spacer(Modifier.height(85.dp).fillMaxWidth())

        // texto adecuado para la lectura
        Text("Recuperar contraseña", style = MaterialTheme.typography.headlineMedium)

        // input de correo label incrementado
        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            // Etiqueta que aparece como placeholder y se anima al escribir
            label = { Text("Correo", fontSize = BUTTON_TEXT_LABEL.sp) },
            textStyle = LocalTextStyle.current.copy(fontSize = TEXT_SIZE_INPUT.sp),
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(Modifier.height(16.dp))

        Button(
            onClick = onBack,
            modifier = Modifier.fillMaxWidth()) {
            Text("Enviar instrucciones", fontSize = BUTTON_TEXT.sp)
        }
    }
    }
}
