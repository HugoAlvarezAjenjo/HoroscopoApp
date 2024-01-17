package es.hugoalvarezajenjo.horoscopo.data.provider

import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo
import javax.inject.Inject

class HoroscopeProvider @Inject constructor(){
    fun getHoroscopes(): List<HoroscopeInfo> {
        return listOf(
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
}