package ru.vyaacheslav.suhov.imeit.view.ftagments.schedule

import android.os.Bundle
import android.view.*
import com.google.android.material.tabs.TabLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.DayPagerAdapter
import java.util.*
import androidx.coordinatorlayout.widget.CoordinatorLayout

class SchedulePagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_tab, container, false)

        val tabLayout = v.findViewById<TabLayout>(R.id.tabs)
        val viewPager = v.findViewById<ViewPager>(R.id.viewpager)
        val fab: FloatingActionButton = activity!!.findViewById(R.id.fab)

       // val params = fab.layoutParams as CoordinatorLayout.LayoutParams
       // params.anchorId = View.NO_ID

       // fab.setImageDrawable(ContextCompat.getDrawable(activity!!, R.drawable.ic_schedule))
     //   fab.visibility = View.GONE

        viewPager.adapter = DayPagerAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }

        when (Calendar.getInstance().get(Calendar.DAY_OF_WEEK)) {
            Calendar.TUESDAY -> viewPager.setCurrentItem(1, true)
            Calendar.WEDNESDAY -> viewPager.setCurrentItem(2, true)
            Calendar.THURSDAY -> viewPager.setCurrentItem(3, true)
            Calendar.FRIDAY -> viewPager.setCurrentItem(4, true)
            else -> viewPager.setCurrentItem(0, true)
        }
        return v
    }
}