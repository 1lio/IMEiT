package ru.vyaacheslav.suhov.imeit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.view.ftagments.auth.SignInFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.calls.CallSetupFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.other.BottomNavigationDrawerFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.other.EmptyGroupFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.schedule.SchedulePagerFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var model: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProviders.of(this@MainActivity)[MainViewModel::class.java]
        setSupportActionBar(bottom_bar)

        model.observeSigned(this, Observer {
            if (it) {
                toolbar.visibility = View.VISIBLE
                bottom_bar.visibility = View.VISIBLE
                fab.visibility = View.VISIBLE
                loadStartFragment()

            } else {
                toolbar.visibility = View.GONE
                bottom_bar.visibility = View.GONE
                fab.visibility = View.GONE
                pushFragment(SignInFragment())
            }
        })
        fab.setOnClickListener { fabOnClick() }          // Обработка нажатия на FAB
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu); return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
            R.id.group_setup -> showDialogSelectGroup()
            R.id.bells_pref -> pushFragment(CallSetupFragment())
        }
        return true
    }

    private fun loadStartFragment() {
        when {
            // Проверка на первый запуск
            model.isFirstRun() -> {
                showDialogSelectGroup()
                pushFragment(EmptyGroupFragment())
            }
            // Проверка выбрана ли группа
            !model.isSelectedGroup() -> pushFragment(EmptyGroupFragment())

            else -> pushFragment(SchedulePagerFragment())     // В других случаях грузим фрагмент с расписанием
        }
    }

    private fun fabOnClick() {
        if (model.isSelectedGroup()) pushFragment(SchedulePagerFragment())
        else pushFragment(EmptyGroupFragment())
    }

    private fun pushFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun showDialogSelectGroup() {

        AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.group)
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }
                .setSingleChoiceItems(model.getListGroups(), model.getSelectedId())
                { d, i ->
                    model.setSelectedId(i)
                    fabOnClick()
                    d.cancel()
                }
                .create().show()
    }
}