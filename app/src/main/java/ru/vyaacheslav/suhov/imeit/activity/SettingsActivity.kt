package ru.vyaacheslav.suhov.imeit.activity

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.os.Bundle
import android.preference.ListPreference
import android.preference.PreferenceActivity
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatDelegate
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.MenuInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import ru.vyaacheslav.suhov.imeit.R

class SettingsActivity : PreferenceActivity() {

    private lateinit var prefs: SharedPreferences
    private var mDelegate: AppCompatDelegate? = null

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