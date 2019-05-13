package ru.vyaacheslav.suhov.imeit.view.ftagments.maps

import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.MapPagerAdapter

/** Главный фрагмент карт, содержит в себе viewPager и позволяет листать два фрагмента*/
class MapsPagerFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Инициализация
        val v = inflater.inflate(R.layout.fr_tab, container, false)
        val tabLayout = v.findViewById<TabLayout>(R.id.tab_layout)
        val viewPager = v.findViewById<ViewPager>(R.id.viewpager)

        // Подключаем адаптер в viewPager
        viewPager.adapter = MapPagerAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
        return v
    }
}