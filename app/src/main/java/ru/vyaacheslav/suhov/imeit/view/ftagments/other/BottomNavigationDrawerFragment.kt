package ru.vyaacheslav.suhov.imeit.view.ftagments.other

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fr_bottomsheet.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsPagerFragment

class BottomNavigationDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fr_bottomsheet, container, false)
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        navigation_view.setNavigationItemSelectedListener { menuItem ->

            when (menuItem.itemId) {
                R.id.bells_info -> pushFragment(CallFragment())
                R.id.location -> pushFragment(MapsPagerFragment())
                /*   R.id.schedule -> {
                       if (model.isSelectedGroup()) pushFragment(SchedulePagerFragment())
                       else pushFragment(EmptyGroupFragment())
                   }*/

            }
            true

            //TODO: ОТКРЕПИТЬ ДИАЛОГ ФРАГМЕНТ ПОСЛЕ НАЖАТИЯ
        }


    }

    private fun pushFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction().replace(R.id.container, fragment).commit()
    }
}