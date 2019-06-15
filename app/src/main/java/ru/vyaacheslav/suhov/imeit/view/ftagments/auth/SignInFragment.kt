package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_FIRST
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignInView

/** Фрагмент авторизации */
class SignInFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = SignInView(activity!!)
        val btnSingIn: Button = v.findViewById(R.id.sign_in)
        val btnSignUp: View = v.findViewById(R.id.sign_up)

        btnSignUp.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_UP_FIRST) }
        btnSingIn.setOnClickListener { accountModel.signIn() }
        return v
    }
}