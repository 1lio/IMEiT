package ru.vyaacheslav.suhov.imeit;

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


public class Mon extends Fragment {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z;
    public LinearLayout m_l1, m_l2, m_l3, m_l4;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az;
    Spinner spinner;

    public Mon() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mon, container, false);
        spinner = getActivity().findViewById(R.id.spinner);
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
        m_l2.setVisibility(View.GONE);

        p3 = (TextView)v.findViewById(R.id.m_p3);
        p3a = (TextView)v.findViewById(R.id.m_p3_a);
        m_p3_t = (TextView)v.findViewById(R.id.m_p3_t);
        m_p3_k = (TextView)v.findViewById(R.id.m_p3_k);
        p3z = (TextView)v.findViewById(R.id.m_p3z);
        p3az = (TextView)v.findViewById(R.id.m_p3_az);
        m_p3_tz = (TextView)v.findViewById(R.id.m_p3_tz);
        m_p3_kz = (TextView)v.findViewById(R.id.m_p3_kz);

        p4 = (TextView)v.findViewById(R.id.m_p4);
        p4a = (TextView)v.findViewById(R.id.m_p4_a);
        m_p4_t = (TextView)v.findViewById(R.id.m_p4_t);
        m_p4_k = (TextView)v.findViewById(R.id.m_p4_k);
        p4z = (TextView)v.findViewById(R.id.m_p4z);
        p4az = (TextView)v.findViewById(R.id.m_p4_az);
        m_p4_tz = (TextView)v.findViewById(R.id.m_p4_tz);
        m_p4_kz = (TextView)v.findViewById(R.id.m_p4_kz);

        loadMethod();
        return v;
    }


    public void loadMethod(){
      SharedPreferences  sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int position= sharedPreferences .getInt("spnCalorieRange",-1);
            layoutVisable();
        // # позиции - группа
        switch (position){
            case 0:

                p1.setText(getResources().getString(R.string.pcixol));
                p1a.setText(getResources().getString(R.string.okuneva));
                m_p1_t.setText(getResources().getString(R.string.pz));
                m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                p1z.setText(getResources().getString(R.string.pedagogic));
                p1az.setText(getResources().getString(R.string.zaharova));
                m_p1_tz.setText(getResources().getString(R.string.lk));
                m_p1_kz.setText(getResources().getString(R.string.uk)+ " 4-24");

                p2.setText(getResources().getString(R.string.pedagogic));
                p2a.setText(getResources().getString(R.string.zaharova));
                m_p2_t.setText(getResources().getString(R.string.pz));
                m_p2_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                m_l_2z.setVisibility(View.GONE);
                m_l2.setVisibility(View.GONE);

                p3.setText(getResources().getString(R.string.fk));
                p3a.setVisibility(View.GONE);
                m_p3_t.setVisibility(View.GONE);
                m_p3_k.setText(getResources().getString(R.string.fok));
                m_l_3z.setVisibility(View.GONE);
                m_l3.setVisibility(View.GONE);

                p4.setText(getResources().getString(R.string.bjd));
                p4a.setText(getResources().getString(R.string.ivanov));
                m_p4_t.setText(getResources().getString(R.string.lk));
                m_p4_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                p4z.setVisibility(View.GONE);
                p4az.setVisibility(View.GONE);
                m_p4_tz.setVisibility(View.GONE);
                m_p4_kz.setVisibility(View.GONE);
                // Вторник

                break;
            case 1:
                p1.setText(getResources().getString(R.string.pcixol));
                p1a.setText(getResources().getString(R.string.okuneva));
                m_p1_t.setText(getResources().getString(R.string.pz));
                m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                p1z.setText(getResources().getString(R.string.pedagogic));
                p1az.setText(getResources().getString(R.string.zaharova));
                m_p1_tz.setText(getResources().getString(R.string.lk));
                m_p1_kz.setText(getResources().getString(R.string.uk)+ " 4-24");

                p2.setText(getResources().getString(R.string.pedagogic));
                p2a.setText(getResources().getString(R.string.zaharova));
                m_p2_t.setText(getResources().getString(R.string.pz));
                m_p2_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                m_l_2z.setVisibility(View.GONE);
                m_l2.setVisibility(View.GONE);

                p3.setText(getResources().getString(R.string.fk));
                p3a.setVisibility(View.GONE);
                m_p3_t.setVisibility(View.GONE);
                m_p3_k.setText(getResources().getString(R.string.fok));
                m_l_3z.setVisibility(View.GONE);
                m_l3.setVisibility(View.GONE);

                p4.setText(getResources().getString(R.string.bjd));
                p4a.setText(getResources().getString(R.string.ivanov));
                m_p4_t.setText(getResources().getString(R.string.lk));
                m_p4_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                p4z.setVisibility(View.GONE);
                p4az.setVisibility(View.GONE);
                m_p4_tz.setVisibility(View.GONE);
                m_p4_kz.setVisibility(View.GONE);
                break;

        }
    }
    public void layoutVisable(){

        m_l1.setVisibility(View.VISIBLE);
        m_l2.setVisibility(View.VISIBLE);
        m_l3.setVisibility(View.VISIBLE);
        m_l4.setVisibility(View.VISIBLE);

        m_l_1z.setVisibility(View.VISIBLE);
        m_l_2z.setVisibility(View.VISIBLE);
        m_l_3z.setVisibility(View.VISIBLE);
        m_l_4z.setVisibility(View.VISIBLE);

    }
}


