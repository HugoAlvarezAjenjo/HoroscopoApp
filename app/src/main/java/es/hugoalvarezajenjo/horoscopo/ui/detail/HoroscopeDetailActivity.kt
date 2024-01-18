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
import es.hugoalvarezajenjo.horoscopo.databinding.ActivityHoroscopeDetailBinding
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
        horoscopeDetailViewModel.getHoroscope(this.args.horoscope.name)
        initUI()
    }

    private fun initUI() {
        initUIState()
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopeDetailViewModel.state.collect {
                    when(it) {
                        HoroscopeDetailState.Loading -> loadingState()
                        is HoroscopeDetailState.Error -> errorState()
                        is HoroscopeDetailState.Success -> sucessState(it)
                    }
                }
            }
        }
    }

    private fun loadingState() {
        binding.progressBar.isVisible = true
    }
    private fun sucessState(state: HoroscopeDetailState.Success) {
        binding.progressBar.isVisible = false
        binding.tvTitle.text = state.sign
        binding.tvBody.text = state.prediction
    }

    private fun errorState() {
        binding.progressBar.isVisible = false
    }

}