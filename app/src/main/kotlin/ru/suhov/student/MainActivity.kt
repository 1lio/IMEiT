package ru.suhov.student

import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import ru.student.assistant.account.AccountFragment
import ru.student.assistant.auth.ui.AuthFragment
import ru.student.assistant.auth.ui.RestoreFragment
import ru.student.assistant.auth.ui.SignInFragment
import ru.student.assistant.auth.ui.SignUpFragment
import ru.student.assistant.maps.MapsFragment
import ru.student.core.AppConstants
import ru.student.core.AppConstants.CONTAINER_ID
import ru.student.core.base.ActivityContract

// Fragments communicate in Activity through Contract
class MainActivity : AppCompatActivity(), ActivityContract {

    private val fragmentManager = this.supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(FrameLayout(this@MainActivity).apply { id = CONTAINER_ID })

        pushFragmentById(AppConstants.FRAGMENT_MAPS)
    }

    override fun pushFragmentById(id: Byte, container: Int) {

        val fragment = getFragment(id)
        val tag = fragment::class.java.name

        fragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(container, fragment, tag)
            .commit()

        if (id != AppConstants.FRAGMENT_AUTH && id != AppConstants.FRAGMENT_RESTORE) {
        //...
        }
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
            //Maps
            AppConstants.FRAGMENT_MAPS -> MapsFragment()
            //...
            else -> Fragment()
        }

    }

}
