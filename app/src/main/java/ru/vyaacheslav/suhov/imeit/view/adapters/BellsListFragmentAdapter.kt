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
import ru.vyaacheslav.suhov.imeit.repository.BellListGenerator
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellCount
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.BellData

class BellsListFragmentAdapter(private val list: List<BellCount>) :
        RecyclerView.Adapter<BellsListFragmentAdapter.ViewHolder>() {

    private lateinit var min: String
    private lateinit var ctx: Context

    inner class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {

        val num: TextView = itemView.findViewById(R.id.t_num)
        val less1top: TextView = itemView.findViewById(R.id.t_top)
        val less1bot: TextView = itemView.findViewById(R.id.t_o_top)
        val less2top: TextView = itemView.findViewById(R.id.t_bott)
        val less2bot: TextView = itemView.findViewById(R.id.t_o_bott)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bells, parent, false)
        min = v.resources.getString(R.string.min)
        ctx = parent.context
        return ViewHolder(v)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.num.text = list[position].num
        holder.less1top.text = list[position].topLesson
        holder.less1bot.text = list[position].topBreak.toString() + min
        holder.less2top.text = list[position].bottomLesson
        holder.less2bot.text = list[position].bottomBreak.toString() + min

        val color = ContextCompat.getColor(ctx, R.color.colorSelect)
        val currentPair = BellListGenerator(BellData()).getNumberCurrentPair().second

        if (currentPair == position) holder.itemView.setBackgroundColor(color)

    }
    override fun getItemCount() = list.size
}