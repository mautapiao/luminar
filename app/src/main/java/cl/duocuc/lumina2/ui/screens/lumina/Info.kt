package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT


/**
 * Info es una vista para dar información básica para usuario sobre la app
 * además se hace uso de variables globales que son enviadas
 * desde MyApp en la rutas como variables
 */
@Composable
fun Info(userName: String, onBack: () -> Unit) {

    var displayedText by remember { mutableStateOf("") }

    // trimIndent() función de Kotlin utilizada para eliminar
    // una cantidad constante de espacios en blanco al principio
    // de cada línea de una cadena multilínea
    //
    // La idea era hacer una marquesina tipo años 2000 pero se me
    // paso el tiempo

    val fullText = """
        
    Hola $userName
    
    Luminar es una App diseñada para apoyar a las personas con retinitis pigmentosa ,
    facilitando el acceso a distintos tipos de información útil.
""".trimIndent()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .padding(16.dp)
            .clickable{ onBack() },

        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(
            text = "Luminar v1",
            fontSize = 40.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(30.dp))

        Text(
            text = fullText,
            fontSize = 30.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyLarge.copy(
                lineHeight = 50.sp
            )
        )

     //   Spacer(Modifier.height(30.dp))

//        Button(
//            onClick = onBack,
//            modifier = Modifier
//                .fillMaxWidth()
//                .height(64.dp),
//            shape = RoundedCornerShape(12.dp),
//            colors = ButtonDefaults.buttonColors(
//                containerColor = MaterialTheme.colorScheme.primary,
//                contentColor = MaterialTheme.colorScheme.onPrimary
//            ),
//            elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
//        ) {
//            Text("MENÚ PRINCIPAL", fontSize = BUTTON_TEXT.sp)
//        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMarqueeText() {
    Info("Juan", onBack = {})
}
