package cl.duocuc.lumina2.data.model

import androidx.compose.ui.graphics.Color
import java.math.BigDecimal

data class IndicatorConfig (

        val titulo: String,
        val valor: BigDecimal,
        val descripcion: String,
        val color: Color

)