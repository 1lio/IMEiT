package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.v_sign_up.*
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_IN
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_SECOND
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignUpFirstView

/** Первый фрагмент регистрации */
class SignUpFirstFragment : BaseLoginFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return SignUpFirstView(activity!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_next_u.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_UP_SECOND) }
        btn_cancel.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_IN) }
    }
}