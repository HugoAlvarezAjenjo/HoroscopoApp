package es.hugoalvarezajenjo.horoscopo.ui.horoscope.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import es.hugoalvarezajenjo.horoscopo.R
import es.hugoalvarezajenjo.horoscopo.domain.model.HoroscopeInfo

class HoroscopeAdapter(private var horoscopeList: List<HoroscopeInfo> = emptyList()): RecyclerView.Adapter<HoroscopeViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopeViewHolder {
        return HoroscopeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_horoscope, parent, false))
    }

    override fun onBindViewHolder(holder: HoroscopeViewHolder, position: Int) {
        holder.render(this.horoscopeList[position])
    }

    override fun getItemCount() = horoscopeList.size

    fun updateList(horoscopeInfoList: List<HoroscopeInfo>) {
        Log.i("ListAdapter", horoscopeInfoList.toString())
        this.horoscopeList = horoscopeInfoList
        notifyDataSetChanged()
    }

}