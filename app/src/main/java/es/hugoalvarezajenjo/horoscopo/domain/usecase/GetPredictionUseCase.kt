package es.hugoalvarezajenjo.horoscopo.domain.usecase

import es.hugoalvarezajenjo.horoscopo.domain.Repository
import javax.inject.Inject

class GetPredictionUseCase @Inject constructor(private val repository: Repository) {
    suspend operator fun invoke(sign: String) =
        this.repository.getPrediction(sign)
}