package ru.vyaacheslav.suhov.imeit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.vyaacheslav.suhov.imeit.view.ftagments.auth.SignInFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportFragmentManager.beginTransaction().replace(R.id.login_container, SignInFragment()).commit()


    }
}