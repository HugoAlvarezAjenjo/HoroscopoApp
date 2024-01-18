package es.hugoalvarezajenjo.horoscopo.data

import android.util.Log
import es.hugoalvarezajenjo.horoscopo.data.mappers.toDomain
import es.hugoalvarezajenjo.horoscopo.data.network.HoroscopeApiService
import es.hugoalvarezajenjo.horoscopo.domain.Repository
import es.hugoalvarezajenjo.horoscopo.domain.model.PredictionModel
import javax.inject.Inject

class RepositoryImplementation @Inject constructor(private val apiService: HoroscopeApiService) :
    Repository {
    override suspend fun getPrediction(sign: String): PredictionModel? {
        runCatching {
            apiService.getHoroscope(sign)
        }.onSuccess {
            return it.toDomain()
        }.onFailure {
            Log.i("APIService", "ApiService failed ${it.message}")
        }
        return null
    }
}