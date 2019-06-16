package ru.vyaacheslav.suhov.imeit.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseAdapter
import ru.vyaacheslav.suhov.imeit.base.BaseViewHolder
import ru.vyaacheslav.suhov.imeit.entity.EduBuilding

class MapsListAdapter : BaseAdapter<EduBuilding, MapsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_maps, parent, false))
    }

    inner class ViewHolder(itemView: View) : BaseViewHolder<EduBuilding>(itemView) {

        private val name: TextView = itemView.findViewById(R.id.text_name_map)
        private val address: TextView = itemView.findViewById(R.id.text_name_address)

        override fun bind(item: EduBuilding) {
            name.text = item.name
            address.text = item.address
        }
    }
}