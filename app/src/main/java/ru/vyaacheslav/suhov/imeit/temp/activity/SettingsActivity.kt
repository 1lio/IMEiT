package ru.vyaacheslav.suhov.imeit.temp.activity

import android.annotation.SuppressLint
import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.preference.*
import android.support.annotation.LayoutRes
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.toast
import ru.vyaacheslav.suhov.imeit.R

@SuppressLint("ExportedPreferenceActivity")
class SettingsActivity : PreferenceActivity() {

    private lateinit var prefs: SharedPreferences
    private var mDelegate: AppCompatDelegate? = null

    lateinit var editPass: EditText
    lateinit var btnOk: Button
    lateinit var btnCancel: Button

    private val delegate: AppCompatDelegate
        get() {
            if (mDelegate == null) {
                mDelegate = AppCompatDelegate.create(this, null)
            }
            return this.mDelegate!!
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext)
        val regular = prefs.getString(getString(R.string.pref_key_theme), "")

        if (regular == "Светлая") {
            setTheme(R.style.ThemeWrithe)
        }

        if (regular == "Темная") {
            setTheme(R.style.ThemeDark)
        }
        super.onCreate(savedInstanceState)

        fragmentManager.beginTransaction().replace(android.R.id.content, MyPreferenceFragment()).commit()

        delegate.installViewFactory()
        delegate.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(id: Int): Dialog {
        val adb = AlertDialog.Builder(this)

        val view = layoutInflater
                .inflate(R.layout.dialog_pass, null) as LinearLayout
        adb.setView(view)

        // Инициализируем view
        editPass = view.findViewById(R.id.edit)
        btnOk = view.findViewById(R.id.diOk)
        btnCancel = view.findViewById(R.id.diCancel)


        return adb.create()
    }

    override fun onPrepareDialog(id: Int, dialog: Dialog?) {
        super.onPrepareDialog(id, dialog)

        if (id == 1) {
            btnOk.setOnClickListener {
                if (editPass.text.toString() == "admin") {
                    toast("Права администратора активированы до следующего перезауска!")
                    val admin = getSharedPreferences(resources.getString(R.string.pref_key_admin), Context.MODE_PRIVATE)

                    val editor: SharedPreferences.Editor = admin.edit()
                    editor.putString(resources.getString(R.string.pref_key_admin), "admin_trues")
                    editor.apply()

                    dialog?.dismiss()

                } else
                    toast("Неверный пароль!")
            }
            btnCancel.setOnClickListener { dialog?.dismiss() }
        }
    }

    override fun onBackPressed() {

        val position = prefs.getString(getString(R.string.pref_key_group), "")

        if (position == "") {
            Toast.makeText(applicationContext, "Выберите группу", Toast.LENGTH_SHORT).show()
        } else {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
            finish()
        }
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        delegate.onPostCreate(savedInstanceState)
    }

    override fun getMenuInflater(): MenuInflater {
        return delegate.menuInflater
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        delegate.setContentView(layoutResID)
    }

    override fun setContentView(view: View, params: ViewGroup.LayoutParams) {
        delegate.setContentView(view, params)
    }

    override fun addContentView(view: View, params: ViewGroup.LayoutParams) {
        delegate.addContentView(view, params)
    }

    override fun onPostResume() {
        super.onPostResume()
        delegate.onPostResume()
    }

    override fun onTitleChanged(title: CharSequence, color: Int) {
        super.onTitleChanged(title, color)
        delegate.setTitle(title)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        delegate.onConfigurationChanged(newConfig)
    }

    override fun onStop() {
        super.onStop()
        delegate.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
        delegate.onDestroy()
    }

    override fun invalidateOptionsMenu() {
        delegate.invalidateOptionsMenu()
    }

    class MyPreferenceFragment : PreferenceFragment() {

        private lateinit var groupe: ListPreference
        lateinit var theme: ListPreference
        lateinit var pair: Preference
        lateinit var admin: Preference


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            addPreferencesFromResource(R.xml.preferences)

            val root = activity.findViewById<View>(android.R.id.list).parent.parent.parent as LinearLayout
            val bar = LayoutInflater.from(activity).inflate(R.layout.toolbar, root, false) as Toolbar
            root.addView(bar, 0)

            bar.setNavigationOnClickListener {
                val prefs = PreferenceManager.getDefaultSharedPreferences(activity)
                val position = prefs.getString(getString(R.string.pref_key_group), "")

                if (position == "") {
                    Toast.makeText(activity, "Выберите группу", Toast.LENGTH_SHORT).show()
                } else {
                    val i = Intent(activity, MainActivity::class.java)
                    startActivity(i)
                }
            }
            groupe = findPreference(getString(R.string.pref_key_group)) as ListPreference
            theme = findPreference(getString(R.string.pref_key_theme)) as ListPreference
            pair = findPreference(getString(R.string.pref_key_pair)) as Preference
            admin = findPreference(getString(R.string.pref_key_admin)) as Preference

            val intent = Intent(activity, SettingsBells::class.java)

            pair.setOnPreferenceClickListener {
                startActivity(intent)
                false
            }

            admin.setOnPreferenceClickListener {

                val panel = activity.getSharedPreferences(getString(R.string.pref_key_admin), Context.MODE_PRIVATE)
                val editor:SharedPreferences.Editor = panel.edit()
                editor.putString(getString(R.string.pref_key_admin), "admin_true")
                editor.apply()
                toast("Права администратора активированы до следующего перезауска!")
                false
            }

            groupe.summary = groupe.entry
            theme.summary = theme.entry
        }


        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            val view = super.onCreateView(inflater, container, savedInstanceState)

            val horizontalMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2f, resources.displayMetrics).toInt()
            val verticalMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2f, resources.displayMetrics).toInt()
            val topMargin = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, (resources.getDimension(R.dimen.activity_vertical_margin).toInt() + 10).toFloat(), resources.displayMetrics).toInt()
            assert(view != null)
            view!!.setPadding(horizontalMargin, topMargin, horizontalMargin, verticalMargin)
            return view
        }
    }
}