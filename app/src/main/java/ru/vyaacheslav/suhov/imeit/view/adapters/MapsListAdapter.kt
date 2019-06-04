package ru.vyaacheslav.suhov.imeit.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseAdapter
import ru.vyaacheslav.suhov.imeit.base.BaseViewHolder
import ru.vyaacheslav.suhov.imeit.repository.entity.MapData

class MapsListAdapter : BaseAdapter<MapData, MapsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_maps, parent, false))
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<MapData>(itemView) {

        private val name: TextView = itemView.findViewById(R.id.text1)
        private val address: TextView = itemView.findViewById(R.id.text2)
        private val iconDelete: ImageView = itemView.findViewById(R.id.delItem)

        override fun bind(item: MapData) {
            name.text = item.name
            address.text = item.address
            iconDelete.visibility = if (isEdited) View.VISIBLE else View.GONE
        }
    }
}