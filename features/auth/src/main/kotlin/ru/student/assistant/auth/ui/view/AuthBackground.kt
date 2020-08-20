package ru.student.assistant.auth.ui.view

import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.ContextCompat
import ru.student.assistant.auth.R

class AuthBackground @JvmOverloads constructor(
    context: Context,
    attr: AttributeSet? = null,
    defStyle: Int = 0
) : AppCompatImageView(context, attr, defStyle) {

    init {
        isFocusable = false
        isEnabled = false
        isClickable = false

        setImageDrawable(ContextCompat.getDrawable(context, R.drawable.a))

        setState(State.CENTER)
    }

    private var lastState = State.LEFT

    fun setState(state: State) {

         val aToB = ContextCompat.getDrawable(context, R.drawable.a) as AnimationDrawable
         val bToA = ContextCompat.getDrawable(context, R.drawable.b) as AnimationDrawable
         val bToC = ContextCompat.getDrawable(context, R.drawable.c) as AnimationDrawable
         val cToB = ContextCompat.getDrawable(context, R.drawable.d) as AnimationDrawable

        var anim: AnimationDrawable = aToB
        when (state) {
            State.LEFT -> {
                anim =
                    if (lastState == State.CENTER) aToB else cToB
                lastState = State.LEFT
            }
            State.CENTER -> {
                anim = bToA
                lastState = State.CENTER
            }
            State.RIGHT -> {
                anim = bToC
                lastState = State.RIGHT
            }
        }

        setImageDrawable(anim)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        anim.start()
    }

    enum class State { LEFT, CENTER, RIGHT }
}