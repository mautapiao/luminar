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
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



@Composable
fun TextSizeSelector(  onBack: () -> Unit ){

    var minSize: Float = 10f
    var  maxSize: Float = 50f
    // Estado del tamaño del texto
    var textSize by remember { mutableStateOf(15f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .padding(16.dp)
            .clickable { onBack() },
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // Texto de ejemplo que se adapta al tamaño seleccionado
        Text(
            text = "Ves El Texto",
            fontSize = textSize.sp,
            color = Color.White.copy(alpha = 0.9f),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Slider para ajustar tamaño
        Slider(
            value = textSize,
            onValueChange = { textSize = it },
            valueRange = minSize..maxSize,
            steps = ((maxSize - minSize) / 1).toInt() - 1 // pasos de 1sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // Mostrar tamaño actual al usuario
        Text(
            text = "Tamaño: ${textSize.toInt()} sp",
            fontSize = 35.sp,
            modifier = Modifier.fillMaxWidth(),
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(30.dp))

        // info para el usuario
        Text(
            text = "Ajusta el tamaño del texto con el slider",
            fontSize = 35.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            lineHeight = 56.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        // indica la medida que se esta utilizando
        Text(
            text = "sp:píxeles escalables",
            fontSize = 25.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            lineHeight = 56.sp,
            modifier = Modifier.fillMaxWidth()

        )

    }
}

@Preview(showBackground = true)
@Composable
fun TextSizeSelector() {
    TextSizeSelector( onBack = {})
}

