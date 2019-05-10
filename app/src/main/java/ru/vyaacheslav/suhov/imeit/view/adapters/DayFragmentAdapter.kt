package ru.vyaacheslav.suhov.imeit.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule

class DayFragmentAdapter(private val list: List<Schedule>) : RecyclerView.Adapter<DayFragmentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_bells, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].name
        holder.surname.text = list[position].surname
        holder.type.text = list[position].type
        holder.build.text = list[position].build
        holder.nameOut.text = list[position].name_out
        holder.surnameOut.text = list[position].surname_out
        holder.typeOut.text = list[position].type_out
        holder.buildOut.text = list[position].build_out
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val name: TextView = v.findViewById(R.id.s_name)
        val surname: TextView = v.findViewById(R.id.s_subname)
        val type: TextView = v.findViewById(R.id.s_type)
        val build: TextView = v.findViewById(R.id.s_build)
        val nameOut: TextView = v.findViewById(R.id.s_name_d)
        val surnameOut: TextView = v.findViewById(R.id.s_name_d)
        val typeOut: TextView = v.findViewById(R.id.s_name_d)
        val buildOut: TextView = v.findViewById(R.id.s_name_d)
    }
}