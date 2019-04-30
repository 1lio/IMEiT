package ru.vyaacheslav.suhov.imeit.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import androidx.core.content.ContextCompat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.BellCount

class BellsListAdapter(private val context: Context, private val list: List<BellCount>,
                       private val countPair: Int) : RecyclerView.Adapter<BellsListAdapter.ViewHolder>() {

    lateinit var min: String

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val num: TextView = itemView.findViewById(R.id.t_num)
        val less1top: TextView = itemView.findViewById(R.id.t_top)
        val less1bot: TextView = itemView.findViewById(R.id.t_o_top)
        val less2top: TextView = itemView.findViewById(R.id.t_bott)
        val less2bot: TextView = itemView.findViewById(R.id.t_o_bott)
    }

    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.it_time, parent, false)
        min = v.resources.getString(R.string.min)
        return ViewHolder(v)
    }


    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.num.text = list[position].num
        holder.less1top.text = list[position].topLesson
        holder.less1bot.text = list[position].topBreak.toString() + min
        holder.less2top.text = list[position].bottomLesson
        holder.less2bot.text = list[position].bottomBreak.toString() + min

        val color = ContextCompat.getColor(context, R.color.gray)
        if (countPair == position) {
            holder.itemView.setBackgroundColor(color)
        }
    }

    override fun getItemCount(): Int = list.size
}