package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.pushFragment
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignInView

class FragmentLogin : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = SignInView(context!!)

        val singIn: Button = v.findViewById(R.id.sign_in)
        val signUp: View = v.findViewById(R.id.sign_up)

        signUp.setOnClickListener { SignUpFirstStepFragment().pushFragment(fragmentManager!!) }
        singIn.setOnClickListener { loginViewModel.login(true)}
        return v
    }
}