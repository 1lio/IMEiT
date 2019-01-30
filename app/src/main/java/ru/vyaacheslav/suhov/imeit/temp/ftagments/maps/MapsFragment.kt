package ru.vyaacheslav.suhov.imeit.temp.ftagments.maps

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.temp.adapters.MapAdapter

/** Главный фрагмент карт, содержит в себе viewPager и позволяет листать два фрагмента*/
class MapsFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Инициализация
        val v = inflater.inflate(R.layout.fragment_tab, container, false)
        val tabLayout = v.findViewById<TabLayout>(R.id.tabs)
        val viewPager = v.findViewById<ViewPager>(R.id.viewpager)

        // Подключаем адаптер в viewPager
        viewPager.adapter = MapAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
        return v
    }
}