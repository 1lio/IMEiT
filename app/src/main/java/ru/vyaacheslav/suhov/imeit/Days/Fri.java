package ru.vyaacheslav.suhov.imeit.Days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Fri extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az;
    Spinner spinner;

    public Fri() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fri, container, false);
        spinner = getActivity().findViewById(R.id.spinner);


        m_l_1z = v.findViewById(R.id.f_l_1z);
        m_l_2z = v.findViewById(R.id.f_l_2z);
        m_l_3z = v.findViewById(R.id.f_l_3z);
        m_l_4z = v.findViewById(R.id.f_l_4z);

        m_l1 = v.findViewById(R.id.f_l1);
        m_l2 = v.findViewById(R.id.f_l2);
        m_l3 = v.findViewById(R.id.f_l3);
        m_l4 = v.findViewById(R.id.f_l4);

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


        loadMethod();

        return v;
    }

    public void loadMethod() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int position = sharedPreferences.getInt("spnCalorieRange", -1);
        layoutVisable();
        switch (position) {
            case 0:
                FMiI_11();
                break;
            case 1:
                Pm_11();
                break;

            case 2:
                IiVT_12();
                break;

            case 3:
                ISiT_11();
                break;

            case 4:
                MI_21();
                break;
            case 5:
                MF_21();
                break;
            case 6:
                PM_21();
                break;
            case 7:
                BI_21();
                break;
            case 8:
                IiVT_21();
                break;
            case 9:
                ISiT_21();
                break;
            case 10:
                NE_21();
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

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

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

        p1.setText(getResources().getString(R.string.inlang));
        p1a.setText(getResources().getString(R.string.lebedeva));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

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

        p1.setText(getResources().getString(R.string.inlang));
        p1a.setText(getResources().getString(R.string.lebedeva));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

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

        p1.setText(getResources().getString(R.string.inlang));
        p1a.setText(getResources().getString(R.string.lebedeva));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделенияния разделения

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
        p1a.setText(getResources().getString(R.string.trofimova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_26));

        p2.setText(getResources().getString(R.string.inlang));
        p1a.setText(getResources().getString(R.string.lebedeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

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

        p2.setText(getResources().getString(R.string.inlang));
        p2a.setText(getResources().getString(R.string.lebedeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

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


        p3.setText(getResources().getString(R.string.inlang));
        p3a.setText(getResources().getString(R.string.lebedeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделения

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

        p3.setText(getResources().getString(R.string.inlang));
        p3a.setText(getResources().getString(R.string.lebedeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделения

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

        p3.setText(getResources().getString(R.string.inlang));
        p3a.setText(getResources().getString(R.string.lebedeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_8));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделе
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

        p3.setText(getResources().getString(R.string.inlang));
        p3a.setText(getResources().getString(R.string.lebedeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_8));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделе

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


        p3.setText(getResources().getString(R.string.inlang));
        p3a.setText(getResources().getString(R.string.lebedeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

    }
}
