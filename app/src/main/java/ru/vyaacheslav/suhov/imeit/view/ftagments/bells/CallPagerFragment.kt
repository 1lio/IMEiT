package ru.vyaacheslav.suhov.imeit.view.ftagments.bells

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.CallSettingsPagerAdapter

class CallPagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)

        val v = inflater.inflate(R.layout.fr_tab, container, false)
        val tabLayout = v.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = v.findViewById<ViewPager>(R.id.viewpager)

        // Подключаем адаптер в viewPager
        viewPager.adapter = CallSettingsPagerAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
        return v
    }
}