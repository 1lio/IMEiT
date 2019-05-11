package ru.vyaacheslav.suhov.imeit.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.Buildings

class MapsListAdapter(private val list: ArrayList<Buildings>) : RecyclerView.Adapter<MapsListAdapter.ViewHolder>() {

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var name: TextView = itemView.findViewById(R.id.text1)
        var address: TextView = itemView.findViewById(R.id.text2)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_maps, parent, false))


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.address.text = list[position].address
    }

    override fun getItemCount(): Int = list.size
}