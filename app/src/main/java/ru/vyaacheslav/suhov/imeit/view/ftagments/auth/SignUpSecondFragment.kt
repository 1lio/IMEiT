package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.v_sign_up_last.*
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_FIRST
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignUpLastView

class SignUpSecondFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return SignUpLastView(activity!!)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_back.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_UP_FIRST) }
    }
}