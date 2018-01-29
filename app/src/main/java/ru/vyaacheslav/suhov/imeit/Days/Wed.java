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


public class Wed extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4, m_l5, l1, l2, l3, l4;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z, s1, s2, s3, s4, s5, s6, s7, s8, s9, s10;

    RelativeLayout mk;

    public Wed() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.wed, container, false);

        m_l_1z = v.findViewById(R.id.w_l_1z);
        m_l_2z = v.findViewById(R.id.w_l_2z);
        m_l_3z = v.findViewById(R.id.w_l_3z);
        m_l_4z = v.findViewById(R.id.w_l_4z);

        m_l1 = v.findViewById(R.id.w_l1);
        m_l2 = v.findViewById(R.id.w_l2);
        m_l3 = v.findViewById(R.id.w_l3);
        m_l4 = v.findViewById(R.id.w_l4);
        m_l5 = v.findViewById(R.id.w_l5);

        p1 = v.findViewById(R.id.w1);
        p1a = v.findViewById(R.id.w_p1_a);
        m_p1_t = v.findViewById(R.id.w_p1_t);
        m_p1_k = v.findViewById(R.id.w_p1_k);
        p1z = v.findViewById(R.id.w_p1z);
        p1az = v.findViewById(R.id.w_p1_az);
        m_p1_tz = v.findViewById(R.id.w_p1_tz);
        m_p1_kz = v.findViewById(R.id.w_p1_kz);

        mk = v.findViewById(R.id.wesa);

        s1 = v.findViewById(R.id.e1);
        s2 = v.findViewById(R.id.e2);
        s3 = v.findViewById(R.id.e3);
        s4 = v.findViewById(R.id.e4);
        s5 = v.findViewById(R.id.e5);
        s6 = v.findViewById(R.id.e6);
        s7 = v.findViewById(R.id.e7);
        s8 = v.findViewById(R.id.e8);
        s9 = v.findViewById(R.id.e9);
        s10 = v.findViewById(R.id.e10);

        l1 = v.findViewById(R.id.ww1);
        l2 = v.findViewById(R.id.w2);
        l3 = v.findViewById(R.id.w3);
        l4 = v.findViewById(R.id.w4);


        p2 = v.findViewById(R.id.w_p2);
        p2a = v.findViewById(R.id.w_p2_a);
        m_p2_t = v.findViewById(R.id.w_p2_t);
        m_p2_k = v.findViewById(R.id.w_p2_k);
        p2z = v.findViewById(R.id.w_p2z);
        p2az = v.findViewById(R.id.w_p2_az);
        m_p2_tz = v.findViewById(R.id.w_p2_tz);
        m_p2_kz = v.findViewById(R.id.w_p2_kz);

        p3 = v.findViewById(R.id.w_p3);
        p3a = v.findViewById(R.id.w_p3_a);
        m_p3_t = v.findViewById(R.id.w_p3_t);
        m_p3_k = v.findViewById(R.id.w_p3_k);
        p3z = v.findViewById(R.id.w_p3z);
        p3az = v.findViewById(R.id.w_p3_az);
        m_p3_tz = v.findViewById(R.id.w_p3_tz);
        m_p3_kz = v.findViewById(R.id.w_p3_kz);

        p4 = v.findViewById(R.id.w_p4);
        p4a = v.findViewById(R.id.w_p4_a);
        m_p4_t = v.findViewById(R.id.w_p4_t);
        m_p4_k = v.findViewById(R.id.w_p4_k);
        p4z = v.findViewById(R.id.w_p4z);
        p4az = v.findViewById(R.id.w_p4_az);
        m_p4_tz = v.findViewById(R.id.w_p4_tz);
        m_p4_kz = v.findViewById(R.id.w_p4_kz);

        p5 = v.findViewById(R.id.w_p5);
        p5a = v.findViewById(R.id.w_p5a);
        m_p5_t = v.findViewById(R.id.w_p5_t);
        m_p5_k = v.findViewById(R.id.w_p5_k);
        p5z = v.findViewById(R.id.w_p5z);
        p5az = v.findViewById(R.id.w_p5_az);
        m_p5_tz = v.findViewById(R.id.w_p5_tz);
        m_p5_kz = v.findViewById(R.id.w_p5_kz);

        loadMethod();
        LoadPreferences();
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
        p1.setText(getResources().getString(R.string.schol_mat));
        p1a.setText(getResources().getString(R.string.chernousova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_28));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        p2.setText(getResources().getString(R.string.m_analis));
        p2a.setText(getResources().getString(R.string.chernousova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_28));
        p2z.setText(getResources().getString(R.string.m_analis));
        p2az.setText(getResources().getString(R.string.chernousova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_28));

        Fizra_pervaki();

        p4.setText(getResources().getString(R.string.pedagogic));
        p4a.setText(getResources().getString(R.string.zaharova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_28));
        p4z.setText(getResources().getString(R.string.russian_lang));
        p4az.setText(getResources().getString(R.string.ivanova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk4_28));


    }

    public void Pm_11() {


        p2.setText(getResources().getString(R.string.m_analis));
        p2a.setText(getResources().getString(R.string.cherbatix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_26));
        p2z.setText(getResources().getString(R.string.m_analis));
        p2az.setText(getResources().getString(R.string.cherbatix));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_26));

        Fizra_pervaki();


    }

    public void IiVT_12() {

        p2.setText(getResources().getString(R.string.oop));
        p2a.setText(getResources().getString(R.string.rochupkin));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_21));
        p2z.setText(getResources().getString(R.string.oop));
        p2az.setText(getResources().getString(R.string.rochupkin));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_21));

        Fizra_pervaki();
    }

    public void ISiT_11() {
        p1.setText(getResources().getString(R.string.m_analis));
        p1a.setText(getResources().getString(R.string.rochupkin));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        p1z.setText(getResources().getString(R.string.m_analis));
        p1az.setText(getResources().getString(R.string.rochupkin));
        m_p1_tz.setText(getResources().getString(R.string.lk));
        m_p1_kz.setText(getResources().getString(R.string.uk4_21));

        p2z.setText(getResources().getString(R.string.m_analis));
        p2az.setText(getResources().getString(R.string.rochupkin));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_21));

        p2.setText(getResources().getString(R.string.oop));
        p2a.setText(getResources().getString(R.string.rochupkin));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_21));
        p2z.setText(getResources().getString(R.string.oop));
        p2az.setText(getResources().getString(R.string.rochupkin));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_21));

        Fizra_pervaki();

    }

    // Второй курс
    public void MI_21() {

        p1.setText(getResources().getString(R.string.pcixol_soc));
        p1a.setText(getResources().getString(R.string.okuneva));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        p1z.setText(getResources().getString(R.string.pcixol_soc));
        p1az.setText(getResources().getString(R.string.okuneva));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_2kurs();
    }

    public void MF_21() {

        p1.setText(getResources().getString(R.string.pcixol_soc));
        p1a.setText(getResources().getString(R.string.okuneva));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        p1z.setText(getResources().getString(R.string.pcixol_soc));
        p1az.setText(getResources().getString(R.string.okuneva));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_2kurs();

        p3z.setText(getResources().getString(R.string.obrInf));
        p3az.setText(getResources().getString(R.string.trofimova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk1_1));


    }

    public void PM_21() {

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.m_analis));
        p3a.setText(getResources().getString(R.string.cherbatix));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_26));
        p3z.setText(getResources().getString(R.string.m_analis));
        p3az.setText(getResources().getString(R.string.cherbatix));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_26));

    }

    public void BI_21() {
        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.dif_raz));
        p3a.setText(getResources().getString(R.string.rochupkin));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_21));
        p3z.setText(getResources().getString(R.string.dif_raz));
        p3az.setText(getResources().getString(R.string.rochupkin));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_21));
    }

    public void IiVT_21() {

        p1.setText(getResources().getString(R.string.log_pro));
        p1a.setText(getResources().getString(R.string.igonina));
        m_p1_t.setText(getResources().getString(R.string.lb_pz));
        m_p1_k.setText(getResources().getString(R.string.gk300));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        Fizra_2kurs();


    }

    public void ISiT_21() {

        p1.setText(getResources().getString(R.string.log_pro));
        p1a.setText(getResources().getString(R.string.igonina));
        m_p1_t.setText(getResources().getString(R.string.lb_pz));
        m_p1_k.setText(getResources().getString(R.string.gk300));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        Fizra_2kurs();


    }

    public void NE_21() {

        p1.setText(getResources().getString(R.string.on_teo_mex));
        p1a.setText(getResources().getString(R.string.kuznecov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_27));

        Fizra_2kurs();

    }

    public void Fizra_pervaki() {

        p3.setText(getResources().getString(R.string.fk));  //Блок физ-ра для первочей
        p3a.setVisibility(View.GONE);
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.fok));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Лини
    }

    public void Fizra_2kurs() {

        p2.setText(getResources().getString(R.string.fkl));  //Блок физ-ра для первочей
        p2a.setVisibility(View.GONE);
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.fok));
        m_l2.setVisibility(View.GONE);
        m_l_2z.setVisibility(View.GONE);

    }

    public void BX_21() {

        p1.setText(getResources().getString(R.string.pcixol_soc));
        p1a.setText(getResources().getString(R.string.okuneva));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        p1z.setText(getResources().getString(R.string.pcixol_soc));
        p1az.setText(getResources().getString(R.string.okuneva));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        p2.setText(getResources().getString(R.string.fkl));
        p2a.setVisibility(View.GONE);
        m_p2_t.setVisibility(View.GONE);
        m_p2_k.setText(getResources().getString(R.string.fok));
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);

        p3.setText(getResources().getString(R.string.rast_mir));
        p3a.setText(getResources().getString(R.string.sotnikova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk12_310));

        p4.setText(getResources().getString(R.string.rast_mir));
        p4a.setText(getResources().getString(R.string.sotnikova));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk12_310));


    }

    public void EG_21() {

        p1.setText(getResources().getString(R.string.pcixol_soc));
        p1a.setText(getResources().getString(R.string.okuneva));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        p1z.setText(getResources().getString(R.string.pcixol_soc));
        p1az.setText(getResources().getString(R.string.okuneva));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        p2.setText(getResources().getString(R.string.fkl));
        p2a.setVisibility(View.GONE);
        m_p2_t.setVisibility(View.GONE);
        m_p2_k.setText(getResources().getString(R.string.fok));
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);

        p3.setText(getResources().getString(R.string.kartograf));
        p3a.setText(getResources().getString(R.string.melnikova));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk4_28));
        p3z.setText(getResources().getString(R.string.zoologia));
        p3az.setText(getResources().getString(R.string.sotnikova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk12_310));

        p4.setText(getResources().getString(R.string.kartograf));
        p4a.setText(getResources().getString(R.string.melnikova));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk4_26));
        p4z.setText(getResources().getString(R.string.zoologia));
        p4az.setText(getResources().getString(R.string.sotnikova));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk12_310));

    }

    public void MF_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.etica));
        p2a.setText(getResources().getString(R.string.mezinov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        p2z.setText(getResources().getString(R.string.etica));
        p2az.setText(getResources().getString(R.string.mezinov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_13));

        p3.setText(getResources().getString(R.string.schol_uche));
        p3a.setText(getResources().getString(R.string.simonovskaya));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_15));


        p4z.setText(getResources().getString(R.string.ob_ex_phys));
        p4az.setText(getResources().getString(R.string.trofimova));
        m_p4_tz.setText(getResources().getString(R.string.lb));
        m_p4_kz.setText(getResources().getString(R.string.uk1_1));


    }

    public void PM_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.teo_ver));
        p2a.setText(getResources().getString(R.string.dvoryakina));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.teo_ver));
        p2az.setText(getResources().getString(R.string.dvoryakina));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void IiVT_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.met_crypto));
        p2a.setText(getResources().getString(R.string.gubin));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.os));
        p3a.setText(getResources().getString(R.string.gubin));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_2));
        p3z.setText(getResources().getString(R.string.mod_soc_pol));
        p3az.setText(getResources().getString(R.string.gubin));
        m_p3_tz.setText(getResources().getString(R.string.dv_pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_2));
    }

    public void NE_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.osn_el));
        p2a.setText(getResources().getString(R.string.kondakov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk15_001));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.osn_el));
        p3a.setText(getResources().getString(R.string.kondakov));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk15_001));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.vector_isch));
        p4a.setText(getResources().getString(R.string.kondakov));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk15_001));
        Null_Mon_Z_4();
    }

    // 4 курс
    public void M_41() {

    }

    public void FM_41() {

        p1z.setText(getResources().getString(R.string.met_phy));
        p1az.setText(getResources().getString(R.string.trofimova));
        m_p1_tz.setText(getResources().getString(R.string.dv_pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_27));


        p2.setText(getResources().getString(R.string.prepo_phy));
        p2a.setText(getResources().getString(R.string.trofimova));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_27));
        p2z.setText(getResources().getString(R.string.compot));
        p2az.setText(getResources().getString(R.string.trofimova));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_26));

        p3.setText(getResources().getString(R.string.prepo_phy));
        p3a.setText(getResources().getString(R.string.trofimova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_27));

        p4.setText(getResources().getString(R.string.met_phy));
        p4a.setText(getResources().getString(R.string.trofimova));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk4_27));


    }

    public void PM_41() {
    }

    public void IiVT_41() {

        p1.setText(getResources().getString(R.string.inf_bez_set));
        p1a.setText(getResources().getString(R.string.pachin));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk2_113));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.pr_web));
        p2a.setText(getResources().getString(R.string.pachin));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk2_113));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.ad_os));
        p3a.setText(getResources().getString(R.string.pachin));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk2_113));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.pr_sys));
        p4a.setText(getResources().getString(R.string.rochupkin));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.uk4_21));
        Null_Mon_Z_4();

    }

    public void NE_41() {


        p3z.setText(getResources().getString(R.string.eco_proiz));
        p3az.setText(getResources().getString(R.string.vorobev));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.gk307));


        p4.setText(getResources().getString(R.string.eco_proiz));
        p4a.setText(getResources().getString(R.string.vorobev));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.gk307));
        Null_Mon_Z_4();


    }

    public void MIitM() {


    }

    public void PMm_11() {


        p4z.setText(getResources().getString(R.string.isp_yaz_pr));
        p4az.setText(getResources().getString(R.string.kornienkod));
        m_p4_tz.setText(getResources().getString(R.string.dv_pz));
        m_p4_kz.setText(getResources().getString(R.string.uk3_16));

        p5z.setText(getResources().getString(R.string.isp_yaz_pr));
        p5az.setText(getResources().getString(R.string.kornienkod));
        m_p5_tz.setText(getResources().getString(R.string.dv_pz));
        m_p5_kz.setText(getResources().getString(R.string.uk3_16));


    }

    public void IIvtm_11() {
        p4.setText(getResources().getString(R.string.vich_sys));
        p4a.setText(getResources().getString(R.string.pachin));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk2_113));
        p4z.setText(getResources().getString(R.string.vich_sys));
        p4az.setText(getResources().getString(R.string.pachin));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk2_113));

        p5.setText(getResources().getString(R.string.tex_po));
        p5a.setText(getResources().getString(R.string.rochupkin));
        m_p5_k.setText(getResources().getString(R.string.uk4_21));
    }

    public void Mm_21() {


    }

    public void Pmm_21() {

    }

    public void IIvtm_21() {

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

    public void Fizra_3kurs() {

        p1.setText(getResources().getString(R.string.fkl));
        p1a.setVisibility(View.GONE);
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.fok));
        m_l1.setVisibility(View.GONE);
        m_l_1z.setVisibility(View.GONE);
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

        l1.setBackgroundResource(R.color.colorSigma);
        l2.setBackgroundResource(R.color.colorSigma);
        l3.setBackgroundResource(R.color.colorSigma);
        l4.setBackgroundResource(R.color.colorSigma);
    }

    public void XBiG_11() {

        p2.setText(getResources().getString(R.string.botanika));
        p2a.setText(getResources().getString(R.string.petricheva));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk12_212));
        p2z.setText(getResources().getString(R.string.botanika) + " 13.09;  11.10;  08.11; 06.12; 20.12");
        p2az.setText(getResources().getString(R.string.petricheva));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk12_212));

        Fizra_pervaki();

        p4.setText(getResources().getString(R.string.pedagogic));
        p4a.setText(getResources().getString(R.string.zaharova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_28));
        p4z.setText(getResources().getString(R.string.russian_lang));
        p4az.setText(getResources().getString(R.string.ivanova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk4_28));

    }

    public void FC_11() {

        p1z.setText(getResources().getString(R.string.vvod_stud_u_de));
        p1az.setText(getResources().getString(R.string.zaharova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk14_215));

        p2.setText(getResources().getString(R.string.inj_ped));
        p2a.setText(getResources().getString(R.string.zaharova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk12_212));
        p2z.setText(getResources().getString(R.string.inj_ped) + " 13.09;  11.10;  08.11; 06.12;");
        p2az.setText(getResources().getString(R.string.zaharova));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk12_212));

        Fizra_pervaki();

        p4.setText(getResources().getString(R.string.pcixol));
        p4a.setText(getResources().getString(R.string.lelinkova));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk4_22));
        p4z.setText(getResources().getString(R.string.pcixol));
        p4az.setText(getResources().getString(R.string.lelinkova));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk4_22));
    }

    public void FR_11() {

        p2.setText(getResources().getString(R.string.inj_ped));
        p2a.setText(getResources().getString(R.string.zaharova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk12_212));
        p2z.setText(getResources().getString(R.string.inj_ped) + " 13.09;  11.10;  08.11; 06.12;");
        p2az.setText(getResources().getString(R.string.zaharova));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk12_212));

        Fizra_pervaki();

    }

    public void FR_12() {

        p1.setText(getResources().getString(R.string.teo_osn_el));
        p1a.setText(getResources().getString(R.string.fortunova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk14_207));
        p1z.setText(getResources().getString(R.string.teo_osn_el));
        p1az.setText(getResources().getString(R.string.fortunova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk14_207));

        p2.setText(getResources().getString(R.string.inj_ped));
        p2a.setText(getResources().getString(R.string.zaharova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk12_212));
        p2z.setText(getResources().getString(R.string.inj_ped) + " 13.09;  11.10;  08.11; 06.12;");
        p2az.setText(getResources().getString(R.string.zaharova));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk12_212));

        Fizra_pervaki();
    }

    public void FC_21() {

        p1.setText(getResources().getString(R.string.teo_osn_el));
        p1a.setText(getResources().getString(R.string.fortunova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_207));
        p1z.setText(getResources().getString(R.string.teo_osn_el));
        p1az.setText(getResources().getString(R.string.fortunova));
        m_p1_tz.setText(getResources().getString(R.string.lk));
        m_p1_kz.setText(getResources().getString(R.string.uk14_207));

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.physics));
        p3a.setText(getResources().getString(R.string.kondakova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_9));
        p3z.setText(getResources().getString(R.string.physics));
        p3az.setText(getResources().getString(R.string.kondakova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_9));

        p4.setText(getResources().getString(R.string.physics));
        p4a.setText(getResources().getString(R.string.kondakova));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk1_9));
    }

    public void FR_21() {

        p1.setText(getResources().getString(R.string.teo_osn_el));
        p1a.setText(getResources().getString(R.string.fortunova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_207));
        p1z.setText(getResources().getString(R.string.teo_osn_el));
        p1az.setText(getResources().getString(R.string.fortunova));
        m_p1_tz.setText(getResources().getString(R.string.lk));
        m_p1_kz.setText(getResources().getString(R.string.uk14_207));

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.physics));
        p3a.setText(getResources().getString(R.string.kondakova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_9));
        p3z.setText(getResources().getString(R.string.physics));
        p3az.setText(getResources().getString(R.string.kondakova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_9));

        p4.setText(getResources().getString(R.string.physics));
        p4a.setText(getResources().getString(R.string.kondakova));
        m_p4_t.setText(getResources().getString(R.string.lb));
        m_p4_k.setText(getResources().getString(R.string.uk1_9));

    }

    public void BX_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.etica));
        p2a.setText(getResources().getString(R.string.mezinov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        p2z.setText(getResources().getString(R.string.etica));
        p2az.setText(getResources().getString(R.string.mezinov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_13));

        p3.setText(getResources().getString(R.string.pop_botanika));
        p3a.setText(getResources().getString(R.string.petricheva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk12_212));


    }

    public void ME_31() {
        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.etica));
        p2a.setText(getResources().getString(R.string.mezinov));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        p2z.setText(getResources().getString(R.string.etica));
        p2az.setText(getResources().getString(R.string.mezinov));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_13));

        p3.setText(getResources().getString(R.string.chemistry));
        p3a.setText(getResources().getString(R.string.pahomova));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk12_103));
        p3z.setText(getResources().getString(R.string.geografia));
        p3az.setText(getResources().getString(R.string.melnikova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_28));

        p4.setText(getResources().getString(R.string.bio_rast));
        p4a.setText(getResources().getString(R.string.petricheva));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk12_212));

    }

    public void FC_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.osn_gosud));
        p2a.setText(getResources().getString(R.string.akopayn));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk14_216));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.osn_gosud));
        p3a.setText(getResources().getString(R.string.akopayn));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk14_216));
        Null_Mon_Z_3();
    }

    public void FP_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.teo_ver));
        p2a.setText(getResources().getString(R.string.dvoryakina));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.teo_ver));
        p2az.setText(getResources().getString(R.string.dvoryakina));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));
    }

    public void FC_41() {

        p1.setText(getResources().getString(R.string.osn_res));
        p1a.setText(getResources().getString(R.string.arnuatov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_214));
        p1z.setText(getResources().getString(R.string.beda));
        p1az.setText(getResources().getString(R.string.nexoroshix));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk14_218));


        p2.setText(getResources().getString(R.string.osn_res));
        p2a.setText(getResources().getString(R.string.spirin));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z_2();

    }

    public void FP_41() {

        p1.setText(getResources().getString(R.string.osn_res));
        p1a.setText(getResources().getString(R.string.arnuatov));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk14_214));

        p2.setText(getResources().getString(R.string.osn_res));
        p2a.setText(getResources().getString(R.string.spirin));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_218));
        Null_Mon_Z_2();

    }

    public void FCm_11() {

        p2.setText(getResources().getString(R.string.corp_up_per));
        p2a.setText(getResources().getString(R.string.strelnikova));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_215));
        p2z.setText(getResources().getString(R.string.corp_up_per));
        p2az.setText(getResources().getString(R.string.strelnikova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk14_215));

        p3.setText(getResources().getString(R.string.sys_analis));
        p3a.setText(getResources().getString(R.string.fortunova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_207));
        p3z.setText(getResources().getString(R.string.sys_analis));
        p3az.setText(getResources().getString(R.string.fortunova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_207));

        p4.setText(getResources().getString(R.string.sert_lecen));
        p4a.setText(getResources().getString(R.string.fortunova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk14_207));
        p4z.setText(getResources().getString(R.string.sert_lecen));
        p4az.setText(getResources().getString(R.string.fortunova));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk14_207));

        p5z.setText(getResources().getString(R.string.sert_lecen));
        p5az.setText(getResources().getString(R.string.fortunova));
        m_p5_tz.setText(getResources().getString(R.string.pz));
        m_p5_kz.setText(getResources().getString(R.string.uk14_207));
    }

    public void FCm_21() {
        p2.setText(getResources().getString(R.string.up_cach));
        p2a.setText(getResources().getString(R.string.fortunova));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk14_207));
        p2z.setText(getResources().getString(R.string.up_cach));
        p2az.setText(getResources().getString(R.string.fortunova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk14_207));

        p3.setText(getResources().getString(R.string.oxrn_sys));
        p3a.setText(getResources().getString(R.string.arnuatov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_203));
        p3z.setText(getResources().getString(R.string.oxrn_sys));
        p3az.setText(getResources().getString(R.string.arnuatov));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_203));

        p4z.setText(getResources().getString(R.string.tex_nou_rab));
        p4az.setText(getResources().getString(R.string.zaharova));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk14_216));

    }
}