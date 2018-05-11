package ru.vyaacheslav.suhov.imeit.days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Thu extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z, main_mon, youday;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z;

    public Thu() {   }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thu, container, false);

        main_mon = v.findViewById(R.id.main_thu);
        youday = v.findViewById(R.id.you_day_thu);

        m_l_1z = v.findViewById(R.id.h_l_1z);
        m_l_2z = v.findViewById(R.id.h_l_2z);
        m_l_3z = v.findViewById(R.id.h_l_3z);
        m_l_4z = v.findViewById(R.id.h_l_4z);

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

        loadMethod();
        return v;
    }

    public void Less1D(String l, String p, String t, String r, boolean duble, boolean i) {

        if (duble) {
            p1z.setText(l);
            p1az.setText(p);
            m_p1_tz.setText(getString(R.string.pz));
            m_p1_kz.setText(r);
        }

        if (i) {
            m_l_1z.setVisibility(View.VISIBLE);
        } else {
            m_l_1z.setVisibility(View.GONE);
        }

        p1.setText(l);
        p1a.setText(p);
        m_p1_t.setText(t);
        m_p1_k.setText(r);
    }

    public void Less2D(String l, String p, String t, String r, boolean duble, boolean i) {

        if (duble) {
            p2z.setText(l);
            p2az.setText(p);
            m_p2_tz.setText(getString(R.string.pz));
            m_p2_kz.setText(r);
        }

        if (i) {
            m_l_2z.setVisibility(View.VISIBLE);
        } else {
            m_l_2z.setVisibility(View.GONE);
        }

        p2.setText(l);
        p2a.setText(p);
        m_p2_t.setText(t);
        m_p2_k.setText(r);
    }

    public void Less3D(String l, String p, String t, String r, boolean duble, boolean i) {

        if (duble) {
            p3z.setText(l);
            p3az.setText(p);
            m_p3_tz.setText(getString(R.string.pz));
            m_p3_kz.setText(r);
        }
        else {}

        if (i) {
            m_l_3z.setVisibility(View.VISIBLE);
        } else {
            m_l_3z.setVisibility(View.GONE);
        }

        p3.setText(l);
        p3a.setText(p);
        m_p3_t.setText(t);
        m_p3_k.setText(r);
    }

    public void Less4D(String l, String p, String t, String r, boolean duble, boolean i) {

        if (duble) {
            p4z.setText(l);
            p4az.setText(p);
            m_p4_tz.setText(getString(R.string.pz));
            m_p4_kz.setText(r);
        }

        if (i) {
            m_l_4z.setVisibility(View.VISIBLE);
        } else {
            m_l_4z.setVisibility(View.GONE);
        }

        p4.setText(l);
        p4a.setText(p);
        m_p4_t.setText(t);
        m_p4_k.setText(r);
    }

    public void Less1(String l, String p, String t, String r, String lz,
                      String pz, String tz, String rz, boolean i) {
        if (i) {
            m_l_1z.setVisibility(View.VISIBLE);
        } else {
            m_l_1z.setVisibility(View.GONE);
        }

        if (lz == null) {
            p1z.setVisibility(View.INVISIBLE);
        }
        if (pz == null) {
            p1az.setVisibility(View.INVISIBLE);
        }
        if (tz == null) {
            m_p1_tz.setVisibility(View.INVISIBLE);
        }
        if (rz == null) {
            m_p1_kz.setVisibility(View.INVISIBLE);
        }

        p1.setText(l);
        p1a.setText(p);
        m_p1_t.setText(t);
        m_p1_k.setText(r);
        p1z.setText(lz);
        p1az.setText(pz);
        m_p1_tz.setText(tz);
        m_p1_kz.setText(rz);
    }

    public void Less2(String l, String p, String t, String r, String lz,
                      String pz, String tz, String rz, boolean i) {
        if (i) {
            m_l_2z.setVisibility(View.VISIBLE);
        } else {
            m_l_2z.setVisibility(View.GONE);
        }
        if (lz == null) {
            p2z.setVisibility(View.INVISIBLE);
        }
        if (pz == null) {
            p2az.setVisibility(View.INVISIBLE);
        }
        if (tz == null) {
            m_p2_tz.setVisibility(View.INVISIBLE);
        }
        if (rz == null) {
            m_p2_kz.setVisibility(View.INVISIBLE);
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
    public void Less3(String l, String p, String t, String r, String lz,
                      String pz, String tz, String rz, boolean i) {

        if (i) {
            m_l_3z.setVisibility(View.VISIBLE);
        } else {
            m_l_3z.setVisibility(View.GONE);
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
    public void Less4(String l, String p, String t, String r, String lz,
                      String pz, String tz, String rz, boolean i) {

        if (i) {
            m_l_4z.setVisibility(View.VISIBLE);
        } else {
            m_l_4z.setVisibility(View.GONE);
        }
        if (lz == null) {
            p4z.setVisibility(View.INVISIBLE);
        }
        if (pz == null) {
            p4az.setVisibility(View.INVISIBLE);
        }
        if (tz == null) {
            m_p4_tz.setVisibility(View.INVISIBLE);
        }
        if (rz == null) {
            m_p4_kz.setVisibility(View.INVISIBLE);
        }

        p4.setText(l);
        p4a.setText(p);
        m_p4_t.setText(t);
        m_p4_k.setText(r);
        p4z.setText(lz);
        p4az.setText(pz);
        m_p4_tz.setText(tz);
        m_p4_kz.setText(rz);
    }

    // Херовый метод
    // Дублирование
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



    // Первый курс
    public void FMiI_11() {
        Less1(null,null,null,null,getString(R.string.el_physic), getString(R.string.trofimova), getString(R.string.pz),getString(R.string.uk4_27), true);
        Less2D(getString(R.string.geometry), getString(R.string.padaeva), getString(R.string.lk),getString(R.string.uk4_15),true, true);
    }

    public void Pm_11() {

        Less2D(getString(R.string.vvod_v_analis), getString(R.string.melnikov), getString(R.string.pz),getString(R.string.uk4_26),false, false);
        Less3D(getString(R.string.metiso), getString(R.string.padaeva), getString(R.string.pz),getString(R.string.uk4_15),false, false);

    }

    public void IiVT_12() {
        Less3D(getString(R.string.el_sx), getString(R.string.zaiceva), getString(R.string.lk),getString(R.string.uk14_211),false, true);
        Less4(null,null,null,null,getString(R.string.metiso), getString(R.string.padaeva), getString(R.string.lb),getString(R.string.uk4_15), true);
    }

    public void ISiT_11() {
        Less3(getString(R.string.m_analis),getString(R.string.rochupkin),getString(R.string.pz),getString(R.string.uk3_16),
                getString(R.string.chemistry), getString(R.string.sotnikova), getString(R.string.lk),getString(R.string.uk12_310), true);
        Less4(getString(R.string.m_analis),getString(R.string.rochupkin),getString(R.string.pz),getString(R.string.uk3_16),
                getString(R.string.chemistry), getString(R.string.sotnikova), getString(R.string.lk),getString(R.string.uk12_310), true);
    }

    // Второй курс
    public void MI_21() {
        Less1D(getString(R.string.filosofia), getString(R.string.podoksenov), getString(R.string.lk),getString(R.string.uk4_24),true, true);
        Less2D(getString(R.string.pcixolp), getString(R.string.larin), getString(R.string.pz),getString(R.string.uk4_24),true, true);
        Less3D(getString(R.string.teo_osn_inf), getString(R.string.padaev), getString(R.string.pz),getString(R.string.gk300),false, true);
        Less4D(getString(R.string.teo_osn_inf), getString(R.string.padaev), getString(R.string.pz),getString(R.string.gk300),false, true);

    }

    public void MF_21() {
        Less1D(getString(R.string.filosofia), getString(R.string.podoksenov), getString(R.string.lk),getString(R.string.uk4_24),true, true);
        Less2D(getString(R.string.pcixolp), getString(R.string.larin), getString(R.string.pz),getString(R.string.uk4_24),true, true);

    }

    public void PM_21() {

        Less1D(getString(R.string.dif_ur), getString(R.string.eleckix), getString(R.string.lk),getString(R.string.uk4_23),true, true);
        Less2(null,null,null,null,getString(R.string.dif_ur), getString(R.string.eleckix), getString(R.string.lb),getString(R.string.uk4_23), true);
        Less3(null,null,null,null,getString(R.string.comp_analis), getString(R.string.padaev), getString(R.string.lb),getString(R.string.uk4_23), true);
    }

    public void BI_21() {
        Less1D(getString(R.string.econ_firma), getString(R.string.pichulin), getString(R.string.lk), getString(R.string.uk16_202), true, true);
        Less2D(getString(R.string.off_tex), getString(R.string.padaev), getString(R.string.pz), getString(R.string.gk300), true, true);
        Less3D(getString(R.string.mat_mod_eco), getString(R.string.tarova), getString(R.string.pz), getString(R.string.uk2_113), true, true);
        Less4D(getString(R.string.mat_mod_eco), getString(R.string.tarova), getString(R.string.pz), getString(R.string.uk2_113), false, true);
    }

    public void IiVT_21() {
        Less1D(getString(R.string.oop), getString(R.string.rochupkin), getString(R.string.lk), getString(R.string.uk4_21), false, true);
        Less2D(getString(R.string.oop), getString(R.string.rochupkin), getString(R.string.lk), getString(R.string.uk4_22), false, false);
        Less3D(getString(R.string.dif_ur), getString(R.string.melnikov), getString(R.string.pz), getString(R.string.uk4_26), false, false);
    }

    public void ISiT_21() {
        Less1(getString(R.string.os), getString(R.string.tarov), getString(R.string.lk), getString(R.string.uk16_301a),
                getString(R.string.teo_game), getString(R.string.prokuratova), getString(R.string.lk), getString(R.string.uk4_13), true);
        Less2(getString(R.string.os), getString(R.string.tarov), getString(R.string.pz), getString(R.string.uk16_301a),
                getString(R.string.teo_game), getString(R.string.prokuratova), getString(R.string.pz), getString(R.string.uk4_13), true);
        Less3(null,null,null,null,
                getString(R.string.tex_pr), getString(R.string.rochupkin), getString(R.string.pz), getString(R.string.uk3_16), true);
        Less4(null,null,null,null,
                getString(R.string.tex_pr), getString(R.string.rochupkin), getString(R.string.lb), getString(R.string.uk3_16), true);
    }
    public void NE_21() {

        Less1D(getString(R.string.rad_eco), getString(R.string.trofimova), getString(R.string.pz), getString(R.string.uk4_27), false, true);
        Less2D(getString(R.string.phyz_osn_el), getString(R.string.kuznecov), getString(R.string.lk), getString(R.string.uk1_9), true, true);
        Less3(getString(R.string.phyz_osn_el), getString(R.string.kuznecov), getString(R.string.lk), getString(R.string.uk1_9),
                getString(R.string.scan_mikr), getString(R.string.kuznecov), getString(R.string.pz), getString(R.string.uk4_26), false);
        Less2D(getString(R.string.scan_mikr), getString(R.string.kuznecov), getString(R.string.pz), getString(R.string.uk4_26), false, false);
    }

    public void MF_31() {

        Less1(getString(R.string.met_or_let_ot), getString(R.string.povalayeva), getString(R.string.pz), getString(R.string.uk4_13),
                getString(R.string.obr_pravo), getString(R.string.akopayn), getString(R.string.lk), getString(R.string.uk14_205), true);
        Less2(getString(R.string.ob_ex_phys), getString(R.string.kondakova), getString(R.string.pz), getString(R.string.uk1_10),
                getString(R.string.obr_pravo), getString(R.string.akopayn), getString(R.string.lk), getString(R.string.uk14_205), true);
        Less3D(getString(R.string.ob_ex_phys), getString(R.string.kondakova), getString(R.string.pz), getString(R.string.uk1_10), true, true);
        Less4D(getString(R.string.m_analis), getString(R.string.melnikov), getString(R.string.pz), getString(R.string.uk4_26), true, true);
    }

    public void PM_31() {

        Less1(getString(R.string.pravo), getString(R.string.akopayn), getString(R.string.pz), getString(R.string.uk4_28),
                getString(R.string.met_opt), getString(R.string.prokuratova), getString(R.string.lk), getString(R.string.uk4_13), true);
        Less2(getString(R.string.pravo), getString(R.string.akopayn), getString(R.string.pz), getString(R.string.uk4_28),
                getString(R.string.met_opt), getString(R.string.prokuratova), getString(R.string.lk), getString(R.string.uk4_13), true);
        Less3(getString(R.string.os), getString(R.string.zaburaeva), getString(R.string.pz), getString(R.string.uk15_313),
                getString(R.string.met_opt), getString(R.string.prokuratova), getString(R.string.pz), getString(R.string.uk4_13), true);
        Less4D(getString(R.string.os), getString(R.string.zaburaeva), getString(R.string.pz), getString(R.string.uk15_305), false, true);
    }

    public void IiVT_31() {

        Less1(getString(R.string.pravo), getString(R.string.akopayn), getString(R.string.pz), getString(R.string.uk4_28),
                getString(R.string.za_inf), getString(R.string.rochupkin), getString(R.string.lk), getString(R.string.uk4_21), true);
        Less2(getString(R.string.pravo), getString(R.string.akopayn), getString(R.string.pz), getString(R.string.uk4_28),
                getString(R.string.app_sys), getString(R.string.rochupkin), getString(R.string.lk), getString(R.string.uk4_22), true);
        Less3(getString(R.string.pr_bd), getString(R.string.igonina), getString(R.string.pz), getString(R.string.uk1_2),
                getString(R.string.os), getString(R.string.tarov), getString(R.string.pz), getString(R.string.uk16_301a), true);
        Less4(getString(R.string.pr_bd), getString(R.string.igonina), getString(R.string.pz), getString(R.string.uk1_2),
                getString(R.string.mod_soc_pol), getString(R.string.petrov), getString(R.string.pz), getString(R.string.uk1_2), true);
    }

    public void NE_31() {

        Less1(getString(R.string.pravo), getString(R.string.akopayn), getString(R.string.pz), getString(R.string.uk4_28),
                getString(R.string.ner_term), getString(R.string.sidorov), getString(R.string.lk), getString(R.string.uk4_26), true);
        Less2(getString(R.string.pravo), getString(R.string.akopayn), getString(R.string.pz), getString(R.string.uk4_28),
                getString(R.string.phyz_osn_el), getString(R.string.trofimova), getString(R.string.lk), getString(R.string.uk4_27), true);
        Less3D(getString(R.string.kvant_mx), getString(R.string.filimonova), getString(R.string.lk), getString(R.string.uk1_5), false, true);
    }

    // 4 курс

    public void M_41() { YouDay();}

    public void FM_41() {
        Less1D(getString(R.string.astrophysic), getString(R.string.kondakova), getString(R.string.lk), getString(R.string.uk1_11),true, true);
        Less2(getString(R.string.his_phy), getString(R.string.trofimova), getString(R.string.lk), getString(R.string.uk4_27),
                getString(R.string.astrophysic), getString(R.string.kondakova), getString(R.string.lk), getString(R.string.uk1_11), true);
        Less3D(getString(R.string.his_phy), getString(R.string.trofimova), getString(R.string.pz), getString(R.string.uk4_27), false, false);
    }

    public void PM_41() {
        Less1D(getString(R.string.vis_sys), getString(R.string.maksimov), getString(R.string.pz), getString(R.string.uk1_2), false, true);
        Less2(null,null,null,null,
                getString(R.string.ii), getString(R.string.kornienko), getString(R.string.lb), getString(R.string.uk3_16), true);

    }

    public void IiVT_41() {
        Less2(getString(R.string.mod_sys_up), getString(R.string.masina), getString(R.string.pz), getString(R.string.uk4_21),
                getString(R.string.ii_ex), getString(R.string.tarov), getString(R.string.pz), getString(R.string.uk16_301a), true);
        Less3   (getString(R.string.ii_ex), getString(R.string.tarov), getString(R.string.pz), getString(R.string.uk16_301a),
                getString(R.string.seti_tv), getString(R.string.igonina), getString(R.string.pz), getString(R.string.uk4_22), true);
        Less4   (getString(R.string.ii_ex), getString(R.string.tarov), getString(R.string.pz), getString(R.string.uk16_301a),
                getString(R.string.ii_ex), getString(R.string.tarov), getString(R.string.pz), getString(R.string.uk16_301a), true);

    }

    public void NE_41() {

        Less1D(getString(R.string.astrophysic), getString(R.string.kondakova), getString(R.string.lk), getString(R.string.uk1_11),false, true);
        Less2D(getString(R.string.mat_nano), getString(R.string.sidorov), getString(R.string.lk), getString(R.string.uk1_2),false, false);
        Less3D(getString(R.string.mat_nano), getString(R.string.sidorov), getString(R.string.lk), getString(R.string.uk1_2),false, false);

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


    public void BX_21() {

        Less1D(getString(R.string.filosofia), getString(R.string.podoksenov), getString(R.string.lk),getString(R.string.uk4_24),true, true);
        Less2D(getString(R.string.pcixolp), getString(R.string.larin), getString(R.string.pz),getString(R.string.uk4_24),true, true);

    }

    public void EG_21() {

        Less1D(getString(R.string.filosofia), getString(R.string.podoksenov), getString(R.string.lk),getString(R.string.uk4_24),true, true);
        Less2D(getString(R.string.pcixolp), getString(R.string.larin), getString(R.string.pz),getString(R.string.uk4_24),true, true);
        Less3D(getString(R.string.bio_rast), getString(R.string.sotnikova), getString(R.string.pz),getString(R.string.uk12_212),false, true);
        Less3D(getString(R.string.bio_rast), getString(R.string.sotnikova), getString(R.string.pz),getString(R.string.uk12_212),false, true);
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

    public void YouDay(){
        youday.setVisibility(View.VISIBLE);
        main_mon.setVisibility(View.GONE);
    }
}