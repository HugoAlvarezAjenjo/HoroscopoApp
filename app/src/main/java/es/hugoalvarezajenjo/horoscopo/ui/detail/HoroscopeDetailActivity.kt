package es.hugoalvarezajenjo.horoscopo.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.navArgs
import dagger.hilt.android.AndroidEntryPoint
import es.hugoalvarezajenjo.horoscopo.R
import es.hugoalvarezajenjo.horoscopo.databinding.ActivityHoroscopeDetailBinding
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HoroscopeDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHoroscopeDetailBinding
    private val horoscopeDetailViewModel: HoroscopeDetailViewModel by viewModels()

    private val args: HoroscopeDetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityHoroscopeDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        horoscopeDetailViewModel.getHoroscope(this.args.horoscope)
        initUI()
    }

    private fun initUI() {
        initListeners()
        initUIState()
    }

    private fun initListeners() {
        binding.ivBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when(it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> successState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }
    private fun successState(state: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
        val image = when(state.horoscopeInfo) {
            HoroscopeInfo.ARIES -> R.drawable.detail_aries
            HoroscopeInfo.TAURUS -> R.drawable.detail_taurus
            HoroscopeInfo.GEMINI -> R.drawable.detail_gemini
            HoroscopeInfo.CANCER -> R.drawable.detail_cancer
            HoroscopeInfo.LEO -> R.drawable.detail_leo
            HoroscopeInfo.VIRGO -> R.drawable.detail_virgo
            HoroscopeInfo.LIBRA -> R.drawable.detail_libra
            HoroscopeInfo.SCORPIO -> R.drawable.detail_scorpio
            HoroscopeInfo.SAGITTARIUS -> R.drawable.detail_sagittarius
            HoroscopeInfo.CAPRICORN -> R.drawable.detail_capricorn
            HoroscopeInfo.AQUARIUS -> R.drawable.detail_aquarius
            HoroscopeInfo.PISCES -> R.drawable.detail_pisces
        }
        binding.ivDetail.setImageResource(image)
    }

    private fun errorState() {
        binding.progressBar.isVisible = false
    }

}