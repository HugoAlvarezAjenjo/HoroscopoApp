package es.hugoalvarezajenjo.horoscopo.data.mappers

import es.hugoalvarezajenjo.horoscopo.motherobject.HoroscopeMotherObject.anyResponse
import io.kotlintest.shouldBe
import org.junit.Test

class ResponseToDomainMapperKtTest {
    @Test
    fun toDomain_should_return_a_correct_prediction_model() {
        val horoscopeResponse = anyResponse
        val predictionModel = horoscopeResponse.toDomain()
        predictionModel.sign shouldBe horoscopeResponse.sign
        predictionModel.horoscope shouldBe horoscopeResponse.horoscope
    }
}