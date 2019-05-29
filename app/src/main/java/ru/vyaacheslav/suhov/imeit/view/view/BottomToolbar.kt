package ru.vyaacheslav.suhov.imeit.view.view

import android.content.Context
import android.graphics.PorterDuff
import android.util.AttributeSet
import androidx.core.content.ContextCompat
import com.google.android.material.bottomappbar.BottomAppBar
import ru.vyaacheslav.suhov.imeit.R

class BottomToolbar : BottomAppBar {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    init {
        overflowIcon!!.setColorFilter(ContextCompat.getColor(context, R.color.white), PorterDuff.Mode.SRC_ATOP)
        replaceMenu(R.menu.menu)
        fabAlignmentMode = FAB_ALIGNMENT_MODE_CENTER
        backgroundTint = ContextCompat.getColorStateList(context, R.color.colorPrimary)
    }
}