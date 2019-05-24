package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.navigation.NavigationView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsPagerFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

// TODO: ОБНОВЛЕНИЕ ФРАГМЕНТОВ В КОНТЕЙНЕРЕ!!!
class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    private lateinit var model: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fr_bottomsheet, container, false)
        model = ViewModelProviders.of(activity!!)[MainViewModel::class.java]

        val navigation: NavigationView = v.findViewById(R.id.navigation_view)
        navigation.setOnClickListener {
            when (it!!.id) {
                R.id.bells_info -> pushFragment(CallFragment())
                R.id.location -> pushFragment(MapsPagerFragment())
                R.id.schedule -> {
                    if (model.isSelectedGroup()) pushFragment(SchedulePagerFragment())
                    else pushFragment(EmptyGroupFragment())
                }
            }
        }
        return v
    }

    private fun pushFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction().replace(R.id.container, fragment).commit()
    }
}