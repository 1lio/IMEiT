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

public class MonTEST extends Fragment {

    private TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az;

    public MonTEST() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.just, container, false);

        p1 = v.findViewById(R.id.m_p1);
        p1a = v.findViewById(R.id.m_p1_a);
        m_p1_t = v.findViewById(R.id.m_p1_t);
        m_p1_k = v.findViewById(R.id.m_p1_k);
        p1z = v.findViewById(R.id.m_p1z);
        p1az = v.findViewById(R.id.m_p1_az);
        m_p1_tz = v.findViewById(R.id.m_p1_tz);
        m_p1_kz = v.findViewById(R.id.m_p1_kz);

        loadMethod();
        return v;
    }

    public void loadMethod() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String position = prefs.getString(getString(R.string.pref_style), "");

        switch (position) {
            case "ИСиТ-11":
                ISiT_11();
                break;
        }
    }

    public void ISiT_11() {

        p1.setText(getResources().getString(R.string.inf_tex));
        p1a.setText(getResources().getString(R.string.igonina));
        m_p1_t.setText(getResources().getString(R.string.lk));
        m_p1_k.setText(getResources().getString(R.string.uk4_21));
        p1z.setText(getResources().getString(R.string.chevetovodstvo));
        p1az.setText(getResources().getString(R.string.samsonova));
        m_p1_tz.setText(getResources().getString(R.string.pz));
        m_p1_kz.setText(getResources().getString(R.string.uk4_21));

    }


}