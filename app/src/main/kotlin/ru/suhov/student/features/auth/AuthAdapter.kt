package ru.suhov.student.features.auth

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class AuthAdapter(fm: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fm, lifecycle) {

    override fun createFragment(position: Int)= if (position == 0) SignInFragment() else SignUpFragment()

    override fun getItemCount(): Int = 2
}