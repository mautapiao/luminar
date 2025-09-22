package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// Content Providers (simulado con lista de datos)
@Composable
fun IndicadorContentProvider() {
    val fakeData = listOf("UF", "UTM", "IPC","USD")
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF3E5F5))
            .padding(12.dp)
    ) {
        fakeData.forEach { item ->
            Text(item, fontSize = 14.sp)
        }
    }
}