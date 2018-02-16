package ru.vyaacheslav.suhov.imeit.Maps;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vyaacheslav.suhov.imeit.R;

public class MapsFragment extends Fragment {

    public TabLayout tabLayout;
    public ViewPager viewPager;

    public MapsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tab, container, false);
        tabLayout = v.findViewById(R.id.tabs);
        viewPager = v.findViewById(R.id.viewpager);
        viewPager.setAdapter(new MapsAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        LoadPreferences();
        return v;
    }

    private void LoadPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String regular = prefs.getString(getString(R.string.pref_theme), "");
        tabLayout.setBackgroundResource(R.color.colorPrimary);
        tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));

        switch (regular) {
            case "Светлая":
                tabLayout.setBackgroundResource(R.color.colorPrimarySS);
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorAccent));
                break;
            case "Темная":
                tabLayout.setBackgroundResource(R.color.colorPrimary);
                tabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhitee));
                break;
        }

    }

}
