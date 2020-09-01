package ru.student.assistant.maps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fr_tab.*

class MapsFragment : Fragment(R.layout.fr_tab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = MapPagerAdapter(childFragmentManager, lifecycle)

        val maps = "MAPS"
        val list = "LIST"

        TabLayoutMediator(tabLayout, viewPager) { t, p -> t.text = if (p == 0) maps else list }.attach()
    }
}