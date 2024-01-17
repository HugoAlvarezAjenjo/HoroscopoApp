package es.hugoalvarezajenjo.horoscopo.ui.horoscope.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import es.hugoalvarezajenjo.horoscopo.databinding.ItemHoroscopeBinding
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo, onItemSelected: (HoroscopeInfo) -> Unit) {
        val context = this.binding.tvTitle.context
        this.binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        this.binding.tvTitle.text = context.getString(horoscopeInfo.horoscopeName)

        this.binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscope, endAction = {onItemSelected(horoscopeInfo)})
        }
    }

    private fun startRotationAnimation(view: View, endAction: () -> Unit) {
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction {
                endAction()
            }
            start()
        }
    }
}