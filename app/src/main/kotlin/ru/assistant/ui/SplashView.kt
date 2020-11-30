package ru.assistant.ui

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.view.Gravity
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import ru.student.assistant.R

/** == SplashView ==

LinearLayout
- ImageView(Logo)
 */

class SplashView(context: Context) : LinearLayout(context) {

    private lateinit var logo: ImageView

    init {
        configureRoot()
        configureLogo()
        merge()
    }

    private fun configureRoot() {

        // Включаем поддержку векторных ресурсов
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        // По умолчанию тема центрует без учета статус бара, делаем сдвиг снизу
        val margin = context.resources.getDimensionPixelOffset(R.dimen.margin_form)
        orientation = VERTICAL
        gravity = Gravity.CENTER

        layoutParams = LayoutParams(MATCH_PARENT, MATCH_PARENT).apply {
            setMargins(0, 0, 0, margin)
        }

    }

    private fun configureLogo() {
        val animVector =
            ContextCompat.getDrawable(context, R.drawable.splash) as AnimatedVectorDrawable

        logo = ImageView(context).apply {
            setImageDrawable(animVector)
        }

        animVector.start()
    }

    private fun merge() {
        addView(logo)
    }

}
