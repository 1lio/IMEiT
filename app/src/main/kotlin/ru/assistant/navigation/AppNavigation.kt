package ru.assistant.navigation

import androidx.fragment.app.Fragment
import ru.assistant.MainActivity
import ru.assistant.auth.ui.AuthFragment
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.contract.AppNavigation
import ru.assistant.debug.FragmentEmpty

class AppNavigation(private val activity: MainActivity) : AppNavigation {

    private val fragmentManager = activity.supportFragmentManager

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

    override fun showLoader(isShow: Boolean) {
    }

    // Activity know all main fragments in modules
    private fun getFragment(id: Byte) = when (id) {
        FRAGMENT_AUTH -> AuthFragment.newInstance()
        17.toByte() -> FragmentEmpty()
        // FRAGMENT_ACCOUNT -> AccountFragment()
        // FRAGMENT_MAPS -> MapsFragment()
        // FRAGMENT_SCHEDULE ->
        // FRAGMENT_CALLS ->

        else -> Fragment()
    }

}