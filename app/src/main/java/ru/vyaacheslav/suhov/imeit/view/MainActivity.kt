package ru.vyaacheslav.suhov.imeit.view

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.orhanobut.hawk.Hawk
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.repository.AppRepository
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_FIST_RUN
import ru.vyaacheslav.suhov.imeit.util.AppConfig.KEY_GROUP_ID
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_FIRST_RUN
import ru.vyaacheslav.suhov.imeit.util.Constants.DEF_GROUP_ID
import ru.vyaacheslav.suhov.imeit.view.ftagments.BellsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.MapsFragment
import ru.vyaacheslav.suhov.imeit.view.ftagments.ScheduleFragment
import ru.vyaacheslav.suhov.imeit.viewmodel.UpToolbarViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(bottom_bar)                                                             // Обрабатываем нажатие на FAB
        loadPreferences()                                                                           // Загружаем настройки

        fab.setOnClickListener { pushFragment(ScheduleFragment()) }                                 // По гажатию на Fab гузим фрагмент с расписанием
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {                                         // Переопределяем пункты меню
        menuInflater.inflate(R.menu.menu, menu)                                                     // Раздуваем меню из menu.xml
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {                                    // Переопределяем нажатия по пунктам меню
        when (item.itemId) {
            R.id.group_setup -> setupGroup()
            R.id.bells_info -> pushFragment(BellsFragment())
            R.id.build_location -> pushFragment(MapsFragment())
        }
        return true
    }

    private fun setupGroup() {                                                                      // Данный метод позволяет выбрать группу

        val listGroups: Array<String> = AppRepository().getListGroup()                              // Получаем лист с группами из репоситория

        val viewModel = ViewModelProviders.of(this)[UpToolbarViewModel::class.java]
        AlertDialog.Builder(this@MainActivity)
                .setTitle(R.string.group)                                                           // Создаем диалог в котором пользователь выбирает группу
                .setCancelable(true)                                                                // Возможность начать по пустому месту и отменить
                .setNeutralButton(resources.getString(R.string.cancel)) { d, _ -> d.cancel() }      // Устанавиливаем кнопку с функццией отмены диалога
                .setSingleChoiceItems(listGroups, Hawk.get(KEY_GROUP_ID, DEF_GROUP_ID))                                         // Устанавиливаем список, чекаем выбранную ранее группу
                { dialog, item ->
                    viewModel.setNameGroup(listGroups[item])                                        // Отдаем ViewModel имя выбранной группы
                    Hawk.put(KEY_GROUP_ID, item)                                                    // TODO: Сохраняем id выбранной группы || Можно изменить!!!
                    dialog.cancel()                                                                 // После выбора закрываем диалог
                }
                .create()                                                                           // Завершаем создание диалога
                .show()                                                                             // Выводим на экран
    }

    private fun loadPreferences() {
        if (Hawk.get(KEY_FIST_RUN, DEF_FIRST_RUN)) Hawk.put(KEY_FIST_RUN, false)                    // Проверку на первый запуск.
        else pushFragment(ScheduleFragment())                                                       // Если запуск не первый грузим фрагмент с расписанием
    }

    private fun pushFragment(fragment: Fragment) {                                                  // Отправлеем нужный фрагмент
        supportFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }
}