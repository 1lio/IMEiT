package ru.vyaacheslav.suhov.imeit;

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

public class Exzam extends Fragment {

    public LinearLayout mod01, mod02, mod03, mod04, mod05, mod06, mod07, mod08, mod09, mod10, mod11, mod12, mod13, mod14;
    public TextView ch01, ch02, ch03, ch04, ch05, ch06, ch07, ch08, ch09, ch10, ch11, ch12, ch13, ch14;
    public TextView ty01, ty02, ty03, ty04, ty05, ty06, ty07, ty08, ty09, ty10, ty11, ty12, ty13, ty14;
    public TextView ti01,ti02,ti03,ti04,ti05,ti06,ti07,ti08,ti09,ti10,ti11;
    public Exzam() {}

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

        ch01 = v.findViewById(R.id.m1);
        ch02 = v.findViewById(R.id.m2);
        ch03 = v.findViewById(R.id.m3);
        ch04 = v.findViewById(R.id.m4);
        ch05 = v.findViewById(R.id.m5);
        ch06 = v.findViewById(R.id.m6);
        ch07 = v.findViewById(R.id.m7);
        ch08 = v.findViewById(R.id.m8);
        ch09 = v.findViewById(R.id.m9);
        ch10 = v.findViewById(R.id.m10);
        ch11 = v.findViewById(R.id.m11);
        ch12 = v.findViewById(R.id.m12);
        ch13 = v.findViewById(R.id.m13);
        ch14 = v.findViewById(R.id.m14);

        ty01 = v.findViewById(R.id.z1);
        ty02 = v.findViewById(R.id.z2);
        ty03 = v.findViewById(R.id.z3);
        ty04 = v.findViewById(R.id.z4);
        ty05 = v.findViewById(R.id.z5);
        ty06 = v.findViewById(R.id.z6);
        ty07 = v.findViewById(R.id.z7);
        ty08 = v.findViewById(R.id.z8);
        ty09 = v.findViewById(R.id.z9);
        ty10 = v.findViewById(R.id.z10);
        ty11 = v.findViewById(R.id.z11);
        ty12 = v.findViewById(R.id.z12);
        ty13 = v.findViewById(R.id.z13);
        ty14 = v.findViewById(R.id.z14);

        ti01 =v.findViewById(R.id.ki1);
        ti02 =v.findViewById(R.id.ki2);
        ti03 =v.findViewById(R.id.ki3);
        ti04 =v.findViewById(R.id.ki4);
        ti05 =v.findViewById(R.id.ki5);
        ti06 =v.findViewById(R.id.ki6);
        ti07 =v.findViewById(R.id.ki7);
        ti08 =v.findViewById(R.id.ki8);
        ti09 =v.findViewById(R.id.ki9);
        ti10 =v.findViewById(R.id.ki10);
        ti11 =v.findViewById(R.id.ki11);

        loadMethod();
        MasterDepos();
        return v;
    }

    public void loadMethod() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_style), "");

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
    private  void  MasterDepos(){

                if (ch01.getText().length() == 0)mod01.setVisibility(View.GONE);
                if (ch02.getText().length() == 0)mod02.setVisibility(View.GONE);
                if (ch03.getText().length() == 0)mod03.setVisibility(View.GONE);
                if (ch04.getText().length() == 0)mod04.setVisibility(View.GONE);
                if (ch05.getText().length() == 0)mod05.setVisibility(View.GONE);
                if (ch06.getText().length() == 0)mod06.setVisibility(View.GONE);
                if (ch07.getText().length() == 0)mod07.setVisibility(View.GONE);
                if (ch08.getText().length() == 0)mod08.setVisibility(View.GONE);
                if (ch09.getText().length() == 0)mod09.setVisibility(View.GONE);
                if (ch10.getText().length() == 0)mod10.setVisibility(View.GONE);
                if (ch11.getText().length() == 0)mod11.setVisibility(View.GONE);
                if (ch12.getText().length() == 0)mod12.setVisibility(View.GONE);
                if (ch13.getText().length() == 0)mod13.setVisibility(View.GONE);
                if (ch14.getText().length() == 0)mod14.setVisibility(View.GONE);

    }

    public void FMiI_11() {

        ch01.setText(getResources().getString(R.string.history));
        ch02.setText(getResources().getString(R.string.langM));
        ch03.setText(getResources().getString(R.string.bjd));
        ch04.setText(getResources().getString(R.string.pcixol));
        ch05.setText(getResources().getString(R.string.vvov_v_ped_de));
        ch06.setText(getResources().getString(R.string.mat_med_obr));
        ch07.setText(getResources().getString(R.string.russian_lang));
        ch08.setText(getResources().getString(R.string.fk));
        ch09.setText(getResources().getString(R.string.m_analis));
        ch10.setText(getResources().getString(R.string.algebra_a_teoc));
        ch11.setText(getResources().getString(R.string.geometry));
        ch12.setText(getResources().getString(R.string.schol_mat));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zacot));

        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.exam));
        ty10.setText(getResources().getString(R.string.exam));
        ty11.setText(getResources().getString(R.string.zacot));

    }

    public void Pm_11() {

        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.history));
        ch03.setText(getResources().getString(R.string.m_analis));
        ch04.setText(getResources().getString(R.string.algebra_a_geo));
        ch05.setText(getResources().getString(R.string.osn_inf));
        ch06.setText(getResources().getString(R.string.bjd));
        ch07.setText(getResources().getString(R.string.fk));
        ch08.setText(getResources().getString(R.string.mat_zad));
        ch09.setText(getResources().getString(R.string.vvod_v_analis));
        ch10.setText(getResources().getString(R.string.metiso));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.examen));

        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
    }

    public void IiVT_12() {

        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.algebra_a_geo));
        ch03.setText(getResources().getString(R.string.disckret));
        ch04.setText(getResources().getString(R.string.fk));
        ch05.setText(getResources().getString(R.string.his_mat));
        ch06.setText(getResources().getString(R.string.m_analis));
        ch07.setText(getResources().getString(R.string.paket_asu));
        ch08.setText(getResources().getString(R.string.oop));
        ch09.setText(getResources().getString(R.string.paket_asu));
        ch10.setText(getResources().getString(R.string.set_protocol));
        ch11.setText(getResources().getString(R.string.com_tip));

        ty01.setText(getResources().getString(R.string.zac_oc));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zacot));

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
        ch08.setText(getResources().getString(R.string.fk));
        ch09.setText(getResources().getString(R.string.bjd));
        ch10.setText(getResources().getString(R.string.oop));
        ch11.setText(getResources().getString(R.string.mat_pra));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));

        ty10.setText(getResources().getString(R.string.examen));
        ty11.setText(getResources().getString(R.string.zacot));
    }

    // Второй курс
    public void MI_21() {
        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.pcixol_soc));
        ch03.setText(getResources().getString(R.string.pedagogic_vosp));
        ch04.setText(getResources().getString(R.string.k_mir));
        ch05.setText(getResources().getString(R.string.eco_obr));
        ch06.setText(getResources().getString(R.string.m_analis));
        ch07.setText(getResources().getString(R.string.algebra_a_teoc));
        ch08.setText(getResources().getString(R.string.geometry));
        ch09.setText(getResources().getString(R.string.matlogic));
        ch10.setText(getResources().getString(R.string.teo_osn_inf));
        ch11.setText(getResources().getString(R.string.saz_inf));
        ch12.setText(getResources().getString(R.string.fkl));
        ch13.setText(getResources().getString(R.string.vop_dif));

        ty01.setText(getResources().getString(R.string.zac_oc));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.examen));

        ty11.setText(getResources().getString(R.string.zacot));
        ty12.setText(getResources().getString(R.string.zacot));

    }


    public void MF_21() {
        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.pcixol_soc));
        ch03.setText(getResources().getString(R.string.pedagogic_vosp));
        ch04.setText(getResources().getString(R.string.k_mir));
        ch05.setText(getResources().getString(R.string.eco_obr));
        ch06.setText(getResources().getString(R.string.m_analis));
        ch07.setText(getResources().getString(R.string.algebra_a_teoc));
        ch08.setText(getResources().getString(R.string.geometry));
        ch09.setText(getResources().getString(R.string.matlogic));
        ch10.setText(getResources().getString(R.string.ob_ex_phys));
        ch11.setText(getResources().getString(R.string.el_physic));
        ch12.setText(getResources().getString(R.string.fkl));
        ch13.setText(getResources().getString(R.string.vop_dif));

        ty01.setText(getResources().getString(R.string.zac_oc));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.examen));

        ty10.setText(getResources().getString(R.string.zacot));
        ty12.setText(getResources().getString(R.string.zacot));
    }

    public void PM_21() {

        ch01.setText(getResources().getString(R.string.filosofia));
        ch02.setText(getResources().getString(R.string.langM));
        ch03.setText(getResources().getString(R.string.econ));
        ch04.setText(getResources().getString(R.string.m_analis));
        ch05.setText(getResources().getString(R.string.algebra_a_geo));
        ch06.setText(getResources().getString(R.string.met_prog));
        ch07.setText(getResources().getString(R.string.data_bases));
        ch08.setText(getResources().getString(R.string.po_prog));
        ch09.setText(getResources().getString(R.string.dif_xz));
        ch10.setText(getResources().getString(R.string.fkl));
        ch11.setText(getResources().getString(R.string.metiso));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zac_oc));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.examen));
    }

    public void BI_21() {

        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.filosofia));
        ch03.setText(getResources().getString(R.string.manadjment));
        ch04.setText(getResources().getString(R.string.dif_raz));
        ch05.setText(getResources().getString(R.string.disckret));
        ch06.setText(getResources().getString(R.string.iss_op));
        ch07.setText(getResources().getString(R.string.analis_data));
        ch08.setText(getResources().getString(R.string.progr));
        ch09.setText(getResources().getString(R.string.data_bases));
        ch10.setText(getResources().getString(R.string.off_tex));
        ch11.setText(getResources().getString(R.string.os));
        ch12.setText(getResources().getString(R.string.sociolog));
        ch13.setText(getResources().getString(R.string.fkl));
        ch14.setText(getResources().getString(R.string.mat_mod_eco));

        ty01.setText(getResources().getString(R.string.zac_oc));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zacot));

        ty12.setText(getResources().getString(R.string.zacot));
        ty13.setText(getResources().getString(R.string.zacot));

    }

    public void IiVT_21() {

        ch01.setText(getResources().getString(R.string.langM));
        ch02.setText(getResources().getString(R.string.filosofia));
        ch03.setText(getResources().getString(R.string.econ));
        ch04.setText(getResources().getString(R.string.m_analis));
        ch05.setText(getResources().getString(R.string.disckret));
        ch06.setText(getResources().getString(R.string.mat_chis_met));
        ch07.setText(getResources().getString(R.string.el_ec));
        ch08.setText(getResources().getString(R.string.mod_phys_pro));
        ch09.setText(getResources().getString(R.string.fkl));
        ch10.setText(getResources().getString(R.string.log_pro));
        ch11.setText(getResources().getString(R.string.rasp_ob_inf));

        ty01.setText(getResources().getString(R.string.zac_oc));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.examen));

    }

    public void ISiT_21() {

        ch01.setText(getResources().getString(R.string.teo_ver));
        ch02.setText(getResources().getString(R.string.arx_sys));
        ch03.setText(getResources().getString(R.string.tex_pr));
        ch04.setText(getResources().getString(R.string.teo_game));
        ch05.setText(getResources().getString(R.string.os));
        ch06.setText(getResources().getString(R.string.fkl));
        ch07.setText(getResources().getString(R.string.com_tip));
        ch08.setText(getResources().getString(R.string.za_ob_d));
        ch09.setText(getResources().getString(R.string.tex_v_c));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.exam));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.exam));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));


        /*ti01.setVisibility(View.VISIBLE);
        ti02.setVisibility(View.VISIBLE);
        ti03.setVisibility(View.VISIBLE);
        ti04.setVisibility(View.VISIBLE);
        ti05.setVisibility(View.VISIBLE);
        ti07.setVisibility(View.VISIBLE);
        ti08.setVisibility(View.VISIBLE);
        ti09.setVisibility(View.VISIBLE);
        ti10.setVisibility(View.VISIBLE);
        ti11.setVisibility(View.VISIBLE);

        ti01.setText(getResources().getString(R.string.podoksenov));
        ti02.setText(getResources().getString(R.string.lebedeva));
        ti03.setText(getResources().getString(R.string.belix));
        ti04.setText(getResources().getString(R.string.kornienko));
        ti05.setText(getResources().getString(R.string.nikitina));
        ti06.setText(getResources().getString(R.string.zaiceva));
        ti07.setText(getResources().getString(R.string.fortunova));
        ti08.setText(getResources().getString(R.string.gubin));

        ti10.setText(getResources().getString(R.string.igonina));
        ti11.setText(getResources().getString(R.string.gubin));*/

    }

    public void NE_21() {

        ch01.setText(getResources().getString(R.string.filosofia));
        ch02.setText(getResources().getString(R.string.langM));
        ch03.setText(getResources().getString(R.string.m_analis));
        ch04.setText(getResources().getString(R.string.disckret));
        ch05.setText(getResources().getString(R.string.physics));
        ch06.setText(getResources().getString(R.string.teo_el));
        ch07.setText(getResources().getString(R.string.metrologia));
        ch08.setText(getResources().getString(R.string.on_teo_mex));
        ch09.setText(getResources().getString(R.string.dif_ur));
        ch10.setText(getResources().getString(R.string.fkl));
        ch11.setText(getResources().getString(R.string.k_mir));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zac_oc));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));

    }

    public void BX_21() {
    }

    public void EG_21() {
    }

    public void MF_31() {
        ch01.setText(getResources().getString(R.string.teo_pr_incluziv));
        ch02.setText(getResources().getString(R.string.met_ob_vos));
        ch03.setText(getResources().getString(R.string.etica));
        ch04.setText(getResources().getString(R.string.m_analis));
        ch05.setText(getResources().getString(R.string.algebra_a_teoc));
        ch06.setText(getResources().getString(R.string.el_mat));
        ch07.setText(getResources().getString(R.string.ob_ex_phys));
        ch08.setText(getResources().getString(R.string.fkl));
        ch09.setText(getResources().getString(R.string.vop_dif));
        ch10.setText(getResources().getString(R.string.osn_geo));
        ch11.setText(getResources().getString(R.string.schol_uche));
        ch12.setText(getResources().getString(R.string.vector_isch));
        ch13.setText(getResources().getString(R.string.practic));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zac_oc));
        ty10.setText(getResources().getString(R.string.examen));

        ty12.setText(getResources().getString(R.string.zacot));
        ty13.setText(getResources().getString(R.string.zac_oc));
    }

    public void PM_31() {

        ch01.setText(getResources().getString(R.string.sociolog));
        ch02.setText(getResources().getString(R.string.fun_analis));
        ch03.setText(getResources().getString(R.string.disckret));
        ch04.setText(getResources().getString(R.string.dif_ur));
        ch05.setText(getResources().getString(R.string.teo_ver));
        ch06.setText(getResources().getString(R.string.mat_chis_met));
        ch07.setText(getResources().getString(R.string.os));
        ch08.setText(getResources().getString(R.string.oop_an_pr));
        ch09.setText(getResources().getString(R.string.fkl));
        ch10.setText(getResources().getString(R.string.pro_tipograf));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
    }

    public void IiVT_31() {

        ch01.setText(getResources().getString(R.string.ibm_per_us));
        ch02.setText(getResources().getString(R.string.os));
        ch03.setText(getResources().getString(R.string.progr));
        ch04.setText(getResources().getString(R.string.data_bases));
        ch05.setText(getResources().getString(R.string.inj_gra));
        ch06.setText(getResources().getString(R.string.metrologia));
        ch07.setText(getResources().getString(R.string.fkl));
        ch08.setText(getResources().getString(R.string.mod_soc_pol));
        ch09.setText(getResources().getString(R.string.crip_za));
        ch10.setText(getResources().getString(R.string.app_sys));
        ch11.setText(getResources().getString(R.string.kursovaya));

        ty01.setText(getResources().getString(R.string.zacot));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zac_exam));
        ty07.setText(getResources().getString(R.string.zacot));

        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zacot));
        ty11.setText(getResources().getString(R.string.ocenka));

    }

    public void NE_31() {

        ch01.setText(getResources().getString(R.string.phy_osn_el));
        ch02.setText(getResources().getString(R.string.shemotexnika));
        ch03.setText(getResources().getString(R.string.up_mat_phy));
        ch04.setText(getResources().getString(R.string.osn_el));
        ch05.setText(getResources().getString(R.string.phys_xim));
        ch06.setText(getResources().getString(R.string.el_sred));
        ch07.setText(getResources().getString(R.string.fkl));
        ch08.setText(getResources().getString(R.string.vector_isch));
        ch09.setText(getResources().getString(R.string.ner_term));
        ch10.setText(getResources().getString(R.string.practic));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.zac_exam));
        ty04.setText(getResources().getString(R.string.zac_exam));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zac_oc));

    }

    // 4 курс
    public void M_41() {
        ch01.setText(getResources().getString(R.string.met_ob_vos));
        ch02.setText(getResources().getString(R.string.el_mat));
        ch03.setText(getResources().getString(R.string.inf_ob_mat));
        ch04.setText(getResources().getString(R.string.met_osb_det));
        ch05.setText(getResources().getString(R.string.schol_uche));
        ch06.setText(getResources().getString(R.string.teo_razv));
        ch07.setText(getResources().getString(R.string.nes_trigo));
        ch08.setText(getResources().getString(R.string.ist_mat_r));
        ch09.setText(getResources().getString(R.string.schol_uche_ug));
        ch10.setText(getResources().getString(R.string.practic));
        ch11.setText(getResources().getString(R.string.ped_practic));
        ch12.setText(getResources().getString(R.string.kursovaya));

        ty01.setText(getResources().getString(R.string.zac_exam));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.examen));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zac_oc));
        ty11.setText(getResources().getString(R.string.zac_oc));
        ty12.setText(getResources().getString(R.string.ocenka));
    }

    public void FM_41() {

        ch01.setText(getResources().getString(R.string.met_phy));
        ch02.setText(getResources().getString(R.string.osn_teo_phy));
        ch03.setText(getResources().getString(R.string.kvant_ph));
        ch04.setText(getResources().getString(R.string.astrophysic));
        ch05.setText(getResources().getString(R.string.prepo_phy));
        ch06.setText(getResources().getString(R.string.zad_hard));
        ch07.setText(getResources().getString(R.string.compot));
        ch08.setText(getResources().getString(R.string.met_or_astr_tex));
        ch09.setText(getResources().getString(R.string.practic));
        ch10.setText(getResources().getString(R.string.ped_practic));
        ch11.setText(getResources().getString(R.string.kursovaya));

        ty01.setText(getResources().getString(R.string.zac_exam));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.zacot));
        ty05.setText(getResources().getString(R.string.examen));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.examen));
        ty09.setText(getResources().getString(R.string.zac_oc));
        ty10.setText(getResources().getString(R.string.zac_oc));
        ty11.setText(getResources().getString(R.string.ocenka));
    }

    public void PM_41() {

        ch01.setText(getResources().getString(R.string.pr_web));
        ch02.setText(getResources().getString(R.string.up_mat_phy));
        ch03.setText(getResources().getString(R.string.sys_po));
        ch04.setText(getResources().getString(R.string.comp_bez));
        ch05.setText(getResources().getString(R.string.par_ob_inf));
        ch06.setText(getResources().getString(R.string.teo_game));
        ch07.setText(getResources().getString(R.string.ad_seit));
        ch08.setText(getResources().getString(R.string.el_nec_mn));
        ch09.setText(getResources().getString(R.string.prog_1c));
        ch10.setText(getResources().getString(R.string.practic3));
        ch11.setText(getResources().getString(R.string.practic2));
        ch12.setText(getResources().getString(R.string.spec_fun));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.examen));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.examen));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zac_oc));
        ty11.setText(getResources().getString(R.string.zac_oc));
        ty12.setText(getResources().getString(R.string.zacot));
    }

    public void IiVT_41() {

        ch01.setText(getResources().getString(R.string.seti_tv));
        ch02.setText(getResources().getString(R.string.ad_os));
        ch03.setText(getResources().getString(R.string.inf_bez_set));
        ch04.setText(getResources().getString(R.string.pr_web));
        ch05.setText(getResources().getString(R.string.mat_mod_eco));
        ch06.setText(getResources().getString(R.string.com_tip));
        ch07.setText(getResources().getString(R.string.pr_sys));
        ch08.setText(getResources().getString(R.string.practic));
        ch09.setText(getResources().getString(R.string.practic2));
        ch10.setText(getResources().getString(R.string.mod_class));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.examen));
        ty03.setText(getResources().getString(R.string.zacot));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.zacot));
        ty06.setText(getResources().getString(R.string.zac_exam));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zac_oc));
        ty09.setText(getResources().getString(R.string.zac_oc));

    }

    public void NE_41() {
        ch01.setText(getResources().getString(R.string.eco_proiz));
        ch02.setText(getResources().getString(R.string.nano_el));
        ch03.setText(getResources().getString(R.string.zona_str_el));
        ch04.setText(getResources().getString(R.string.kvant_el));
        ch05.setText(getResources().getString(R.string.mat_mod_nano));
        ch06.setText(getResources().getString(R.string.mat_nano));
        ch07.setText(getResources().getString(R.string.galv_polpro));
        ch08.setText(getResources().getString(R.string.teplophys));
        ch09.setText(getResources().getString(R.string.astrophysic));
        ch10.setText(getResources().getString(R.string.practic));
        ch11.setText(getResources().getString(R.string.nau_rab));
        ch12.setText(getResources().getString(R.string.int_ur));
        ch13.setText(getResources().getString(R.string.kursovaya));

        ty01.setText(getResources().getString(R.string.examen));
        ty02.setText(getResources().getString(R.string.zacot));
        ty03.setText(getResources().getString(R.string.examen));
        ty04.setText(getResources().getString(R.string.exam));
        ty05.setText(getResources().getString(R.string.exam));
        ty06.setText(getResources().getString(R.string.zacot));
        ty07.setText(getResources().getString(R.string.zacot));
        ty08.setText(getResources().getString(R.string.zacot));
        ty09.setText(getResources().getString(R.string.zacot));
        ty10.setText(getResources().getString(R.string.zac_oc));
        ty11.setText(getResources().getString(R.string.zac_oc));
        ty12.setText(getResources().getString(R.string.zacot));
        ty13.setText(getResources().getString(R.string.ocenka));
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
