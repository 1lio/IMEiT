package ru.vyaacheslav.suhov.imeit.Days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;


public class Fri extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4, m_l5, m_l_5z, l1, l2, l3, l4, l5;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z,
            p6, m_p6_tz, m_p6_kz, p6a, m_p6_t, m_p6_k, p6az, p6z, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12;

    RelativeLayout mk;
    public Fri() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fri, container, false);

        mk = v.findViewById(R.id.fk1);
        s1 = v.findViewById(R.id.ff1);
        s2 = v.findViewById(R.id.ff2);
        s3 = v.findViewById(R.id.f3);
        s4 = v.findViewById(R.id.f4);
        s5 = v.findViewById(R.id.f5);
        s6 = v.findViewById(R.id.f6);
        s7 = v.findViewById(R.id.f7);
        s8 = v.findViewById(R.id.f8);
        s9 = v.findViewById(R.id.f9);
        s10 = v.findViewById(R.id.f10);
        s11 = v.findViewById(R.id.f11);
        s12 = v.findViewById(R.id.f12);

        l1 = v.findViewById(R.id.fl1);
        l2 = v.findViewById(R.id.fl2);
        l3 = v.findViewById(R.id.fl3);
        l4 = v.findViewById(R.id.fl4);
        l5 = v.findViewById(R.id.fl5);

        m_l_1z = v.findViewById(R.id.f_l_1z);
        m_l_2z = v.findViewById(R.id.f_l_2z);
        m_l_3z = v.findViewById(R.id.f_l_3z);
        m_l_4z = v.findViewById(R.id.f_l_4z);
        m_l_5z = v.findViewById(R.id.f_l_5z);

        m_l1 = v.findViewById(R.id.f_l1);
        m_l2 = v.findViewById(R.id.f_l2);
        m_l3 = v.findViewById(R.id.f_l3);
        m_l4 = v.findViewById(R.id.f_l4);
        m_l5 = v.findViewById(R.id.f_l5);
        p1 = v.findViewById(R.id.f1);
        p1a = v.findViewById(R.id.f_p1_a);
        m_p1_t = v.findViewById(R.id.f_p1_t);
        m_p1_k = v.findViewById(R.id.f_p1_k);
        p1z = v.findViewById(R.id.f_p1z);
        p1az = v.findViewById(R.id.f_p1_az);
        m_p1_tz = v.findViewById(R.id.f_p1_tz);
        m_p1_kz = v.findViewById(R.id.f_p1_kz);

        p2 = v.findViewById(R.id.f_p2);
        p2a = v.findViewById(R.id.f_p2_a);
        m_p2_t = v.findViewById(R.id.f_p2_t);
        m_p2_k = v.findViewById(R.id.f_p2_k);
        p2z = v.findViewById(R.id.f_p2z);
        p2az = v.findViewById(R.id.f_p2_az);
        m_p2_tz = v.findViewById(R.id.f_p2_tz);
        m_p2_kz = v.findViewById(R.id.f_p2_kz);
        m_l2.setVisibility(View.GONE);

        p3 = v.findViewById(R.id.f_p3);
        p3a = v.findViewById(R.id.f_p3_a);
        m_p3_t = v.findViewById(R.id.f_p3_t);
        m_p3_k = v.findViewById(R.id.f_p3_k);
        p3z = v.findViewById(R.id.f_p3z);
        p3az = v.findViewById(R.id.f_p3_az);
        m_p3_tz = v.findViewById(R.id.f_p3_tz);
        m_p3_kz = v.findViewById(R.id.f_p3_kz);

        p4 = v.findViewById(R.id.f_p4);
        p4a = v.findViewById(R.id.f_p4_a);
        m_p4_t = v.findViewById(R.id.f_p4_t);
        m_p4_k = v.findViewById(R.id.f_p4_k);
        p4z = v.findViewById(R.id.f_p4z);
        p4az = v.findViewById(R.id.f_p4_az);
        m_p4_tz = v.findViewById(R.id.f_p4_tz);
        m_p4_kz = v.findViewById(R.id.f_p4_kz);

        p5 = v.findViewById(R.id.f_p5);
        p5a = v.findViewById(R.id.f_p5a);
        m_p5_t = v.findViewById(R.id.f_p5_t);
        m_p5_k = v.findViewById(R.id.f_p5_k);
        p5z = v.findViewById(R.id.f_p5z);
        p5az = v.findViewById(R.id.f_p5_az);
        m_p5_tz = v.findViewById(R.id.f_p5_tz);
        m_p5_kz = v.findViewById(R.id.f_p5_kz);


        p6 = v.findViewById(R.id.f_p6);
        p6a = v.findViewById(R.id.f_p6a);
        m_p6_t = v.findViewById(R.id.f_p6_t);
        m_p6_k = v.findViewById(R.id.f_p6_k);
        p6z = v.findViewById(R.id.f_p6z);
        p6az = v.findViewById(R.id.f_p6_az);
        m_p6_tz = v.findViewById(R.id.f_p6_tz);
        m_p6_kz = v.findViewById(R.id.f_p6_kz);

        LoadPreferences();
        loadMethod();

        return v;
    }

    public void loadMethod() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_style), "");
        layoutVisable();

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

    public void layoutVisable() {
        m_l1.setVisibility(View.VISIBLE);
        m_l2.setVisibility(View.VISIBLE);
        m_l3.setVisibility(View.VISIBLE);
        m_l4.setVisibility(View.VISIBLE);
        m_l_1z.setVisibility(View.VISIBLE);
        m_l_2z.setVisibility(View.VISIBLE);
        m_l_3z.setVisibility(View.VISIBLE);
        m_l_4z.setVisibility(View.VISIBLE);

    }

    // Первый курс
    public void FMiI_11() {

        decL_1p();

        p2.setText(getResources().getString(R.string.osn_mat_inf));
        p2a.setText(getResources().getString(R.string.tarova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk2_213));
        p2z.setText(getResources().getString(R.string.osn_mat_inf));
        p2az.setText(getResources().getString(R.string.tarova));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk2_213));

        p3.setText(getResources().getString(R.string.osn_mat_inf));
        p3a.setText(getResources().getString(R.string.tarova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk2_213));
        p3z.setText(getResources().getString(R.string.history));
        p3az.setText(getResources().getString(R.string.klevcova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk1_22));

        p4z.setText(getResources().getString(R.string.history));
        p4az.setText(getResources().getString(R.string.klevcova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk1_22));

    }

    public void Pm_11() {

        decL_1p();

        p2.setText(getResources().getString(R.string.vvod_v_analis));
        p2a.setText(getResources().getString(R.string.melnikova));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_26));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

        p3.setText(getResources().getString(R.string.osn_inf));
        p3a.setText(getResources().getString(R.string.gubina));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk16_301a));
        p3z.setText(getResources().getString(R.string.history));
        p3az.setText(getResources().getString(R.string.klevcova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk1_22));

        p4z.setText(getResources().getString(R.string.history));
        p4az.setText(getResources().getString(R.string.klevcova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk1_22));


    }

    public void IiVT_12() {

        decL_1p();

        p2.setText(getResources().getString(R.string.paket_asu));
        p2a.setText(getResources().getString(R.string.masina));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk4_21));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

        p3.setText(getResources().getString(R.string.paket_asu));
        p3a.setText(getResources().getString(R.string.masina));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_21));
        p3z.setText(getResources().getString(R.string.set_protocol));
        p3az.setText(getResources().getString(R.string.pachin));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.gk300));


    }

    public void ISiT_11() {

        decL_1p();

        p3z.setText(getResources().getString(R.string.history));
        p3az.setText(getResources().getString(R.string.klevcova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk1_22));

        p4z.setText(getResources().getString(R.string.history));
        p4az.setText(getResources().getString(R.string.klevcova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk1_22));

    }

    // Второй курс
    public void MI_21() {
        p1.setText(getResources().getString(R.string.k_mir));
        p1a.setText(getResources().getString(R.string.trofimova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_26));
        p1z.setText(getResources().getString(R.string.k_mir));
        p1az.setText(getResources().getString(R.string.trofimova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_26));

        engL_2p();

        p3.setText(getResources().getString(R.string.m_analis));
        p3a.setText(getResources().getString(R.string.chernousova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_28));
        p3z.setText(getResources().getString(R.string.m_analis));
        p3az.setText(getResources().getString(R.string.chernousova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_28));


    }

    public void MF_21() {

        p1.setText(getResources().getString(R.string.k_mir));
        p1a.setText(getResources().getString(R.string.trofimova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_26));
        p1z.setText(getResources().getString(R.string.k_mir));
        p1az.setText(getResources().getString(R.string.trofimova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_26));

        engL_2p();

        p3.setText(getResources().getString(R.string.m_analis));
        p3a.setText(getResources().getString(R.string.chernousova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_28));
        p3z.setText(getResources().getString(R.string.m_analis));
        p3az.setText(getResources().getString(R.string.chernousova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_28));

    }

    public void PM_21() {


        engL_3p();

        p4.setText(getResources().getString(R.string.data_bases));
        p4a.setText(getResources().getString(R.string.zaburaeva));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk15_305));
        p4z.setText(getResources().getString(R.string.data_bases));
        p4az.setText(getResources().getString(R.string.zaburaeva));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk15_305));


    }

    public void BI_21() {
        p2.setText(getResources().getString(R.string.os));
        p2a.setText(getResources().getString(R.string.zaburaeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk15_305));

        engL_3p();

        p4.setText(getResources().getString(R.string.mat_mod_eco));
        p4a.setText(getResources().getString(R.string.tarova));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.uk2_113));
    }

    public void IiVT_21() {

        p1.setText(getResources().getString(R.string.rasp_ob_inf));
        p1a.setText(getResources().getString(R.string.gubin));
        m_p1_t.setText(getResources().getString(R.string.dv_pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_2));

        p2.setText(getResources().getString(R.string.rasp_ob_inf));
        p2a.setText(getResources().getString(R.string.gubin));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));

        engL_3p();
    }

    public void ISiT_21() {

        p1z.setText(getResources().getString(R.string.or_ibm));
        p1az.setText(getResources().getString(R.string.gubin));
        m_p1_tz.setText(getResources().getString(R.string.lk));
        m_p1_kz.setText(getResources().getString(R.string.uk1_2));

        p2z.setText(getResources().getString(R.string.or_ibm));
        p2az.setText(getResources().getString(R.string.gubin));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk1_2));

        engL_3p();

        p4z.setText(getResources().getString(R.string.or_ibm));
        p4az.setText(getResources().getString(R.string.gubin));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk1_2));


    }

    public void NE_21() {

        p1.setText(getResources().getString(R.string.k_mir));
        p1a.setText(getResources().getString(R.string.trofimova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_26));
        p1z.setText(getResources().getString(R.string.k_mir));
        p1az.setText(getResources().getString(R.string.trofimova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_26));

        p2.setText(getResources().getString(R.string.physics));
        p2a.setText(getResources().getString(R.string.kondakova));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk1_1));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделе


        engL_3p();

    }


    public void MF_31() {

        p1.setText(getResources().getString(R.string.met_ob_vos));
        p1a.setText(getResources().getString(R.string.safronova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_15));
        p1z.setText(getResources().getString(R.string.practic));
        p1z.setTextSize(8);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);

        p2.setText(getResources().getString(R.string.met_ob_vos));
        p2a.setText(getResources().getString(R.string.safronova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_15));
        p2z.setText(getResources().getString(R.string.practic));
        p2az.setVisibility(View.GONE);
        m_p2_tz.setVisibility(View.GONE);
        m_p2_kz.setVisibility(View.GONE);
        p2z.setTextSize(8);

        p3z.setText(getResources().getString(R.string.practic));
        p3az.setVisibility(View.GONE);
        m_p3_tz.setVisibility(View.GONE);
        m_p3_kz.setVisibility(View.GONE);
        p3z.setTextSize(8);

        p4z.setText(getResources().getString(R.string.practic));
        p4az.setVisibility(View.GONE);
        m_p4_tz.setVisibility(View.GONE);
        p4z.setTextSize(8);
        m_p4_kz.setVisibility(View.GONE);
    }

    public void PM_31() {


        p2.setText(getResources().getString(R.string.os));
        p2a.setText(getResources().getString(R.string.zaburaeva));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk15_305));
        p2z.setText(getResources().getString(R.string.os));
        p2az.setText(getResources().getString(R.string.zaburaeva));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk15_305));

        p3.setText(getResources().getString(R.string.fun_analis));
        p3a.setText(getResources().getString(R.string.kornienko));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk3_16));
        p3z.setText(getResources().getString(R.string.mat_chis_met));
        p3az.setText(getResources().getString(R.string.tarova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk2_113));

        p4z.setText(getResources().getString(R.string.mat_chis_met));
        p4az.setText(getResources().getString(R.string.tarova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk2_113));
    }

    public void IiVT_31() {

        p1.setText(getResources().getString(R.string.ibm_per_us));
        p1a.setText(getResources().getString(R.string.masina));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        p1z.setText(getResources().getString(R.string.ibm_per_us));
        p1az.setText(getResources().getString(R.string.masina));
        m_p1_tz.setText(getResources().getString(R.string.lb));
        m_p1_kz.setText(getResources().getString(R.string.uk4_21));

        p2z.setText(getResources().getString(R.string.inj_gra));
        p2az.setText(getResources().getString(R.string.rodionova));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk12_2_101));

    }

    public void NE_31() {

        p1z.setText(getResources().getString(R.string.phys_xim));
        p1az.setText(getResources().getString(R.string.pahomova));
        m_p1_tz.setText(getResources().getString(R.string.lk));
        m_p1_kz.setText(getResources().getString(R.string.uk12_103));

        p2z.setText(getResources().getString(R.string.phys_xim));
        p2az.setText(getResources().getString(R.string.pahomova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk12_103));

        p3.setText(getResources().getString(R.string.el_sred));
        p3a.setText(getResources().getString(R.string.kuznecov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_9));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.el_sred));
        p4a.setText(getResources().getString(R.string.kuznecov));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk1_9));
        Null_Mon_Z_4();


    }

    // 4 курс
    public void M_41() {

        p1z.setText(getResources().getString(R.string.inf_ob_mat));
        p1az.setText(getResources().getString(R.string.safronova));
        m_p1_tz.setText(getResources().getString(R.string.dv_pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_15));

        p2z.setText(getResources().getString(R.string.inf_ob_mat));
        p2az.setText(getResources().getString(R.string.safronova));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_15));

        p3.setText(getResources().getString(R.string.inf_ob_mat));
        p3a.setText(getResources().getString(R.string.safronova));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_15));
        p3z.setText(getResources().getString(R.string.nes_trigo));
        p3az.setText(getResources().getString(R.string.melnikova));
        m_p3_tz.setText(getResources().getString(R.string.dv_pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_26));
    }

    public void FM_41() {

        p1.setText(getResources().getString(R.string.met_or_astr_tex));
        p1a.setText(getResources().getString(R.string.kondakova));
        m_p1_t.setText(getResources().getString(R.string.dv_pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_11));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.kvant_ph));
        p2a.setText(getResources().getString(R.string.sidorov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_27));
        p2z.setText(getResources().getString(R.string.kvant_ph));
        p2az.setText(getResources().getString(R.string.sidorov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_27));


        p3.setText(getResources().getString(R.string.astrophysic));
        p3a.setText(getResources().getString(R.string.kondakova));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_11));


    }

    public void PM_41() {
        p1.setText(getResources().getString(R.string.par_ob_inf));
        p1a.setText(getResources().getString(R.string.gubina));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk16_301a));
        p1z.setText(getResources().getString(R.string.par_ob_inf));
        p1az.setText(getResources().getString(R.string.gubina));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk16_301a));

        p2.setText(getResources().getString(R.string.pr_web));
        p2a.setText(getResources().getString(R.string.gubina));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk16_301a));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.comp_bez));
        p3a.setText(getResources().getString(R.string.zaburaeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk15_305));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.ad_seit));
        p4a.setText(getResources().getString(R.string.tarov));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.gk300));
        Null_Mon_Z_4();
    }

    public void IiVT_41() {
    }

    public void NE_41() {

        p1.setText(getResources().getString(R.string.nano_el));
        p1a.setText(getResources().getString(R.string.kuznecov));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_9));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.kvant_el));
        p2a.setText(getResources().getString(R.string.kuznecov));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_28));
        p2z.setText(getResources().getString(R.string.nano_el));
        p2az.setText(getResources().getString(R.string.kuznecov));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk4_28));

        p3.setText(getResources().getString(R.string.mat_mod_nano));
        p3a.setText(getResources().getString(R.string.sidorov));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.gk300));
        p3z.setText(getResources().getString(R.string.mat_mod_nano));
        p3az.setText(getResources().getString(R.string.sidorov));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk4_22));

        p4.setText(getResources().getString(R.string.teplophys));
        p4a.setText(getResources().getString(R.string.sidorov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_22));
        Null_Mon_Z_4();
    }


    //Пустой знаменатель
    public void Null_Mon_Z() {
        p1z.setVisibility(View.GONE);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);
        m_l1.setVisibility(View.GONE);
        m_l_1z.setVisibility(View.GONE);

    }

    public void Null_Mon_Z_2() {
        p2z.setVisibility(View.GONE);
        p2az.setVisibility(View.GONE);
        m_p2_tz.setVisibility(View.GONE);
        m_p2_kz.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);
        m_l_2z.setVisibility(View.GONE);

    }

    public void Null_Mon_Z_3() {
        p3z.setVisibility(View.GONE);
        p3az.setVisibility(View.GONE);
        m_p3_tz.setVisibility(View.GONE);
        m_p3_kz.setVisibility(View.GONE);
        m_l3.setVisibility(View.GONE);
        m_l_3z.setVisibility(View.GONE);

    }

    public void Null_Mon_Z_4() {
        p4z.setVisibility(View.GONE);
        p4az.setVisibility(View.GONE);
        m_p4_tz.setVisibility(View.GONE);
        m_p4_kz.setVisibility(View.GONE);
        m_l4.setVisibility(View.GONE);
        m_l_4z.setVisibility(View.GONE);
    }

    public void MIitM() {

        INlang_mag();

    }

    public void PMm_11() {

        INlang_mag();

        p5.setText(getResources().getString(R.string.sov_os));
        p5a.setText(getResources().getString(R.string.zaburaeva));
        m_p5_t.setText(getResources().getString(R.string.lk));
        m_p5_k.setText(getResources().getString(R.string.uk15_305));
        p5z.setText(getResources().getString(R.string.sov_os));
        p5az.setText(getResources().getString(R.string.zaburaeva));
        m_p5_tz.setText(getResources().getString(R.string.pz));
        m_p5_kz.setText(getResources().getString(R.string.uk15_305));

        p6z.setText(getResources().getString(R.string.sov_os));
        p6az.setText(getResources().getString(R.string.zaburaeva));
        m_p6_tz.setText(getResources().getString(R.string.lk));
        m_p6_kz.setText(getResources().getString(R.string.uk15_305));

    }

    public void BX_21() {

        p1.setText(getResources().getString(R.string.botanika));
        p1a.setText(getResources().getString(R.string.petricheva));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk12_212));

        p2.setText(getResources().getString(R.string.botanika));
        p2a.setText(getResources().getString(R.string.petricheva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk12_212));

    }

    public void EG_21() {


    }


    public void IIvtm_11() {
        INlang_mag();


        p3.setText(getResources().getString(R.string.int_sys));
        p3a.setText(getResources().getString(R.string.gubin));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_2));
        p3z.setText(getResources().getString(R.string.int_sys));
        p3az.setText(getResources().getString(R.string.gubin));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk1_2));


    }

    public void Mm_21() {


    }

    public void Pmm_21() {


        p3z.setText(getResources().getString(R.string.opt_chis_met));
        p3az.setText(getResources().getString(R.string.kornienko));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk3_16));

        p4.setText(getResources().getString(R.string.diskret_matmod));
        p4a.setText(getResources().getString(R.string.masina));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk4_21));
        p4z.setText(getResources().getString(R.string.opt_chis_met));
        p4az.setText(getResources().getString(R.string.kornienko));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk3_16));

        p5.setText(getResources().getString(R.string.verif));
        p5a.setText(getResources().getString(R.string.tarov));
        m_p5_t.setText(getResources().getString(R.string.lk));
        m_p5_k.setText(getResources().getString(R.string.gk300));
        p5z.setText(getResources().getString(R.string.verif));
        p5az.setText(getResources().getString(R.string.tarov));
        m_p5_tz.setText(getResources().getString(R.string.lk));
        m_p5_kz.setText(getResources().getString(R.string.gk300));

    }

    public void INlang_mag() {

        p4.setText(getResources().getString(R.string.lang_mag));
        p4a.setText(getResources().getString(R.string.leb_sedova));
        m_p4_k.setText(getResources().getString(R.string.uk4_28_13));
        Null_Mon_Z_4();
    }

    public void IIvtm_21() {

        p3z.setText(getResources().getString(R.string.teo_mas_obsl));
        p3az.setText(getResources().getString(R.string.masina));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk4_21));

        p4z.setText(getResources().getString(R.string.teo_mas_obsl));
        p4az.setText(getResources().getString(R.string.masina));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk4_21));

        p5.setText(getResources().getString(R.string.prish_neop));
        p5a.setText(getResources().getString(R.string.masina));
        m_p5_t.setText(getResources().getString(R.string.pz));
        m_p5_k.setText(getResources().getString(R.string.uk4_21));

        p5z.setVisibility(View.GONE);
        p5az.setVisibility(View.GONE);
        m_p5_tz.setVisibility(View.GONE);
        m_p5_kz.setVisibility(View.GONE);
        m_l5.setVisibility(View.GONE);
        m_l_5z.setVisibility(View.GONE);

    }

    public void decL_1p() {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getActivity());
        // читаем установленное значение из CheckBoxPreference
        if (prefs.getBoolean(getString(R.string.pref_chek2), false)) {
            p1.setText(getResources().getString(R.string.inlangN));
            p1a.setText(getResources().getString(R.string.sedova));
            m_p1_t.setText(getResources().getString(R.string.pz));
            m_p1_k.setText(getResources().getString(R.string.uk4_24));
            m_l_1z.setVisibility(View.GONE); // знаменатель
            m_l1.setVisibility(View.GONE);  // Линия разделения
            m_l1.setVisibility(View.VISIBLE);

        } else {

            m_l1.setVisibility(View.VISIBLE);
        }

    }

    public void engL_2p() {
        SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(getActivity());
        // читаем установленное значение из CheckBoxPreference
        if (prefs.getBoolean(getString(R.string.pref_chek1), false)) {

            p2.setText(getResources().getString(R.string.inlang));
            p2a.setText(getResources().getString(R.string.lebedeva));
            m_p2_t.setText(getResources().getString(R.string.pz));
            m_p2_k.setText(getResources().getString(R.string.uk4_24));
            m_l_2z.setVisibility(View.GONE); // знаменатель
            m_l2.setVisibility(View.GONE);  // Линия разделения

        } else {
            m_l2.setVisibility(View.VISIBLE);
        }

    }

    public void engL_3p() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());
        if (prefs.getBoolean(getString(R.string.pref_chek1), false)) {
            p3.setText(getResources().getString(R.string.inlang));
            p3a.setText(getResources().getString(R.string.lebedeva));
            m_p3_t.setText(getResources().getString(R.string.pz));
            m_p3_k.setText(getResources().getString(R.string.uk4_24));
            m_l_3z.setVisibility(View.GONE); // знаменатель
            m_l3.setVisibility(View.GONE);  // Линия разделени.
        } else {
            m_l2.setVisibility(View.VISIBLE);
        }

    }

    private void LoadPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String regular = prefs.getString(getString(R.string.pref_theme), "");

        switch (regular) {
            case "Светлая":
                ThemeWrite();
                break;
            case "Темная":
                ThemeDark();
                break;
        }
    }

    public void ThemeWrite() {

        mk.setBackgroundResource(R.color.colorWhitee);
        p1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p1_t.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p1z.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p1_tz.setTextColor(getResources().getColor(R.color.colorTextBlack));

        p2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p2_t.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p2z.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p2_tz.setTextColor(getResources().getColor(R.color.colorTextBlack));

        p3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p3_t.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p3z.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p3_tz.setTextColor(getResources().getColor(R.color.colorTextBlack));

        p4.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p4_t.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p4z.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p4_tz.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p5.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p5_t.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p5z.setTextColor(getResources().getColor(R.color.colorTextBlack));
        m_p5_tz.setTextColor(getResources().getColor(R.color.colorTextBlack));

        s1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s4.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s5.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s6.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s7.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s8.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s9.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s10.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s11.setTextColor(getResources().getColor(R.color.colorTextBlack));
        s12.setTextColor(getResources().getColor(R.color.colorTextBlack));

        l1.setBackgroundResource(R.color.colorNewstitle);
        l2.setBackgroundResource(R.color.colorNewstitle);
        l3.setBackgroundResource(R.color.colorNewstitle);
        l4.setBackgroundResource(R.color.colorNewstitle);

        m_l1.setBackgroundResource(R.color.colorNewstitle);
        m_l2.setBackgroundResource(R.color.colorNewstitle);
        m_l3.setBackgroundResource(R.color.colorNewstitle);
        m_l4.setBackgroundResource(R.color.colorNewstitle);
        m_l5.setBackgroundResource(R.color.colorNewstitle);


    }

    public void ThemeDark() {

        mk.setBackgroundResource(R.color.colorPrimaryF);
        p1.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p1_t.setTextColor(getResources().getColor(R.color.colorWhitee));
        p1z.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p1_tz.setTextColor(getResources().getColor(R.color.colorWhitee));

        p2.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p2_t.setTextColor(getResources().getColor(R.color.colorWhitee));
        p2z.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p2_tz.setTextColor(getResources().getColor(R.color.colorWhitee));

        p3.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p3_t.setTextColor(getResources().getColor(R.color.colorWhitee));
        p3z.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p3_tz.setTextColor(getResources().getColor(R.color.colorWhitee));

        p4.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p4_t.setTextColor(getResources().getColor(R.color.colorWhitee));
        p4z.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p4_tz.setTextColor(getResources().getColor(R.color.colorWhitee));
        p5.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p5_t.setTextColor(getResources().getColor(R.color.colorWhitee));
        p5z.setTextColor(getResources().getColor(R.color.colorWhitee));
        m_p5_tz.setTextColor(getResources().getColor(R.color.colorWhitee));

        s1.setTextColor(getResources().getColor(R.color.colorWhitee));
        s2.setTextColor(getResources().getColor(R.color.colorWhitee));
        s3.setTextColor(getResources().getColor(R.color.colorWhitee));
        s4.setTextColor(getResources().getColor(R.color.colorWhitee));
        s5.setTextColor(getResources().getColor(R.color.colorWhitee));
        s6.setTextColor(getResources().getColor(R.color.colorWhitee));
        s7.setTextColor(getResources().getColor(R.color.colorWhitee));
        s8.setTextColor(getResources().getColor(R.color.colorWhitee));
        s9.setTextColor(getResources().getColor(R.color.colorWhitee));
        s10.setTextColor(getResources().getColor(R.color.colorWhitee));
        s11.setTextColor(getResources().getColor(R.color.colorWhitee));
        s12.setTextColor(getResources().getColor(R.color.colorWhitee));

        m_l1.setBackgroundResource(R.drawable.side_nav_bar);
        m_l2.setBackgroundResource(R.drawable.side_nav_bar);
        m_l3.setBackgroundResource(R.drawable.side_nav_bar);
        m_l4.setBackgroundResource(R.drawable.side_nav_bar);
        m_l5.setBackgroundResource(R.drawable.side_nav_bar);


        l1.setBackgroundResource(R.color.colorSigma);
        l2.setBackgroundResource(R.color.colorSigma);
        l3.setBackgroundResource(R.color.colorSigma);
        l4.setBackgroundResource(R.color.colorSigma);

    }

    public void XBiG_11() {

        p1.setText(getResources().getString(R.string.inlangAaN));
        p1a.setText(getResources().getString(R.string.leb_sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_13_24));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.osn_mat_inf));
        p2a.setText(getResources().getString(R.string.tarova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk2_113));
        p2z.setText(getResources().getString(R.string.osn_mat_inf));
        p2az.setText(getResources().getString(R.string.tarova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk2_113));

        p3.setText(getResources().getString(R.string.osn_mat_inf));
        p3a.setText(getResources().getString(R.string.tarova));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk2_113));

    }

    public void FC_11() {

        p1.setText(getResources().getString(R.string.inlangAaN));
        p1a.setText(getResources().getString(R.string.leb_sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_13_24));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.physics));
        p2a.setText(getResources().getString(R.string.trofimova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_9));
        p2z.setText(getResources().getString(R.string.physics));
        p2az.setText(getResources().getString(R.string.trofimova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_9));

        p3.setText(getResources().getString(R.string.physics));
        p3a.setText(getResources().getString(R.string.trofimova));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk1_6));

    }

    public void FR_11() {

        p1.setText(getResources().getString(R.string.inlangAaN));
        p1a.setText(getResources().getString(R.string.leb_sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_13_24));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.physics));
        p2a.setText(getResources().getString(R.string.trofimova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_9));
        p2z.setText(getResources().getString(R.string.physics));
        p2az.setText(getResources().getString(R.string.trofimova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_9));

        p3.setText(getResources().getString(R.string.physics));
        p3a.setText(getResources().getString(R.string.trofimova));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk1_6));

        p4.setText(getResources().getString(R.string.vich_ss));
        p4a.setText(getResources().getString(R.string.pachin));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk3_16));
    }

    public void FR_12() {

        p1.setText(getResources().getString(R.string.inlangAaN));
        p1a.setText(getResources().getString(R.string.leb_sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_13_24));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.physics));
        p2a.setText(getResources().getString(R.string.trofimova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_9));
        p2z.setText(getResources().getString(R.string.physics));
        p2az.setText(getResources().getString(R.string.trofimova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_9));

        p3.setText(getResources().getString(R.string.physics));
        p3a.setText(getResources().getString(R.string.trofimova));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk1_6));
    }

    public void FC_21() {

    }

    public void FR_21() {


    }

    public void BX_31() {

        p1z.setText(getResources().getString(R.string.practic));
        p1z.setTextSize(8);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);

        p2z.setText(getResources().getString(R.string.practic));
        p2z.setTextSize(8);
        p2az.setVisibility(View.GONE);
        m_p2_tz.setVisibility(View.GONE);
        m_p2_kz.setVisibility(View.GONE);

        p3z.setText(getResources().getString(R.string.practic));
        p3z.setTextSize(8);
        p3az.setVisibility(View.GONE);
        m_p3_tz.setVisibility(View.GONE);
        m_p3_kz.setVisibility(View.GONE);

        p4z.setText(getResources().getString(R.string.practic));
        p4z.setTextSize(8);
        p4az.setVisibility(View.GONE);
        m_p4_tz.setVisibility(View.GONE);
        m_p4_kz.setVisibility(View.GONE);


    }

    public void ME_31() {

        p1z.setText(getResources().getString(R.string.practic));
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);

        p2z.setText(getResources().getString(R.string.practic));
        p2az.setVisibility(View.GONE);
        m_p2_tz.setVisibility(View.GONE);
        m_p2_kz.setVisibility(View.GONE);

        p3z.setText(getResources().getString(R.string.practic));
        p3az.setVisibility(View.GONE);
        m_p3_tz.setVisibility(View.GONE);
        m_p3_kz.setVisibility(View.GONE);

        p4z.setText(getResources().getString(R.string.practic));
        p4az.setVisibility(View.GONE);
        m_p4_tz.setVisibility(View.GONE);
        m_p4_kz.setVisibility(View.GONE);


    }

    public void FC_31() {

    }

    public void FP_31() {

        p1.setText(getResources().getString(R.string.radiousttr));
        p1a.setText(getResources().getString(R.string.pechkov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_205));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.radiousttr));
        p2a.setText(getResources().getString(R.string.pechkov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_205));
        p2z.setText(getResources().getString(R.string.radiousttr));
        p2az.setText(getResources().getString(R.string.pechkov));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk14_205));
    }

    public void FC_41() {

        p2.setText(getResources().getString(R.string.radiolocal));
        p2a.setText(getResources().getString(R.string.pechkov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_205));
        p2z.setText(getResources().getString(R.string.radiolocal));
        p2az.setText(getResources().getString(R.string.pechkov));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk14_205));

        p3.setText(getResources().getString(R.string.tex_exp_appr));
        p3a.setText(getResources().getString(R.string.pechkov));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk14_205));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.beda));
        p4.setTextSize(8);
        p4a.setText(getResources().getString(R.string.nexoroshix));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk14_215));
        p4z.setText(getResources().getString(R.string.tex_exp_appr));
        p4az.setText(getResources().getString(R.string.pechkov));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk14_205));

    }

    public void FP_41() {

        p2.setText(getResources().getString(R.string.radiolocal));
        p2a.setText(getResources().getString(R.string.pechkov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_205));
        p2z.setText(getResources().getString(R.string.radiolocal));
        p2az.setText(getResources().getString(R.string.pechkov));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk14_205));

        p3.setText(getResources().getString(R.string.tex_exp_appr));
        p3a.setText(getResources().getString(R.string.pechkov));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk14_205));
        Null_Mon_Z_3();

        p4z.setText(getResources().getString(R.string.tex_exp_appr));
        p4az.setText(getResources().getString(R.string.pechkov));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk14_205));

    }

    public void FCm_11() {

        p3z.setText(getResources().getString(R.string.comp_tex_nou));
        p3az.setText(getResources().getString(R.string.gubina));
        m_p3_tz.setText(getResources().getString(R.string.lb));
        m_p3_kz.setText(getResources().getString(R.string.uk16_301a));

        p4.setText(getResources().getString(R.string.in_lan_prof));
        p4a.setText(getResources().getString(R.string.leb_sedova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_28_13));
        Null_Mon_Z_4();

        p5z.setText(getResources().getString(R.string.comp_tex_nou));
        p5az.setText(getResources().getString(R.string.gubina));
        m_p5_tz.setText(getResources().getString(R.string.lb));
        m_p5_kz.setText(getResources().getString(R.string.uk16_301a));

    }

    public void FCm_21() {
    }
}
