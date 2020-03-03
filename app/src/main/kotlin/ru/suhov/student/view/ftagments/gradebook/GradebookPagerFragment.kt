package ru.suhov.student.view.ftagments.gradebook

import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.fr_tab.*
import ru.suhov.student.base.BasePagerFragment

class GradebookPagerFragment : BasePagerFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewPager.adapter = GradebookPagerAdapter(childFragmentManager, 8)
        tabLayout.post { tabLayout.setupWithViewPager(viewPager) }
    }

}