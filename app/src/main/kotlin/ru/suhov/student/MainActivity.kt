package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.student.assistant.auth.ui.AuthFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, AuthFragment())
                .commit()
        }
    }

}
