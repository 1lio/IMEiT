package ru.student.assistant.calls

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager


fun AppCompatActivity.pushFragment(fragment: Fragment, container: Int) {

    this.supportFragmentManager
        .beginTransaction()
        .replace(container, fragment)
        .commit()
}

fun Fragment.pushFragment(fm: FragmentManager) {

    fm
        .beginTransaction()
        .replace(R.id.container, this)
        .commit()
}
