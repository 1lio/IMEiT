package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import ru.student.assistant.auth.ui.AuthFragment
import ru.student.core.AppConstants.CONTAINER_ID

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val container = FragmentContainerView(this@MainActivity)
        container.id = CONTAINER_ID

        setContentView(container)

        AuthFragment().pushFragment()
    }

    private fun Fragment.pushFragment() {
        this@MainActivity.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(CONTAINER_ID, this)
            .commit()
    }
}
