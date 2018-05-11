package ru.vyaacheslav.suhov.imeit.ftagments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.Serializable;

import ru.vyaacheslav.suhov.imeit.R;

public class Exzam extends Fragment {

    public LinearLayout mod01, mod02, mod03, mod04, mod05, mod06, mod07, mod08, mod09, mod10, mod11, mod12, mod13, mod14;
    public TextView ch01, ch02, ch03, ch04, ch05, ch06, ch07, ch08, ch09, ch10, ch11, ch12, ch13, ch14;
    public TextView ty01, ty02, ty03, ty04, ty05, ty06, ty07, ty08, ty09, ty10, ty11, ty12, ty13, ty14;
    public TextView ti01, ti02, ti03, ti04, ti05, ti06, ti07, ti08, ti09, ti10, ti11;

    public String zacot = "Зачет";
    public String examen = "Экзамен";

    public Exzam() {
    }

    static class Item implements Serializable {

        public String name;
        public String type;

        public Item() {
        }

        Item(String name, String type) {
            this.name = name;
            this.type = type;
        }
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exzam, container, false);

        mod01 = v.findViewById(R.id.mod1);
        mod02 = v.findViewById(R.id.mod2);
        mod03 = v.findViewById(R.id.mod3);
        mod04 = v.findViewById(R.id.mod4);
        mod05 = v.findViewById(R.id.mod5);
        mod06 = v.findViewById(R.id.mod6);
        mod07 = v.findViewById(R.id.mod7);
        mod08 = v.findViewById(R.id.mod8);
        mod09 = v.findViewById(R.id.mod9);
        mod10 = v.findViewById(R.id.mod10);
        mod11 = v.findViewById(R.id.mod11);
        mod12 = v.findViewById(R.id.mod12);
        mod13 = v.findViewById(R.id.mod13);
        mod14 = v.findViewById(R.id.mod14);

        ch01 = v.findViewById(R.id.m01);
        ch02 = v.findViewById(R.id.m02);
        ch03 = v.findViewById(R.id.m03);
        ch04 = v.findViewById(R.id.m04);
        ch05 = v.findViewById(R.id.m05);
        ch06 = v.findViewById(R.id.m06);
        ch07 = v.findViewById(R.id.m07);
        ch08 = v.findViewById(R.id.m08);
        ch09 = v.findViewById(R.id.m09);
        ch10 = v.findViewById(R.id.m10);
        ch11 = v.findViewById(R.id.m11);
        ch12 = v.findViewById(R.id.m12);
        ch13 = v.findViewById(R.id.m13);
        ch14 = v.findViewById(R.id.m14);

        ty01 = v.findViewById(R.id.z01);
        ty02 = v.findViewById(R.id.z02);
        ty03 = v.findViewById(R.id.z03);
        ty04 = v.findViewById(R.id.z04);
        ty05 = v.findViewById(R.id.z05);
        ty06 = v.findViewById(R.id.z06);
        ty07 = v.findViewById(R.id.z07);
        ty08 = v.findViewById(R.id.z08);
        ty09 = v.findViewById(R.id.z09);
        ty10 = v.findViewById(R.id.z10);
        ty11 = v.findViewById(R.id.z11);
        ty12 = v.findViewById(R.id.z12);
        ty13 = v.findViewById(R.id.z13);
        ty14 = v.findViewById(R.id.z14);

        ti01 = v.findViewById(R.id.ki1);
        ti02 = v.findViewById(R.id.ki2);
        ti03 = v.findViewById(R.id.ki3);
        ti04 = v.findViewById(R.id.ki4);
        ti05 = v.findViewById(R.id.ki5);
        ti06 = v.findViewById(R.id.ki6);
        ti07 = v.findViewById(R.id.ki7);
        ti08 = v.findViewById(R.id.ki8);
        ti09 = v.findViewById(R.id.ki9);
        ti10 = v.findViewById(R.id.ki10);
        ti11 = v.findViewById(R.id.ki11);


        loadMethod();
        MasterDepos();
        return v;
    }

    public void loadMethod() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_groupe), "");

        switch (position) {
            case "ФМиИ-11":
                FMiI_11();
                break;
            case "ПМ-11":
                Pm_11();
                break;
            case "ИиВТ-12":
                IiVT_12();
                break;
            case "ИСиТ-11":
                ISiT_11();
                break;
            case "МИ-21":
                MI_21();
                break;
            case "МФ-21":
                MF_21();
                break;
            case "ПМ-21":
                PM_21();
                break;
            case "БИ-21":
                BI_21();
                break;
            case "ИиВТ-21":
                IiVT_21();
                break;
            case "ИСиТ-21":
                ISiT_21();
                break;
            case "НЭ-21":
                NE_21();
                break;
            case "БХ-21":
                BX_21();
                break;
            case "ЕГ-21":
                EG_21();
                break;
            case "МФ-31":
                MF_31();
                break;
            case "ПМ-31":
                PM_31();
                break;
            case "ИиВТ-31":
                IiVT_31();
                break;
            case "НЭ-31":
                NE_31();
                break;
            case "М-41":
                M_41();
                break;
            case "ФМ-41":
                FM_41();
                break;
            case "ПМ-41":
                PM_41();
                break;
            case "ИиВТ-41":
                IiVT_41();
                break;
            case "НЭ-41":
                NE_41();
                break;
            case "МиИТм-11":
                MIitM();
                break;
            case "ПМм-11":
                PMm_11();
                break;
            case "ИиВтМ-11":
                IIvtm_11();
                break;
            case "Мм-21":
                Mm_21();
                break;
            case "ПМм-21":
                Pmm_21();
                break;
            case "ИиВТм-21":
                IIvtm_21();
                break;
            case "ХБиГ-11":
                XBiG_11();
                break;
            case "ФС-11":
                FC_11();
                break;
            case "ФР-11":
                FR_11();
                break;
            case "ФР-12":
                FR_12();
                break;
            case "ФС-21":
                FC_21();
                break;
            case "ФР-21":
                FR_21();
                break;
            case "БХ-31":
                BX_31();
                break;
            case "МЕ-31":
                ME_31();
                break;
            case "ФС-31":
                FC_31();
                break;
            case "Р-31":
                FP_31();
                break;
            case "ФС-41":
                FC_41();
                break;
            case "ФР-41":
                FP_41();
                break;
            case "ФСм-11":
                FCm_11();
                break;
            case "ФСм-21":
                FCm_21();
                break;
            default:
                break;
        }
    }

    // Визуальное скрытие неиспользуемых элементов
    private void MasterDepos() {

        if (ch01.getText().length() == 0) mod01.setVisibility(View.GONE);
        if (ch02.getText().length() == 0) mod02.setVisibility(View.GONE);
        if (ch03.getText().length() == 0) mod03.setVisibility(View.GONE);
        if (ch04.getText().length() == 0) mod04.setVisibility(View.GONE);
        if (ch05.getText().length() == 0) mod05.setVisibility(View.GONE);
        if (ch06.getText().length() == 0) mod06.setVisibility(View.GONE);
        if (ch07.getText().length() == 0) mod07.setVisibility(View.GONE);
        if (ch08.getText().length() == 0) mod08.setVisibility(View.GONE);
        if (ch09.getText().length() == 0) mod09.setVisibility(View.GONE);
        if (ch10.getText().length() == 0) mod10.setVisibility(View.GONE);
        if (ch11.getText().length() == 0) mod11.setVisibility(View.GONE);
        if (ch12.getText().length() == 0) mod12.setVisibility(View.GONE);
        if (ch13.getText().length() == 0) mod13.setVisibility(View.GONE);
        if (ch14.getText().length() == 0) mod14.setVisibility(View.GONE);

    }

    public void objectTable(String c1, String c2, String c3, String c4, String c5, String c6, String c7, String c8, String c9, String c10, String c11, String c12, String c13, String c14,
                            String t1, String t2, String t3, String t4, String t5, String t6, String t7, String t8, String t9, String t10, String t11, String t12, String t13, String t14) {

        ch01.setText(c1);
        ch02.setText(c2);
        ch03.setText(c3);
        ch04.setText(c4);
        ch05.setText(c5);
        ch06.setText(c6);
        ch07.setText(c7);
        ch08.setText(c8);
        ch09.setText(c9);
        ch10.setText(c10);
        ch11.setText(c11);
        ch12.setText(c12);
        ch13.setText(c13);
        ch14.setText(c14);

        ty01.setText(t1);
        ty02.setText(t2);
        ty03.setText(t3);
        ty04.setText(t4);
        ty05.setText(t5);
        ty06.setText(t6);
        ty07.setText(t7);
        ty08.setText(t8);
        ty09.setText(t9);
        ty10.setText(t10);
        ty11.setText(t11);
        ty12.setText(t12);
        ty13.setText(t13);
        ty14.setText(t14);


        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_groupe), "");


        Item item = new Item(c1, t1);
        Item item2 = new Item(c2, t2);
        Item item3 = new Item(c3, t3);
        Item item4 = new Item(c4, t4);
        Item item5 = new Item(c5, t5);
        Item item6 = new Item(c6, t6);
        Item item7 = new Item(c7, t7);
        Item item8 = new Item(c8, t8);
        Item item9 = new Item(c9, t9);
        Item item10 = new Item(c10, t10);
        Item item11 = new Item(c11, t11);
        Item item12 = new Item(c12, t12);
        Item item13 = new Item(c13, t13);
        Item item14 = new Item(c14, t14);


        ch01.setText(item.name);
        ty01.setText(item.type);
        ch02.setText(item2.name);
        ty02.setText(item2.type);
        ch03.setText(item3.name);
        ty03.setText(item3.type);
        ch04.setText(item4.name);
        ty04.setText(item4.type);
        ch05.setText(item5.name);
        ty05.setText(item5.type);
        ch06.setText(item6.name);
        ty06.setText(item6.type);
        ch07.setText(item7.name);
        ty07.setText(item7.type);
        ch08.setText(item8.name);
        ty08.setText(item8.type);
        ch09.setText(item9.name);
        ty09.setText(item9.type);
        ch10.setText(item10.name);
        ty10.setText(item10.type);
        ch11.setText(item11.name);
        ty11.setText(item11.type);
        ch12.setText(item12.name);
        ty12.setText(item12.type);
        ch13.setText(item13.name);
        ty13.setText(item13.type);
        ch14.setText(item14.name);
        ty14.setText(item14.type);

    }

    public void FMiI_11() {


        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.bjd));
        ch03.setText(getResources().getString(R.string.pcixolv));
        ch04.setText(getResources().getString(R.string.pedagogic_vosp));
        ch05.setText(getResources().getString(R.string.inf_tex_ob));
        ch06.setText(getResources().getString(R.string.m_analis));
        ch07.setText(getResources().getString(R.string.algebra_a_teoc));
        ch08.setText(getResources().getString(R.string.geometry));
        ch09.setText(getResources().getString(R.string.el_physic));
        ch10.setText(getResources().getString(R.string.fkl));
        ch11.setText(getResources().getString(R.string.schol_mat));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zac_oc));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.exam));
        ty08.setText(getResources().getString(R.string.exam));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.exam));

    }

    public void Pm_11() {
        objectTable(getString(R.string.langM), getString(R.string.m_analis), getString(R.string.algebra_a_geo), getString(R.string.physics), getString(R.string.arx_com)
                , getString(R.string.lang_progr), getString(R.string.bjd), getString(R.string.russian_lang), getString(R.string.fkl), getString(R.string.vvod_v_analis),
                getString(R.string.com_gra), getString(R.string.comt_tex_zad), null, null, zacot, examen, zacot, examen, zacot, examen, zacot, zacot, zacot, examen, zacot, zacot, null, null);

    }

    public void IiVT_12() {

        ch01.setText(getResources().getString(R.string.m_analis));
        ch02.setText(getResources().getString(R.string.mat_chis_met));
        ch03.setText(getResources().getString(R.string.el_sx));
        ch04.setText(getResources().getString(R.string.ibm_per_us));
        ch05.setText(getResources().getString(R.string.data_bases));
        ch06.setText(getResources().getString(R.string.teo_sys));
        ch07.setText(getResources().getString(R.string.mod_sys));
        ch08.setText(getResources().getString(R.string.teo_pr_reh));
        ch09.setText(getResources().getString(R.string.fkl));
        ch10.setText(getResources().getString(R.string.set_protocol));
        ch11.setText(getResources().getString(R.string.log_pro));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.exam));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.exam));
        ty06.setText(getResources().getString(R.string.exam));
        ty07.setText(getResources().getString(R.string.exam));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.zacot));
    }

    public void ISiT_11() {

        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.algebra_a_geo));
        ch03.setText(getResources().getString(R.string.m_analis));
        ch04.setText(getResources().getString(R.string.matlogic));
        ch05.setText(getResources().getString(R.string.physics));
        ch06.setText(getResources().getString(R.string.chemistry));
        ch07.setText(getResources().getString(R.string.teo_pr_incluziv));
        ch08.setText(getResources().getString(R.string.bjd));
        ch09.setText(getResources().getString(R.string.russian_lang));
        ch10.setText(getResources().getString(R.string.fkl));
        ch11.setText(getResources().getString(R.string.elc_doc));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.exam));
        ty08.setText(getResources().getString(R.string.zac_oc));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.exam));
    }

    // Второй курс
    public void MI_21() {
        ch01.setText(getResources().getString(R.string.filosofia));
        ch02.setText(getResources().getString(R.string.pcixolp));
        ch03.setText(getResources().getString(R.string.pedagogic_vosp));
        ch04.setText(getResources().getString(R.string.m_analis));
        ch05.setText(getResources().getString(R.string.algebra_a_teoc));
        ch06.setText(getResources().getString(R.string.geometry));
        ch07.setText(getResources().getString(R.string.matlogic));
        ch08.setText(getResources().getString(R.string.el_mat_pr));
        ch09.setText(getResources().getString(R.string.progr));
        ch10.setText(getResources().getString(R.string.teo_osn_inf));
        ch11.setText(getResources().getString(R.string.fkl));
        ch12.setText(getResources().getString(R.string.vop_dif));
        ch13.setText(getResources().getString(R.string.kursovaya));

    }


    public void MF_21() {
        ch01.setText(getResources().getString(R.string.filosofia));
        ch02.setText(getResources().getString(R.string.pcixolp));
        ch03.setText(getResources().getString(R.string.pedagogic_vosp));
        ch04.setText(getResources().getString(R.string.m_analis));
        ch05.setText(getResources().getString(R.string.algebra_a_teoc));
        ch06.setText(getResources().getString(R.string.geometry));
        ch07.setText(getResources().getString(R.string.matlogic));
        ch08.setText(getResources().getString(R.string.el_mat_pr));
        ch09.setText(getResources().getString(R.string.ob_ex_phys));
        ch10.setText(getResources().getString(R.string.el_physic));
        ch11.setText(getResources().getString(R.string.fkl));
        ch12.setText(getResources().getString(R.string.vop_dif));
        ch13.setText(getResources().getString(R.string.kursovaya));

        ty01.setText(getResources().getString(R.string.exam));
        ty02.setText(getResources().getString(R.string.exam));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.exam));
        ty10.setText(getResources().getString(R.string.zacot));

        ty13.setText(getResources().getString(R.string.ocenka));
    }

    public void PM_21() {
        ch01.setText(getResources().getString(R.string.comp_analis));
        ch02.setText(getResources().getString(R.string.com_gra));
        ch03.setText(getResources().getString(R.string.dif_ur));
        ch04.setText(getResources().getString(R.string.data_bases));
        ch05.setText(getResources().getString(R.string.dif_geometry));
        ch06.setText(getResources().getString(R.string.rech_zad_lin_al));
        ch07.setText(getResources().getString(R.string.mat_mod));
        ch08.setText(getResources().getString(R.string.fkl));
        ch09.setText(getResources().getString(R.string.sys_content));
        ch10.setText(getResources().getString(R.string.kursovaya));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.exam));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.exam));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.exam));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.ocenka));
    }

    public void BI_21() {

        ch01.setText(getResources().getString(R.string.econ_firma));
        ch02.setText(getResources().getString(R.string.com_gra));
        ch03.setText(getResources().getString(R.string.inf_sys_com));
        ch04.setText(getResources().getString(R.string.oop_an_pr));
        ch05.setText(getResources().getString(R.string.razr_sys));
        ch06.setText(getResources().getString(R.string.ofiice_tex));
        ch07.setText(getResources().getString(R.string.os));
        ch08.setText(getResources().getString(R.string.za_ob_d));
        ch09.setText(getResources().getString(R.string.fkl));
        ch10.setText(getResources().getString(R.string.mat_mod));
        ch11.setText(getResources().getString(R.string.comt_tex_zad));
        ch12.setText(getResources().getString(R.string.mat_mod_eco));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.exam));
        ty07.setText(getResources().getString(R.string.zacot));

        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.exam));
        ty11.setText(getResources().getString(R.string.exam));
        ty12.setText(getResources().getString(R.string.zacot));

    }

    public void IiVT_21() {

        ch01.setText(getResources().getString(R.string.teo_ver));
        ch02.setText(getResources().getString(R.string.ibm_per_us));
        ch03.setText(getResources().getString(R.string.progr));
        ch04.setText(getResources().getString(R.string.dif_ur));
        ch05.setText(getResources().getString(R.string.teo_pr_reh));
        ch06.setText(getResources().getString(R.string.oop));
        ch07.setText(getResources().getString(R.string.fkl));
        ch08.setText(getResources().getString(R.string.avtor_pravo));
        ch09.setText(getResources().getString(R.string.log_pro));
        ch10.setText(getResources().getString(R.string.rasp_ob_inf));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.exam));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.exam));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.exam));
    }

    public void ISiT_21() {

        objectTable(getString(R.string.teo_ver), getString(R.string.arx_sys), getString(R.string.tex_pr), getString(R.string.teo_game), getString(R.string.os)
                , getString(R.string.fkl), getString(R.string.com_tip), getString(R.string.za_ob_d), getString(R.string.tex_v_c), null,
                null, null, null, null, zacot, examen, zacot, examen, examen, zacot, zacot, zacot, zacot, null, null, null, null, null);
    }

    public void NE_21() {

        ch01.setText(getResources().getString(R.string.teo_ver));
        ch02.setText(getResources().getString(R.string.mat_el_tex));
        ch03.setText(getResources().getString(R.string.phyz_cond));
        ch04.setText(getResources().getString(R.string.phy_osn_el));
        ch05.setText(getResources().getString(R.string.politologia));
        ch06.setText(getResources().getString(R.string.scan_mikr));
        ch07.setText(getResources().getString(R.string.osn_poly));
        ch08.setText(getResources().getString(R.string.fkl));
        ch09.setText(getResources().getString(R.string.rad_eco));
        ch10.setText(getResources().getString(R.string.k_mir));


        ty03.setText(getResources().getString(R.string.zac_exam));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.exam));
        ty07.setText(getResources().getString(R.string.exam));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.exam));

    }

    public void BX_21() {
    }

    public void EG_21() {
    }

    public void MF_31() {
        ch01.setText(getResources().getString(R.string.obr_pravo));
        ch02.setText(getResources().getString(R.string.met_ob_mat));
        ch03.setText(getResources().getString(R.string.met_ob_phy));
        ch04.setText(getResources().getString(R.string.m_analis));
        ch05.setText(getResources().getString(R.string.el_mat_pr));
        ch06.setText(getResources().getString(R.string.ob_ex_phys));
        ch07.setText(getResources().getString(R.string.fkl));
        ch08.setText(getResources().getString(R.string.schol_uche));
        ch09.setText(getResources().getString(R.string.vector_isch));
        ch10.setText(getResources().getString(R.string.met_or_let_ot));
        ch11.setText(getResources().getString(R.string.practic2));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.exam));
        ty07.setText(getResources().getString(R.string.zacot));

        ty09.setText(getResources().getString(R.string.exam));
        ty10.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.otchot));

    }

    public void PM_31() {


    }

    public void IiVT_31() {


    }

    public void NE_31() {


    }

    // 4 курс
    public void M_41() {

    }

    public void FM_41() {


    }

    public void PM_41() {


    }

    public void IiVT_41() {


    }

    public void NE_41() {

    }


    public void MIitM() {
    }

    public void PMm_11() {
    }

    public void IIvtm_11() {
    }

    public void Mm_21() {
    }

    public void Pmm_21() {
    }

    public void IIvtm_21() {
    }


    // Инжинерно-физическое отделение

    public void XBiG_11() {


    }

    public void FC_11() {


    }

    public void FR_11() {

    }

    public void FR_12() {


    }

    public void FC_21() {


    }

    public void FR_21() {


    }

    public void BX_31() {


    }

    public void ME_31() {


    }

    public void FC_31() {


    }

    public void FP_31() {

    }

    public void FC_41() {
    }

    public void FP_41() {


    }

    public void FCm_11() {

    }

    public void FCm_21() {

    }

}
