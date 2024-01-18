package es.hugoalvarezajenjo.horoscopo.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo
import es.hugoalvarezajenjo.horoscopo.domain.usecase.GetPredictionUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HoroscopeDetailViewModel @Inject constructor(private val getPredictionUseCase: GetPredictionUseCase) :
    ViewModel() {
    private var _state = MutableStateFlow<HoroscopeDetailState>(HoroscopeDetailState.Loading)
    val state: StateFlow<HoroscopeDetailState> = _state

    lateinit var horoscope: HoroscopeInfo

    fun getHoroscope(sign: HoroscopeInfo) {
        this.horoscope = sign
        viewModelScope.launch {
            _state.value = HoroscopeDetailState.Loading
            val result = withContext(Dispatchers.IO) {
                getPredictionUseCase(sign.name)
            }
            if (result != null) {
                _state.value = HoroscopeDetailState.Success(result.sign, result.horoscope, horoscope)
            } else {
                _state.value =
                    HoroscopeDetailState.Error("Ha ocurrido un error, intentelo mas tarde")
            }
        }
    }


}