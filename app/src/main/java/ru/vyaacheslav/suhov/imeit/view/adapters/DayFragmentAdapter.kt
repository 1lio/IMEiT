package ru.vyaacheslav.suhov.imeit.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule

class DayFragmentAdapter(private val list: ArrayList<Schedule>) : RecyclerView.Adapter<DayFragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_schedule, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].lesson
        holder.surname.text = list[position].teacher
        holder.type.text = list[position].type
        holder.build.text = list[position].building
        holder.nameOut.text = list[position].lesson2
        holder.surnameOut.text = list[position].teacher2
        holder.typeOut.text = list[position].type2
        holder.buildOut.text = list[position].building2
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var name: TextView = v.findViewById(R.id.s_name)
        var surname: TextView = v.findViewById(R.id.s_subname)
        var type: TextView = v.findViewById(R.id.s_type)
        var build: TextView = v.findViewById(R.id.s_build)
        var nameOut: TextView = v.findViewById(R.id.s_name_d)
        var surnameOut: TextView = v.findViewById(R.id.s_name_d)
        var typeOut: TextView = v.findViewById(R.id.s_name_d)
        var buildOut: TextView = v.findViewById(R.id.s_name_d)
    }
}