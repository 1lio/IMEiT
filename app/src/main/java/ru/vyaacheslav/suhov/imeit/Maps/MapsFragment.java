package ru.vyaacheslav.suhov.imeit.Maps;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vyaacheslav.suhov.imeit.R;

public class MapsFragment extends Fragment {

    TabLayout tabLayout;
    ViewPager viewPager;

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
        checkAndSetImage();
        return v;
    }

    public void checkAndSetImage() {
        SharedPreferences settings = getActivity().getSharedPreferences("status", 0);
        if (settings.getBoolean("orange", false)) {
            tabLayout.setBackgroundResource(R.color.colorTab);
        }
        if (settings.getBoolean("blue", false)) {
            tabLayout.setBackgroundResource(R.color.colorPrimarySS);

        }
    }
}
