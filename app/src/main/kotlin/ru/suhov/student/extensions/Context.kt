package ru.suhov.student.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

fun AppCompatActivity.pushFragment(fragment: Fragment, container: Int) {

    this.supportFragmentManager
        .beginTransaction()
        .replace(container, fragment)
        .commit()
}
