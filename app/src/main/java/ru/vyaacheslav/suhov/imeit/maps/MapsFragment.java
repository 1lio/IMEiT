package ru.vyaacheslav.suhov.imeit.maps;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class MapsFragment extends Fragment {

    public TabLayout tabLayout;
    public ViewPager viewPager;
    public LinearLayout times;

    public MapsFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_tab, container, false);
        tabLayout = v.findViewById(R.id.tabs);
        viewPager = v.findViewById(R.id.viewpager);
        times = v.findViewById(R.id.times);
        viewPager.setAdapter(new MapsAdapter(getChildFragmentManager()));
        tabLayout.post(new Runnable() {
            @Override
            public void run() {
                tabLayout.setupWithViewPager(viewPager);
            }
        });

        times.setVisibility(View.INVISIBLE);
        ViewGroup.LayoutParams params = times.getLayoutParams();
        params.width = 0;
        times.setLayoutParams(params);


        return v;
    }

}
