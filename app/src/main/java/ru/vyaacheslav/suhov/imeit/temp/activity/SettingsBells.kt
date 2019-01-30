package ru.vyaacheslav.suhov.imeit.temp.activity

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.CompoundButton
import kotlinx.android.synthetic.main.bells_setup.*
import kotlinx.android.synthetic.main.toolbar.*
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.toast
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.temp.adapters.SettingsBellsAdapter
import ru.vyaacheslav.suhov.imeit.temp.SettingsPoly

class SettingsBells : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ThemeDark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bells_setup)

        val regular = getSharedPreferences(getString(R.string.pref_key_admin), Context.MODE_PRIVATE)

        if (regular.getString(getString(R.string.pref_key_admin), "") == "admin_true") {
            sw.isChecked = true
            admin_panel.visibility = View.VISIBLE
        }

        setSupportActionBar(toolbarj)
        toolbarj.setNavigationOnClickListener {
            startActivity(intentFor<SettingsActivity>())
        }

        /** Создаем адаптер и подключаем */
        // Используем дефолтные настройки
        val nameSettings: Array<String> = resources.getStringArray(R.array.settings_pair)
        val defaultDataPair: Array<Int> = arrayOf(6, 510, 45, 5, 40, 10, 2)
        val check: MutableList<SettingsPoly> = mutableListOf()

        for (x in 0..6) {
            val defPref = SettingsPoly(nameSettings[x], defaultDataPair[x], true, true)
            check.add(defPref)
        }

        rvc.layoutManager = LinearLayoutManager(this)
        rvc.adapter = SettingsBellsAdapter(this, check)
        sw.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(buttonView: CompoundButton, isChecked: Boolean) {

        if (!isChecked) {
            admin_panel.visibility = View.GONE
            val panel = getSharedPreferences(getString(R.string.pref_key_admin), Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = panel.edit()
            editor.putString(getString(R.string.pref_key_admin), "admin_false")
            editor.apply()
            toast("Права администратора деактивированы!")
        }

    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(intentFor<SettingsActivity>())
        finish()
    }

    fun save(v: View) {
        when {
            update.isChecked -> toast("Отправляю данные на сервер")
            setDef.isChecked -> toast("Default данные обновлены")
            neverUse.isChecked -> toast("Редактировать поля запрещено администратором")
        }
    }
}