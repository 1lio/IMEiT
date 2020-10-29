package ru.student.assistant.auth.ui.view

import android.content.Context
import android.graphics.drawable.*
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import ru.student.assistant.auth.R

class AuthBackground @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0,
) : AppCompatImageView(context, attr, defStyle) {

    private val aToB: Drawable?
    private val bToA: Drawable?
    private val bToC: Drawable?
    private val cToB: Drawable?

    init {

        isFocusable = false
        isEnabled = false
        isClickable = false

        aToB = ContextCompat.getDrawable(context, R.drawable.a)
        bToA = ContextCompat.getDrawable(context, R.drawable.b)
        bToC = ContextCompat.getDrawable(context, R.drawable.c)
        cToB = ContextCompat.getDrawable(context, R.drawable.d)

        setImageDrawable(aToB)
        setState(0)
    }

    private var lastState = 0.toByte()

    fun setState(state: Byte) {

        /*var anim: AnimationDrawable = aToB!!

        when (state) {
            0.toByte() -> {
                anim =
                    if (lastState == 1.toByte()) aToB!! else cToB!!
                lastState = 0.toByte()
            }
            1.toByte() -> {
                anim = bToA!!
                lastState = 1.toByte()
            }
            2.toByte() -> {
                anim = bToC!!
                lastState = 2.toByte()
            }
        }

        setImageDrawable(anim)
        anim.start()*/
    }
}