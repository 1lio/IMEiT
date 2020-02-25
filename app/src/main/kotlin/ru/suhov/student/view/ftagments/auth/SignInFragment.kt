package ru.suhov.student.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.v_sign_in.*
import ru.suhov.student.base.BaseLoginFragment
import ru.suhov.student.util.AppConstants.FRAGMENT_SIGN_UP_FIRST
import ru.suhov.student.view.view.auth.SignInView

/** Фрагмент авторизации */
class SignInFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return SignInView(activity!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_sign_in.setOnClickListener { accountModel.signIn() }
        btn_sign_up.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_UP_FIRST) }
    }
}