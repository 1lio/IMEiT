package ru.assistant.ui.views

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.util.TypedValue
import android.view.Gravity
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import ru.assistant.core.AppConstants.LOADER_ID
import ru.student.assistant.R

/** == LoaderView ==

LinearLayout
- ImageView(LoaderImage)
- TextView(Message)
 */

class LoaderView(context: Context) : LinearLayout(context) {

    private lateinit var imageView: AppCompatImageView
    private lateinit var textView: AppCompatTextView

    init {
        configureRoot()
        configureImage()
        configureText()
        merge()
    }

    private fun configureRoot() {
        id = LOADER_ID
        setBackgroundColor(ContextCompat.getColor(context, R.color.white))
        orientation = VERTICAL
        setPadding(0, 0, 0, 200)
        gravity = Gravity.CENTER
    }

    private fun configureImage() {
        val animVector =
            ContextCompat.getDrawable(context, R.drawable.loader) as AnimatedVectorDrawable

        imageView = AppCompatImageView(context).apply {
            id = ID_IMAGE
            layoutParams = LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            ).apply {
                gravity = Gravity.CENTER
            }
            setImageDrawable(animVector)
        }

        animVector.start()
    }

    private fun configureText() {
        textView = AppCompatTextView(context).apply {
            id = ID_TEXT
            text = DEFAULT_TEXT
            setTextSize(
                TypedValue.COMPLEX_UNIT_SP,
                resources.getDimension(R.dimen.text_size_small)
            )
            layoutParams = LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            textAlignment = TEXT_ALIGNMENT_CENTER
            setTextColor(ContextCompat.getColor(context, R.color.grayLight))
        }
    }

    private fun merge() {
        addView(imageView)
        addView(textView)
    }

    fun setText(message: String = DEFAULT_TEXT) {
        textView.text = message
    }

    private companion object {
        const val DEFAULT_TEXT = "${0x2026.toChar()}" // …
        const val ID_TEXT = 103
        const val ID_IMAGE = 102
    }
}