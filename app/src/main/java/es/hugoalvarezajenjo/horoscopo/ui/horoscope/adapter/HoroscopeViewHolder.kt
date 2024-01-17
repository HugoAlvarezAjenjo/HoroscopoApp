package es.hugoalvarezajenjo.horoscopo.ui.horoscope.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import es.hugoalvarezajenjo.horoscopo.databinding.ItemHoroscopeBinding
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo

class HoroscopeViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    private val binding = ItemHoroscopeBinding.bind(view)

    fun render(horoscopeInfo: HoroscopeInfo) {
        val context = this.binding.tvTitle.context
        this.binding.ivHoroscope.setImageResource(horoscopeInfo.img)
        this.binding.tvTitle.text = context.getString(horoscopeInfo.horoscopeName)
    }
}