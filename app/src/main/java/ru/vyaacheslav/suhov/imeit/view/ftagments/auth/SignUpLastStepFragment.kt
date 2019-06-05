package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.pushFragment
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignUpLastView

class SignUpLastStepFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = SignUpLastView(context!!)

        val btnBack: View = v.findViewById(R.id.btn_back)
        val btnCreate: Button = v.findViewById(R.id.registration)

        btnBack.setOnClickListener { SignUpFirstStepFragment().pushFragment(fragmentManager!!) }
        btnCreate.setOnClickListener { createAccount(loginViewModel.getEmail(), loginViewModel.getPass()) }

        return v
    }
}