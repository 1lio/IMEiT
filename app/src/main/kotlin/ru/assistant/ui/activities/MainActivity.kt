package ru.assistant.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.assistant.auth.ui.AuthFragment
import ru.assistant.core.AppConstants.FRAGMENT_AUTH
import ru.assistant.core.AppConstants.FRAGMENT_ID_KEY
import ru.assistant.core.AppConstants.LOADER_ID
import ru.assistant.core.contract.AppNavigation
import ru.assistant.ui.views.ContainerView
import ru.assistant.ui.views.LoaderView

// Навигация в приложении происходит через AppNavigation который реализует активити.
class MainActivity : AppCompatActivity(), AppNavigation {

    private lateinit var containerView: ContainerView
    private var fragmentId: Byte = DEFAULT_FRAGMENT

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        containerView = ContainerView(this@MainActivity)
        setContentView(containerView)
        if (savedInstanceState == null) pushFragmentById(FRAGMENT_AUTH, isPushNow = true)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        fragmentId = savedInstanceState.getByte(FRAGMENT_ID_KEY)
        pushFragmentById(fragmentId)
    }

    override fun onResume() {
        super.onResume()
        pushFragmentById(fragmentId)
    }

    private val fragmentManager = supportFragmentManager

    override fun pushFragmentById(id: Byte, container: Int, isPushNow: Boolean) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        showLoader(true)
        
        if (isPushNow) {
            fragmentManager
                    .beginTransaction()
                    .replace(container, fragment, tag)
                    .commitNow()
        } else {
            fragmentManager
                    .beginTransaction()
                    .addToBackStack(null)
                    .replace(container, fragment, tag)
                    .commit()
        }

        if (id != FRAGMENT_AUTH) {
            containerView.run {
                isVisibleAppBar = true
                isVisibleFab = true
            }
        }

        showLoader(false)
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

    override fun showLoader(isShow: Boolean, message: String) {

        val loaderView: LoaderView?

        if (isShow) {

            loaderView = findViewById(LOADER_ID) ?: LoaderView(this)

            if (findViewById<LoaderView>(LOADER_ID) == null) {
                containerView.addView(loaderView)
            }

            loaderView.setText(message)
        } else containerView.removeView(findViewById(LOADER_ID))

    }

    private fun getFragment(id: Byte) = when (id) {
        FRAGMENT_AUTH -> AuthFragment.newInstance()
        // FRAGMENT_ACCOUNT -> AccountFragment()
        // FRAGMENT_MAPS -> MapsFragment()
        // FRAGMENT_SCHEDULE ->
        // FRAGMENT_CALLS ->

        else -> Fragment()
    }

    private companion object {
        const val DEFAULT_FRAGMENT: Byte = FRAGMENT_AUTH
    }

}
