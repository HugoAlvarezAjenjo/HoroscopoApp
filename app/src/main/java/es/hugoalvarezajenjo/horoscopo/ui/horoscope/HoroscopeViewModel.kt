package es.hugoalvarezajenjo.horoscopo.ui.horoscope

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HoroscopeViewModel @Inject constructor(): ViewModel() {

    private var _horoscope = MutableStateFlow<List<HoroscopeInfo>>(emptyList())
    val horoscope: StateFlow<List<HoroscopeInfo>> = _horoscope

    init {
        this._horoscope.value = listOf(HoroscopeInfo.AQUARIUS)
    }

    fun getHoroscopes() {

    }
}