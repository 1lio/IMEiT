package ru.suhov.student.features.map

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fr_tab.*
import ru.suhov.student.core.platform.BasePagerFragment

class MapsPagerFragment : BasePagerFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter =
            MapPagerAdapter(childFragmentManager)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
    }
}