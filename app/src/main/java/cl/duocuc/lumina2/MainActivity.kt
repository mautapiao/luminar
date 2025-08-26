package cl.duocuc.lumina2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cl.duocuc.lumina2.ui.screens.lumina.MyApp
import cl.duocuc.lumina2.ui.theme.Lumina2Theme

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


