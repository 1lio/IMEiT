package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.student.assistant.auth.ui.AuthFragment
import ru.suhov.student.extensions.pushFragment

class MainActivity : AppCompatActivity(R.layout.activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Грузим фрагмент с авторизацией
        if (savedInstanceState == null) pushFragment(AuthFragment())
    }

}
