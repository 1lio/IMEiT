package ru.vyaacheslav.suhov.imeit.Days;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;
import ru.vyaacheslav.suhov.imeit.Settings;

public class Mon extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4, lkV;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az;
    Spinner spinner;
    Button send;

    public Mon() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mon, container, false);
        spinner = getActivity().findViewById(R.id.spinner);
        send = v.findViewById(R.id.send);

        lkV = v.findViewById(R.id.lkV);

        m_l_1z = v.findViewById(R.id.m_l_1z);
        m_l_2z = v.findViewById(R.id.m_l_2z);
        m_l_3z = v.findViewById(R.id.m_l_3z);
        m_l_4z = v.findViewById(R.id.m_l_4z);

        m_l1 = v.findViewById(R.id.m_l1);
        m_l2 = v.findViewById(R.id.m_l2);
        m_l3 = v.findViewById(R.id.m_l3);
        m_l4 = v.findViewById(R.id.m_l4);

        p1 = v.findViewById(R.id.m_p1);
        p1a = v.findViewById(R.id.m_p1_a);
        m_p1_t = v.findViewById(R.id.m_p1_t);
        m_p1_k = v.findViewById(R.id.m_p1_k);
        p1z = v.findViewById(R.id.m_p1z);
        p1az = v.findViewById(R.id.m_p1_az);
        m_p1_tz = v.findViewById(R.id.m_p1_tz);
        m_p1_kz = v.findViewById(R.id.m_p1_kz);

        p2 = v.findViewById(R.id.m_p2);
        p2a = v.findViewById(R.id.m_p2_a);
        m_p2_t = v.findViewById(R.id.m_p2_t);
        m_p2_k = v.findViewById(R.id.m_p2_k);
        p2z = v.findViewById(R.id.m_p2z);
        p2az = v.findViewById(R.id.m_p2_az);
        m_p2_tz = v.findViewById(R.id.m_p2_tz);
        m_p2_kz = v.findViewById(R.id.m_p2_kz);

        p3 = v.findViewById(R.id.m_p3);
        p3a = v.findViewById(R.id.m_p3_a);
        m_p3_t = v.findViewById(R.id.m_p3_t);
        m_p3_k = v.findViewById(R.id.m_p3_k);
        p3z = v.findViewById(R.id.m_p3z);
        p3az = v.findViewById(R.id.m_p3_az);
        m_p3_tz = v.findViewById(R.id.m_p3_tz);
        m_p3_kz = v.findViewById(R.id.m_p3_kz);

        p4 = v.findViewById(R.id.m_p4);
        p4a = v.findViewById(R.id.m_p4_a);
        m_p4_t = v.findViewById(R.id.m_p4_t);
        m_p4_k = v.findViewById(R.id.m_p4_k);
        p4z = v.findViewById(R.id.m_p4z);
        p4az = v.findViewById(R.id.m_p4_az);
        m_p4_tz = v.findViewById(R.id.m_p4_tz);
        m_p4_kz = v.findViewById(R.id.m_p4_kz);


        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sett = new Intent(getContext(), Settings.class);
                lkV.setVisibility(View.GONE);
                startActivity(sett);
            }
        });
        loadMethod();
        return v;
    }

    // Готовимся к выходу релиза // Полный список настройки.

    public void loadMethod(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int position= sharedPreferences .getInt("spnCalorieRange",-1);
        layoutVisable();
        switch (position){
            case 0:
                lkV.setVisibility(View.GONE);
                FMiI_11();
                break;
            case 1:
                lkV.setVisibility(View.GONE);
                Pm_11();
                break;

            case 2:
                lkV.setVisibility(View.GONE);
                IiVT_12();
                break;

            case 3:
                lkV.setVisibility(View.GONE);
                ISiT_11();
                break;

            case 4:
                lkV.setVisibility(View.GONE);
                MI_21();
                break;
            case 5:
                lkV.setVisibility(View.GONE);
                MF_21();
                break;
            case 6:
                lkV.setVisibility(View.GONE);
                PM_21();
                break;
            case 7:
                lkV.setVisibility(View.GONE);
                BI_21();
                break;
            case 8:
                lkV.setVisibility(View.GONE);
                IiVT_21();
                break;
            case 9:
                lkV.setVisibility(View.GONE);
                ISiT_21();
                break;
            case 10:
                lkV.setVisibility(View.GONE);
                NE_21();
                break;
            case 11:
                lkV.setVisibility(View.GONE);
                BX_21();
                break;
            case 12:
                lkV.setVisibility(View.GONE);
                EG_21();
                break;
            case 13:
                lkV.setVisibility(View.GONE);
                MF_31();
                break;
            case 14:
                lkV.setVisibility(View.GONE);
                PM_31();
                break;
            case 15:
                lkV.setVisibility(View.GONE);
                IiVT_31();
                break;
            case 16:
                lkV.setVisibility(View.GONE);
                NE_31();
                break;
            case 17:
                lkV.setVisibility(View.GONE);
                M_41();
                break;
            case 18:
                lkV.setVisibility(View.GONE);

                break;
            case 19:
                lkV.setVisibility(View.GONE);
                PM_41();
                break;
            case 20:
                lkV.setVisibility(View.GONE);

                break;
            case 21:
                lkV.setVisibility(View.GONE);

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

        p2.setText(getResources().getString(R.string.pedagogic));
        p2a.setText(getResources().getString(R.string.zaharova));
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_27));
        m_l_2z.setVisibility(View.GONE); // знаменатель
        m_l2.setVisibility(View.GONE);  // Линия разделения

        Fizra_pervaki();

    }

    public void Pm_11() {

        p2.setText(getResources().getString(R.string.algebra_a_geo));
        p2a.setText(getResources().getString(R.string.belix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.algebra_a_geo));
        p2az.setText(getResources().getString(R.string.belix));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_pervaki();

    }

    public void IiVT_12() {

        p1.setText(getResources().getString(R.string.paket_asu));
        p1a.setText(getResources().getString(R.string.igonina));
        m_p1_t.setText(getResources().getString(R.string.dv_pz));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.algebra_a_geo));
        p2a.setText(getResources().getString(R.string.belix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.algebra_a_geo));
        p2az.setText(getResources().getString(R.string.belix));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_pervaki();

        p4.setText(getResources().getString(R.string.disckret));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_24));
        p4z.setText(getResources().getString(R.string.disckret));
        p4az.setText(getResources().getString(R.string.belix));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_24));

    }

    public void ISiT_11() {

        p1.setText(getResources().getString(R.string.inf_tex));
        p1a.setText(getResources().getString(R.string.igonina));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        p1z.setText(getResources().getString(R.string.inf_tex));
        p1az.setText(getResources().getString(R.string.igonina));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_21));

        p2.setText(getResources().getString(R.string.algebra_a_geo));
        p2a.setText(getResources().getString(R.string.belix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_24));
        p2z.setText(getResources().getString(R.string.algebra_a_geo));
        p2az.setText(getResources().getString(R.string.belix));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_pervaki();

        p4.setText(getResources().getString(R.string.mat_pra));
        p4a.setText(getResources().getString(R.string.pomanova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_15));
        Null_Mon_Z_4();

    }

    // Второй курс
    public void MI_21() {

        p1.setText(getResources().getString(R.string.pedagogic_vosp));
        p1a.setText(getResources().getString(R.string.zaharova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        p1z.setText(getResources().getString(R.string.pedagogic_vosp));
        p1az.setText(getResources().getString(R.string.zaharova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.matlogic));
        p3a.setText(getResources().getString(R.string.belix));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        p3z.setText(getResources().getString(R.string.matlogic));
        p3az.setText(getResources().getString(R.string.belix));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void MF_21() {

        p1.setText(getResources().getString(R.string.pedagogic_vosp));
        p1a.setText(getResources().getString(R.string.zaharova));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_24));
        p1z.setText(getResources().getString(R.string.pedagogic_vosp));
        p1az.setText(getResources().getString(R.string.zaharova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_24));

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.matlogic));
        p3a.setText(getResources().getString(R.string.belix));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_24));
        p3z.setText(getResources().getString(R.string.matlogic));
        p3az.setText(getResources().getString(R.string.belix));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_24));

        p4.setText(getResources().getString(R.string.el_physic));
        p4a.setText(getResources().getString(R.string.trofimova));
        m_p4_t.setText(getResources().getString(R.string.pz));
        m_p4_k.setText(getResources().getString(R.string.uk4_27));
        Null_Mon_Z_4();


    }

    public void PM_21() {

        p1.setText(getResources().getString(R.string.met_prog));
        p1a.setText(getResources().getString(R.string.kornienko));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk3_16));
        p1z.setText(getResources().getString(R.string.met_prog));
        p1az.setText(getResources().getString(R.string.kornienko));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk3_16));

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.algebra_a_geo));
        p3a.setText(getResources().getString(R.string.padaeva));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_10));
        p3z.setText(getResources().getString(R.string.algebra_a_geo));
        p3az.setText(getResources().getString(R.string.padaeva));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_10));

        p4z.setText(getResources().getString(R.string.po_prog));
        p4az.setText(getResources().getString(R.string.kornienko));
        m_p4_tz.setText(getResources().getString(R.string.lb));
        m_p4_kz.setText(getResources().getString(R.string.uk3_16));


    }

    public void BI_21() {

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.progr));
        p3a.setText(getResources().getString(R.string.kornienko));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk3_16));
        p3z.setText(getResources().getString(R.string.progr));
        p3az.setText(getResources().getString(R.string.kornienko));
        m_p3_tz.setText(getResources().getString(R.string.lb));
        m_p3_kz.setText(getResources().getString(R.string.uk3_16));

        p4.setText(getResources().getString(R.string.disckret));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_24));
        p4z.setText(getResources().getString(R.string.disckret));
        p4az.setText(getResources().getString(R.string.belix));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void IiVT_21() {

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.m_analis));
        p3a.setText(getResources().getString(R.string.melnikova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_26));
        p3z.setText(getResources().getString(R.string.m_analis));
        p3az.setText(getResources().getString(R.string.melnikova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_26));

        p4.setText(getResources().getString(R.string.disckret));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_24));
        p4z.setText(getResources().getString(R.string.disckret));
        p4az.setText(getResources().getString(R.string.belix));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void ISiT_21() {

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.metrologia));
        p3a.setText(getResources().getString(R.string.fortunova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_15));
        p3z.setText(getResources().getString(R.string.metrologia));
        p3az.setText(getResources().getString(R.string.fortunova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_15));

        p4.setText(getResources().getString(R.string.disckret));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_24));
        p4z.setText(getResources().getString(R.string.disckret));
        p4az.setText(getResources().getString(R.string.belix));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void NE_21() {

        Fizra_2kurs();

        p3.setText(getResources().getString(R.string.m_analis));
        p3a.setText(getResources().getString(R.string.melnikova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_26));
        p3z.setText(getResources().getString(R.string.m_analis));
        p3az.setText(getResources().getString(R.string.melnikova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_26));

        p4.setText(getResources().getString(R.string.disckret));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_24));
        p4z.setText(getResources().getString(R.string.disckret));
        p4az.setText(getResources().getString(R.string.belix));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_24));


    }

    public void BX_21() {
        lkV.setVisibility(View.GONE);
        p1.setText(getResources().getString(R.string.teo_met_vosp));
        p1a.setText(getResources().getString(R.string.zaharova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);

        p2.setText(getResources().getString(R.string.fk));
        p2a.setVisibility(View.GONE);
        m_p2_t.setVisibility(View.GONE);
        m_p2_k.setText(getResources().getString(R.string.fok));
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);

        p3.setText(getResources().getString(R.string.zoologia));
        p3a.setText(getResources().getString(R.string.sotnikova));
        m_p3_t.setText(getResources().getString(R.string.lb));
        m_p3_k.setText(getResources().getString(R.string.uk) + " 12-213");
        m_l_3z.setVisibility(View.GONE); // знаменатель
        m_l3.setVisibility(View.GONE);

    }

    public void EG_21() {
        lkV.setVisibility(View.GONE);
        p1.setText(getResources().getString(R.string.teo_met_vosp));
        p1a.setText(getResources().getString(R.string.zaharova));
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.uk) + " 4-24");
        m_l_1z.setVisibility(View.GONE); // знаменатель
        m_l1.setVisibility(View.GONE);

        p2.setText(getResources().getString(R.string.fk));
        p2a.setVisibility(View.GONE);
        m_p2_t.setVisibility(View.GONE);
        m_p2_k.setText(getResources().getString(R.string.fok));
        m_l_2z.setVisibility(View.GONE);
        m_l2.setVisibility(View.GONE);

        p3.setText(getResources().getString(R.string.algebra_a_geo));
        p3a.setText(getResources().getString(R.string.padaeva));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk) + " 1-10");
        m_l_3z.setVisibility(View.INVISIBLE);
        m_l3.setVisibility(View.GONE);

        p4.setText(getResources().getString(R.string.kartograf));
        p4a.setText(getResources().getString(R.string.melnikova));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk) + " 4-26");
        m_l_4z.setVisibility(View.GONE);
        m_l4.setVisibility(View.GONE);

    }

    // 3 курс

    public void MF_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.m_analis));
        p2a.setText(getResources().getString(R.string.melnikova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_26));
        p2z.setText(getResources().getString(R.string.m_analis));
        p2az.setText(getResources().getString(R.string.melnikova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk4_26));

        p3.setText(getResources().getString(R.string.ob_ex_phys));
        p3a.setText(getResources().getString(R.string.trofimova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_27));
        p3z.setText(getResources().getString(R.string.ob_ex_phys));
        p3az.setText(getResources().getString(R.string.trofimova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_27));

        p4.setText(getResources().getString(R.string.osn_geo));
        p4a.setText(getResources().getString(R.string.padaeva));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.uk1_10));
        Null_Mon_Z_4();

    }

    public void PM_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.oop_an_pr));
        p2a.setText(getResources().getString(R.string.kornienko));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk3_16));
        p2z.setText(getResources().getString(R.string.oop_an_pr));
        p2az.setText(getResources().getString(R.string.kornienko));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk3_16));

        p3.setText(getResources().getString(R.string.dif_ur));
        p3a.setText(getResources().getString(R.string.eleckix));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk1_9));
        p3z.setText(getResources().getString(R.string.dif_ur));
        p3az.setText(getResources().getString(R.string.eleckix));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk1_9));

        p4.setText(getResources().getString(R.string.disckret));
        p4a.setText(getResources().getString(R.string.belix));
        m_p4_t.setText(getResources().getString(R.string.lk));
        m_p4_k.setText(getResources().getString(R.string.uk4_24));
        p4z.setText(getResources().getString(R.string.disckret));
        p4az.setText(getResources().getString(R.string.belix));
        m_p4_tz.setText(getResources().getString(R.string.pz));
        m_p4_kz.setText(getResources().getString(R.string.uk4_24));

    }

    public void IiVT_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.inj_gra));
        p2a.setText(getResources().getString(R.string.rodionova));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk12_2_101));
        p2z.setText(getResources().getString(R.string.inj_gra));
        p2az.setText(getResources().getString(R.string.rodionova));
        m_p2_tz.setText(getResources().getString(R.string.pz));
        m_p2_kz.setText(getResources().getString(R.string.uk12_2_101));

        p3.setText(getResources().getString(R.string.metrologia));
        p3a.setText(getResources().getString(R.string.fortunova));
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.uk4_15));
        p3z.setText(getResources().getString(R.string.metrologia));
        p3az.setText(getResources().getString(R.string.fortunova));
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.uk4_15));

    }

    public void NE_31() {

        Fizra_3kurs();

        p2.setText(getResources().getString(R.string.up_mat_phy));
        p2a.setText(getResources().getString(R.string.cherbatix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_28));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.metrologia));
        p3a.setText(getResources().getString(R.string.fortunova));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_28));
        Null_Mon_Z_3();

    }

    // 4 курс
    public void M_41() {

        p1z.setText(getResources().getString(R.string.schol_uche));
        p1az.setText(getResources().getString(R.string.pomanova));
        m_p1_tz.setText(getResources().getString(R.string.dv_pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_13));

        p2.setText(getResources().getString(R.string.schol_uche_ug));
        p2a.setText(getResources().getString(R.string.pomanova));
        m_p2_t.setText(getResources().getString(R.string.dv_pz));
        m_p2_k.setText(getResources().getString(R.string.uk4_13));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.schol_uche_ug));
        p3a.setText(getResources().getString(R.string.pomanova));
        m_p3_t.setText(getResources().getString(R.string.dv_pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_13));
        Null_Mon_Z_3();

        p4.setText(getResources().getString(R.string.el_mat));
        p4a.setText(getResources().getString(R.string.elchinova));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.uk4_13));
        Null_Mon_Z_4();

    }

    //FM
    public void PM_41() {

        p1z.setText(getResources().getString(R.string.el_nec_mn));
        p1az.setText(getResources().getString(R.string.belix));
        m_p1_tz.setText(getResources().getString(R.string.dv_pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_26));
        Null_Mon_Z();

        p2.setText(getResources().getString(R.string.ur_mat_phy));
        p2a.setText(getResources().getString(R.string.cherbatix));
        m_p2_t.setText(getResources().getString(R.string.lk));
        m_p2_k.setText(getResources().getString(R.string.uk4_28));
        Null_Mon_Z_2();

        p3.setText(getResources().getString(R.string.up_mat_phy));
        p3a.setText(getResources().getString(R.string.cherbatix));
        m_p3_t.setText(getResources().getString(R.string.pz));
        m_p3_k.setText(getResources().getString(R.string.uk4_28));


        p4.setText(getResources().getString(R.string.prog_1c));
        p4a.setText(getResources().getString(R.string.kornienko));
        m_p4_t.setText(getResources().getString(R.string.dv_pz));
        m_p4_k.setText(getResources().getString(R.string.uk3_16));

    }
    //IiVT
    //NE


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

    //
    public void Fizra_pervaki() {

        p3.setText(getResources().getString(R.string.fk));  //Блок физ-ра для первочей
        p3a.setVisibility(View.GONE);
        m_p3_t.setText(getResources().getString(R.string.lk));
        m_p3_k.setText(getResources().getString(R.string.gk212));
        p3z.setText(getResources().getString(R.string.fk));
        p3az.setVisibility(View.GONE);
        m_p3_tz.setText(getResources().getString(R.string.pz));
        m_p3_kz.setText(getResources().getString(R.string.fok));
    }

    public void Fizra_2kurs() {

        p2.setText(getResources().getString(R.string.fkl));
        p2a.setVisibility(View.GONE);
        m_p2_t.setText(getResources().getString(R.string.pz));
        m_p2_k.setText(getResources().getString(R.string.fok));
        m_l2.setVisibility(View.GONE);
        m_l_2z.setVisibility(View.GONE);

    }

    public void Fizra_3kurs() {

        p1.setText(getResources().getString(R.string.fkl));
        p1a.setVisibility(View.GONE);
        m_p1_t.setText(getResources().getString(R.string.pz));
        m_p1_k.setText(getResources().getString(R.string.fok));
        m_l1.setVisibility(View.GONE);
        m_l_1z.setVisibility(View.GONE);
    }
}