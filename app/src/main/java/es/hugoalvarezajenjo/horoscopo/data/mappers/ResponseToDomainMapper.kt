package es.hugoalvarezajenjo.horoscopo.data.mappers

import es.hugoalvarezajenjo.horoscopo.data.network.response.PredictionResponse
import es.hugoalvarezajenjo.horoscopo.domain.model.PredictionModel

fun PredictionResponse.toDomain(): PredictionModel {
    return PredictionModel(
        horoscope = this.horoscope,
        sign = this.sign,
        )
}