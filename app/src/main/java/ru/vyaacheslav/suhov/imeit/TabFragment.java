package ru.vyaacheslav.suhov.imeit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabFragment extends Fragment {

    public static int int_items = 5;
    TabLayout tabLayout;
    ViewPager viewPager;

    public TabFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab, container, false);
        tabLayout = v.findViewById(R.id.tabs);
        viewPager = v.findViewById(R.id.viewpager);

        viewPager.setAdapter(new MyAdapter(getChildFragmentManager()));

        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        tabLayout.setBackgroundResource(R.color.colorPrimary);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhitee));
        LoadPreferences();
        return v;
    }

    private void LoadPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String regular = prefs.getString(getString(R.string.pref_theme), "");

        switch (regular) {
            case "Светлая":
                tabLayout.setBackgroundResource(R.color.colorPrimary);
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhitee));
                break;
            case "Темная":
                tabLayout.setBackgroundResource(R.color.colorPrimarySS);
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
                break;
        }

    }
}
