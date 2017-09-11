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


public class Tue extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az;
    Spinner spinner;

    public Tue() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tue, container, false);
        spinner = getActivity().findViewById(R.id.spinner);

        m_l_1z = v.findViewById(R.id.t_l_1z);
        m_l_2z = v.findViewById(R.id.t_l_2z);
        m_l_3z = v.findViewById(R.id.t_l_3z);
        m_l_4z = v.findViewById(R.id.t_l_4z);

        m_l1 = v.findViewById(R.id.tu_l1);
        m_l2 = v.findViewById(R.id.tu_l2);
        m_l3 = v.findViewById(R.id.tu_l3);
        m_l4 = v.findViewById(R.id.tu_l4);

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
        m_l2.setVisibility(View.GONE);

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
            case 11:
                BX_21();
                break;
            case 12:
                EG_21();
                break;
            case 13:

                MF_31();
                break;
            case 14:

                PM_31();
                break;
            case 15:

                IiVT_31();
                break;
            case 16:

                NE_31();
                break;
            case 17:
                M_41();
                break;
            case 18:
                FM_41();
                break;
            case 19:

                PM_41();
                break;
            case 20:
                IiVT_41();
                break;
            case 21:
                NE_41();
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
        p1.setText(getResources().getString(R.string.algebra_a_teoc));
        p1a.setText(getResources().getString(R.string.belix));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_13));
        p1z.setText(getResources().getString(R.string.algebra_a_teoc));
        p1az.setText(getResources().getString(R.string.belix));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_13));

        p2.setText(getResources().getString(R.string.pcixol));
        p2a.setText(getResources().getString(R.string.budyakova));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_22));
        p2z.setText(getResources().getString(R.string.pcixol));
        p2az.setText(getResources().getString(R.string.budyakova));
        m_p2_tz.setText(getResources().getString(R.string.lk));
        m_p2_kz.setText(getResources().getString(R.string.uk1_22));

        p3.setText(getResources().getString(R.string.inlang));
        p3a.setText(getResources().getString(R.string.lebedeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_27));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделения

        p4.setText(getResources().getString(R.string.bjd));
        p4a.setText(getResources().getString(R.string.sazanov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk1_22));
        p4z.setText(getResources().getString(R.string.bjd));
        p4az.setText(getResources().getString(R.string.sazanov));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk1_22));


    }

    public void Pm_11() {

        p2.setText(getResources().getString(R.string.inlang));
        p2a.setText(getResources().getString(R.string.lebedeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения


        p3.setText(getResources().getString(R.string.mat_zad));
        p3a.setText(getResources().getString(R.string.pomanova));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_22));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделения

        p4.setText(getResources().getString(R.string.bjd));
        p4a.setText(getResources().getString(R.string.sazanov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk1_22));
        p4z.setText(getResources().getString(R.string.bjd));
        p4az.setText(getResources().getString(R.string.sazanov));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk1_22));

    }

    public void IiVT_12() {

        p1.setText(getResources().getString(R.string.m_analiso));
        p1a.setText(getResources().getString(R.string.padaev));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_26));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        p2.setText(getResources().getString(R.string.inlang));
        p2a.setText(getResources().getString(R.string.lebedeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения


        p3.setText(getResources().getString(R.string.his_mat));
        p3a.setText(getResources().getString(R.string.savvina));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_15));
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);  // Линия разделения



    }

    public void ISiT_11() {

        p1z.setText(getResources().getString(R.string.mat_pra));
        p1az.setText(getResources().getString(R.string.pomanova));
        m_p1_tz.setText(getResources().getString(R.string.dv_pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_22));

        p2.setText(getResources().getString(R.string.inlang));
        p2a.setText(getResources().getString(R.string.lebedeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

        p3.setText(getResources().getString(R.string.eco));
        p3a.setText(getResources().getString(R.string.melnikova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_26));
        p3z.setText(getResources().getString(R.string.eco));
        p3az.setText(getResources().getString(R.string.melnikova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_26));

        p4.setText(getResources().getString(R.string.bjd));
        p4a.setText(getResources().getString(R.string.sazanov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk1_22));
        p4z.setText(getResources().getString(R.string.bjd));
        p4az.setText(getResources().getString(R.string.sazanov));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk1_22));

    }

    // Второй курс
    public void MI_21() {

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        p2.setText(getResources().getString(R.string.eco_obr));
        p2a.setText(getResources().getString(R.string.nikitina));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.eco_obr));
        p2az.setText(getResources().getString(R.string.nikitina));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));


        p3z.setText(getResources().getString(R.string.algebra_a_teoc));
        p3az.setText(getResources().getString(R.string.prokuratova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk4_28));

    }

    public void MF_21() {

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения


        p2.setText(getResources().getString(R.string.eco_obr));
        p2a.setText(getResources().getString(R.string.nikitina));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.eco_obr));
        p2az.setText(getResources().getString(R.string.nikitina));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));


        p3z.setText(getResources().getString(R.string.algebra_a_teoc));
        p3az.setText(getResources().getString(R.string.prokuratova));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk4_28));


    }

    public void PM_21() {

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения


        p2.setText(getResources().getString(R.string.dif_xz));
        p2a.setText(getResources().getString(R.string.eleckix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_9));
        p2z.setText(getResources().getString(R.string.dif_xz));
        p2a.setText(getResources().getString(R.string.eleckix));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk1_9));

        p3.setText(getResources().getString(R.string.econ));
        p3a.setText(getResources().getString(R.string.nikitina));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        p3z.setText(getResources().getString(R.string.econ));
        p3az.setText(getResources().getString(R.string.nikitina));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_24));

        p4.setText(getResources().getString(R.string.po_prog));
        p4a.setText(getResources().getString(R.string.kornienko));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk3_16));
        p4z.setText(getResources().getString(R.string.po_prog));
        p4az.setText(getResources().getString(R.string.kornienko));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk3_16));


    }

    public void BI_21() {
        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения

        p2.setText(getResources().getString(R.string.iss_op));
        p2a.setText(getResources().getString(R.string.prokuratova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_27));
        p2z.setText(getResources().getString(R.string.iss_op));
        p2a.setText(getResources().getString(R.string.prokuratova));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_27));

        p3.setText(getResources().getString(R.string.sociolog));
        p3a.setText(getResources().getString(R.string.korotkix));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_8));
        p3z.setText(getResources().getString(R.string.sociolog));
        p3az.setText(getResources().getString(R.string.korotkix));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_8));


    }

    public void IiVT_21() {

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения


        p2.setText(getResources().getString(R.string.mat_chis_met));
        p2a.setText(getResources().getString(R.string.kornienko));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));
        p2z.setText(getResources().getString(R.string.mat_chis_met));
        p2az.setText(getResources().getString(R.string.kornienko));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_2));

        p3.setText(getResources().getString(R.string.econ));
        p3a.setText(getResources().getString(R.string.nikitina));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        p3z.setText(getResources().getString(R.string.econ));
        p3az.setText(getResources().getString(R.string.nikitina));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void ISiT_21() {

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения


        p2.setText(getResources().getString(R.string.mat_chis_met));
        p2a.setText(getResources().getString(R.string.kornienko));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_2));
        p2z.setText(getResources().getString(R.string.mat_chis_met));
        p2az.setText(getResources().getString(R.string.kornienko));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_2));

        p3.setText(getResources().getString(R.string.econ));
        p3a.setText(getResources().getString(R.string.nikitina));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        p3z.setText(getResources().getString(R.string.econ));
        p3az.setText(getResources().getString(R.string.nikitina));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void NE_21() {

        p1.setText(getResources().getString(R.string.inlangN));
        p1a.setText(getResources().getString(R.string.sedova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk1_8));
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);  // Линия разделения


        p2.setText(getResources().getString(R.string.dif_ur));
        p2a.setText(getResources().getString(R.string.turtaeva));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.gk208));
        p2z.setText(getResources().getString(R.string.dif_ur));
        p2a.setText(getResources().getString(R.string.turtaeva));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.gk208));

        p3.setText(getResources().getString(R.string.physics));
        p3a.setText(getResources().getString(R.string.kondakova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_11));
        p3z.setText(getResources().getString(R.string.physics));
        p3az.setText(getResources().getString(R.string.kondakova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_11));

    }

    public void BX_21() {
        p1.setText(getResources().getString(R.string.inlang));
        p1a.setText(getResources().getString(R.string.lebedeva));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk) + " 1-10");
        p1z.setVisibility(View.GONE);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);
        m_l1.setVisibility(View.GONE);
        m_l_1z.setVisibility(View.GONE);

        p2.setText(getResources().getString(R.string.eco_obr));
        p2a.setText(getResources().getString(R.string.nikitina));
        m_p2_t.setText(getResources().getString(R.string.prs));
        m_p2_k.setText(getResources().getString(R.string.uk) + " 4-24");
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);

        p3.setText(getResources().getString(R.string.f_col_che));
        p3a.setText(getResources().getString(R.string.pahomova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk) + " 12-103");
        m_l_3z.setVisibility(View.GONE);
        m_l3.setVisibility(View.GONE);


    }

    public void EG_21() {
        p1.setText(getResources().getString(R.string.inlang));
        p1a.setText(getResources().getString(R.string.lebedeva));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk) + " 1-10");
        p1z.setVisibility(View.GONE);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);
        m_l1.setVisibility(View.GONE);
        m_l_1z.setVisibility(View.GONE);

        p2.setText(getResources().getString(R.string.eco_obr));
        p2a.setText(getResources().getString(R.string.nikitina));
        m_p2_t.setText(getResources().getString(R.string.prs));
        m_p2_k.setText(getResources().getString(R.string.uk) + " 4-24");
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);

    }

    public void MF_31() {

        p1.setText(getResources().getString(R.string.teo_inz_obr));
        p1a.setText(getResources().getString(R.string.samsonova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_27));
        p1z.setText(getResources().getString(R.string.teo_inz_obr));
        p1az.setText(getResources().getString(R.string.samsonova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_27));

        p2.setText(getResources().getString(R.string.vop_dif));
        p2a.setText(getResources().getString(R.string.melnikova));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_26));
        p2z.setText(getResources().getString(R.string.vop_dif));
        p2az.setText(getResources().getString(R.string.melnikova));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_26));

        p3.setText(getResources().getString(R.string.algebra_a_teoc));
        p3a.setText(getResources().getString(R.string.prokuratova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_28));


        p4.setText(getResources().getString(R.string.algebra_a_teoc));
        p4a.setText(getResources().getString(R.string.prokuratova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_28));


    }

    public void PM_31() {

        p1.setText(getResources().getString(R.string.fun_analis));
        p1a.setText(getResources().getString(R.string.kornienko));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_2));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.pro_tipograf));
        p2a.setText(getResources().getString(R.string.kornienko));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk3_16));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.sociolog));
        p3a.setText(getResources().getString(R.string.korotkix));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_8));
        p3z.setText(getResources().getString(R.string.sociolog));
        p3az.setText(getResources().getString(R.string.korotkix));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_8));


    }

    public void IiVT_31() {

        p1.setText(getResources().getString(R.string.data_bases));
        p1a.setText(getResources().getString(R.string.pachin));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk2_113));
        p1z.setText(getResources().getString(R.string.data_bases));
        p1az.setText(getResources().getString(R.string.pachin));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk2_113));


        p2z.setText(getResources().getString(R.string.data_bases));
        p2az.setText(getResources().getString(R.string.pachin));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk2_113));


    }

    public void NE_31() {

        p1z.setText(getResources().getString(R.string.phy_osn_el));
        p1az.setText(getResources().getString(R.string.kuznecov));
        m_p1_tz.setText(getResources().getString(R.string.lb));
        m_p1_kz.setText(getResources().getString(R.string.uk1_8));

        p2.setText(getResources().getString(R.string.phy_osn_el));
        p2a.setText(getResources().getString(R.string.kuznecov));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk1_8));
        p2z.setText(getResources().getString(R.string.phy_osn_el));
        p2az.setText(getResources().getString(R.string.kuznecov));
        m_p2_tz.setText(getResources().getString(R.string.lb));
        m_p2_kz.setText(getResources().getString(R.string.uk1_8));

        p3.setText(getResources().getString(R.string.shemotexnika));
        p3a.setText(getResources().getString(R.string.arnuatov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk14_203));
        p3z.setText(getResources().getString(R.string.shemotexnika));
        p3az.setText(getResources().getString(R.string.arnuatov));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk14_203));

        p4z.setText(getResources().getString(R.string.shemotexnika));
        p4az.setText(getResources().getString(R.string.arnuatov));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk14_203));

    }

    // 4 курс
    public void M_41() {

        p1.setText(getResources().getString(R.string.met_mat));
        p1a.setText(getResources().getString(R.string.pomanova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_22));

        p2.setText(getResources().getString(R.string.met_mat));
        p2a.setText(getResources().getString(R.string.pomanova));
        m_p2_t.setText(getResources().getString(R.string.lb));
        m_p2_k.setText(getResources().getString(R.string.uk4_22));
        p2z.setText(getResources().getString(R.string.met_mat));
        p2az.setText(getResources().getString(R.string.pomanova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_22));


    }

    public void FM_41() {

        p1.setText(getResources().getString(R.string.osn_teo_phy));
        p1a.setText(getResources().getString(R.string.kondakova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk1_11));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.astrophysic));
        p2a.setText(getResources().getString(R.string.kondakova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk1_11));
        p2z.setText(getResources().getString(R.string.astrophysic));
        p2az.setText(getResources().getString(R.string.kondakova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_11));


    }

    public void PM_41() {

        p3.setText(getResources().getString(R.string.sys_po));
        p3a.setText(getResources().getString(R.string.tarov));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_2));
        p3z.setText(getResources().getString(R.string.sys_po));
        p3az.setText(getResources().getString(R.string.tarov));
        m_p3_tz.setText(getResources().getString(R.string.lk));
        m_p3_kz.setText(getResources().getString(R.string.uk1_2));

        p4.setText(getResources().getString(R.string.sys_po));
        p4a.setText(getResources().getString(R.string.tarov));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk1_2));
        p4z.setText(getResources().getString(R.string.ad_seit));
        p4az.setText(getResources().getString(R.string.tarov));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk1_2));

    }

    public void IiVT_41() {

        p2.setText(getResources().getString(R.string.mat_mod_eco));
        p2a.setText(getResources().getString(R.string.gladkih));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_21));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.seti_tv));
        p3a.setText(getResources().getString(R.string.pachin));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk2_113));
        p3z.setText(getResources().getString(R.string.seti_tv));
        p3az.setText(getResources().getString(R.string.pachin));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk2_113));

        p4.setText(getResources().getString(R.string.ad_os));
        p4a.setText(getResources().getString(R.string.pachin));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk2_113));


    }

    public void NE_41() {

        p2z.setText(getResources().getString(R.string.astrophysic));
        p2az.setText(getResources().getString(R.string.kondakova));
        m_p2_tz.setText(getResources().getString(R.string.dv_pz));
        m_p2_kz.setText(getResources().getString(R.string.uk1_11));

        p3.setText(getResources().getString(R.string.galv_polpro));
        p3a.setText(getResources().getString(R.string.kuznecov));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk1_6));
        Null_Mon_Z_3();

        p4z.setText(getResources().getString(R.string.kvant_el));
        p4az.setText(getResources().getString(R.string.kuznecov));
        m_p4_tz.setText(getResources().getString(R.string.lk));
        m_p4_kz.setText(getResources().getString(R.string.uk1_9));


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
}
