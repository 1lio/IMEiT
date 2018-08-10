package ru.vyaacheslav.suhov.imeit.days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Mon extends Fragment{

    public View v;
    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z, m_l_4c, m_l_3c, m_l_2c, m_l_1c, m_l_5c;
    public LinearLayout mm1, mm2, mm3, mm4, mm5, main_mon, youday;
    private TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, p5a, m_p5_t, m_p5_k;

    public Mon() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mon, container, false);
        InitViews();
        loadMethod();
        return v;
    }

    public void Less1D(String l, String p, String t, String r, boolean duble, boolean i) {

        if (duble) {
            p1z.setText(l);
            p1az.setText(p);
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

     /*   final String para = "1 пара";
        mm1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getActivity(), Docks.class);

                intent.putExtra("day", day);
                intent.putExtra("para", para);

                intent.putExtra("name", p1.getText().toString());
                intent.putExtra("subname", p1a.getText().toString());
                intent.putExtra("type", m_p1_t.getText().toString());
                intent.putExtra("corp", m_p1_k.getText().toString());

                intent.putExtra("zname", p1z.getText().toString());
                intent.putExtra("zsubname", p1az.getText().toString());
                intent.putExtra("ztype", m_p1_tz.getText().toString());
                intent.putExtra("zcorp", m_p1_kz.getText().toString());

                startActivity(intent);
                return false;
            }
        });*/
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

     /*   final String para = "2 пара";
        mm2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getActivity(), Docks.class);

                intent.putExtra("day", day);
                intent.putExtra("para", para);

                intent.putExtra("name", p2.getText().toString());
                intent.putExtra("subname", p2a.getText().toString());
                intent.putExtra("type", m_p2_t.getText().toString());
                intent.putExtra("corp", m_p2_k.getText().toString());

                intent.putExtra("zname", p2z.getText().toString());
                intent.putExtra("zsubname", p2az.getText().toString());
                intent.putExtra("ztype", m_p2_tz.getText().toString());
                intent.putExtra("zcorp", m_p2_kz.getText().toString());

                startActivity(intent);
                return false;
            }
        });

*/

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

      /*  final String para = "3 пара";
        mm3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getActivity(), Docks.class);

                intent.putExtra("day", day);
                intent.putExtra("para", para);

                intent.putExtra("name", p3.getText().toString());
                intent.putExtra("subname", p3a.getText().toString());
                intent.putExtra("type", m_p3_t.getText().toString());
                intent.putExtra("corp", m_p3_k.getText().toString());

                intent.putExtra("zname", p3z.getText().toString());
                intent.putExtra("zsubname", p3az.getText().toString());
                intent.putExtra("ztype", m_p3_tz.getText().toString());
                intent.putExtra("zcorp", m_p3_kz.getText().toString());

                startActivity(intent);
                return false;
            }
        });*/
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

      /*  final String para = "4 пара";
        mm4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getActivity(), Docks.class);

                intent.putExtra("day", day);
                intent.putExtra("para", para);

                intent.putExtra("name", p4.getText().toString());
                intent.putExtra("subname", p4a.getText().toString());
                intent.putExtra("type", m_p4_t.getText().toString());
                intent.putExtra("corp", m_p4_k.getText().toString());

                intent.putExtra("zname", p4z.getText().toString());
                intent.putExtra("zsubname", p4az.getText().toString());
                intent.putExtra("ztype", m_p4_tz.getText().toString());
                intent.putExtra("zcorp", m_p4_kz.getText().toString());

                startActivity(intent);
                return false;
            }
        });*/
    }
    public void Less5(String l, String p, String t, String r) {

       // 5 пара только у 1 группы поэтому проверки нет
        // исправить в последующих версиях

        p5.setText(l);
        p5a.setText(p);
        m_p5_t.setText(t);
        m_p5_k.setText(r);

      /*  final String para = "5 пара";
        mm5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Intent intent = new Intent(getActivity(), Docks.class);

                intent.putExtra("day", day);
                intent.putExtra("para", para);

                intent.putExtra("name", p5.getText().toString());
                intent.putExtra("subname", p5a.getText().toString());
                intent.putExtra("type", m_p5_t.getText().toString());
                intent.putExtra("corp", m_p5_k.getText().toString());

                intent.putExtra("zname", p5.getText().toString());
                intent.putExtra("zsubname", p5a.getText().toString());
             *//*   intent.putExtra("ztype", m_p5_tz.getText().toString());
                intent.putExtra("zcorp", m_p5_kz.getText().toString());*//*

                startActivity(intent);
                return false;
            }
        });*/
    }
    // нужно оптимизировать эту херню.
    public void loadMethod() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_groupe), "");

        String[] asu = getResources().getStringArray(R.array.groups_value);
        String[] names = getResources().getStringArray(R.array.all_group);

        int index = -1;

        for (int i = 0; (i < asu.length) && (index == -1); i++) {

            if (asu[i].equals(position)) {
                index = i;
            }
        }

    }
    public void InitViews() {

        main_mon = v.findViewById(R.id.main_mon);
        youday = v.findViewById(R.id.you_day);
        m_l_1z = v.findViewById(R.id.m_l_1z);
        m_l_2z = v.findViewById(R.id.m_l_2z);
        m_l_3z = v.findViewById(R.id.m_l_3z);
        m_l_4z = v.findViewById(R.id.m_l_4z);

        m_l_1c = v.findViewById(R.id.m_l_1с);
        m_l_2c = v.findViewById(R.id.m_l_2с);
        m_l_3c = v.findViewById(R.id.m_l_3с);
        m_l_4c = v.findViewById(R.id.m_l_4с);
        m_l_5c = v.findViewById(R.id.m_l_5c);

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

        p5 = v.findViewById(R.id.m_p5);
        p5a = v.findViewById(R.id.m_p5a);
        m_p5_t = v.findViewById(R.id.m_p5_t);
        m_p5_k = v.findViewById(R.id.m_p5_k);

        mm1 = v.findViewById(R.id.mm1);
        mm2 = v.findViewById(R.id.mm2);
        mm3 = v.findViewById(R.id.mm3);
        mm4 = v.findViewById(R.id.mm4);
        mm5 = v.findViewById(R.id.mm5);
    }
    // Дальше идет огроменный кусок говнеца который нужно оптимизировать и научить работать с БД
    // TODO: Научить работать с БД.
    // Первый курс

}