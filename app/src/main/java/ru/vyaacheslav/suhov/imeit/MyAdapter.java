package ru.vyaacheslav.suhov.imeit;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import static ru.vyaacheslav.suhov.imeit.TabFragment.int_items;

 class MyAdapter  extends FragmentPagerAdapter {


    MyAdapter(FragmentManager fm)
    {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new Mon();
            case 1:
                return new Tue();
            case 2:
                return new Mon();
            case 3:
                return new Mon();
            case 4:
                return new Mon();
        }
        return null;
    }

    @Override
    public int getCount() {
        return int_items;
    }

    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Пн";
            case 1:
                return "Вт";
            case 2:
                return "Ср";
            case 3:
                return "Чт";
            case 4:
                return "Пт";

        }

        return null;
    }
}
