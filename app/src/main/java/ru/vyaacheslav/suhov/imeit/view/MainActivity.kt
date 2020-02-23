package ru.vyaacheslav.suhov.imeit.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.AppConstants.DIALOG_EXIT
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_CALLS
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_MAPS
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_SCHEDULE
import ru.vyaacheslav.suhov.imeit.viewmodel.ActivityController
import ru.vyaacheslav.suhov.imeit.viewmodel.ControlViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var model: ControlViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity)

        ActivityController(activity = this@MainActivity)
        model = ViewModelProvider(this@MainActivity)[ControlViewModel::class.java]

        bottomBar.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.account -> model.setFragmentId(FRAGMENT_SCHEDULE)
                R.id.bells -> model.setFragmentId(FRAGMENT_CALLS)
                R.id.schedule -> model.setFragmentId(FRAGMENT_SCHEDULE)
                R.id.maps -> model.setFragmentId(FRAGMENT_MAPS)
                R.id.chat -> model.setFragmentId(FRAGMENT_SCHEDULE)
            }
            true
        }
    }

    override fun onBackPressed() {
        model.setDialogID(DIALOG_EXIT)
    }
}