package ru.suhov.student.features.auth

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.v_sign_in.*
import ru.suhov.student.features.viewmodel.AuthSignInModel
import ru.suhov.student.R
import ru.suhov.student.core.extension.isValidEmail
import ru.suhov.student.core.extension.isValidPass
import ru.suhov.student.features.viewmodel.AuthState
import java.util.*

class SignInFragment : BaseAuthFragment() {

    override val state: AuthState = AuthState.SIGN_IN

    private lateinit var viewModel: AuthSignInModel

    private var isValid = false

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        super.onCreateView(inflater, group, bundle)
        viewModel = ViewModelProvider(this)[AuthSignInModel::class.java]
        return inflater.inflate(R.layout.fr_sign_in, group, false)
    }

    override fun onViewCreated(view: View, instance: Bundle?) {
        super.onViewCreated(view, instance)

        isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, Observer { authModel.setEnableAction(isValid) })

        authRestore.setOnClickListener {

            val frame: AppBarLayout = activity!!.findViewById(R.id.authAppBarLayout)
            frame.visibility = View.INVISIBLE

            authModel.setActionName(resources.getString(R.string.restore))

            val fm = childFragmentManager
            fm.beginTransaction().replace(R.id.frameLayout,
                AuthRestoreFragment(fm)
            ).commit()
        }

        listOf(edSignEmail, edSignPass).forEach {

            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if (it == edSignEmail) edSignEmail.isValidEmail() else edSignPass.isValidPass()

                    isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
                    viewModel.setValidForm(isValid)
                    authModel.setEnableAction(isValid && (authModel.getState() == AuthState.SIGN_IN))

                }
            })

        }
    }

    override fun onResume() {
        super.onResume()
        authModel.setActionName(resources.getString(R.string.sign_in).toUpperCase(Locale.ROOT))
        viewModel.setValidForm(isValid)
    }
}