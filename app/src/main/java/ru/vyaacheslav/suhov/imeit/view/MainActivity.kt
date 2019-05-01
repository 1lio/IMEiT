package ru.vyaacheslav.suhov.imeit.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.view.ftagments.BellsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.EmptyGroupFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.MapsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.ScheduleFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.MainViewModel
import ru.vyaacheslav.suhov.imeit.viewmodel.StateSelectedGroup.FIRST_RUN
import ru.vyaacheslav.suhov.imeit.viewmodel.StateSelectedGroup.EMPTY_GROUP

class MainActivity : AppCompatActivity() {

    private lateinit var model: MainViewModel                                                       // ViewModel Activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        model = ViewModelProviders.of(this)[MainViewModel::class.java]                       // Инициализируем модель

        setSupportActionBar(bottom_bar)                                                             // Обрабатываем нажатие на FAB
        loadFragment()                                                                              // Загружаем настройки
        fab.setOnClickListener { loadFragment() }                                                   // Обработка нажатия на FAB
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu); return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {                                   // Переопределяем нажатия
        when (item.itemId) {
            R.id.group_setup -> showDialogSelectGroup()
            R.id.bells_info -> pushFragment(BellsFragment())
            R.id.build_location -> pushFragment(MapsFragment())
        }
        return true
    }

    private fun loadFragment() {                                                                    // Загрузить фрагмент
        when (model.getState()) {
            FIRST_RUN -> {showDialogSelectGroup(); pushFragment(EmptyGroupFragment())}              // Показываем диалог с выбором группы
            EMPTY_GROUP -> pushFragment(EmptyGroupFragment())                                       // Гузим пустой фрагмент
            else -> pushFragment(ScheduleFragment())                                                // В других случаях грузим расписание
        }
    }

    private fun pushFragment(fragment: Fragment) {                                                  // Отправлеем нужный фрагмент
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

    private fun showDialogSelectGroup() {                                                           // Метод позволяет выбрать группу
        AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.group)                                                                 // Диалог с выбором группы
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }                                  // Кнопка с функццией отмены диалога
                .setSingleChoiceItems(model.getListGroups(), model.getSelectedId())                 // Выбранная группа по усолчанию
                { d, i -> model.setSelectedId(i);loadFragment();d.cancel() }                                                                                   // После выбора закрываем диалог
                .create()                                                                           // Завершаем создание диалога
                .show()                                                                             // Выводим на экран
    }
}