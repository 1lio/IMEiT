package ru.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.assistant.auth.ui.AuthFragment
import ru.assistant.core.AppConstants.CONTAINER_ID
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.AppConstants.FRAGMENT_RESTORE
import ru.assistant.core.contract.ActivityContract
import ru.assistant.ui.ContainerView

// Fragments communicate in Activity through Contract
class MainActivity : AppCompatActivity(), ActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContainerView(this@MainActivity))

        pushFragmentById(FRAGMENT_AUTH, now = true)
    }

    private val fragmentManager = supportFragmentManager

    override fun pushFragmentById(id: Byte, container: Int, now: Boolean) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        if (now) {
            fragmentManager
                .beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commitNow()
        } else {
            fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commit()
        }

        findViewById<ContainerView>(CONTAINER_ID).apply {
            isVisibleAppBar = id != FRAGMENT_AUTH && id != FRAGMENT_RESTORE
        }
    }

    override fun removeFragmentById(id: Byte) {

        fragmentManager.findFragmentByTag(getFragment(id)::class.java.name)
            ?.let {
                fragmentManager
                    .beginTransaction()
                    .remove(it)
                    .commit()
            } ?: return
    }

    // Activity know all main fragments in modules
    private fun getFragment(id: Byte) = when (id) {
        FRAGMENT_AUTH -> AuthFragment()
        // FRAGMENT_ACCOUNT -> AccountFragment()
        // FRAGMENT_MAPS -> MapsFragment()
        // FRAGMENT_SCHEDULE ->
        // FRAGMENT_CALLS ->

        else -> Fragment()
    }

}
