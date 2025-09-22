package cl.duocuc.lumina2.ui.screens.lumina

import android.R.attr.text
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun ColorTestCard(  onBack: () -> Unit )
{
    // Estado del color de fondo
    var backgroundColor by remember { mutableStateOf(randomColor()) }
    var text: String = "Pulsa aquí"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .padding(16.dp)
            .clickable { onBack() },
        verticalArrangement = Arrangement.spacedBy(16.dp)

    ) {
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            // un emoji
            text = "\uD83C\uDFA8",
            fontSize = 50.sp,
            color = Color.White.copy(alpha = 0.9f),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            lineHeight = 56.sp
        )

        Spacer(modifier = Modifier.height(30.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(140.dp)
                .clickable {
                    backgroundColor = randomColor() // cambia a color aleatorio
                }
                .padding(12.dp),
            colors = CardDefaults.cardColors(
                containerColor = backgroundColor
            ),
            shape = RoundedCornerShape(16.dp),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = text,
                    fontSize = 40.sp,
                    fontWeight = FontWeight.Bold,
                    color = androidx.compose.ui.graphics.Color.White.copy(alpha = 0.9f),
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}

// Función para generar un color aleatorio
fun randomColor(): Color {
    val rnd = java.util.Random()
    return Color(
        red = rnd.nextInt(256),
        green = rnd.nextInt(256),
        blue = rnd.nextInt(256)
    )
}

@Preview(showBackground = true)
@Composable
fun ColorTestCard() {
    ColorTestCard( onBack = {})
}

