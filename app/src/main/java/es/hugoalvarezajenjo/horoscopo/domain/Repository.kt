package es.hugoalvarezajenjo.horoscopo.domain

import es.hugoalvarezajenjo.horoscopo.data.network.response.PredictionResponse
import es.hugoalvarezajenjo.horoscopo.domain.model.PredictionModel

interface Repository {
    suspend fun getPrediction(sign: String): PredictionModel?
}