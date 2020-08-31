package ru.suhov.student

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import ru.student.assistant.account.AccountFragment
import ru.student.assistant.auth.ui.AuthFragment
import ru.student.assistant.auth.ui.RestoreFragment
import ru.student.assistant.auth.ui.SignInFragment
import ru.student.assistant.auth.ui.SignUpFragment
import ru.student.core.AppConstants.CONTAINER_ID
import ru.student.core.AppConstants
import ru.student.core.contract.ActivityContract

// Fragments communicate in Activity through Contract
class MainActivity : AppCompatActivity(), ActivityContract {

    private val fragmentManager = this.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FragmentContainerView(this@MainActivity).apply { id = CONTAINER_ID })

        pushFragmentById(AppConstants.FRAGMENT_AUTH)
    }

    override fun pushFragmentById(id: Byte, container: Int) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        fragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(container, fragment, tag)
            .commit()
    }

    override fun removeFragmentById(id: Byte) {

        val fragmentByTag = fragmentManager.findFragmentByTag(getFragment(id)::class.java.name)

        if (fragmentByTag != null) {
            fragmentManager
                .beginTransaction()
                .remove(fragmentByTag)
                .commit()
        }
    }

    // Activity know all fragments in modules
    // This project numbers ~20 fragments
    private fun getFragment(id: Byte): Fragment {
        return when (id) {
            // Auth
            AppConstants.FRAGMENT_AUTH -> AuthFragment()
            AppConstants.FRAGMENT_RESTORE -> RestoreFragment()
            AppConstants.FRAGMENT_SIGN_IN -> SignInFragment()
            AppConstants.FRAGMENT_SIGN_UP -> SignUpFragment()
            // Account
            AppConstants.FRAGMENT_ACCOUNT -> AccountFragment()
            //...
            else -> Fragment()
        }

    }

}
