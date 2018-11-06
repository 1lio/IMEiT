package ru.vyaacheslav.suhov.imeit.activity

import android.annotation.TargetApi
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.CompoundButton
import android.support.v7.widget.Toolbar
import kotlinx.android.synthetic.main.bells_setup.*
import org.jetbrains.anko.toast
import ru.vyaacheslav.suhov.imeit.R
import ru.vyaacheslav.suhov.imeit.adapters.SettingsBellsAdapter
import ru.vyaacheslav.suhov.imeit.objects.SettingsPoly


class SettingsBells : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var mAdapter: RecyclerView.Adapter<*>

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.ThemeDark)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bells_setup)

        val regular = getSharedPreferences(getString(R.string.pref_key_admin), Context.MODE_PRIVATE)

        if (regular.getString(getString(R.string.pref_key_admin), "") == "admin_true") {
            sw.isChecked = true
            admin_panel.visibility = View.VISIBLE

        }

        val bar: Toolbar = findViewById(R.id.toolbarj)
        setSupportActionBar(bar)
        bar.setNavigationOnClickListener {
            val i = Intent(this, SettingsActivity::class.java)
            startActivity(i)
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

        mAdapter = SettingsBellsAdapter(this, check)

        val mRecyclerView: RecyclerView = findViewById(R.id.rvc)
        val mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this)
        mRecyclerView.layoutManager = mLayoutManager

        mRecyclerView.adapter = mAdapter


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
        val v = Intent(this, SettingsActivity::class.java)
        startActivity(v)
        finish()
    }

    fun save(v: View) {
        if (update.isChecked){
            toast("Отправляю данные на сервер")
        }
        if (setDef.isChecked){
            toast("Default данные обновлены")
        }
        if(neverUse.isChecked){
            toast("Редактировать поля запрещено администратором")
        }

    }

    fun getDate():String{
        return ""
    }
}