package ru.assistant.ui.activites

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.assistant.ui.views.SplashView
import ru.student.assistant.R
import java.util.concurrent.TimeUnit

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(SplashView(this))

        val intent = Intent(this, MainActivity::class.java)

        Thread {
            TimeUnit.MILLISECONDS.sleep(1000)
            startActivity(intent)
            finish()
        }.start()
    }

}