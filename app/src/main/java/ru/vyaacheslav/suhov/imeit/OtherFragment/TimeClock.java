package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.R;

public class TimeClock extends Fragment {

    public int getHour;
    private LinearLayout l1, l2, l3, l4, l5, l6, lss;
    private TimePicker timePicker;
    private Calendar calendar;
    private TextView t1, t2, t3, t5, t6, t7, t8, t10, t11, t12, t13, t14, t15, t16, t17, t19, t20, t21, t22,
            t24, t25, t26, t27, t29, t30, t31, t32;
    private RelativeLayout lsss;

    public TimeClock() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.time_clock, container, false);

        l1 = v.findViewById(R.id.l1);
        l2 = v.findViewById(R.id.l2);
        l3 = v.findViewById(R.id.l3);
        l4 = v.findViewById(R.id.l4);
        l5 = v.findViewById(R.id.l5);
        l6 = v.findViewById(R.id.l6);
        lss = v.findViewById(R.id.lss);
        lsss = v.findViewById(R.id.lsss);

        timePicker = v.findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();

        t1 = v.findViewById(R.id.t1);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t5 = v.findViewById(R.id.t5);
        t6 = v.findViewById(R.id.t6);
        t7 = v.findViewById(R.id.t7);
        t8 = v.findViewById(R.id.t8);
        t10 = v.findViewById(R.id.t10);
        t11 = v.findViewById(R.id.t11);
        t12 = v.findViewById(R.id.t12);
        t13 = v.findViewById(R.id.t13);
        t14 = v.findViewById(R.id.t14);
        t15 = v.findViewById(R.id.t15);
        t16 = v.findViewById(R.id.t16);
        t17 = v.findViewById(R.id.t17);
        t19 = v.findViewById(R.id.t19);
        t20 = v.findViewById(R.id.t20);
        t21 = v.findViewById(R.id.t21);
        t22 = v.findViewById(R.id.t22);
        t24 = v.findViewById(R.id.t24);
        t25 = v.findViewById(R.id.t25);
        t26 = v.findViewById(R.id.t26);
        t27 = v.findViewById(R.id.t27);
        t29 = v.findViewById(R.id.t29);
        t30 = v.findViewById(R.id.t30);
        t31 = v.findViewById(R.id.t31);
        t32 = v.findViewById(R.id.t32);

       updateClock();
        TimeFunction();
        return v;
    }

    public void TimeFunction() {

        if (Build.VERSION.SDK_INT < 23) {
            getHour = timePicker.getCurrentHour();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        } else {
            getHour = timePicker.getHour();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        }

         if ((getHour > 8)) {
            updateClock();
            l2.setBackground(getResources().getDrawable(R.drawable.card_row2));
        }

         if ((getHour > 10)) {
            updateClock();
            l3.setBackground(getResources().getDrawable(R.drawable.card_row2));
        }
         if ((getHour > 12)) {
            updateClock();
            l4.setBackground(getResources().getDrawable(R.drawable.card_row2));
        }
         if ((getHour > 14)) {
            updateClock();
            l5.setBackground(getResources().getDrawable(R.drawable.card_row2));
        }

         if ((getHour > 16)) {
            updateClock();
            l6.setBackground(getResources().getDrawable(R.drawable.card_row2));
        }

         if ((getHour > 18)) {
            updateClock();
        }
    }

    public void updateClock() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String regular = prefs.getString(getString(R.string.pref_theme), "");

        switch (regular) {
            case "Светлая":
                l1.setBackground(getResources().getDrawable(R.drawable.card_row1));
                l2.setBackground(getResources().getDrawable(R.drawable.card_row1));
                l3.setBackground(getResources().getDrawable(R.drawable.card_row1));
                l4.setBackground(getResources().getDrawable(R.drawable.card_row1));
                l5.setBackground(getResources().getDrawable(R.drawable.card_row1));
                l6.setBackground(getResources().getDrawable(R.drawable.card_row1));
                break;
            case "Темная":
                l1.setBackground(getResources().getDrawable(R.drawable.card_row0));
                l2.setBackground(getResources().getDrawable(R.drawable.card_row0));
                l3.setBackground(getResources().getDrawable(R.drawable.card_row0));
                l4.setBackground(getResources().getDrawable(R.drawable.card_row0));
                l5.setBackground(getResources().getDrawable(R.drawable.card_row0));
                l6.setBackground(getResources().getDrawable(R.drawable.card_row0));
                break;
        }
    }

}
