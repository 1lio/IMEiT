package ru.assistant.ui

import android.content.Context
import android.graphics.drawable.AnimatedVectorDrawable
import android.os.Handler
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.content.ContextCompat
import ru.student.assistant.R
import java.util.concurrent.Executor

class SplashView(context: Context) : LinearLayout(context) {

    private var animVector: AnimatedVectorDrawable
    private var vectorImage: ImageView

    init {

        orientation = VERTICAL
        gravity = Gravity.CENTER

        vectorImage = ImageView(context)
        val margin = context.resources.getDimensionPixelOffset(R.dimen.margin_form)
        vectorImage.layoutParams =
            LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT).apply {
                setMargins(0, 0, 0, margin)
            }


        // Векторная анимация | Установим картинку по умолчанию
        animVector =
            ContextCompat.getDrawable(context, R.drawable.vector_splash) as AnimatedVectorDrawable

        vectorImage.setImageDrawable(animVector)
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)

        addView(vectorImage)

        // Запуск анимаций с задержкой, чтобы показать анимацию после открытия окна
        startAnimation()
    }

    private fun startAnimation() {
        Handler().postDelayed({
            animVector.start()
        }, 1500)
    }

}
