package ru.vyaacheslav.suhov.imeit.view.adapters

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import ru.vyaacheslav.suhov.imeit.view.ftagments.bells.CallPreviewFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.bells.CallPagerFragment

class CallSettingsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int) = if (position == 0) CallPagerFragment() else CallPreviewFragment()

    override fun getCount() = 2

    override fun getPageTitle(position: Int) = if (position == 0) "Настройки" else "Предпросмотр"
}