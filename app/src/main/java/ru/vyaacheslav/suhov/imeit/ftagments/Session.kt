package ru.vyaacheslav.suhov.imeit.ftagments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import kotlinx.android.synthetic.main.item.*
import ru.vyaacheslav.suhov.imeit.R
import android.app.Activity
import android.widget.BaseAdapter




class Session : Fragment() {

    private lateinit var v: View
    private lateinit var prefs: SharedPreferences
    private lateinit var regular: String
    private lateinit var list:ListView
    private lateinit var listAdapter: ListViewAdapter

    private var nameEx: Items = Items()
    private var typeEx: Items = Items()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        v = inflater.inflate(R.layout.fragment_exzam, container, false)
        list = v.findViewById(R.id.listView)

        prefs = PreferenceManager.getDefaultSharedPreferences(activity)
        regular = prefs.getString(getString(R.string.pref_theme), "") // Константа для темы
        val groupe = prefs.getString(getString(R.string.pref_groupe), "") // Константа для групп

        val z: String = getString(R.string.zacot)
        val zo: String = getString(R.string.zac_oc)
        val e: String = getString(R.string.exam)
        val ze: String = getString(R.string.zac_exam)
        val n = ""
        val o: String = getString(R.string.ocenka)

        when (groupe) {

            "ФМиИ-11" -> {
                nameEx = Items((getString(R.string.langM)), (getString(R.string.bjd)),
                        (getString(R.string.pcixolv)), (getString(R.string.pedagogic_vosp)),
                        (getString(R.string.inf_tex_ob)), (getString(R.string.m_analis)),
                        (getString(R.string.algebra_a_teoc)), (getString(R.string.geometry)),
                        (getString(R.string.el_physic)), (getString(R.string.fkl)),
                        (getString(R.string.schol_mat)))
                typeEx = Items(z, zo, z, e, z, z, e, e, z, z, e)
            }
            "ПМ-11" -> {
                nameEx = Items(getString(R.string.langM), getString(R.string.m_analis), getString(R.string.algebra_a_geo),
                        getString(R.string.physics), getString(R.string.arx_com), getString(R.string.lang_progr),
                        getString(R.string.bjd), getString(R.string.russian_lang), getString(R.string.fkl), getString(R.string.vvod_v_analis),
                        getString(R.string.com_gra), getString(R.string.comt_tex_zad))
                typeEx = Items(z, zo, z, e, z, z, e, e, z, z, e)
            }
            "ИиВТ-12" -> {
                nameEx = Items(getString(R.string.m_analis), getString(R.string.mat_chis_met),
                        getString(R.string.el_sx), getString(R.string.ibm_per_us), getString(R.string.data_bases),
                        getString(R.string.teo_sys), getString(R.string.mod_sys), getString(R.string.teo_pr_reh),
                        getString(R.string.fkl), getString(R.string.set_protocol), getString(R.string.log_pro))
                typeEx = Items(z, z, e, e, e, e, e, z, z, z, z)
            }
            "ИСиТ-11" -> {
                nameEx = Items(getString(R.string.langM), getString(R.string.algebra_a_geo), getString(R.string.m_analis),
                        getString(R.string.matlogic), getString(R.string.physics), getString(R.string.chemistry), getString(R.string.teo_pr_incluziv),
                        getString(R.string.bjd), getString(R.string.russian_lang), getString(R.string.fkl), getString(R.string.elc_doc))
                typeEx = Items(z, z, e, z, e, z, e, zo, z, z, e)
            }
            "МИ-21" -> {
                nameEx = Items(getString(R.string.filosofia), getString(R.string.pcixolp), getString(R.string.pedagogic_vosp),
                        getString(R.string.m_analis), getString(R.string.algebra_a_teoc), getString(R.string.geometry), getString(R.string.matlogic),
                        getString(R.string.el_mat_pr), getString(R.string.progr), getString(R.string.teo_osn_inf),
                        getString(R.string.fkl), getString(R.string.vop_dif), getString(R.string.kursovaya))
                typeEx = Items(e, e, z, z, z, e, e, z, z, zo, zo, n, o)

            }
            "МФ-21" -> {
                nameEx = Items(getString(R.string.filosofia), getString(R.string.pcixolp), getString(R.string.pedagogic_vosp),
                        getString(R.string.m_analis), getString(R.string.algebra_a_teoc), getString(R.string.geometry), getString(R.string.matlogic),
                        getString(R.string.el_mat_pr), getString(R.string.ob_ex_phys), getString(R.string.el_physic),
                        getString(R.string.fkl), getString(R.string.vop_dif), getString(R.string.kursovaya))
                typeEx = Items(e, e, z, z, z, e, e, z, z, zo, zo, n, o)
            }

            "ПМ-21" -> {
                nameEx = Items(getString(R.string.comp_analis), getString(R.string.com_gra), getString(R.string.dif_ur),
                        getString(R.string.data_bases), getString(R.string.dif_geometry), getString(R.string.rech_zad_lin_al),
                        getString(R.string.mat_mod), getString(R.string.fkl), getString(R.string.sys_content),
                        getString(R.string.kursovaya))
                typeEx = Items(z, z, e, z, e, z, e, z, z, o)
            }
            "БИ-21" -> {
                nameEx = Items(getString(R.string.econ_firma), getString(R.string.com_gra), getString(R.string.inf_sys_com),
                        getString(R.string.oop_an_pr), getString(R.string.razr_sys), getString(R.string.ofiice_tex),
                        getString(R.string.os), getString(R.string.za_ob_d), getString(R.string.fkl), getString(R.string.mat_mod),
                        getString(R.string.comt_tex_zad), getString(R.string.mat_mod_eco))
                typeEx = Items(z,
                        z, z, e, z, e, z, z, n, e, e, z)
            }
            "ИиВТ-21" -> {
                nameEx = Items(getString(R.string.teo_ver), getString(R.string.ibm_per_us),
                        getString(R.string.progr), getString(R.string.dif_ur), getString(R.string.teo_pr_reh),
                        getString(R.string.oop), getString(R.string.fkl), getString(R.string.avtor_pravo),
                        getString(R.string.log_pro), getString(R.string.rasp_ob_inf))
                typeEx = Items(z, e, z, e, z, e, z, z, z, e)
            }
            "ИСиТ-21" -> {
                nameEx = Items(getString(R.string.teo_ver), getString(R.string.arx_sys), getString(R.string.tex_pr), getString(R.string.teo_game), getString(R.string.os)
                        , getString(R.string.fkl), getString(R.string.com_tip), getString(R.string.za_ob_d), getString(R.string.tex_v_c))
                typeEx = Items(z, e, z, e, e, z, z, z, z)
            }
            "НЭ-21" -> {
                nameEx = Items(getString(R.string.teo_ver), getString(R.string.mat_el_tex), getString(R.string.phyz_cond),
                        getString(R.string.phy_osn_el), getString(R.string.politologia), getString(R.string.scan_mikr),
                        getString(R.string.osn_poly), getString(R.string.fkl), getString(R.string.rad_eco), getString(R.string.k_mir))
                typeEx = Items(z, z, ze, z, z, e, e, z, z, e)
            }

            else -> nameEx = Items("По вашей группе нет информации") // Коллекция названием предметов
        }
        exSeparator(nameEx, typeEx)

        return v
    }

    private fun exSeparator(x: Items, y: Items) {

        val st01: TextView = v.findViewById(R.id.m01)
        val st02: TextView = v.findViewById(R.id.m02)
        val st03: TextView = v.findViewById(R.id.m03)
        val st04: TextView = v.findViewById(R.id.m04)
        val st05: TextView = v.findViewById(R.id.m05)
        val st06: TextView = v.findViewById(R.id.m06)
        val st07: TextView = v.findViewById(R.id.m07)
        val st08: TextView = v.findViewById(R.id.m08)
        val st09: TextView = v.findViewById(R.id.m09)
        val st10: TextView = v.findViewById(R.id.m10)
        val st11: TextView = v.findViewById(R.id.m11)
        val st12: TextView = v.findViewById(R.id.m12)
        val st13: TextView = v.findViewById(R.id.m13)
        val st14: TextView = v.findViewById(R.id.m14)

        val ty01: TextView = v.findViewById(R.id.z01)
        val ty02: TextView = v.findViewById(R.id.z02)
        val ty03: TextView = v.findViewById(R.id.z03)
        val ty04: TextView = v.findViewById(R.id.z04)
        val ty05: TextView = v.findViewById(R.id.z05)
        val ty06: TextView = v.findViewById(R.id.z06)
        val ty07: TextView = v.findViewById(R.id.z07)
        val ty08: TextView = v.findViewById(R.id.z08)
        val ty09: TextView = v.findViewById(R.id.z09)
        val ty10: TextView = v.findViewById(R.id.z10)
        val ty11: TextView = v.findViewById(R.id.z11)
        val ty12: TextView = v.findViewById(R.id.z12)
        val ty14: TextView = v.findViewById(R.id.z13)
        val ty13: TextView = v.findViewById(R.id.z14)

        val n01: String = x.n01
        val n02: String = x.n02
        val n03: String = x.n03
        val n04: String = x.n04
        val n05: String = x.n05
        val n06: String = x.n06
        val n07: String = x.n07
        val n08: String = x.n08
        val n09: String = x.n09
        val n10: String = x.n10
        val n11: String = x.n11
        val n12: String = x.n12
        val n13: String = x.n13
        val n14: String = x.n14

        val t01: String = y.n01
        val t02: String = y.n02
        val t03: String = y.n03
        val t04: String = y.n04
        val t05: String = y.n05
        val t06: String = y.n06
        val t07: String = y.n07
        val t08: String = y.n08
        val t09: String = y.n09
        val t10: String = y.n10
        val t11: String = y.n11
        val t12: String = y.n12
        val t13: String = y.n13
        val t14: String = y.n14

        // Работаем со списком UI
        val exName = listOf(st01, st02, st03, st04, st05, st06, st07, st08, st09, st10, st11, st12, st13, st14) // Коллекция предметами
        val listName: List<TextView> = exName
/*
        val lsT: Array<String> = arrayOf(Items().n01,Items().n02)*/

        val exType = listOf(ty01, ty02, ty03, ty04, ty05, ty06, ty07, ty08, ty09, ty10, ty11, ty12, ty13, ty14)
        val listType: List<TextView> = exType

   /*     listAdapter = ListViewAdapter(this.activity!!, lsT,lsT)*/

        listName.elementAt(0).text = n01
        listName.elementAt(1).text = n02
        listName.elementAt(2).text = n03
        listName.elementAt(3).text = n04
        listName.elementAt(4).text = n05
        listName.elementAt(5).text = n06
        listName.elementAt(6).text = n07
        listName.elementAt(7).text = n08
        listName.elementAt(8).text = n09
        listName.elementAt(9).text = n10
        listName.elementAt(10).text = n11
        listName.elementAt(11).text = n12
        listName.elementAt(12).text = n13
        listName.elementAt(13).text = n14

        listType.elementAt(0).text = t01
        listType.elementAt(1).text = t02
        listType.elementAt(2).text = t03
        listType.elementAt(3).text = t04
        listType.elementAt(4).text = t05
        listType.elementAt(5).text = t06
        listType.elementAt(6).text = t07
        listType.elementAt(7).text = t08
        listType.elementAt(8).text = t09
        listType.elementAt(9).text = t10
        listType.elementAt(10).text = t11
        listType.elementAt(11).text = t12
        listType.elementAt(12).text = t13
        listType.elementAt(13).text = t14

    }
}

class Items(var n01: String = "", var n02: String = "", var n03: String = "", var n04: String = "",
            var n05: String = "", var n06: String = "", var n07: String = "", var n08: String = "",
            var n09: String = "", var n10: String = "", var n11: String = "", var n12: String = "",
            var n13: String = "", var n14: String = "") // По умолчанию строки пустые не null

class ListViewAdapter(internal var context: Activity, internal var title: Array<String>, internal var description: Array<String>) : BaseAdapter() {

    override fun getItem(position: Int): Any {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getItemId(position: Int): Long {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun getCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private inner class ViewHolder {
        internal var txtViewTitle: TextView? = null
        internal var txtViewDescription: TextView? = null
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        // TODO Auto-generated method stub
        val holder: ViewHolder
        val inflater = context.layoutInflater

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_list, null)
            holder = ViewHolder()
            holder.txtViewTitle = convertView!!.findViewById(R.id.tex1) as TextView
            holder.txtViewDescription = convertView.findViewById<View>(R.id.tex2) as TextView
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }

        holder.txtViewTitle!!.text = title[position]
        holder.txtViewDescription!!.text = description[position]

        return convertView
    }

}