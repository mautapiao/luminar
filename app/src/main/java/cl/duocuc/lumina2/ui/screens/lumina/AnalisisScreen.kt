package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.text.font.FontWeight
import cl.duocuc.lumina2.data.ejemplosData
import cl.duocuc.lumina2.data.model.SemanaCinco

@Composable
fun EjemploCard(ejemplo: SemanaCinco) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = ejemplo.titulo,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = ejemplo.descripcion,
                style = MaterialTheme.typography.titleLarge
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Resultado:",
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold
            )

            Text(
                text = ejemplo.resultado,
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
        }

    }
}

@Composable
fun ListaEjemplos( onBack: () -> Unit) {

    Column(
        modifier = Modifier.clickable { onBack() }
    ) {
        // Para listas verticales (lazy loading)
        LazyColumn {
            // Función de orden superior que recibe una lista
            items(ejemplosData)
            // Lambda que se ejecuta para cada elemento
            {
                // es el parametro que representa cada item individual
                ejemplo ->
                // composable que se crea con cada elemento
                EjemploCard(ejemplo)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewEjemplos() {
    ListaEjemplos({})
}

