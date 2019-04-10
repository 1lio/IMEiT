package ru.vyaacheslav.suhov.imeit.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.AppRepository
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_NAME
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.KEY_GROUP_NAME
import ru.vyaacheslav.suhov.imeit.view.ftagments.BellsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.MapsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.ScheduleFragment

class MainActivity : AppCompatActivity() {

    private lateinit var listGroups: Array<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(bottom_bar)
        loadPreferences() // Загружаем настройки

        listGroups = AppRepository(this).getListGroup()
        // Обрабатываем нажатие на FAB
        fab.setOnClickListener { fragmentTransaction( ScheduleFragment()) }
    }

    // Данный метод позволяет выбрать группу
    private fun setupGroup() {
        // Создаем диалог в котором пользователь выбирает группу
        AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.group)
                // Возможность начать по пустому месту и отменить
                .setCancelable(true)
                // Устанавиливаем кнопку с функццией отмены диалога
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }

                // Устанавиливаем список, чекаем выбранную ранее группу
                .setSingleChoiceItems(listGroups, Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID)) { d, item ->
                    toolbar.subtitle = listGroups[item]         // Меняем subTitle у Toolbar
                    Hawk.put(KEY_GROUP_NAME, listGroups[item])  // Сохраняем в Hawk имя гуппы
                    Hawk.put(KEY_GROUP_ID, item)                // И id
                    d.cancel()}                                 // Закрываем диалог
                .create()
                .show()
    }

    // Подключаем разметку меню
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }

    // Обрабатываем нажатия
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.group_setup -> setupGroup()
            R.id.bells_info -> fragmentTransaction(BellsFragment())
            R.id.build_location -> fragmentTransaction(MapsFragment())
        }
        return true
    }

    // Загружаем настройки
    private fun loadPreferences() {
        // Название Института
        toolbar.title = resources.getString(R.string.app_name)

        // Делаем проверку на первый запуск
        if (Hawk.get(KEY_FIST_RUN, DEF_FIST_RUN)) {
            setupGroup()
            Hawk.put(KEY_FIST_RUN, false) // Записываем что запуск не первый
        } else {
            // Подставляем имя группы в toolbar
            toolbar.subtitle = Hawk.get(KEY_GROUP_NAME, DEF_GROUP_NAME)
            // По умолчанию грузим фрагмент с расписанием, если группа уже выбрана
            fragmentTransaction(ScheduleFragment())
        }
    }

    private fun fragmentTransaction(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}