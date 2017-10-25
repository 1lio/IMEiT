package ru.vyaacheslav.suhov.imeit;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Exzam extends Fragment{

    public LinearLayout mod01,mod02,mod03,mod04,mod05,mod06,mod07,mod08,mod09,mod10,mod11,mod12,mod13,mod14;
    public TextView ch01,ch02,ch03,ch04,ch05,ch06,ch07,ch08,ch09,ch10,ch11,ch12,ch13,ch14;
    public TextView ty01,ty02,ty03,ty04,ty05,ty06,ty07,ty08,ty09,ty10,ty11,ty12,ty13,ty14;

    public Exzam() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
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

        loadMethod();
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

    public void FMiI_11() {  }

    public void Pm_11() {   }

    public void IiVT_12() { }

    public void ISiT_11() {  }

    // Второй курс
    public void MI_21() {
        mod14.setVisibility(View.GONE);
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




    public void MF_21() {    }

    public void PM_21() {    }

    public void BI_21() {    }

    public void IiVT_21() {    }

    public void ISiT_21() {




    }

    public void NE_21() {



    }

    public void BX_21() {



    }

    public void EG_21() {


    }

    public void MF_31() {



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
