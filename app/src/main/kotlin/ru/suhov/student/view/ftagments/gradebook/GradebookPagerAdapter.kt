package ru.suhov.student.view.ftagments.gradebook

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class GradebookPagerAdapter(fm: FragmentManager, private val countSemesters: Byte = 8) :

    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int) = GradebookFragment(position.toByte())

    override fun getCount() = countSemesters.toInt()

    override fun getPageTitle(position: Int) = "$position"
}