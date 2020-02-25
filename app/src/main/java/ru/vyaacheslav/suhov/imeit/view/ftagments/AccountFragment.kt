package ru.vyaacheslav.suhov.imeit.view.ftagments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.account.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.viewmodel.AuthViewModel

class AccountFragment : Fragment() {

    private var title: String? = null
    private var subTitle: String? = null


    override fun onCreateView(inflater: LayoutInflater, group: ViewGroup?, state: Bundle?): View? =
        inflater.inflate(R.layout.account, group, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val activity = context as MainActivity
        val model = ViewModelProvider(activity)[AuthViewModel::class.java]

        model.observeUser(activity, Observer {
            title = it.name.trim()
            subTitle = "${it.faculty.trim()} | ${it.group.trim()}"
        })

        uName.text = title
        uGroup.text = subTitle

        exit.setOnClickListener { model.signOut() }
    }

}