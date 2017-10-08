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

public class Thu extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4, m_l5, l1, l2, l3, l4;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

    RelativeLayout mk;

    public Thu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thu, container, false);

        m_l_1z = v.findViewById(R.id.h_l_1z);
        m_l_2z = v.findViewById(R.id.h_l_2z);
        m_l_3z = v.findViewById(R.id.h_l_3z);
        m_l_4z = v.findViewById(R.id.h_l_4z);

        mk = v.findViewById(R.id.hh1);

        s1 = v.findViewById(R.id.r1);
        s2 = v.findViewById(R.id.r2);
        s3 = v.findViewById(R.id.r3);
        s4 = v.findViewById(R.id.r4);
        s5 = v.findViewById(R.id.r5);
        s6 = v.findViewById(R.id.r6);
        s7 = v.findViewById(R.id.r7);
        s8 = v.findViewById(R.id.r8);
        s9 = v.findViewById(R.id.r9);
        s10 = v.findViewById(R.id.r10);

        l1 = v.findViewById(R.id.rr1);
        l2 = v.findViewById(R.id.rr2);
        l3 = v.findViewById(R.id.rr3);
        l4 = v.findViewById(R.id.rr4);

        m_l1 = v.findViewById(R.id.th_l1);
        m_l2 = v.findViewById(R.id.th_l2);
        m_l3 = v.findViewById(R.id.th_l3);
        m_l4 = v.findViewById(R.id.th_l4);
        m_l5 = v.findViewById(R.id.h_l5);

        p1 = v.findViewById(R.id.th1);
        p1a = v.findViewById(R.id.h_p1_a);
        m_p1_t = v.findViewById(R.id.h_p1_t);
        m_p1_k = v.findViewById(R.id.h_p1_k);
        p1z = v.findViewById(R.id.h_p1z);
        p1az = v.findViewById(R.id.h_p1_az);
        m_p1_tz = v.findViewById(R.id.h_p1_tz);
        m_p1_kz = v.findViewById(R.id.h_p1_kz);

        p2 = v.findViewById(R.id.h_p2);
        p2a = v.findViewById(R.id.h_p2_a);
        m_p2_t = v.findViewById(R.id.h_p2_t);
        m_p2_k = v.findViewById(R.id.h_p2_k);
        p2z = v.findViewById(R.id.h_p2z);
        p2az = v.findViewById(R.id.h_p2_az);
        m_p2_tz = v.findViewById(R.id.h_p2_tz);
        m_p2_kz = v.findViewById(R.id.h_p2_kz);
        m_l2.setVisibility(View.GONE);

        p3 = v.findViewById(R.id.h_p3);
        p3a = v.findViewById(R.id.h_p3_a);
        m_p3_t = v.findViewById(R.id.h_p3_t);
        m_p3_k = v.findViewById(R.id.h_p3_k);
        p3z = v.findViewById(R.id.h_p3z);
        p3az = v.findViewById(R.id.h_p3_az);
        m_p3_tz = v.findViewById(R.id.h_p3_tz);
        m_p3_kz = v.findViewById(R.id.h_p3_kz);

        p4 = v.findViewById(R.id.h_p4);
        p4a = v.findViewById(R.id.h_p4_a);
        m_p4_t = v.findViewById(R.id.h_p4_t);
        m_p4_k = v.findViewById(R.id.h_p4_k);
        p4z = v.findViewById(R.id.h_p4z);
        p4az = v.findViewById(R.id.h_p4_az);
        m_p4_tz = v.findViewById(R.id.h_p4_tz);
        m_p4_kz = v.findViewById(R.id.h_p4_kz);

        p5 = v.findViewById(R.id.h_p5);
        p5a = v.findViewById(R.id.h_p5a);
        m_p5_t = v.findViewById(R.id.h_p5_t);
        m_p5_k = v.findViewById(R.id.h_p5_k);
        p5z = v.findViewById(R.id.h_p5z);
        p5az = v.findViewById(R.id.h_p5_az);
        m_p5_tz = v.findViewById(R.id.h_p5_tz);
        m_p5_kz = v.findViewById(R.id.h_p5_kz);

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
                break;
            case "ПМ-41":
                PM_41();
                break;
            case "ИиВТ-41":
                break;
            case "НЭ-41":
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
        p1.setText(getResources().getString(R.string.russian_lang));
        p1a.setText(getResources().getString(R.string.ivanova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_27));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        p2.setText(getResources().getString(R.string.geometry));
        p2a.setText(getResources().getString(R.string.prokuratova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_15));
        p2z.setText(getResources().getString(R.string.geometry));
        p2az.setText(getResources().getString(R.string.prokuratova));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk4_15));

    }

    public void Pm_11() {

        p1.setText(getResources().getString(R.string.osn_inf));
        p1a.setText(getResources().getString(R.string.gubina));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk15_305));

        p2.setText(getResources().getString(R.string.metiso));
        p2a.setText(getResources().getString(R.string.padaev));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_10));
        Null_Mon_Z_2();


    }

    public void IiVT_12() {

        p1.setText(getResources().getString(R.string.m_analiso));
        p1a.setText(getResources().getString(R.string.padaev));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_15));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        p2.setText(getResources().getString(R.string.com_tip));
        p2a.setText(getResources().getString(R.string.gubin));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения


        p3.setText(getResources().getString(R.string.oop));
        p3a.setText(getResources().getString(R.string.rochupkin));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk16_301a));


    }

    public void ISiT_11() {
        p3z.setText(getResources().getString(R.string.informat));
        p3az.setText(getResources().getString(R.string.masina));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk4_21));

        p4z.setText(getResources().getString(R.string.informat));
        p4az.setText(getResources().getString(R.string.masina));
        m_p4_tz.setText(getResources().getString(R.string.lb));
        m_p4_kz.setText(getResources().getString(R.string.uk4_21));

    }

    // Второй курс
    public void MI_21() {
        p1z.setText(getResources().getString(R.string.algebra_a_teoc));
        p1az.setText(getResources().getString(R.string.prokuratova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        p2z.setText(getResources().getString(R.string.vop_int_vi));
        p2az.setText(getResources().getString(R.string.melnikova));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_26));


        p3.setText(getResources().getString(R.string.geometry));
        p3a.setText(getResources().getString(R.string.padaeva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_10));
        p3z.setText(getResources().getString(R.string.geometry));
        p3az.setText(getResources().getString(R.string.padaeva));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_10));

        p4.setText(getResources().getString(R.string.saz_inf));
        p4a.setText(getResources().getString(R.string.zaburaeva));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk15_313));
        p4z.setText(getResources().getString(R.string.teo_osn_inf));
        p4az.setText(getResources().getString(R.string.gubina));
        m_p4_tz.setText(getResources().getString(R.string.lb));
        m_p4_kz.setText(getResources().getString(R.string.uk15_305));

    }

    public void MF_21() {


        p1z.setText(getResources().getString(R.string.algebra_a_teoc));
        p1az.setText(getResources().getString(R.string.prokuratova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        p2z.setText(getResources().getString(R.string.vop_int_vi));
        p2az.setText(getResources().getString(R.string.melnikova));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_26));

        p3.setText(getResources().getString(R.string.geometry));
        p3a.setText(getResources().getString(R.string.padaeva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_10));
        p3z.setText(getResources().getString(R.string.geometry));
        p3az.setText(getResources().getString(R.string.padaeva));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_10));

    }

    public void PM_21() {

        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));


        p2.setText(getResources().getString(R.string.metiso));
        p2a.setText(getResources().getString(R.string.padaev));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_10));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

    }

    public void BI_21() {
        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));


        p2.setText(getResources().getString(R.string.analis_data));
        p2a.setText(getResources().getString(R.string.zaburaeva));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk15_313));
        p2z.setText(getResources().getString(R.string.analis_data));
        p2az.setText(getResources().getString(R.string.zaburaeva));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk15_313));

        p3.setText(getResources().getString(R.string.data_bases));
        p3a.setText(getResources().getString(R.string.zaburaeva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk15_313));
        p3z.setText(getResources().getString(R.string.ofiice_tex));
        p3az.setText(getResources().getString(R.string.gubin));
        m_p3_tz.setText(getResources().getString(R.string.lb));
        m_p3_kz.setText(getResources().getString(R.string.uk15_305));

        p4.setText(getResources().getString(R.string.manadjment));
        p4a.setText(getResources().getString(R.string.pichulin));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_23));
        p4z.setText(getResources().getString(R.string.manadjment));
        p4az.setText(getResources().getString(R.string.pichulin));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_23));


    }

    public void IiVT_21() {

        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));


        p2.setText(getResources().getString(R.string.mod_phys_pro));
        p2a.setText(getResources().getString(R.string.sidorov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk3_16));
        p2z.setText(getResources().getString(R.string.mod_phys_pro));
        p2az.setText(getResources().getString(R.string.sidorov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk3_16));

        p3.setText(getResources().getString(R.string.el_ec));
        p3a.setText(getResources().getString(R.string.zaiceva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_216));
        p3z.setText(getResources().getString(R.string.el_ec));
        p3az.setText(getResources().getString(R.string.zaiceva));
        m_p3_tz.setText(getResources().getString(R.string.lb));
        m_p3_kz.setText(getResources().getString(R.string.uk14_216));

        p4.setText(getResources().getString(R.string.mod_phys_pro));
        p4a.setText(getResources().getString(R.string.sidorov));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk3_16));
    }

    public void ISiT_21() {

        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));

        p2.setText(getResources().getString(R.string.com_tip));
        p2a.setText(getResources().getString(R.string.gubin));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));
        p2z.setText(getResources().getString(R.string.com_tip));
        p2az.setText(getResources().getString(R.string.gubin));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_2));

        p3.setText(getResources().getString(R.string.el_ec));
        p3a.setText(getResources().getString(R.string.zaiceva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_216));
        p3z.setText(getResources().getString(R.string.el_ec));
        p3az.setText(getResources().getString(R.string.zaiceva));
        m_p3_tz.setText(getResources().getString(R.string.lb));
        m_p3_kz.setText(getResources().getString(R.string.uk14_216));

        p4.setText(getResources().getString(R.string.el_ec));
        p4a.setText(getResources().getString(R.string.zaiceva));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk14_216));


    }
    public void NE_21() {

        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));

        p2.setText(getResources().getString(R.string.teo_el));
        p2a.setText(getResources().getString(R.string.fortunova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_207));
        p2z.setText(getResources().getString(R.string.teo_el));
        p2az.setText(getResources().getString(R.string.zaiceva));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk14_211));

        p3.setText(getResources().getString(R.string.metrologian));
        p3a.setText(getResources().getString(R.string.fortunova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_207));
        p3z.setText(getResources().getString(R.string.metrologian));
        p3az.setText(getResources().getString(R.string.fortunova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_207));

        p4.setText(getResources().getString(R.string.on_teo_mex));
        p4a.setText(getResources().getString(R.string.kuznecov));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk1_9));
        m_l_4z.setVisibility(View.GONE); // знаменатель
        m_l4.setVisibility(View.GONE);

    }

    public void MF_31() {

        p3.setText(getResources().getString(R.string.vector_isch));
        p3a.setText(getResources().getString(R.string.sidorov));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_9));
        p3z.setText(getResources().getString(R.string.vector_isch));
        p3az.setText(getResources().getString(R.string.sidorov));
        m_p3_tz.setText(getResources().getString(R.string.dv_pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_9));

        p4.setText(getResources().getString(R.string.el_mat));
        p4a.setText(getResources().getString(R.string.elchinova));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk4_15));

    }

    public void PM_31() {
    }

    public void IiVT_31() {

        p1.setText(getResources().getString(R.string.app_sys));
        p1a.setText(getResources().getString(R.string.rochupkin));
        m_p1_t.setText(getResources().getString(R.string.dv_pz));
        m_p1_k.setText(getResources().getString(R.string.uk16_301a));

        p2.setText(getResources().getString(R.string.app_sys));
        p2a.setText(getResources().getString(R.string.rochupkin));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk16_301a));

        p3.setText(getResources().getString(R.string.ibm_per_us));
        p3a.setText(getResources().getString(R.string.masina));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_21));
        p3z.setText(getResources().getString(R.string.progr));
        p3az.setText(getResources().getString(R.string.rochupkin));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk16_301a));

        p4.setText(getResources().getString(R.string.progr));
        p4a.setText(getResources().getString(R.string.rochupkin));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk16_301a));
        p4z.setText(getResources().getString(R.string.progr));
        p4az.setText(getResources().getString(R.string.rochupkin));
        m_p4_tz.setText(getResources().getString(R.string.lb));
        m_p4_kz.setText(getResources().getString(R.string.uk16_301a));

    }

    public void NE_31() {

        p1.setText(getResources().getString(R.string.ner_term));
        p1a.setText(getResources().getString(R.string.sidorov));
        m_p1_t.setText(getResources().getString(R.string.dv_pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_9));


        p2.setText(getResources().getString(R.string.vector_isch));
        p2a.setText(getResources().getString(R.string.kondakov));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk15_001));


    }

    // 4 курс
    public void M_41() {

        p1.setText(getResources().getString(R.string.teo_razv));
        p1a.setText(getResources().getString(R.string.safronova));
        m_p1_t.setText(getResources().getString(R.string.dv_pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_22));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.teo_razv));
        p2a.setText(getResources().getString(R.string.safronova));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_22));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.ist_mat_r));
        p3a.setText(getResources().getString(R.string.savvina));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_15));
        Null_Mon_Z_3();
    }

    public void FM_41() {

        p1z.setText(getResources().getString(R.string.kvant_ph));
        p1az.setText(getResources().getString(R.string.sidorov));
        m_p1_tz.setText(getResources().getString(R.string.lb));
        m_p1_kz.setText(getResources().getString(R.string.uk1_9));


        p2.setText(getResources().getString(R.string.zad_hard));
        p2a.setText(getResources().getString(R.string.kondakova));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_11));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.zad_hard));
        p3a.setText(getResources().getString(R.string.kondakova));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_11));
        p3z.setText(getResources().getString(R.string.osn_teo_phy));
        p3az.setText(getResources().getString(R.string.kondakova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_11));


    }

    public void PM_41() {
        p1.setText(getResources().getString(R.string.teo_game));
        p1a.setText(getResources().getString(R.string.belix));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_13));
        p1z.setText(getResources().getString(R.string.teo_game));
        p1az.setText(getResources().getString(R.string.belix));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_13));

        p2.setText(getResources().getString(R.string.spec_fun));
        p2a.setText(getResources().getString(R.string.melnikova));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_26));
        p2z.setText(getResources().getString(R.string.par_ob_inf));
        p2az.setText(getResources().getString(R.string.gubina));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk15_305));

        p3.setText(getResources().getString(R.string.comp_bez));
        p3a.setText(getResources().getString(R.string.zaburaeva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk15_313));

        p4.setText(getResources().getString(R.string.pr_web));
        p4a.setText(getResources().getString(R.string.gubina));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk15_305));
    }

    public void IiVT_41() {

        p1.setText(getResources().getString(R.string.inf_bez_set));
        p1a.setText(getResources().getString(R.string.pachin));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk2_113));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.com_tip));
        p2a.setText(getResources().getString(R.string.gubin));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.pr_web));
        p3a.setText(getResources().getString(R.string.pachin));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk2_113));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.mod_class));
        p4a.setText(getResources().getString(R.string.masina));
        m_p4_t.setText(getResources().getString(R.string.ftd));
        m_p4_k.setText(getResources().getString(R.string.uk4_21));

    }

    public void NE_41() {

        p1z.setText(getResources().getString(R.string.mat_nano));
        p1az.setText(getResources().getString(R.string.kondakov));
        m_p1_tz.setText(getResources().getString(R.string.lk));
        m_p1_kz.setText(getResources().getString(R.string.uk15_001));

        p2.setText(getResources().getString(R.string.int_ur));
        p2a.setText(getResources().getString(R.string.melnikova));
        m_p2_t.setText(getResources().getString(R.string.ftd));
        m_p2_k.setText(getResources().getString(R.string.uk4_26));
        p2z.setText(getResources().getString(R.string.mat_nano));
        p2az.setText(getResources().getString(R.string.kondakov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk15_001));

        p3.setText(getResources().getString(R.string.zona_str_el));
        p3a.setText(getResources().getString(R.string.kondakov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk15_001));
        p3z.setText(getResources().getString(R.string.zona_str_el));
        p3az.setText(getResources().getString(R.string.kondakov));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk15_001));

        p4.setText(getResources().getString(R.string.zona_str_el));
        p4a.setText(getResources().getString(R.string.kondakov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk15_001));
        Null_Mon_Z_4();
    }

    public void MIitM() {

        p2z.setText(getResources().getString(R.string.nau_rab));
        p2az.setText(getResources().getString(R.string.savvina));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_23));

        p3z.setText(getResources().getString(R.string.analis_kom_mat));
        p3az.setText(getResources().getString(R.string.safronova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_22));

        p4.setText(getResources().getString(R.string.his_mat_ob));
        p4a.setText(getResources().getString(R.string.savvina));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_26));
        p4z.setText(getResources().getString(R.string.his_mat_ob));
        p4az.setText(getResources().getString(R.string.savvina));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_26));

    }

    public void PMm_11() {


    }

    public void IIvtm_11() {

        p1z.setText(getResources().getString(R.string.nau_rab));
        p1az.setText(getResources().getString(R.string.masina));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_21));

        p2.setText(getResources().getString(R.string.acp_opz));
        p2a.setText(getResources().getString(R.string.masina));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_21));
        p2z.setText(getResources().getString(R.string.analis_inf));
        p2az.setText(getResources().getString(R.string.masina));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_21));

        p3.setText(getResources().getString(R.string.cloud_osn));
        p3a.setText(getResources().getString(R.string.gubin));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_2));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.imt_mod));
        p4a.setText(getResources().getString(R.string.pachin));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk2_113));

    }

    public void Mm_21() {


        p2.setText(getResources().getString(R.string.pos_vis_mat));
        p2a.setText(getResources().getString(R.string.savvina));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk4_23));
        p2z.setText(getResources().getString(R.string.nau_rab));
        p2az.setText(getResources().getString(R.string.savvina));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_23));

        p3.setText(getResources().getString(R.string.ob_hard_zad));
        p3a.setText(getResources().getString(R.string.safronova));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_22));
        p3z.setText(getResources().getString(R.string.vosp_mat));
        p3az.setText(getResources().getString(R.string.pomanova));
        m_p3_tz.setText(getResources().getString(R.string.dv_pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_23));


        p4.setText(getResources().getString(R.string.ob_hard_zad));
        p4a.setText(getResources().getString(R.string.safronova));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.uk4_23));

    }

    public void Pmm_21() {


    }

    public void IIvtm_21() {
        p1.setText(getResources().getString(R.string.prish_neop));
        p1a.setText(getResources().getString(R.string.masina));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        p1z.setText(getResources().getString(R.string.nau_rab));
        p1az.setText(getResources().getString(R.string.masina));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_21));

        p2.setText(getResources().getString(R.string.tex_v_c));
        p2a.setText(getResources().getString(R.string.pachin));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk2_113));
        p2z.setText(getResources().getString(R.string.tex_v_c));
        p2az.setText(getResources().getString(R.string.pachin));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk2_113));


    }


    public void BX_21() {

        p2.setText(getResources().getString(R.string.zoologia));
        p2a.setText(getResources().getString(R.string.sotnikova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));

        p3.setText(getResources().getString(R.string.anatomia));
        p3a.setText(getResources().getString(R.string.chaxsuarov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_8));
        p3z.setText(getResources().getString(R.string.anatomia));
        p3az.setText(getResources().getString(R.string.chaxsuarov));
        m_p3_tz.setText(getResources().getString(R.string.lb));
        m_p3_kz.setText(getResources().getString(R.string.uk1_8));

        p4.setText(getResources().getString(R.string.k_mir));
        p4a.setText(getResources().getString(R.string.usacheva));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk1_8));
        p4z.setText(getResources().getString(R.string.k_mir));
        p4az.setText(getResources().getString(R.string.usacheva));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk1_8));

    }

    public void EG_21() {

        p2.setText(getResources().getString(R.string.m_analis));
        p2a.setText(getResources().getString(R.string.padaev));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_27));
        p2z.setText(getResources().getString(R.string.m_analis));
        p2az.setText(getResources().getString(R.string.padaev));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_27));

        p3.setText(getResources().getString(R.string.zoologia));
        p3a.setText(getResources().getString(R.string.sotnikova));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_13));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.k_mir));
        p4a.setText(getResources().getString(R.string.usacheva));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk1_8));
        p4z.setText(getResources().getString(R.string.k_mir));
        p4az.setText(getResources().getString(R.string.usacheva));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk1_8));
    }


    public void XBiG_11() {

        p1.setText(getResources().getString(R.string.russian_lang));
        p1a.setText(getResources().getString(R.string.ivanova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        Null_Mon_Z();

        p2z.setText(getResources().getString(R.string.pr_sch_chem));
        p2az.setText(getResources().getString(R.string.sotnikova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_13));

        p3z.setText(getResources().getString(R.string.chevetovodstvo));
        p3az.setText(getResources().getString(R.string.petricheva));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk12_212));

    }

    public void FC_11() {

        p2.setText(getResources().getString(R.string.algebra_a_geo));
        p2a.setText(getResources().getString(R.string.belix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.vvos_v_spec));
        p3a.setText(getResources().getString(R.string.zaicev));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_218));
        p3z.setText(getResources().getString(R.string.vvos_v_spec));
        p3az.setText(getResources().getString(R.string.zaicev));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_218));

        p4.setText(getResources().getString(R.string.algebra_a_geo));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk14_218));

        p5.setText(getResources().getString(R.string.algebra_a_geo));
        p5a.setText(getResources().getString(R.string.belix));
        m_p5_t.setText(getResources().getString(R.string.pz));
        m_p5_k.setText(getResources().getString(R.string.uk14_218));

    }

    public void FR_11() {

        p2.setText(getResources().getString(R.string.algebra_a_geo));
        p2a.setText(getResources().getString(R.string.belix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.vvos_v_spec));
        p3a.setText(getResources().getString(R.string.zaicev));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_218));
        p3z.setText(getResources().getString(R.string.vvos_v_spec));
        p3az.setText(getResources().getString(R.string.zaicev));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_218));

        p4.setText(getResources().getString(R.string.algebra_a_geo));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk14_218));
        p4z.setText(getResources().getString(R.string.vu_i_sys));
        p4az.setText(getResources().getString(R.string.pachin));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk2_113));

        p5.setText(getResources().getString(R.string.algebra_a_geo));
        p5a.setText(getResources().getString(R.string.belix));
        m_p5_t.setText(getResources().getString(R.string.pz));
        m_p5_k.setText(getResources().getString(R.string.uk14_218));
    }

    public void FR_12() {

        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));

        p2.setText(getResources().getString(R.string.algebra_a_geo));
        p2a.setText(getResources().getString(R.string.belix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.vvos_v_spec));
        p3a.setText(getResources().getString(R.string.zaicev));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_218));
        p3z.setText(getResources().getString(R.string.vvos_v_spec));
        p3az.setText(getResources().getString(R.string.zaicev));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_218));

        p4.setText(getResources().getString(R.string.algebra_a_geo));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk14_218));

        p5.setText(getResources().getString(R.string.algebra_a_geo));
        p5a.setText(getResources().getString(R.string.belix));
        m_p5_t.setText(getResources().getString(R.string.pz));
        m_p5_k.setText(getResources().getString(R.string.uk14_218));
    }

    public void FC_21() {
        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));

        p2.setText(getResources().getString(R.string.pl_prib));
        p2a.setText(getResources().getString(R.string.zaicev));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_216));
        p2z.setText(getResources().getString(R.string.cob_sys));
        p2az.setText(getResources().getString(R.string.zaicev));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk14_216));

    }

    public void FR_21() {

        p1.setText(getResources().getString(R.string.filosofia));
        p1a.setText(getResources().getString(R.string.podoksenov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_22));
        p1z.setText(getResources().getString(R.string.filosofia));
        p1az.setText(getResources().getString(R.string.podoksenov));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk1_22));

        p2.setText(getResources().getString(R.string.pl_prib));
        p2a.setText(getResources().getString(R.string.zaicev));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_216));
        p2z.setText(getResources().getString(R.string.cob_sys));
        p2az.setText(getResources().getString(R.string.zaicev));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk14_216));

    }

    public void BX_31() {

        p2.setText(getResources().getString(R.string.physics));
        p2a.setText(getResources().getString(R.string.kuznecov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_9));
        p2z.setText(getResources().getString(R.string.physics));
        p2az.setText(getResources().getString(R.string.kuznecov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_9));

        p3.setText(getResources().getString(R.string.biogeografia));
        p3a.setText(getResources().getString(R.string.melnikova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_26));
        p3z.setText(getResources().getString(R.string.physics));
        p3az.setText(getResources().getString(R.string.kuznecov));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_6));

        p4.setText(getResources().getString(R.string.phys_rast));
        p4a.setText(getResources().getString(R.string.sotnikova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_13));
        p4z.setText(getResources().getString(R.string.phys_rast));
        p4az.setText(getResources().getString(R.string.sotnikova));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_13));


    }

    public void ME_31() {

        p2.setText(getResources().getString(R.string.met_ob_estest));
        p2a.setText(getResources().getString(R.string.morgaceva));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk12_220));

        p3.setText(getResources().getString(R.string.met_ob_estest));
        p3a.setText(getResources().getString(R.string.morgaceva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk12_220));
        p3z.setText(getResources().getString(R.string.geografia));
        p3az.setText(getResources().getString(R.string.melnikova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk4_26));

        p4.setText(getResources().getString(R.string.bio_rast));
        p4a.setText(getResources().getString(R.string.petricheva));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk12_213));
        Null_Mon_Z_4();

    }

    public void FC_31() {


        p1.setText(getResources().getString(R.string.cifr_ust_micro));
        p1a.setText(getResources().getString(R.string.arnuatov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_216));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.cifr_ust_micro));
        p2a.setText(getResources().getString(R.string.arnuatov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_216));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.psy_pract));
        p3a.setText(getResources().getString(R.string.larin));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk14_215));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.psy_pract));
        p4a.setText(getResources().getString(R.string.larin));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk14_215));
        Null_Mon_Z_4();

    }

    public void FP_31() {

        p1.setText(getResources().getString(R.string.cifr_ust_micro));
        p1a.setText(getResources().getString(R.string.arnuatov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_216));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.cifr_ust_micro));
        p2a.setText(getResources().getString(R.string.arnuatov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_216));
        Null_Mon_Z_2();

    }

    public void FC_41() {
        p1.setText(getResources().getString(R.string.tel_video));
        p1a.setText(getResources().getString(R.string.spirin));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z();
        p2.setText(getResources().getString(R.string.tel_video));
        p2a.setText(getResources().getString(R.string.spirin));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_202));
        Null_Mon_Z();
    }

    public void FP_41() {

        p1.setText(getResources().getString(R.string.tel_video));
        p1a.setText(getResources().getString(R.string.spirin));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z();
        p2.setText(getResources().getString(R.string.tel_video));
        p2a.setText(getResources().getString(R.string.spirin));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_202));
        Null_Mon_Z_2();

    }

    public void FCm_11() {
    }

    public void FCm_21() {

        p1.setText(getResources().getString(R.string.serv_sys_cifr));
        p1a.setText(getResources().getString(R.string.pechkov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_205));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.serv_sys_cifr));
        p2a.setText(getResources().getString(R.string.pechkov));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk14_205));
        p2z.setText(getResources().getString(R.string.serv_sys_cifr));
        p2az.setText(getResources().getString(R.string.pechkov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk14_205));

        p3.setText(getResources().getString(R.string.sys_raddostup));
        p3a.setText(getResources().getString(R.string.pechkov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_205));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.serv_sys_cifr));
        p4a.setText(getResources().getString(R.string.pechkov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk14_205));
        p4z.setText(getResources().getString(R.string.sys_raddostup));
        p4az.setText(getResources().getString(R.string.pechkov));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk14_205));


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
}