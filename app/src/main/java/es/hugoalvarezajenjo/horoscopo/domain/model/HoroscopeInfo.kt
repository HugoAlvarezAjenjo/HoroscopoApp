package es.hugoalvarezajenjo.horoscopo.domain.model

import es.hugoalvarezajenjo.horoscopo.R

enum class HoroscopeInfo(val horoscopeName: Int, val img: Int) {
    Aries(R.string.aries ,R.drawable.aries),
    Taurus(R.string.taurus, R.drawable.tauro),
    GEMINI(R.string.gemini, R.drawable.geminis),
    CANCER(R.string.cancer, R.drawable.cancer),
    LEO(R.string.leo, R.drawable.leo),
    VIRGO(R.string.virgo, R.drawable.virgo),
    LIBRA(R.string.libra, R.drawable.libra),
    SCORPIO(R.string.scorpio, R.drawable.escorpio),
    SAGITTARIUS(R.string.sagittarius, R.drawable.sagitario),
    CAPRICORN(R.string.capricorn, R.drawable.capricornio),
    AQUARIUS(R.string.aquarius, R.drawable.aquario),
    PISCES(R.string.pisces, R.drawable.piscis)
}
