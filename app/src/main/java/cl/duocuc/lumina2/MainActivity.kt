package cl.duocuc.lumina2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.duocuc.lumina2.ui.screens.lumina.MyApp
import cl.duocuc.lumina2.ui.theme.Lumina2Theme

// Esta es mi Activity en Jetpack Compose.
// Es una sola Activity que actúa como contenedor raíz de la aplicación.
// Dentro de setContent { ... } defino todo mi árbol de Composables.
// Normalmente no se van creando más Activities,
// sino que se maneja todo con Navigation Compose (pantallas, rutas, NavHost, etc.).

class MainActivity : ComponentActivity() {
    /**
     * onCreate: Método que se ejecuta cuando se crea la actividad
     * setContent: define el conetenido UI usando Jetpack Compose
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            /**
             * Sistema de navegación
             * MaterialTheme: Aplica el tema Material Design
             */
            Lumina2Theme(darkTheme = true) {
                // punto de entrada
                MyApp();
            }
        }
    }
}


