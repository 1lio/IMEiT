package ru.vyaacheslav.suhov.imeit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import static android.content.Context.MODE_PRIVATE;

public class TabFragment extends Fragment {

    public static final String APP_PREFERENCES = "sasa";
    public static int int_items = 5;
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
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

        LoadPreferences();
        return v;
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        switch (savedRadioIndex) {
            case 0:
                tabLayout.setBackgroundResource(R.color.colorPrimary);
                break;
            case 1:
                tabLayout.setBackgroundResource(R.color.colorPrimarySS);
                break;
        }
    }
}
