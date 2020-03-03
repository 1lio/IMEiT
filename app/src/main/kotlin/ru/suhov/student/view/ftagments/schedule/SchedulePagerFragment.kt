package ru.suhov.student.view.ftagments.schedule

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fr_tab.*
import ru.suhov.student.base.BasePagerFragment
import ru.suhov.student.view.adapters.DayPagerAdapter
import java.util.*

// Фрагмент с Pager-ом содержащим в себе расписание по дням недели.
class SchedulePagerFragment : BasePagerFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewPager.adapter = DayPagerAdapter(childFragmentManager, activity!!)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }

        // Устанвливаем таб согласно текущему дню недели
        val item: Int = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.TUESDAY -> 1
            Calendar.WEDNESDAY -> 2
            Calendar.THURSDAY -> 3
            Calendar.FRIDAY -> 4
            else -> 0
        }

        viewPager.setCurrentItem(item, true)
    }
}