package ru.vyaacheslav.suhov.imeit.BusRoute;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

class BussAdapter extends FragmentPagerAdapter {

    BussAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new BussL();
            case 1:
                return new BussK();

        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Маршруты";
            case 1:
                return "Корпуса";

        }
        return null;
    }
}
