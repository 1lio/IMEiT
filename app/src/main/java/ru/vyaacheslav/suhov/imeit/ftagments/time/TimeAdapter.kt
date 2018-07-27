package ru.vyaacheslav.suhov.imeit.ftagments.time

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R

class TimeAdapter internal constructor(internal var timeData: List<TimeData>) : RecyclerView.Adapter<TimeAdapter.TimeViewHolder>() {

    class TimeViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var timeNum: TextView = itemView.findViewById(R.id.num_time_item)
        var timeTop: TextView = itemView.findViewById(R.id.item_time_top)
        var timeBottom: TextView = itemView.findViewById(R.id.item_time_bottom)
        var timeOutTop: TextView = itemView.findViewById(R.id.item_out_top)
        var timeOutBottom: TextView = itemView.findViewById(R.id.item_out_bottom)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): TimeViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.time_item, viewGroup, false)

        return TimeViewHolder(v)
    }

    override fun onBindViewHolder(personViewHolder: TimeViewHolder, i: Int) {
        personViewHolder.timeNum.text = timeData[i].num.toString()
        personViewHolder.timeTop.text = timeData[i].itemTopTime
        personViewHolder.timeBottom.text = timeData[i].itemBottomTime
        personViewHolder.timeOutTop.text = timeData[i].itemTopOut
        personViewHolder.timeOutBottom.text = timeData[i].itemBottomOut
    }

    override fun getItemCount(): Int {
        return timeData.size
    }

}