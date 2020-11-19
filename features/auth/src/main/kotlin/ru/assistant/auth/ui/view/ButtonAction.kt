package ru.assistant.auth.ui.view

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import ru.student.assistant.auth.R

class ButtonAction : AppCompatTextView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attr: AttributeSet) : super(context, attr)

    init {

        text = resources.getString(R.string.sign_in)

        isAllCaps = true

        val colorAccent = ContextCompat.getColor(context, R.color.colorAccent)
        val colorGray = ContextCompat.getColor(context, R.color.gray)

        setTextColor(if (isEnabled) colorAccent else colorGray)

    }
}
