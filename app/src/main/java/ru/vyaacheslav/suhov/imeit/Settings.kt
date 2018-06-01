package ru.vyaacheslav.suhov.imeit

import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.ListPreference
import android.preference.Preference
import android.preference.PreferenceFragment
import android.preference.PreferenceManager
import android.support.v7.widget.Toolbar
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout

class Settings() : PreferenceFragment() {

    lateinit var groupe: ListPreference
    lateinit var theme: ListPreference
    lateinit var week: ListPreference
    lateinit var edu: ListPreference
    lateinit var facul: ListPreference
    lateinit var edup: String
    lateinit var regular: String
    lateinit var instp: String
    lateinit var faculp: String
    lateinit var prefs: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addPreferencesFromResource(R.xml.preferences)

        prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        regular = prefs.getString(getString(R.string.pref_theme), "")

        edup = prefs.getString(getString(R.string.pref_education), getString(R.string.bak))
        instp = prefs.getString(getString(R.string.pref_inst), getString(R.string.app_name))
        faculp = prefs.getString(getString(R.string.pref_facul), getString(R.string.m_f))

        val root = activity.findViewById<View>(android.R.id.list).parent.parent.parent as LinearLayout
        val bar = LayoutInflater.from(activity).inflate(R.layout.toolbar, root, false) as Toolbar
        root.addView(bar, 0) // insert at top


        bar.setNavigationOnClickListener {
            val intent = Intent(activity, MainActivity::class.java)
            startActivity(intent)
        }

        groupe = findPreference(getString(R.string.pref_groupe)) as ListPreference
        theme = findPreference(getString(R.string.pref_theme)) as ListPreference
        week = findPreference(getString(R.string.week_i)) as ListPreference
        edu = findPreference(getString(R.string.pref_education)) as ListPreference
        facul = findPreference(getString(R.string.pref_facul)) as ListPreference
    }

    override fun onResume() {
        setListPreferenceData(groupe)
        super.onResume()
        groupe.onPreferenceClickListener = Preference.OnPreferenceClickListener {
            setListPreferenceData(groupe)
            false
        }
        groupe.summary = groupe.entry
        theme.setSummary(theme.getEntry())
        week.setSummary(week.getEntry())
        edu.setSummary(edu.getEntry())
        facul.setSummary(facul.getEntry())
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

    internal fun setListPreferenceData(lp: ListPreference) {

        val faculp = prefs.getString(getString(R.string.pref_facul), "")

        if (faculp == getString(R.string.m_f)) {
            lp.setEntries(R.array.bak_m_groups)
            lp.setEntryValues(R.array.bak_m_groups_val)
        } else {
            lp.setEntries(R.array.bak_e_groups)
            lp.setEntryValues(R.array.bak_e_groups_val)
        }
    }
}