package ru.student.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.student.assistant.account.AccountFragment
import ru.student.assistant.auth.ui.AuthFragment
import ru.student.assistant.maps.MapsFragment
import ru.student.core.AppConstants
import ru.student.core.contract.ActivityContract

// Fragments communicate in Activity through Contract
class MainActivity : AppCompatActivity(), ActivityContract {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContainerView(this@MainActivity))

        pushFragmentById(AppConstants.FRAGMENT_AUTH)
    }

    override fun pushFragmentById(id: Byte, container: Int) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(container, fragment, tag)
            .commit()

        findViewById<ContainerView>(AppConstants.CONTAINER_ID).apply {
            isVisibleAppBar =
                id != AppConstants.FRAGMENT_AUTH && id != AppConstants.FRAGMENT_RESTORE
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
        AppConstants.FRAGMENT_AUTH -> AuthFragment()
        AppConstants.FRAGMENT_ACCOUNT -> AccountFragment()
        AppConstants.FRAGMENT_MAPS -> MapsFragment()
        else -> Fragment()
    }
}
