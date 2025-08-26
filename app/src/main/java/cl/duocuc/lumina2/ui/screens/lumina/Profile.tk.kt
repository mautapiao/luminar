package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp


// Pantallas adicionales para probar
@Composable
fun ProfileScreen() {
    Text(
        text = "Pantalla de Perfil",
        fontSize = 24.sp,
        color = Color.Green,
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize(Alignment.Center)
    )
}
