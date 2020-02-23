package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fr_bottomsheet.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_CALLS
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_MAPS
import ru.vyaacheslav.suhov.imeit.view.view.auth.UserHeader
import ru.vyaacheslav.suhov.imeit.viewmodel.ControlViewModel

/** Фрагмент с менюшкой навигации */
class BottomNavFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fr_bottomsheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navigation_view.addHeaderView(UserHeader(activity!!))

        val controlModel = ViewModelProvider(activity!!)[ControlViewModel::class.java]
        controlModel.observeVisibleUI(activity!!, Observer { if (!it) this.dismiss() })

        navigation_view.setNavigationItemSelectedListener {
            controlModel.setFragmentId(
                when (it.itemId) {
                    R.id.bells_info -> FRAGMENT_CALLS
                    R.id.location -> FRAGMENT_MAPS
                    else -> controlModel.getFragmentSchedule()
                }
            )

            this.dismiss()
            true
        }
    }
}