package ru.vyaacheslav.suhov.imeit.ftagments.maps

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.adapters.MapAdapter

class MapsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.tabs, container, false)
        val tabLayout = v.findViewById<TabLayout>(R.id.tabss)
        val viewPager = v.findViewById<ViewPager>(R.id.viewpagerr)

        viewPager.adapter = MapAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
        return v
    }
}