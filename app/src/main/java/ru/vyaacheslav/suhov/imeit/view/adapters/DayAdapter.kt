package ru.vyaacheslav.suhov.imeit.view.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.Schedule


class DayAdapter(private val list: List<Schedule>)
    : androidx.recyclerview.widget.RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    lateinit var min: String

    inner class ViewHolder(v: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(v) {

        val name: TextView = v.findViewById(R.id.s_name)
        val surname: TextView = v.findViewById(R.id.s_subname)
        val type: TextView = v.findViewById(R.id.s_type)
        val build: TextView = v.findViewById(R.id.s_build)
        val name_out: TextView = v.findViewById(R.id.s_name_d)
        val surname_out: TextView = v.findViewById(R.id.s_name_d)
        val type_out: TextView = v.findViewById(R.id.s_name_d)
        val build_out: TextView = v.findViewById(R.id.s_name_d)

        val tex1: TextView = v.findViewById(R.id.tex1)
        val tex2: TextView = v.findViewById(R.id.tex2)
        val tex3: TextView = v.findViewById(R.id.tex3)

    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): DayAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.it_time, parent, false)
        min = v.resources.getString(R.string.min)
        return ViewHolder(v)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


        holder.name.text = list[position].name
        holder.surname.text = list[position].surname
        holder.type.text = list[position].type
        holder.build.text = list[position].build
        holder.name_out.text = list[position].name_out
        holder.surname_out.text = list[position].surname_out
        holder.type_out.text = list[position].type_out
        holder.build_out.text = list[position].build_out
        holder.tex1.text = list[position].tex1
        holder.tex2.text = list[position].tex2
        holder.tex3.text = list[position].tex3

    }

    override fun getItemCount(): Int {
        return list.size
    }
}