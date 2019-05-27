package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import ru.vyaacheslav.suhov.imeit.R

class Fab : FloatingActionButton {

    constructor(context: Context) : super (context)
    constructor(context: Context, attr:AttributeSet) : super(context,attr)

    init {

        if (isEnabled) {
           setBackgroundColor(ContextCompat.getColor(context, R.color.colorAccent))
        } else {
           setBackgroundColor(ContextCompat.getColor(context, R.color.gray))
        }

        visibility = View.GONE
    }
}