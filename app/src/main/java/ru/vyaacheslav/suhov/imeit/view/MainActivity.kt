package ru.vyaacheslav.suhov.imeit.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.util.AppConstants.DIALOG_EXIT
import ru.vyaacheslav.suhov.imeit.util.AppConstants.DIALOG_GROUP
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_CALLS_PREF
import ru.vyaacheslav.suhov.imeit.util.AppConstants.FRAGMENT_NAVIGATION
import ru.vyaacheslav.suhov.imeit.viewmodel.ActivityController
import ru.vyaacheslav.suhov.imeit.viewmodel.ControlViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var model: ControlViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_bar)

        ActivityController(activity = this@MainActivity)
        model = ViewModelProviders.of(this@MainActivity)[ControlViewModel::class.java]
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> model.setFragmentId(FRAGMENT_NAVIGATION)
            R.id.item_m_calls -> model.setFragmentId(FRAGMENT_CALLS_PREF)
            R.id.item_m_group -> model.setDialogID(DIALOG_GROUP)
        }
        return true
    }

    override fun onBackPressed() {
        model.setDialogID(DIALOG_EXIT)
    }
}