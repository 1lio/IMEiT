package ru.vyaacheslav.suhov.imeit.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseAdapter
import ru.vyaacheslav.suhov.imeit.base.BaseViewHolder
import ru.vyaacheslav.suhov.imeit.util.CallUtil
import ru.vyaacheslav.suhov.imeit.util.styleAppearance
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.CallItem
import ru.vyaacheslav.suhov.imeit.entity.CallPref

class CallListFragmentAdapter : BaseAdapter<CallItem, CallListFragmentAdapter.ViewHolder>() {

    private var min: String = ""
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_bells, parent, false)
        min = v.resources.getString(R.string.min)
        context = parent.context
        return ViewHolder(v)
    }

    inner class ViewHolder(v: View) : BaseViewHolder<CallItem>(v) {

        val num: TextView = itemView.findViewById(R.id.t_num)
        val less1top: TextView = itemView.findViewById(R.id.t_top)
        val less1bot: TextView = itemView.findViewById(R.id.t_o_top)
        val less2top: TextView = itemView.findViewById(R.id.t_bott)
        val less2bot: TextView = itemView.findViewById(R.id.t_o_bott)

        override fun bind(item: CallItem) {
            num.text = item.num
            less1top.text = item.topLesson
            less1bot.text = (item.topBreak + min)
            less2top.text = item.bottomLesson
        }
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)
        val currentPair = CallUtil(CallPref()).getNumberCurrentPair().second
        if (currentPair == position) decorateItem(holder)

        holder.less2bot.text = if (position != list.lastIndex) list[position].bottomBreak + min
        else list[position].bottomBreak
    }

    private fun decorateItem(holder: ViewHolder) {
        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.gray))
        listOf(holder.num, holder.less1top, holder.less1bot, holder.less2top, holder.less2bot)
                .forEach { it.styleAppearance(context) }
    }
}