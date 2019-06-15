package ru.vyaacheslav.suhov.imeit.view.ftagments.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.base.BaseLoginFragment
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_IN
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SIGN_UP_SECOND
import ru.vyaacheslav.suhov.imeit.view.view.auth.SignUpFirstView

/** Первый фрагмент регистрации */
class SignUpFirstFragment : BaseLoginFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = SignUpFirstView(activity!!)

        val btnNext: Button = v.findViewById(R.id.btn_next_u)
        val btnCancel: Button = v.findViewById(R.id.cancel)

        btnNext.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_UP_SECOND) }
        btnCancel.setOnClickListener { controlModel.setFragmentId(FRAGMENT_SIGN_IN) }
        return v
    }
}