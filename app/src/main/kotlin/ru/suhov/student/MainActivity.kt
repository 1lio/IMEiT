package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.student.assistant.auth.ui.AuthFragment
import ru.suhov.student.extensions.pushFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)
        // Грузим фрагмент с авторизацией
        pushFragment(AuthFragment())
    }

}
