package ru.vyaacheslav.suhov.imeit.days;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Wed extends Fragment {

    public ScrollView main_mon;
    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z, youday;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z;

    public Wed() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.wed, container, false);

        main_mon = v.findViewById(R.id.main_wed);
        youday = v.findViewById(R.id.you_daywe);

        m_l_1z = v.findViewById(R.id.w_l_1z);
        m_l_2z = v.findViewById(R.id.w_l_2z);
        m_l_3z = v.findViewById(R.id.w_l_3z);
        m_l_4z = v.findViewById(R.id.w_l_4z);

        p1 = v.findViewById(R.id.w_p1);
        p1a = v.findViewById(R.id.w_p1_a);
        m_p1_t = v.findViewById(R.id.w_p1_t);
        m_p1_k = v.findViewById(R.id.w_p1_k);
        p1z = v.findViewById(R.id.w_p1z);
        p1az = v.findViewById(R.id.w_p1_az);
        m_p1_tz = v.findViewById(R.id.w_p1_tz);
        m_p1_kz = v.findViewById(R.id.w_p1_kz);

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

    public void Less2D(String l, String p, String t, String r, boolean duble, boolean i) {

        if (duble) {
            p2z.setText(l);
            p2az.setText(p);
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
            m_p3_kz.setText(r);
        }

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

        if ((lz == null) && (pz == null) && (tz == null) && (rz == null)) {
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

        if ((lz == null) && (pz == null) && (tz == null) && (rz == null)) {
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

    public void loadMethod() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_key_group), "");

        String[] asu = getResources().getStringArray(R.array.groups_value);
        String[] names = getResources().getStringArray(R.array.all_group);

        int index = -1;

        for (int i = 0; (i < asu.length) && (index == -1); i++) {

            if (asu[i].equals(position)) {
                index = i;
            }
        }

    }
}