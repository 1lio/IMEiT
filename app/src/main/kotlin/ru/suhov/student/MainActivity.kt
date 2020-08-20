package ru.suhov.student

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import ru.student.assistant.auth.ui.AuthFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = FragmentContainerView(this)
        container.id = View.generateViewId()

        setContentView(container)

        // Грузим фрагмент с авторизацией
        pushFragment(AuthFragment(), container.id)
    }

    private fun AppCompatActivity.pushFragment(fragment: Fragment, container: Int) {
        this.supportFragmentManager
            .beginTransaction()
            .replace(container, fragment)
            .commit()
    }
}
