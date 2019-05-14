package ru.vyaacheslav.suhov.imeit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.view.ftagments.bells.BellsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.maps.MapsPagerFragment
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
        loadStartFragment()                              // Загружаем стартовый фрагмент
        fab.setOnClickListener { pushFabFragment() }     // Обработка нажатия на FAB
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu); return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.group_setup -> showDialogSelectGroup()
            R.id.bells_info -> pushFragment(BellsFragment())
            R.id.build_location -> pushFragment(MapsPagerFragment())
            R.id.schedule -> {
                if (model.isSelectedGroup()) pushFragment(SchedulePagerFragment())
                else pushFragment(EmptyGroupFragment())
            }
        }
        return true
    }

    private fun loadStartFragment() {

        when {
            // Проверка на первый запуск
            model.isFirstRun() -> { showDialogSelectGroup(); pushFragment(EmptyGroupFragment()) }
            // Проверка выбрана ли группа
            !model.isSelectedGroup() -> pushFragment(EmptyGroupFragment())

            else -> pushFragment(SchedulePagerFragment())     // В других случаях грузим фрагмент с расписанием
        }
    }

    private fun pushFabFragment() {
        if (model.isSelectedGroup()) pushFragment(SchedulePagerFragment())
        else pushFragment(EmptyGroupFragment())
    }

    private fun pushFragment(fragment: Fragment) {                                                  // Отправлеем нужный фрагмент
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun showDialogSelectGroup() {                                                           // Метод позволяет выбрать группу
        AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.group)                                                                 // Диалог с выбором группы
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }                                  // Кнопка с функццией отмены диалога
                .setSingleChoiceItems(model.getListGroups(), model.getSelectedId())                 // Выбранная группа по усолчанию
                { d, i -> model.setSelectedId(i);pushFabFragment();d.cancel() }.create().show()     // После выбора закрываем диалог Выводим на экран
    }
}