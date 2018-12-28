package zo.den.testtask5.view.adapter

import android.support.v7.util.DiffUtil
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.card_city.view.*
import zo.den.testtask5.R
import zo.den.testtask5.model.City

class CityAdapter : RecyclerView.Adapter<CityAdapter.CityViewHolder>() {

    var listener: OnItemClickListener? = null

    var list: List<City> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CityViewHolder {
        return CityViewHolder(LayoutInflater.from(p0.context).inflate(R.layout.card_city, p0, false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(p0: CityViewHolder, p1: Int) {
        p0.bind(list[p1])
    }

    inner class CityViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var cardView: CardView? = null

        fun bind(city: City) {
            cardView = itemView.cardview
            itemView.city.text = city.city
            itemView.type.text = city.type
            itemView.setOnClickListener {
                listener?.onItemClick(city)
            }
            itemView.setOnClickListener {
                listener?.onItemLongClick(city)
            }
        }
    }

    private class CityDiffCallback constructor(private val old: List<City>, private val new: List<City>)
        : DiffUtil.Callback() {
        override fun areItemsTheSame(p0: Int, p1: Int): Boolean {
            return old[p0].city == new[p1].city
        }

        override fun getOldListSize(): Int {
            return old.size
        }

        override fun getNewListSize(): Int {
            return new.size
        }

        override fun areContentsTheSame(p0: Int, p1: Int): Boolean {
            return old[p0].city == new[p1].city && old[p0].type == new[p1].type
        }
    }

    interface OnItemClickListener {
        fun onItemClick(city: City)
        fun onItemLongClick(city: City)
    }
}