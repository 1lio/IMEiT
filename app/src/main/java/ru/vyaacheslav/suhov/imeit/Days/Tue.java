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

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.R;

public class Tue extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z,main_mon, youday;
    public LinearLayout m_l1, m_l2, m_l3, m_l4, m_l5, l1, l2, l3, l4;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

    RelativeLayout mk;
    SharedPreferences sp;

    public Tue() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tue, container, false);

        m_l_1z = v.findViewById(R.id.t_l_1z);
        m_l_2z = v.findViewById(R.id.t_l_2z);
        m_l_3z = v.findViewById(R.id.t_l_3z);
        m_l_4z = v.findViewById(R.id.t_l_4z);

        sp = PreferenceManager.getDefaultSharedPreferences(getActivity());

        main_mon = v.findViewById(R.id.main_tue);
        youday = v.findViewById(R.id.you_day_tue);

        mk = v.findViewById(R.id.ttr);
        s1 = v.findViewById(R.id.u1);
        s2 = v.findViewById(R.id.u2);
        s3 = v.findViewById(R.id.u3);
        s4 = v.findViewById(R.id.u4);
        s5 = v.findViewById(R.id.u5);
        s6 = v.findViewById(R.id.u6);
        s7 = v.findViewById(R.id.u7);
        s8 = v.findViewById(R.id.u8);
        s9 = v.findViewById(R.id.u9);
        s10 = v.findViewById(R.id.u10);

        l1 = v.findViewById(R.id.z1);
        l2 = v.findViewById(R.id.z2);
        l3 = v.findViewById(R.id.z3);
        l4 = v.findViewById(R.id.z4);

        m_l1 = v.findViewById(R.id.tu_l1);
        m_l2 = v.findViewById(R.id.tu_l2);
        m_l3 = v.findViewById(R.id.tu_l3);
        m_l4 = v.findViewById(R.id.tu_l4);
        m_l5 = v.findViewById(R.id.t_l5);

        p1 = v.findViewById(R.id.t1);
        p1a = v.findViewById(R.id.t_p1_a);
        m_p1_t = v.findViewById(R.id.t_p1_t);
        m_p1_k = v.findViewById(R.id.t_p1_k);
        p1z = v.findViewById(R.id.t_p1z);
        p1az = v.findViewById(R.id.t_p1_az);
        m_p1_tz = v.findViewById(R.id.t_p1_tz);
        m_p1_kz = v.findViewById(R.id.t_p1_kz);

        p2 = v.findViewById(R.id.t_p2);
        p2a = v.findViewById(R.id.t_p2_a);
        m_p2_t = v.findViewById(R.id.t_p2_t);
        m_p2_k = v.findViewById(R.id.t_p2_k);
        p2z = v.findViewById(R.id.t_p2z);
        p2az = v.findViewById(R.id.t_p2_az);
        m_p2_tz = v.findViewById(R.id.t_p2_tz);
        m_p2_kz = v.findViewById(R.id.t_p2_kz);

        p3 = v.findViewById(R.id.t_p3);
        p3a = v.findViewById(R.id.t_p3_a);
        m_p3_t = v.findViewById(R.id.t_p3_t);
        m_p3_k = v.findViewById(R.id.t_p3_k);
        p3z = v.findViewById(R.id.t_p3z);
        p3az = v.findViewById(R.id.t_p3_az);
        m_p3_tz = v.findViewById(R.id.t_p3_tz);
        m_p3_kz = v.findViewById(R.id.t_p3_kz);

        p4 = v.findViewById(R.id.t_p4);
        p4a = v.findViewById(R.id.t_p4_a);
        m_p4_t = v.findViewById(R.id.t_p4_t);
        m_p4_k = v.findViewById(R.id.t_p4_k);
        p4z = v.findViewById(R.id.t_p4z);
        p4az = v.findViewById(R.id.t_p4_az);
        m_p4_tz = v.findViewById(R.id.t_p4_tz);
        m_p4_kz = v.findViewById(R.id.t_p4_kz);

        p5 = v.findViewById(R.id.t_p5);
        p5a = v.findViewById(R.id.t_p5a);
        m_p5_t = v.findViewById(R.id.t_p5_t);
        m_p5_k = v.findViewById(R.id.t_p5_k);
        p5z = v.findViewById(R.id.t_p5z);
        p5az = v.findViewById(R.id.t_p5_az);
        m_p5_tz = v.findViewById(R.id.t_p5_tz);
        m_p5_kz = v.findViewById(R.id.t_p5_kz);

        loadMethod();
        LoadPreferences();
        Danger();
        return v;
    }

    public void Less1D(String l, String p, String t, String r, boolean duble , boolean i) {

        if( duble){
            p1z.setText(l);
            p1az.setText(p);
            m_p1_tz.setText(getString(R.string.pz));
            m_p1_kz.setText(r);
        }

        if (i) {
            m_l_1z.setVisibility(View.VISIBLE);
        } else {
            m_l1.setVisibility(View.GONE);
            m_l_1z.setVisibility(View.GONE);
        }

        p1.setText(l);
        p1a.setText(p);
        m_p1_t.setText(t);
        m_p1_k.setText(r);
    }
    public void Less2D(String l, String p, String t, String r, boolean duble , boolean i) {

        if( duble){
            p2z.setText(l);
            p2az.setText(p);
            m_p2_tz.setText(getString(R.string.pz));
            m_p2_kz.setText(r);
        }

        if (i) {
            m_l_2z.setVisibility(View.VISIBLE);
        } else {
            m_l2.setVisibility(View.GONE);
            m_l_2z.setVisibility(View.GONE);
        }

        p2.setText(l);
        p2a.setText(p);
        m_p2_t.setText(t);
        m_p2_k.setText(r);
    }
    public void Less3D(String l, String p, String t, String r, boolean duble , boolean i) {

        if( duble){
            p3z.setText(l);
            p3az.setText(p);
            m_p3_tz.setText(getString(R.string.pz));
            m_p3_kz.setText(r);
        }

        if (i) {
            m_l_3z.setVisibility(View.VISIBLE);
        } else {
            m_l3.setVisibility(View.GONE);
            m_l_3z.setVisibility(View.GONE);
        }

        p3.setText(l);
        p3a.setText(p);
        m_p3_t.setText(t);
        m_p3_k.setText(r);
    }
    public void Less4D(String l, String p, String t, String r, boolean duble , boolean i) {

        if( duble){
            p4z.setText(l);
            p4az.setText(p);
            m_p4_tz.setText(getString(R.string.pz));
            m_p4_kz.setText(r);
        }

        if (i) {
            m_l_4z.setVisibility(View.VISIBLE);
        } else {
            m_l4.setVisibility(View.GONE);
            m_l_4z.setVisibility(View.GONE);
        }

        p4.setText(l);
        p4a.setText(p);
        m_p4_t.setText(t);
        m_p4_k.setText(r);
    }

    public void Less2(String l, String p, String t, String r, String lz, String pz, String tz, String rz, boolean i) {


        if (i) {
            m_l2.setVisibility(View.VISIBLE);
        } else {
            m_l2.setVisibility(View.GONE);
        }


        if (lz == null) {
            p2z.setVisibility(View.GONE);
        }
        if (pz == null) {
            p2az.setVisibility(View.GONE);
        }
        if (tz == null) {
            m_p2_tz.setVisibility(View.GONE);
        }
        if (rz == null) {
            m_p2_kz.setVisibility(View.GONE);
        }

        if((lz==null)&&(pz==null)&&(tz==null)&&(rz==null)){
            m_l_2z.setVisibility(View.GONE);
        }

        p2.setText(l);
        p2a.setText(p);
        m_p2_t.setText(t);
        m_p2_k.setText(r);
        p2z.setText(lz);
        p2az.setText(pz);
        m_p2_tz.setText(tz);
        m_p2_kz.setText(rz);
    }
    public void Less3(String l, String p, String t, String r, String lz, String pz, String tz, String rz, boolean i) {


        if (i) {
            m_l3.setVisibility(View.VISIBLE);
        } else {
            m_l3.setVisibility(View.GONE);
        }


        if (lz == null) {
            p3z.setVisibility(View.GONE);
        }
        if (pz == null) {
            p3az.setVisibility(View.GONE);
        }
        if (tz == null) {
            m_p3_tz.setVisibility(View.GONE);
        }
        if (rz == null) {
            m_p3_kz.setVisibility(View.GONE);
        }

        if((lz==null)&&(pz==null)&&(tz==null)&&(rz==null)){
            m_l_3z.setVisibility(View.GONE);
        }

        p3.setText(l);
        p3a.setText(p);
        m_p3_t.setText(t);
        m_p3_k.setText(r);
        p3z.setText(lz);
        p3az.setText(pz);
        m_p3_tz.setText(tz);
        m_p3_kz.setText(rz);
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
                YouDay();
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

    private void Danger() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getContext());

        if (prefs.getBoolean(getString(R.string.danger), false)) {
            Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
            int weekYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

            SharedPreferences prefss = PreferenceManager.getDefaultSharedPreferences(getContext());
            String position = prefss.getString(getString(R.string.week_i), "");
            switch (position) {

                case "Числитель": {

                    if ((weekYear % 2 == 0)) {

                        Null_Mon_Z();
                        Null_Mon_Z_2();
                        Null_Mon_Z_3();
                        Null_Mon_Z_4();
                        Null_Mon_Z_5();
                    }
                    // знаменатель
                    else {
                        Null_Mon_C();
                        Null_Mon_C_2();
                        Null_Mon_C_3();
                        Null_Mon_C_4();
                        Null_Mon_C_5();
                    }

                }
                break;

                case "Знаменатель": {
                    if ((weekYear % 2 == 0)) {
                        Null_Mon_C();
                        Null_Mon_C_2();
                        Null_Mon_C_3();
                        Null_Mon_C_4();
                        Null_Mon_C_5();
                    }
                    // знаменатель
                    else {
                        Null_Mon_Z();
                        Null_Mon_Z_2();
                        Null_Mon_Z_3();
                        Null_Mon_Z_4();
                        Null_Mon_Z_5();
                    }
                }
                break;

                case "Авто": {
                    //числитель
                    if ((weekYear % 2 == 0)) {
                        Null_Mon_C();
                        Null_Mon_C_2();
                        Null_Mon_C_3();
                        Null_Mon_C_4();
                        Null_Mon_C_5();
                    }
                    // знаменатель
                    else {
                        Null_Mon_Z();
                        Null_Mon_Z_2();
                        Null_Mon_Z_3();
                        Null_Mon_Z_4();
                        Null_Mon_Z_5();
                    }
                }
                break;
                default:
                    break;
            }

        }
    }

    // Первый курс
    public void FMiI_11() {
        Less2D(getString(R.string.pcixolv), getString(R.string.budyakova), getString(R.string.lk),getString(R.string.gk212),true, true);
        Less3D(getString(R.string.algebra_a_teoc), getString(R.string.belix), getString(R.string.lk),getString(R.string.uk4_13),true, true);
        Less4D(getString(R.string.m_analis), getString(R.string.chernousova), getString(R.string.lk),getString(R.string.uk4_15),false, false);
    }

    public void Pm_11() {
        Less1D(getString(R.string.met_prog), getString(R.string.kornienko), getString(R.string.lk),getString(R.string.uk3_16),true, true);
        Less2D(getString(R.string.algebra_a_geo), getString(R.string.belix), getString(R.string.lk),getString(R.string.uk4_13),true, true);
        Less3D(getString(R.string.arx_com), getString(R.string.tarov), getString(R.string.lk),getString(R.string.uk16_301a), true, true);
        Less4D(getString(R.string.comt_tex_zad), getString(R.string.tarova), getString(R.string.lk),getString(R.string.uk15_305), false, false);
    }

    public void IiVT_12() {
        Less1D(getString(R.string.mat_mod), getString(R.string.gladkih), getString(R.string.lk),getString(R.string.uk4_21),false, false);
        Less2D(getString(R.string.mat_chis_met), getString(R.string.kornienkod), getString(R.string.lk),getString(R.string.uk4_15),true, true);
    }

    public void ISiT_11() {
        Less1D(getString(R.string.matlogic), getString(R.string.belix), getString(R.string.lk),getString(R.string.uk4_13),true, true);
        Less2D(getString(R.string.algebra_a_geo), getString(R.string.belix), getString(R.string.lk),getString(R.string.uk4_13),true, true);
        Less3D(getString(R.string.elc_doc), getString(R.string.gladkih), getString(R.string.lk),getString(R.string.uk4_21), false, false);
        Less4D(getString(R.string.elc_doc), getString(R.string.gladkih), getString(R.string.pz),getString(R.string.uk4_21), false, false);
    }

    // Второй курс
    public void MI_21() {
        Less2D(getString(R.string.progr), getString(R.string.kornienko), getString(R.string.lk),getString(R.string.uk3_16),true, true);
        Less3D(getString(R.string.m_analis), getString(R.string.chernousova), getString(R.string.lk),getString(R.string.uk4_28), true, true);
        Less4D(getString(R.string.matlogic), getString(R.string.belix), getString(R.string.lk),getString(R.string.uk4_13), true, true);
    }

    public void MF_21() {
        Less2D(getString(R.string.ob_ex_phys), getString(R.string.trofimova), getString(R.string.lk),getString(R.string.uk4_27),true, true);
        Less3D(getString(R.string.m_analis), getString(R.string.chernousova), getString(R.string.lk),getString(R.string.uk4_28), true, true);
        Less4D(getString(R.string.matlogic), getString(R.string.belix), getString(R.string.lk),getString(R.string.uk4_13), true, true);
    }

    public void PM_21() {
        Less1D(getString(R.string.rech_zad_pm), getString(R.string.kornienkod), getString(R.string.lb),getString(R.string.uk4_15),false, false);
    }

    public void BI_21() {
        Less3D(getString(R.string.inf_sys_com), getString(R.string.kornienkod), getString(R.string.lk),getString(R.string.uk3_16), true, true);
        Less4D(getString(R.string.comt_tex_zad), getString(R.string.tarova), getString(R.string.pz),getString(R.string.uk15_305), false, false);
    }

    public void IiVT_21() {
        Less2D(getString(R.string.teo_ver), getString(R.string.dvoryakina), getString(R.string.lk),getString(R.string.uk4_28),true, true);
        Less3D(getString(R.string.dif_ur), getString(R.string.melnikov), getString(R.string.lk),getString(R.string.uk4_26), false, false);
    }

    public void ISiT_21() {
        Less2D(getString(R.string.teo_ver), getString(R.string.dvoryakina), getString(R.string.lk),getString(R.string.uk4_28),true, true);
    }

    public void NE_21() {
        Less1D(getString(R.string.osn_poly), getString(R.string.kondakova), getString(R.string.lk),getString(R.string.uk15_001),false, false);
        Less2D(getString(R.string.teo_ver), getString(R.string.dvoryakina), getString(R.string.lk),getString(R.string.uk4_28),true, true);
        Less3D(getString(R.string.mat_el_tex), getString(R.string.kondakova), getString(R.string.lk),getString(R.string.uk15_001),true, true);
        Less4D(getString(R.string.mat_el_tex), getString(R.string.kondakova), getString(R.string.lk),getString(R.string.uk15_001),true, true);
    }

    public void BX_21() {
        Less1D(getString(R.string.vvod_nano), getString(R.string.kuznecov), getString(R.string.pz),getString(R.string.uk12_213),false, true);
        Less2D(getString(R.string.sov_met_him), getString(R.string.pahomova), getString(R.string.lb),getString(R.string.uk12_103),false, false);
    }

    public void EG_21() {
        Less1D(getString(R.string.ob_soc_geogr), getString(R.string.melnikov), getString(R.string.pz),getString(R.string.uk4_26),false, false);
        Less2D(getString(R.string.m_analis), getString(R.string.padaev), getString(R.string.lk),getString(R.string.uk4_23),false, true);
        Less3D(getString(R.string.m_analis), getString(R.string.padaev), getString(R.string.pz),getString(R.string.uk4_23),false, true);
    }

    public void MF_31() {

        Less2D(getString(R.string.m_analis), getString(R.string.melnikov), getString(R.string.pz),getString(R.string.uk4_26),true, true);
        Less3(getString(R.string.met_ob_mat), getString(R.string.safronova), getString(R.string.lk),getString(R.string.uk14_218),
                getString(R.string.ob_ex_phys), getString(R.string.kondakova), getString(R.string.lb),getString(R.string.uk1_13), true);
        Less4D(getString(R.string.met_ob_mat), getString(R.string.safronova), getString(R.string.pz),getString(R.string.uk14_218),false, true);
    }

    public void PM_31() {

        Less3D(getString(R.string.teo_ver), getString(R.string.dvoryakina), getString(R.string.lk),getString(R.string.uk4_15),true, true);
        Less4D(getString(R.string.pr_sys_up), getString(R.string.kornienko), getString(R.string.lk),getString(R.string.uk3_16),true, true);

    }

    public void IiVT_31() {
    }

    public void NE_31() {
        Less2D(getString(R.string.osn_tex_el_bd), getString(R.string.kondakov), getString(R.string.lk),getString(R.string.uk15_001),true, true);
        Less3D(getString(R.string.osn_stat_phy), getString(R.string.kondakova), getString(R.string.lk),getString(R.string.uk1_10),false, true);
        Less4D(getString(R.string.osn_stat_phy), getString(R.string.kondakova), getString(R.string.pz),getString(R.string.uk1_10),false, true);

    }

    // 4 курс
    public void M_41() {
        Less2(getString(R.string.teo_osn_m_analis), getString(R.string.elchinova), getString(R.string.pz),getString(R.string.uk4_24),
                getString(R.string.el_mat), getString(R.string.elchinova), getString(R.string.pz),getString(R.string.uk4_24), true);
        Less3D(  getString(R.string.el_mat), getString(R.string.elchinova), getString(R.string.pz),getString(R.string.uk4_24),false, false);
        Less4D(getString(R.string.nes_trigo), getString(R.string.melnikov), getString(R.string.lk),getString(R.string.uk4_26),false, false);

    }

    public void FM_41() {
        Less2D(getString(R.string.zad_hard), getString(R.string.kondakova), getString(R.string.lk),getString(R.string.uk1_10),true, true);
        Less3D(getString(R.string.kvant_ph), getString(R.string.filimonova), getString(R.string.pz),getString(R.string.uk1_5),false, true);
    }

    public void PM_41() {
        Less4D(  getString(R.string.sys_po), getString(R.string.tarov), getString(R.string.pz),getString(R.string.uk16_301a),true, true);
    }

    public void IiVT_41() {
        Less2D(getString(R.string.pr_asoi), getString(R.string.gladkih), getString(R.string.lk), getString(R.string.uk4_21),false, false);
        Less2D(getString(R.string.pr_sys), getString(R.string.rochupkin), getString(R.string.pz), getString(R.string.uk4_22),false, false);
    }

    public void NE_41() {}

    public void MIitM() {}

    public void PMm_11() {}

    public void IIvtm_11() {}

    public void Mm_21() {}

    public void Pmm_21() {}

    public void IIvtm_21() {}

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

    }

    public void ThemeDark() {

        mk.setBackgroundResource(R.color.colorT);
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
    }

    public void XBiG_11() {}

    public void FC_11() {}

    public void FR_11() {}

    public void FR_12() {}

    public void FC_21() {}

    public void FR_21() {}

    public void BX_31() {}

    public void ME_31() {}

    public void FC_31() {}

    public void FP_31() {}

    public void FC_41() {}

    public void FP_41() {}

    public void FCm_11() {}

    public void FCm_21() {}

    public void YouDay(){
        youday.setVisibility(View.VISIBLE);
        main_mon.setVisibility(View.GONE);
    }

    public void Null_Mon_Z() {
        p1z.setVisibility(View.GONE);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);
        m_l_1z.setVisibility(View.GONE);
        m_l1.setVisibility(View.GONE);
    }

    public void Null_Mon_Z_2() {
        p2z.setVisibility(View.GONE);
        p2az.setVisibility(View.GONE);
        m_p2_tz.setVisibility(View.GONE);
        m_p2_kz.setVisibility(View.GONE);
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);
    }

    public void Null_Mon_Z_3() {
        p3z.setVisibility(View.GONE);
        p3az.setVisibility(View.GONE);
        m_p3_tz.setVisibility(View.GONE);
        m_p3_kz.setVisibility(View.GONE);
        m_l_3z.setVisibility(View.GONE);
        m_l3.setVisibility(View.GONE);

    }

    public void Null_Mon_Z_4() {
        p4z.setVisibility(View.GONE);
        p4az.setVisibility(View.GONE);
        m_p4_tz.setVisibility(View.GONE);
        m_p4_kz.setVisibility(View.GONE);
        m_l_4z.setVisibility(View.GONE);
        m_l4.setVisibility(View.GONE);
    }

    public void Null_Mon_Z_5() {
        p5z.setVisibility(View.GONE);
        p5az.setVisibility(View.GONE);
        m_p5_tz.setVisibility(View.GONE);
        m_p5_kz.setVisibility(View.GONE);
    /*    m_l_5z.setVisibility(View.GONE);*/
        m_l5.setVisibility(View.GONE);

    }

    public void Null_Mon_C() {
        p1.setVisibility(View.GONE);
        p1a.setVisibility(View.GONE);
        m_p1_t.setVisibility(View.GONE);
        m_p1_k.setVisibility(View.GONE);

        m_l1.setVisibility(View.GONE);
    }

    public void Null_Mon_C_2() {
        p2.setVisibility(View.GONE);
        p2a.setVisibility(View.GONE);
        m_p2_t.setVisibility(View.GONE);
        m_p2_k.setVisibility(View.GONE);

        m_l2.setVisibility(View.GONE);

    }

    public void Null_Mon_C_3() {
        p3.setVisibility(View.GONE);
        p3a.setVisibility(View.GONE);
        m_p3_t.setVisibility(View.GONE);
        m_p3_k.setVisibility(View.GONE);

        m_l3.setVisibility(View.GONE);

    }

    public void Null_Mon_C_4() {
        p4.setVisibility(View.GONE);
        p4a.setVisibility(View.GONE);
        m_p4_t.setVisibility(View.GONE);
        m_p4_k.setVisibility(View.GONE);

        m_l4.setVisibility(View.GONE);
    }

    public void Null_Mon_C_5() {
        p5.setVisibility(View.GONE);
        p5a.setVisibility(View.GONE);
        m_p5_t.setVisibility(View.GONE);
        m_p5_k.setVisibility(View.GONE);

        m_l5.setVisibility(View.GONE);
    }

}
