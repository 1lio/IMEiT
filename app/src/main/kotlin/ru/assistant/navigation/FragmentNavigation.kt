package ru.assistant.navigation

import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.assistant.auth.ui.AuthFragment
import ru.assistant.core.AppConstants
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.AppConstants.FRAGMENT_RESTORE
import ru.assistant.core.contract.AppNavigation
import ru.assistant.debug.FragmentEmpty
import ru.assistant.ui.ContainerView

class FragmentNavigation(private val activity: AppCompatActivity) : AppNavigation {

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


        val containerView = activity.findViewById<ContainerView>(AppConstants.CONTAINER_ID)
        //containerView.isVisibleAppBar =  (id != FRAGMENT_AUTH && id != FRAGMENT_RESTORE)

        Toast.makeText(activity, (containerView ).toString(), Toast.LENGTH_SHORT).show()



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