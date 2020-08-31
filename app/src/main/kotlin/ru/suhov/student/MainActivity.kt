package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import ru.student.assistant.account.AccountFragment
import ru.student.assistant.auth.ui.AuthFragment
import ru.student.core.AppConstants.CONTAINER_ID
import ru.student.core.AppConstants.FRAGMENT_ACCOUNT
import ru.student.core.AppConstants.FRAGMENT_AUTH
import ru.student.core.base.ActivityContract

class MainActivity : AppCompatActivity(), ActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FragmentContainerView(this@MainActivity).apply { id = CONTAINER_ID })

        pushFragmentById(FRAGMENT_AUTH)
    }

    override fun pushFragmentById(id: Byte) {

        val fragment = getFragment(id)

        this@MainActivity.supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(CONTAINER_ID, fragment)
            .commit()
    }

    override fun removeFragmentById(id: Byte) {

        val fragment = getFragment(id)

        this@MainActivity.supportFragmentManager
            .beginTransaction()
            .remove(fragment)
            .commit()
    }

    private fun getFragment(id: Byte): Fragment {

        return when (id) {
            FRAGMENT_AUTH -> AuthFragment()
            FRAGMENT_ACCOUNT -> AccountFragment()
            else -> Fragment()
        }

    }

}
