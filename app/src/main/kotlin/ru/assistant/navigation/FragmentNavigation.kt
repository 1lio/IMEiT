package ru.assistant.navigation

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import ru.assistant.MainActivity
import ru.assistant.auth.ui.AuthFragment
import ru.assistant.core.AppConstants
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.contract.AppNavigation
import ru.assistant.debug.FragmentEmpty
import ru.assistant.ui.ContainerView
import ru.assistant.ui.ContainerViewModel

class FragmentNavigation(private val activity: AppCompatActivity) : AppNavigation {

    private lateinit var containerViewModel: ContainerViewModel

    private val fragmentManager = activity.supportFragmentManager

    override fun pushFragmentById(id: Byte, container: Int, now: Boolean) {

        containerViewModel =
            ViewModelProvider(activity as MainActivity)[ContainerViewModel::class.java]

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

        val containerView = activity.findViewById<ContainerView>(AppConstants.CONTAINER_ID)

        containerViewModel.setVisibleAppBar(true)
        containerViewModel.setVisibleFAB(false)

        containerView.setFabAction {
            containerViewModel.setVisibleAppBar(false)
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
        TODO("Not yet implemented")
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