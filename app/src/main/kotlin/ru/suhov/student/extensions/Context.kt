package ru.suhov.student.extensions

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.suhov.student.R

fun AppCompatActivity.pushFragment(fragment: Fragment) {

    this.supportFragmentManager
        .beginTransaction()
        .replace(R.id.container, fragment)
        .commit()
}

