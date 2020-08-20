package ru.student.assistant.maps

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_tab.*
import ru.suhov.student.features.map.MapPagerAdapter

class MapsPagerFragment : Fragment(R.layout.fr_tab) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter =
            MapPagerAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
    }
}