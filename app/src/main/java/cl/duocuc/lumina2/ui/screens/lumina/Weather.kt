package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.duocuc.lumina2.data.fake.FakeWeatherProvider


@Composable
fun Weather( onBack: () -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(FondoPrincipal)
            .padding(16.dp)
            .clickable { onBack() },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            // un emoji
            text = "⋆.˚☁\uFE0F⋆",
            fontSize = 50.sp,
            color = Color.White.copy(alpha = 0.9f),
            textAlign = TextAlign.Center,
            lineHeight = 56.sp

        )

        Spacer(Modifier.height(25.dp))

        // Para listas verticales (lazy loading)
        LazyColumn {

            items(FakeWeatherProvider.weatherList) { weather ->

                Text(
                    text = "${weather.fecha} ${weather.temperatura}  ${weather.condicion}",
                    fontSize = 30.sp,
                    textAlign = TextAlign.Center,
                    color = Color.White
                )

               // HorizontalDivider(thickness = 2.dp)
                Spacer(Modifier.height(25.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Weather() {
    Weather({})
}

