package ru.vyaacheslav.suhov.imeit.maps;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

 class MapsAdapter extends FragmentPagerAdapter {

     MapsAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Maps_Inst();
            case 1:
                return new Maps_Camus();
            case 2:
                return new Maps_Other();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Институты";
            case 1:
                return "Корпуса";
            case 2:
                return "Прочее";
        }
        return null;
    }
}
