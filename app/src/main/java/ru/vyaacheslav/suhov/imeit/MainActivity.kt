package ru.vyaacheslav.suhov.imeit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import ru.vyaacheslav.suhov.imeit.util.gone
import ru.vyaacheslav.suhov.imeit.util.visible
import ru.vyaacheslav.suhov.imeit.view.ftagments.auth.FragmentLogin
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallSetupFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.other.BottomNavFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.other.FragmentEmptyGroup
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment
import ru.vyaacheslav.suhov.imeit.view.view.UpToolbar
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_bar)

        model = ViewModelProviders.of(this@MainActivity)[MainViewModel::class.java]
        model.observeAuth(this@MainActivity, Observer {
            if (!it) FragmentLogin().show()
            visibleUI(it)
        })

        if (model.isAuth) loadStartFragment() else FragmentLogin().show()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu); return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val navDrawerFragment = BottomNavFragment()
                navDrawerFragment.show(supportFragmentManager, navDrawerFragment.tag)
            }
            R.id.group_setup -> showDialogSelectGroup()
            R.id.bells_pref -> CallSetupFragment().show()
        }
        return true
    }

    private fun loadStartFragment() {
        if (model.isExistsGroup()) SchedulePagerFragment().show() else FragmentEmptyGroup().show()
    }

    private fun showDialogSelectGroup() {
        AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.group)
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }
                .setSingleChoiceItems(model.getListGroups(), model.getSelectedId())
                { d, i ->
                    model.setSelectedId(i)
                    loadStartFragment()
                    d.cancel()
                }
                .create()
                .show()
    }

    private fun showDialogExit() {
        AlertDialog.Builder(this@MainActivity)
                .setTitle(resources.getString(R.string.exit_of_app))
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }
                .setPositiveButton(resources.getString(R.string.yes)) { d, _ -> d.dismiss(); finish() }
                .create()
                .show()
    }

    private fun Fragment.show() {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.container, this@show, this@show.tag)
                .commit()
    }

    private fun visibleUI(v: Boolean) {

        val toolbar: UpToolbar = findViewById(R.id.toolbar)
        val bottomView: CoordinatorLayout = findViewById(R.id.bottom_view)

        val toolbars = arrayOf(toolbar, bottomView)
        if (v) toolbars.forEach { it.visible() } else toolbars.forEach { it.gone() }
    }

    override fun onBackPressed() {
        showDialogExit()
    }
}