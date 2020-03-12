package ru.suhov.student.features.map

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.suhov.student.R
import ru.suhov.student.core.platform.BaseAdapter
import ru.suhov.student.core.platform.BaseViewHolder
import ru.suhov.student.core.entity.EduLocation

class MapsListAdapter : BaseAdapter<EduLocation, MapsListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_maps, parent, false))


    inner class ViewHolder(itemView: View) : BaseViewHolder<EduLocation>(itemView) {

        private val name: TextView = itemView.findViewById(R.id.text_name_map)
        private val address: TextView = itemView.findViewById(R.id.text_name_address)

        override fun bind(item: EduLocation) {
            name.text = item.name
            address.text = item.address
        }
    }
}