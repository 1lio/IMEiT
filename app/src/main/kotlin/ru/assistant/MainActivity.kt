package ru.assistant

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.assistant.auth.ui.AuthFragment
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.contract.AppNavigation
import ru.assistant.ui.ContainerView

// Навигация в приложении происходит через AppNavigation который реализует активити. Стараюсь не
// тащить посторонние либы в проект
class MainActivity : AppCompatActivity(), AppNavigation {

    private lateinit var containerView: ContainerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        containerView = ContainerView(this@MainActivity)

        setContentView(containerView)

        if (savedInstanceState == null) pushFragmentById(FRAGMENT_AUTH, now = true)
    }

    private val fragmentManager = supportFragmentManager

    override fun pushFragmentById(id: Byte, container: Int, now: Boolean) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        if (now) {
            fragmentManager
                .beginTransaction()
                .replace(container, fragment, tag)
                .commitNow()
        } else {
            fragmentManager.beginTransaction()
                .addToBackStack(null)
                .replace(container, fragment, tag)
                .commit()
        }

        when (id) {

            /*  17.toByte() -> {
                  containerView.isVisibleAppBar = false
                  containerView.isVisibleFab = false
              }
              18.toByte() -> {
                  containerView.isVisibleAppBar = false
                  containerView.isVisibleFab = true
              }
              19.toByte() -> {
                  containerView.isVisibleAppBar = true
                  containerView.isVisibleFab = true
              }
              20.toByte() -> {
                  containerView.isVisibleAppBar = true
                  containerView.isVisibleFab = false
              }*/


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

    override fun showLoader(isShow: Boolean) {}


    // Activity know all main fragments in modules
    private fun getFragment(id: Byte) = when (id) {
        FRAGMENT_AUTH -> AuthFragment.newInstance()
        // FRAGMENT_ACCOUNT -> AccountFragment()
        // FRAGMENT_MAPS -> MapsFragment()
        // FRAGMENT_SCHEDULE ->
        // FRAGMENT_CALLS ->

        else -> Fragment()
    }

}
