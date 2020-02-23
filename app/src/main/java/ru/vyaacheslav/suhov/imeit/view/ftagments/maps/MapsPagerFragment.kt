package ru.vyaacheslav.suhov.imeit.view.ftagments.maps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fr_tab.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.adapters.MapPagerAdapter

/** Главный фрагмент карт, содержит в себе viewPager и позволяет листать два фрагмента */
class MapsPagerFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? =
        inflater.inflate(R.layout.fr_tab, group, false)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view_pager.adapter = MapPagerAdapter(childFragmentManager)
        tab_layout.post { tab_layout.setupWithViewPager(view_pager) }
    }
}