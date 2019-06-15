package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_FIRST
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignUpLastView

/** Последний фрагмент регистрации */
class SignUpSecondFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = SignUpLastView(activity!!)

        val btnBack: View = v.findViewById(R.id.btn_back)
        val btnCreate: Button = v.findViewById(R.id.registration)

        btnBack.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_UP_FIRST) }
        btnCreate.setOnClickListener { accountModel.signUp() }

        return v
    }
}