package es.hugoalvarezajenjo.horoscopo.motherobject

import es.hugoalvarezajenjo.horoscopo.data.network.response.PredictionResponse
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo

object HoroscopeMotherObject {
    val anyResponse = PredictionResponse("date", "prediction", "taurus")

    val horoscopeInfoList = listOf(
        HoroscopeInfo.ARIES,
        HoroscopeInfo.TAURUS,
        HoroscopeInfo.GEMINI,
        HoroscopeInfo.CANCER,
        HoroscopeInfo.LEO,
        HoroscopeInfo.VIRGO,
        HoroscopeInfo.LIBRA,
        HoroscopeInfo.SCORPIO,
        HoroscopeInfo.SAGITTARIUS,
        HoroscopeInfo.CAPRICORN,
        HoroscopeInfo.AQUARIUS,
        HoroscopeInfo.PISCES
    )
}