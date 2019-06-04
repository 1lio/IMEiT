package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.fr_bottomsheet.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsPagerFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment
import ru.vyaacheslav.suhov.imeit.view.view.UserHeader
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class BottomNavFragment : BottomSheetDialogFragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fr_bottomsheet, container, false)
        val navigation: NavigationView = v.findViewById(R.id.navigation_view)
        navigation.addHeaderView(UserHeader(activity!!))
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val model = ViewModelProviders.of(this)[MainViewModel::class.java]

        navigation_view.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.bells_info -> pushFragment(CallFragment())
                R.id.location -> pushFragment(MapsPagerFragment())
                R.id.schedule -> {
                    if (model.isExistsGroup()) pushFragment(SchedulePagerFragment())
                    else pushFragment(FragmentEmptyGroup())
                }
            }
            this.dismiss()
            true
        }
    }

    private fun pushFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction().replace(R.id.container, fragment).commit()
    }
}