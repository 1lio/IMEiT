package ru.vyaacheslav.suhov.imeit.temp.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.DialogInterface
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.temp.ftagments.bells.BellsFragment
import ru.vyaacheslav.suhov.imeit.temp.ftagments.maps.MapsFragment
import ru.vyaacheslav.suhov.imeit.temp.ftagments.schedule.ScheduleFragment


class MainActivity : AppCompatActivity() {

    private lateinit var fragmentTransaction: FragmentTransaction
    private lateinit var fragmentManager: FragmentManager

    private var idGroup: Int = 0
    private lateinit var groups: Array<String>
    private lateinit var preferences: SharedPreferences

    val schedule: String = "https://yadi.sk/d/SRZmnHWF3aabGA"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        groups = resources.getStringArray(R.array.all_group)
        fragmentTransaction = supportFragmentManager.beginTransaction()
        preferences = applicationContext.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        loadPreferences()

        // Инициализация транзакции фрагментов
        fragmentManager = supportFragmentManager

        //
        //() // По умолчанию - расписание.

        setSupportActionBar(bottom_app_bar)

        toolbar.title = resources.getString(R.string.app_name)


        /*// Обработка нажатий на пункты меню.
        settingsIntent = Intent(this, SettingsActivity::class.java)
        groupName("Расписание") // Загрузка имени группы согласно настройкам;

        visibleFab(fab)
        bottom_navigation.selectedItemId = R.id.schedule
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.times -> {
                    groupName("Время звонков")
                    val ft3 = fragmentManager.beginTransaction()
                    ft3.replace(R.id.container, BellsFragment()).commit()

           *//*         fab.setImageResource(R.drawable.ic_assessment)
                    visibleFab(fab)
                    fab.setOnClickListener {
                        // Анализ расписания
                    }*//*
                    invisibleView(fab)
                }
                R.id.schedule -> {
                    isGroupConnected()
                    groupName("Расписание")
                    fab.setImageResource(R.drawable.ic_download)
                    visibleFab(fab)
                    fab.setOnClickListener {
                        startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(schedule)))
                    }
                }
                R.id.location -> {
                    val ft2 = fragmentManager.beginTransaction()
                    ft2.replace(R.id.container, MapsFragment()).commit()
                    groupName("Корпуса")
                    invisibleView(fab)
                }
            }
            true*/
    }


    private fun reGroup() {

        idGroup = preferences.getInt(KEY_GROUP_ID, 0)

        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(R.string.refresh_group)
                .setCancelable(false)
                .setNeutralButton("Отмена") { dialog, _ -> dialog.cancel() }
                .setSingleChoiceItems(groups, idGroup) { dialog, item ->
                    // Меняем сбтитл
                    toolbar.subtitle = groups[item]
                    // Сохраняем в SharedPref
                    preferences.edit().putString(KEY_GROUP_NAME, groups[item]).apply()
                    preferences.edit().putInt(KEY_GROUP_ID, item).apply()
                    dialog.cancel()

                }

        val alert = builder.create()
        alert.show()
        alert.getButton(DialogInterface.BUTTON_NEUTRAL).setTextColor(ContextCompat.getColor(this, R.color.white))

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    @SuppressLint("RestrictedApi")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        return when (item.itemId) {

            R.id.re_group -> {
                reGroup()
                true
            }
            R.id.times -> {
                fragmentManager.beginTransaction().replace(R.id.container, BellsFragment()).commit()
                true
            }
            R.id.location -> {
                fragmentManager.beginTransaction().replace(R.id.container, MapsFragment()).commit()
                true
            }

            R.id.schedule -> {
                fragmentManager.beginTransaction().replace(R.id.container, ScheduleFragment()).commit()
                true
            }

            else -> false
        }

    }

    private fun groupName(s: String?) {
        //prefGr = prefs.getString(getString(R.string.pref_key_group), "")

        /*  val name = DB(this).groups()*/

        /* var i = 0
         while (i < name.size) {
             val str: String = name[i]["value"].toString() // HashMap  со всеми группами
             i++

             if (prefGr == "Нет группы") {
                 this.tb.subtitle = s
             } else {
                 this.tb.subtitle = "$str | $s"
             }
         }*/

        // В качестве подзоголовка берем значение выбранной группы.

        // prefGr = prefs.getString(getString(R.string.pref_key_group), "")


        // Для DB имена групп указаны английским алфавитом без пробелов и символов
        // Поэтому создаем второй массив на русском, сравниваем их по id
        /*  val asu = resources.getStringArray(R.array.groups_value)
          val names = resources.getStringArray(R.array.all_group)
          var index = -1
          var i = 0
          while (i < asu.size && index == -1) {
              if (asu[i] == prefGr) {
                  index = i
              }
              i++
          }*/
        // затем подставляем значение в качестве заголовка
        //  this.toolbar.subtitle = names[index] + " | $s"
    }

    private fun loadPreferences() {

        if (preferences.getBoolean(KEY_FIST_RUN, true)) {
            reGroup()
            preferences.edit().putBoolean(KEY_FIST_RUN, false).apply()
        }

        idGroup = preferences.getInt(KEY_GROUP_ID, 0)
        toolbar.subtitle = preferences.getString(KEY_GROUP_NAME, DEF_GROUP_NAME)
    }


    companion object {
        const val APP_PREFERENCES = "application_settings"
        const val KEY_FIST_RUN = "isFirstRun"
        const val KEY_GROUP_NAME = "group_name"
        const val KEY_GROUP_ID = "group_id"
        const val DEF_GROUP_NAME = "empty"
    }
}