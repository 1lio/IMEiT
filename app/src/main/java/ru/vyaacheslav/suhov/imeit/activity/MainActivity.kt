package ru.vyaacheslav.suhov.imeit.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.ftagments.bells.BellsFragment
import ru.vyaacheslav.suhov.imeit.ftagments.maps.MapsFragment
import ru.vyaacheslav.suhov.imeit.ftagments.schedule.TemporarySchedule
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var calendar: java.util.Calendar
    lateinit var FT: FragmentTransaction
    private var FM: FragmentManager? = null
    private var prefs: SharedPreferences? = null
    var typeTheme: String? = null
    var typeGroupe: String? = null
    private var settingsIntent: Intent? = null
    lateinit var tb: Toolbar

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {

        prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        typeTheme = prefs!!.getString(getString(R.string.pref_theme), "")
        typeGroupe = prefs!!.getString(getString(R.string.pref_groupe), "")

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (typeTheme == "Светлая") {
                setTheme(R.style.ThemeWrithe)
            } else {
                setTheme(R.style.ThemeDark)
            }
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Интент для запуска окна с настройками
        val prefs = getPreferences(Context.MODE_PRIVATE)
        if (prefs.getBoolean("isFirstRun", true)) {
            val intent = Intent(this, SettingsActivity::class.java)
            startActivity(intent)
        }
        prefs.edit().putBoolean("isFirstRun", false).apply()

        // Стандартная инициализация компонетов
        tb = findViewById(R.id.toolbar)


        calendar = Calendar.getInstance()
        setSupportActionBar(tb)

        // Инициализация транзакции фрагментов
        FM = supportFragmentManager
        FT = FM!!.beginTransaction()
        FT.replace(R.id.container, TemporarySchedule()).commit() // По умолчанию - расписание.

        // Обработка нажатий на пункты меню.

        settingsIntent = Intent(this, SettingsActivity::class.java)
        loadName("Расписание") // Загрузка имени группы согласно настройкам;


        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.schedule

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.times -> {
                    loadName("Время звонков")
                    val ft3 = FM!!.beginTransaction()
                    ft3.replace(R.id.container, BellsFragment()).commit()
                }
                R.id.schedule -> {
                    val ft1 = FM!!.beginTransaction()
                    ft1.replace(R.id.container, TemporarySchedule()).commit()
                    loadName("Расписание")
                }
                R.id.location -> {
                    val ft2 = FM!!.beginTransaction()
                    ft2.replace(R.id.container, MapsFragment()).commit()
                    loadName("Корпуса")
                }
            }
            true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.settings -> {
                startActivity(settingsIntent)
                finish()

                return super.onOptionsItemSelected(item)
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun loadName(s: String) {
        // В качестве подзоголовка берем значение выбранной группы.
        typeGroupe = prefs!!.getString(getString(R.string.pref_groupe), "")
        // Для DB имена групп указаны английским алфавитом без пробелов и символов
        // Поэтому создаем второй массив на русском, сравниваем их по id
        val asu = resources.getStringArray(R.array.groups_value)
        val names = resources.getStringArray(R.array.all_group)
        var index = -1

        var i = 0
        while (i < asu.size && index == -1) {
            if (asu[i] == typeGroupe) {
                index = i
            }
            i++
        }
        // затем подставляем значение в качестве заголовка
        this.tb.subtitle = names[index] + " | $s"
    }
}