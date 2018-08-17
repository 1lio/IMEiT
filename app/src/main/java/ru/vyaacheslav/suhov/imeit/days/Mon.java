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

import ru.vyaacheslav.suhov.imeit.R;

public class Mon extends Fragment{

    public View v;
    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z, m_l_4c, m_l_3c, m_l_2c, m_l_1c, m_l_5c;
    public LinearLayout mm1, mm2, mm3, mm4, mm5, main_mon, youday;

    public Mon() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.mon, container, false);
        InitViews();
        loadMethod();
        return v;
    }


    // нужно оптимизировать эту херню.
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

        mm1 = v.findViewById(R.id.mm1);
        mm2 = v.findViewById(R.id.mm2);
        mm3 = v.findViewById(R.id.mm3);
        mm4 = v.findViewById(R.id.mm4);
        mm5 = v.findViewById(R.id.mm5);
    }
}