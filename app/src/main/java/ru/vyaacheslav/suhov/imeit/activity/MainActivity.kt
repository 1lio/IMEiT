package ru.vyaacheslav.suhov.imeit.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.preference.PreferenceManager
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.intentFor
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.ftagments.bells.BellsFragment
import ru.vyaacheslav.suhov.imeit.ftagments.maps.MapsFragment
import ru.vyaacheslav.suhov.imeit.ftagments.schedule.ScheduleFragment
import ru.vyaacheslav.suhov.imeit.ftagments.schedule.TemporarySchedule

class MainActivity : AppCompatActivity() {

    private lateinit var ft: FragmentTransaction
    private lateinit var fm: FragmentManager
    private lateinit var prefs: SharedPreferences
    private lateinit var prefTh: String
    private lateinit var prefGr: String
    private var prefFab: Boolean = true
    private var prefWeek: Boolean = true

    private lateinit var settingsIntent: Intent

    val schedule: String = "https://yadi.sk/d/SRZmnHWF3aabGA"

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
        if (prefs.getBoolean("isFirstRun", true)) startActivity(intentFor<SettingsActivity>())
        prefs.edit().putBoolean("isFirstRun", false).apply()

        isWeek()
        // Стандартная инициализация компонетов
        setSupportActionBar(toolbar)

        // Инициализация транзакции фрагментов
        fm = supportFragmentManager
        ft = fm.beginTransaction()
        isGroupConnected() // По умолчанию - расписание.

        // Обработка нажатий на пункты меню.
        settingsIntent = Intent(this, SettingsActivity::class.java)
        groupName("Расписание") // Загрузка имени группы согласно настройкам;

        visibleFab(fab)
        bottom_navigation.selectedItemId = R.id.schedule
        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.times -> {
                    groupName("Время звонков")
                    val ft3 = fm.beginTransaction()
                    ft3.replace(R.id.container, BellsFragment()).commit()

           /*         fab.setImageResource(R.drawable.ic_assessment)
                    visibleFab(fab)
                    fab.setOnClickListener {
                        // Анализ расписания
                    }*/
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

    private fun groupName(s: String?) {
        prefGr = prefs.getString(getString(R.string.pref_key_group), "")

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
        prefGr = prefs.getString(getString(R.string.pref_key_group), "")
        // Для DB имена групп указаны английским алфавитом без пробелов и символов
        // Поэтому создаем второй массив на русском, сравниваем их по id
        val asu = resources.getStringArray(R.array.groups_value)
        val names = resources.getStringArray(R.array.all_group)
        var index = -1
        var i = 0
        while (i < asu.size && index == -1) {
            if (asu[i] == prefGr) {
                index = i
            }
            i++
        }
        // затем подставляем значение в качестве заголовка
        this.toolbar.subtitle = names[index] + " | $s"
    }

    private fun isWeek() {
        if (prefWeek) {
            week.visibility = View.VISIBLE
            week.text = "Числитель"

            week.startAnimation(AnimationUtils.loadAnimation(this, R.anim.falling))
            container.startAnimation(AnimationUtils.loadAnimation(this, R.anim.bottom))
            Handler().postDelayed({
                invisibleView(week)
                container.startAnimation(AnimationUtils.loadAnimation(this, R.anim.top))
            }, 3000)
        } else
            week.visibility = View.GONE
    }

    private fun visibleFab(view: View) {
        if (prefFab) {
                view.visibility = View.VISIBLE
                view.startAnimation(AnimationUtils.loadAnimation(applicationContext, R.anim.view_alpha_visable))
        } else view.visibility = View.GONE
    }

    private fun invisibleView(view: View) {

        if (prefFab) {
            if (view.visibility != View.GONE) {
                view.startAnimation( AnimationUtils.loadAnimation(applicationContext, R.anim.view_alpha_gone))
                view.visibility = View.GONE
            }
        } else view.visibility = View.GONE

    }
}