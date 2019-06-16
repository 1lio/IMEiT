package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fr_bottomsheet.*
import ru.vyaacheslav.suhov.imeit.view.MainActivity
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_CALLS
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_MAPS
import ru.vyaacheslav.suhov.imeit.view.view.auth.UserHeader
import ru.vyaacheslav.suhov.imeit.viewmodel.ControlViewModel

class BottomNavFragment : BottomSheetDialogFragment() {

    private lateinit var controlModel: ControlViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fr_bottomsheet, container, false)
        val activity = context as MainActivity
        val navigation: NavigationView = v.findViewById(R.id.navigation_view)

        controlModel = ViewModelProviders.of(activity)[ControlViewModel::class.java]
        navigation.addHeaderView(UserHeader(activity))
        controlModel.observeVisibleUI(activity, Observer { if (!it) this.dismiss() })
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener {
            controlModel.setFragmentId(
                    when (it.itemId) {
                        R.id.bells_info -> FRAGMENT_CALLS
                        R.id.location -> FRAGMENT_MAPS
                        else -> controlModel.getFragmentSchedule()
                    })

            this.dismiss()
            true
        }
    }
}