package ru.suhov.student

import android.annotation.SuppressLint
import androidx.appcompat.view.menu.MenuBuilder
import com.google.android.material.bottomappbar.BottomAppBar
import ru.student.core.ext.getDrawable

@SuppressLint("RestrictedApi")
fun BottomAppBar.setAppBarMenu() {

    val m = MenuBuilder(this.context)
    m.add(1, 1, 0, R.string.nav_account).apply { icon = getDrawable(R.drawable.ic_account) }
    m.add(1, 2, 1, R.string.nav_calls).apply { icon = getDrawable(R.drawable.ic_calls) }
    m.add(1, 3, 2, R.string.nav_schedule).apply { icon = getDrawable(R.drawable.ic_schedule) }
    m.add(1, 3, 2, R.string.nav_maps).apply { icon = getDrawable(R.drawable.ic_location) }
    m.add(1, 3, 2, R.string.nav_chat).apply { icon = getDrawable(R.drawable.ic_chat) }

    this.setMenu(m, null)
}