package ru.vyaacheslav.suhov.imeit.view.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.BellListGenerator
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

        val currentPair = BellListGenerator(BellData()).getNumberCurrentPair().second
        if (currentPair == position) currentPair(holder)

        holder.num.text = list[position].num
        holder.less1top.text = list[position].topLesson
        holder.less1bot.text = list[position].topBreak.toString() + min
        holder.less2top.text = list[position].bottomLesson
        // Костыль
        holder.less2bot.text = if (position != list.lastIndex) list[position].bottomBreak.toString() + min else ""

    }

    private fun currentPair(holder: ViewHolder) {

        holder.itemView.setBackgroundColor(ContextCompat.getColor(ctx, R.color.colorAccent))

        holder.num.styleAppearance()
        holder.less1top.styleAppearance()
        holder.less1bot.styleAppearance()
        holder.less2top.styleAppearance()
        holder.less2bot.styleAppearance()
    }

    override fun getItemCount() = list.size

    private fun TextView.styleAppearance() {

        if (Build.VERSION.SDK_INT < 23) {
            this.setTextAppearance(ctx, R.style.TextCurrentPair)
        } else {
            this.setTextAppearance(R.style.TextCurrentPair)
        }
    }

}