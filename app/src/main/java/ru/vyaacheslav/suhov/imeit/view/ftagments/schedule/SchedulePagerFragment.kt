package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fr_tab.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseFragment
import ru.vyaacheslav.suhov.imeit.view.adapters.DayPagerAdapter
import java.util.*

/** Фрагмент с Pager-ом содержащим в себе расписание по дням недели. */
class SchedulePagerFragment : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fr_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        view_pager.adapter = DayPagerAdapter(childFragmentManager,activity!!)
        tab_layout.post { tab_layout.setupWithViewPager(view_pager) }

        val item:Int = when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.TUESDAY -> 1
            Calendar.WEDNESDAY -> 2
            Calendar.THURSDAY -> 3
            Calendar.FRIDAY -> 4
            else -> 0
        }

        view_pager.setCurrentItem(item,true)
    }
}