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
import ru.vyaacheslav.suhov.imeit.repository.entity.Schedule
import ru.vyaacheslav.suhov.imeit.util.UtilBell
import ru.vyaacheslav.suhov.imeit.util.styleAppearance
import ru.vyaacheslav.suhov.imeit.repository.entity.CallPref
import ru.vyaacheslav.suhov.imeit.view.adapters.entity.TimeData

class DayFragmentAdapter : BaseAdapter<Schedule, DayFragmentAdapter.TestViewHolder>() {

    private val listTime: List<TimeData> = UtilBell().getListTime()
    private lateinit var context: Context

    override fun onCreateViewHolder(p: ViewGroup, t: Int): TestViewHolder {
        context = p.context
        return TestViewHolder(LayoutInflater.from(p.context).inflate(R.layout.item_schedule, p, false))
    }

    inner class TestViewHolder(v: View) : BaseViewHolder<Schedule>(v) {

        val lesson: TextView = v.findViewById(R.id.s_name)
        val teacher: TextView = v.findViewById(R.id.s_subname)
        val type: TextView = v.findViewById(R.id.s_type)
        val building: TextView = v.findViewById(R.id.s_build)
        val lesson2: TextView = v.findViewById(R.id.s_name_d)
        val teacher2: TextView = v.findViewById(R.id.s_subname_d)
        val type2: TextView = v.findViewById(R.id.s_type_d)
        val building2: TextView = v.findViewById(R.id.s_build_d)

        val time1: TextView = v.findViewById(R.id.tex1)
        val time2: TextView = v.findViewById(R.id.tex2)
        val time3: TextView = v.findViewById(R.id.tex3)


        override fun bind(item: Schedule) {

            lesson.text = item.lesson
            teacher.text = item.teacher
            type.text = item.type
            building.text = item.building
            lesson2.text = item.lesson2
            teacher2.text = item.teacher2
            type2.text = item.type2
            building2.text = item.building2
        }

    }

    override fun onBindViewHolder(holder: TestViewHolder, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.time1.text = listTime[position].tex1
        holder.time2.text = listTime[position].tex2
        holder.time3.text = listTime[position].tex3

        val currentPair = UtilBell(CallPref()).getNumberCurrentPair().second
        if (currentPair == position) decorateItem(holder)

    }

    private fun decorateItem(holder: TestViewHolder) {

        holder.itemView.setBackgroundColor(ContextCompat.getColor(context, R.color.gray))

        listOf(holder.lesson, holder.teacher, holder.type, holder.building, holder.lesson2,
                holder.teacher2, holder.type2, holder.building2, holder.time1, holder.time2, holder.time3
        ).forEach { it.styleAppearance(context) }
    }

}