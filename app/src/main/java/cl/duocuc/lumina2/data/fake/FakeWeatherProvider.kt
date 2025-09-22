package cl.duocuc.lumina2.data.fake

import cl.duocuc.lumina2.data.model.Weather

// Proveedor simulado para un content providers
object FakeWeatherProvider {

    val weatherList = listOf(
        Weather("21/09/25", "25º", "Despejado"),
        Weather("22/09/25", "18º", "Lluvioso"),
        Weather("23/09/25", "22º", "Nublado")
    )

}