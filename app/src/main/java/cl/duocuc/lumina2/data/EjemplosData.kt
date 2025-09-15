package cl.duocuc.lumina2.data

import cl.duocuc.lumina2.data.model.SemanaCinco
import cl.duocuc.lumina2.data.repository.IndicatorRepository
import cl.duocuc.lumina2.utils.medirTiempo
import cl.duocuc.lumina2.utils.parsearDolar
import cl.duocuc.lumina2.utils.promedioIPC
import cl.duocuc.lumina2.utils.promedioUF
import cl.duocuc.lumina2.utils.valorReal
import java.math.BigDecimal

val ejemplosData = listOf(
    // modelo SemenaCinco data/model
    SemanaCinco(
        "Función de Nivel Superior",
        "Calcula el promedio de la UF en el período.",
        promedioUF(IndicatorRepository.indicators)
    ),
    SemanaCinco(
        "Función de Extensión",
        "Promedio del IPC.",
        IndicatorRepository.indicators.promedioIPC() // String
    ),
    SemanaCinco(
        "Propiedad de Extensión",
        "Valor real (UF + UTM + Dólar) del primer día.",
        IndicatorRepository.indicators.first().valorReal.toString()
    ),
    SemanaCinco(
        "Lambda con filtro",
        "Filtrar días con dólar > 930.",
        IndicatorRepository.indicators.filter { it.dolar > BigDecimal(930) }.joinToString { it.date }
    ),
    // Es inline: porque recibe un lambda y se busca optimizar rendimiento evitando objetos extras y llamadas indirectas
    SemanaCinco(
        "Inline Function",
        "Tiempo en filtrar datos.",
        medirTiempo { IndicatorRepository.indicators.filter { it.uf > BigDecimal(36000) } }
    ),
    // Un lambda con etiqueta es una lambda que tiene un nombre personalizado para identificar
    // específicamente a qué lambda debe retornar el return
    // es un recurso visual y semántico que le da contexto al return

    SemanaCinco(
        "Lambda con etiqueta",
        "Iterar y saltar cuando UF < 36000.",
        buildString {
            IndicatorRepository.indicators.forEach lit@{
                if (it.uf < BigDecimal(36000)) return@lit
                append("${it.date} ")
            }
        }
    ),
    SemanaCinco(
        "Try-Catch",
        "Convertir dólar 'abc' a número.",
        parsearDolar("abc").toString()
    ),
    SemanaCinco(
        "For / If-Else",
        "Clasificar según UF.",
        buildString {
            for (d in IndicatorRepository.indicators) {
                append("${d.date}: ")
                if (d.uf > BigDecimal(36000)) append("Alta\n") else append("Baja\n")
            }
        }
    ),
    SemanaCinco(
        "Do-While",
        "Mostrar primeros 3 registros.",
        buildString {
            var i = 0
            do {
                append("${IndicatorRepository.indicators[i].date} -> UF: ${IndicatorRepository.indicators[i].uf}\n")
                i++
            } while (i < 3)
        }
    )
)
