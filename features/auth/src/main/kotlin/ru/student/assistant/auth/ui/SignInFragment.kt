package ru.student.assistant.auth.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.appbar.AppBarLayout
import kotlinx.android.synthetic.main.fr_sign_in.*
import ru.student.assistant.auth.R
import ru.student.assistant.auth.util.isValidEmail
import ru.student.assistant.auth.util.isValidPass
import ru.student.assistant.auth.viewmodel.AuthSignInModel
import ru.student.assistant.auth.viewmodel.AuthState.SIGN_IN
import ru.student.assistant.auth.viewmodel.AuthViewModel

class SignInFragment : Fragment() {

     val state: Byte = SIGN_IN

    private lateinit var viewModel: AuthSignInModel
    private lateinit var authViewModel: AuthViewModel

    private var isValid = false

    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, bundle: Bundle?): View? {
        super.onCreateView(inflater, group, bundle)
        viewModel = ViewModelProvider(this)[AuthSignInModel::class.java]
        authViewModel = ViewModelProvider(this)[AuthViewModel::class.java]
        return inflater.inflate(R.layout.fr_sign_in, group, false)
    }

    override fun onViewCreated(view: View, instance: Bundle?) {
        super.onViewCreated(view, instance)

        isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
        viewModel.setValidForm(isValid)

        viewModel.observeForm(this, Observer { authViewModel.setEnableAction(isValid) })

        authRestore.setOnClickListener {

            val frame: AppBarLayout = activity!!.findViewById(R.id.authAppBarLayout)
            frame.visibility = View.INVISIBLE


            val fm = activity!!.supportFragmentManager
            fm.beginTransaction().replace(R.id.frameLayout, RestoreFragment()).commitNow()
        }

        listOf(edSignEmail, edSignPass).forEach {

            it.addTextChangedListener(object : TextWatcher {

                override fun afterTextChanged(s: Editable?) {}
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                    if (it == edSignEmail) edSignEmail.isValidEmail() else edSignPass.isValidPass()

                    isValid = (edSignEmail.isValidEmail() && edSignPass.isValidPass())
                    viewModel.setValidForm(isValid)
                    authViewModel.setEnableAction(isValid && (authViewModel.getState() == SIGN_IN))

                }
            })

        }
    }

    override fun onResume() {
        super.onResume()
        // authViewModel.setActionName(resources.getString(R.string.sign_in).toUpperCase(Locale.ROOT))
        viewModel.setValidForm(isValid)
    }
}