package ru.vyaacheslav.suhov.imeit.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.support.design.widget.BottomNavigationView
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.TextView
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.ftagments.bells.BellsFragment
import ru.vyaacheslav.suhov.imeit.ftagments.maps.MapsFragment
import ru.vyaacheslav.suhov.imeit.ftagments.schedule.ScheduleFragment
import ru.vyaacheslav.suhov.imeit.ftagments.schedule.TemporarySchedule
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var calendar: java.util.Calendar
    private lateinit var ft: FragmentTransaction
    private lateinit var fm: FragmentManager
    private lateinit var prefs: SharedPreferences
    private lateinit var prefTh: String
    private lateinit var prefGr: String
    private var prefFab: Boolean = true
    private var prefWeek: Boolean = true
    private lateinit var settingsIntent: Intent
    private lateinit var tb: Toolbar
    lateinit var week: TextView

    val schedule: String = "https://yadi.sk/d/SRZmnHWF3aabGA"

    @SuppressLint("CommitTransaction")
    override fun onCreate(savedInstanceState: Bundle?) {

        prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        prefTh = prefs.getString(getString(R.string.pref_key_theme), "")
        prefGr = prefs.getString(getString(R.string.pref_key_group), "")
        prefFab = prefs.getBoolean(getString(R.string.pref_key_check_fab), true)
        prefWeek = prefs.getBoolean(getString(R.string.pref_key_check_week), true)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (prefTh == "Светлая") {
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

        week = findViewById(R.id.week)
        isWeek()
        // Стандартная инициализация компонетов
        tb = findViewById(R.id.toolbar)
        calendar = Calendar.getInstance()
        setSupportActionBar(tb)

        // Инициализация транзакции фрагментов
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        isGroupConnected() // По умолчанию - расписание.

        // Обработка нажатий на пункты меню.
        settingsIntent = Intent(this, SettingsActivity::class.java)
        groupName("Расписание") // Загрузка имени группы согласно настройкам;


        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener {
            val address = Uri.parse(schedule)
            val openLinkIntent = Intent(Intent.ACTION_VIEW, address)
            startActivity(openLinkIntent)
        }

        visibleFab(fab)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavigationView.selectedItemId = R.id.schedule

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.times -> {
                    groupName("Время звонков")
                    val ft3 = fm.beginTransaction()
                    ft3.replace(R.id.container, BellsFragment()).commit()
                    invisibleView(fab)
                }
                R.id.schedule -> {
                    isGroupConnected()
                    groupName("Расписание")
                    visibleFab(fab)
                }
                R.id.location -> {
                    val ft2 = fm.beginTransaction()
                    ft2.replace(R.id.container, MapsFragment()).commit()
                    groupName("Корпуса")
                    invisibleView(fab)
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
        return when (item.itemId) {
            R.id.settings -> {
                startActivity(settingsIntent)
                finish()
                super.onOptionsItemSelected(item)
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun isGroupConnected() {

        val ft1 = fm.beginTransaction()
        if (prefGr == "isNot") {
            ft1.replace(R.id.container, TemporarySchedule()).commit()
        } else {
            ft1.replace(R.id.container, ScheduleFragment()).commit()
        }
    }


    private fun groupName(s: String?): String {
        // В качестве подзоголовка берем значение выбранной группы.
        prefGr = prefs.getString(getString(R.string.pref_key_group), "")
        // Для DB имена групп указаны английским алфавитом без пробелов и символов
        // Поэтому создаем второй массив на русском, сравниваем их по id
        val asu = resources.getStringArray(R.array.groups_value)
        val names = resources.getStringArray(R.array.all_group)
        var index = 0

        var i = 0
        while (i < asu.size && index == 0) {
            if (asu[i] == prefGr) {
                index = i
            }
            i++
        }
        // затем подставляем значение в качестве заголовка
        if (names[index] == "Нет группы") {
            this.tb.subtitle = s
        } else {
            this.tb.subtitle = names[index] + " | $s"
        }

        return index.toString()
    }

    private fun isWeek() {
        if (prefWeek) {
            week.visibility = View.VISIBLE
            week.text = "Числитель"
            val fallingAnimation: Animation = AnimationUtils.loadAnimation(this, R.anim.falling)
            week.startAnimation(fallingAnimation)

            Handler().postDelayed({
                invisibleView(week)
                week.visibility = View.GONE
            }, 3000)
        } else week.visibility = View.GONE

    }

    private fun visibleFab(view: View) {
        if (prefFab) {
            view.visibility = View.VISIBLE
            val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.view_alpha_visable)
            view.startAnimation(animation)
        } else view.visibility = View.GONE
    }

    private fun invisibleView(view: View) {

        if (prefFab) {
            val animation = AnimationUtils.loadAnimation(applicationContext, R.anim.view_alpha_gone)
            if (view.visibility != View.GONE) {

                view.startAnimation(animation)
                view.visibility = View.GONE
            }
        } else view.visibility = View.GONE

    }
}