import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

// 1) Data class para los botones
data class BotonItem(
    val icono: ImageVector,
    val titulo: String,
    val fecha: String,
    val color: Color,
    val destino: String
)