package ru.vyaacheslav.suhov.imeit.util

import android.content.Context
import android.os.Build
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R

fun TextView.styleAppearance(context: Context) {
    if (Build.VERSION.SDK_INT < 23) {
        this.setTextAppearance(context, R.style.TextCurrentPair)
    } else {
        this.setTextAppearance(R.style.TextCurrentPair)
    }
}

