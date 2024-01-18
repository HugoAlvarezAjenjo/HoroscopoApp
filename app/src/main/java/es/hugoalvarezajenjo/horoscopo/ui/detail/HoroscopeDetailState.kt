package es.hugoalvarezajenjo.horoscopo.ui.detail

import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo

sealed class HoroscopeDetailState {
    data object Loading : HoroscopeDetailState()
    data class Error(val error: String) : HoroscopeDetailState()
    data class Success(val sign: String, val prediction: String, val horoscopeInfo: HoroscopeInfo) :
        HoroscopeDetailState()

}