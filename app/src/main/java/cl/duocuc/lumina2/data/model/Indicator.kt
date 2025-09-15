package cl.duocuc.lumina2.data.model

import java.math.BigDecimal

data class ChileIndicators(
    val date: String,
    val uf: BigDecimal,
    val utm: BigDecimal,
    val ipc: BigDecimal,
    val dolar: BigDecimal
)