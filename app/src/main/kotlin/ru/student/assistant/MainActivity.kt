package ru.student.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.student.assistant.account.AccountFragment
import ru.student.assistant.auth.ui.AuthFragment
import ru.student.assistant.maps.MapsFragment
import ru.student.core.AppConstants.CONTAINER_ID
import ru.student.core.AppConstants.FRAGMENT_ACCOUNT
import ru.student.core.AppConstants.FRAGMENT_AUTH
import ru.student.core.AppConstants.FRAGMENT_MAPS
import ru.student.core.AppConstants.FRAGMENT_RESTORE
import ru.student.core.contract.ActivityContract

// Fragments communicate in Activity through Contract
class MainActivity : AppCompatActivity(), ActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContainerView(this@MainActivity))

        pushFragmentById(FRAGMENT_AUTH)
    }

    override fun pushFragmentById(id: Byte, container: Int) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(container, fragment, tag)
            .commit()

        findViewById<ContainerView>(CONTAINER_ID).apply {
            isVisibleAppBar = id != FRAGMENT_AUTH && id != FRAGMENT_RESTORE
        }
    }

    override fun removeFragmentById(id: Byte) {

        supportFragmentManager.findFragmentByTag(getFragment(id)::class.java.name)
            ?.let {
                supportFragmentManager
                    .beginTransaction()
                    .remove(it)
                    .commit()
            } ?: return
    }

    // Activity know all main fragments in modules
    private fun getFragment(id: Byte) = when (id) {
        FRAGMENT_AUTH -> AuthFragment()
        FRAGMENT_ACCOUNT -> AccountFragment()
        FRAGMENT_MAPS -> MapsFragment()
        else -> Fragment()
    }
}
