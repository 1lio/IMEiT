package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.R;

import static android.content.Context.MODE_PRIVATE;

public class TimeClock extends Fragment {

    public static final String APP_PREFERENCES = "sasa";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    public int getHour;
    LinearLayout l1, l2, l3, l4, l5, l6, lss, lsss;
    TimePicker timePicker;
    Calendar calendar;
    TextView t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13, t14, t15, t16, t17, t18, t19, t20, t21, t22,
            t23, t24, t25, t26, t27, t28, t29, t30, t31, t32, c3;

    public TimeClock() {
    }

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

        c3 = v.findViewById(R.id.c3);
        t1 = v.findViewById(R.id.t1);
        t2 = v.findViewById(R.id.t2);
        t3 = v.findViewById(R.id.t3);
        t4 = v.findViewById(R.id.t4);
        t5 = v.findViewById(R.id.t5);
        t6 = v.findViewById(R.id.t6);
        t7 = v.findViewById(R.id.t7);
        t8 = v.findViewById(R.id.t8);
        t9 = v.findViewById(R.id.t9);
        t10 = v.findViewById(R.id.t10);
        t11 = v.findViewById(R.id.t11);
        t12 = v.findViewById(R.id.t12);
        t13 = v.findViewById(R.id.t13);
        t14 = v.findViewById(R.id.t14);
        t15 = v.findViewById(R.id.t15);
        t16 = v.findViewById(R.id.t16);
        t17 = v.findViewById(R.id.t17);
        t18 = v.findViewById(R.id.t18);
        t19 = v.findViewById(R.id.t19);
        t20 = v.findViewById(R.id.t20);
        t21 = v.findViewById(R.id.t21);
        t22 = v.findViewById(R.id.t22);
        t23 = v.findViewById(R.id.t23);
        t24 = v.findViewById(R.id.t24);
        t25 = v.findViewById(R.id.t25);
        t26 = v.findViewById(R.id.t26);
        t27 = v.findViewById(R.id.t27);
        t28 = v.findViewById(R.id.t28);
        t29 = v.findViewById(R.id.t29);
        t30 = v.findViewById(R.id.t30);
        t31 = v.findViewById(R.id.t31);
        t32 = v.findViewById(R.id.t32);

        TimeOne();
        LoadPreferences();
        return v;
    }

    public void TimeOne() {

        if (Build.VERSION.SDK_INT < 23) {
            getHour = timePicker.getCurrentHour();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour());
        } else {
            getHour = timePicker.getHour();
            calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
        }
        /// ^sdk

        if ((getHour > 8)/*&&(getMinute > 30)*/) {
            updateClock();
            l1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }
        if ((getHour > 9)/*&&(getMinute > 15)*/) {
            updateClock();
            l2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }

        if ((getHour > 11)/*&&(getMinute > 30)*/) {
            updateClock();
            l3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }
        if ((getHour > 13)/*&&(getMinute > 15)*/) {
            updateClock();
            l4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }
        if ((getHour > 15)/*&&(getMinute > 0)*/) {
            updateClock();
            l5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));
        }

        if ((getHour > 17)/*&&(getMinute > 45)*/) {
            updateClock();
            l6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorAccent));

        }

        if ((getHour > 19)/*&&(getMinute > 0)*/) {
            updateClock();
        }
    }

    public void updateClock() {

        SharedPreferences settings = getContext().getSharedPreferences("status", 0);
        if (settings.getBoolean("orange", false)) {
            l1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWhitee));
            l2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTes));
            l3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWhitee));
            l4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTes));
            l5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorWhitee));
            l6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTes));


        }
        if (settings.getBoolean("blue", false)) {
            //dark
            l1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
            l2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
            l3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
            l4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
            l5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
            l6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));

        }
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        switch (savedRadioIndex) {
            case 0:
                ThemeWrite();
                break;
            case 1:
                ThemeDark();
                break;
        }
    }

    public void ThemeWrite() {
        lss.setBackgroundResource(R.color.colorTes);
        lsss.setBackgroundResource(R.color.colorWhitee);
        c3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t4.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t5.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t6.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t7.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t8.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t9.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t10.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t11.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t12.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t13.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t14.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t15.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t16.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t17.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t18.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t19.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t20.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t21.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t22.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t23.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t24.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t25.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t26.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t27.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t28.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t29.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t30.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t31.setTextColor(getResources().getColor(R.color.colorTextBlack));
        t32.setTextColor(getResources().getColor(R.color.colorTextBlack));

    }

    public void ThemeDark() {

        lss.setBackgroundResource(R.color.colorPrimarySS);
        lsss.setBackgroundResource(R.color.colorPrimaryD);
        c3.setTextColor(getResources().getColor(R.color.colorWhitee));
        t1.setTextColor(getResources().getColor(R.color.colorWhitee));
        t2.setTextColor(getResources().getColor(R.color.colorWhitee));
        t3.setTextColor(getResources().getColor(R.color.colorWhitee));
        t4.setTextColor(getResources().getColor(R.color.colorWhitee));
        t5.setTextColor(getResources().getColor(R.color.colorWhitee));
        t6.setTextColor(getResources().getColor(R.color.colorWhitee));
        t7.setTextColor(getResources().getColor(R.color.colorWhitee));
        t8.setTextColor(getResources().getColor(R.color.colorWhitee));
        t9.setTextColor(getResources().getColor(R.color.colorWhitee));
        t10.setTextColor(getResources().getColor(R.color.colorWhitee));
        t11.setTextColor(getResources().getColor(R.color.colorWhitee));
        t12.setTextColor(getResources().getColor(R.color.colorWhitee));
        t13.setTextColor(getResources().getColor(R.color.colorWhitee));
        t14.setTextColor(getResources().getColor(R.color.colorWhitee));
        t15.setTextColor(getResources().getColor(R.color.colorWhitee));
        t16.setTextColor(getResources().getColor(R.color.colorWhitee));
        t17.setTextColor(getResources().getColor(R.color.colorWhitee));
        t18.setTextColor(getResources().getColor(R.color.colorWhitee));
        t19.setTextColor(getResources().getColor(R.color.colorWhitee));
        t20.setTextColor(getResources().getColor(R.color.colorWhitee));
        t21.setTextColor(getResources().getColor(R.color.colorWhitee));
        t22.setTextColor(getResources().getColor(R.color.colorWhitee));
        t23.setTextColor(getResources().getColor(R.color.colorWhitee));
        t24.setTextColor(getResources().getColor(R.color.colorWhitee));
        t25.setTextColor(getResources().getColor(R.color.colorWhitee));
        t26.setTextColor(getResources().getColor(R.color.colorWhitee));
        t27.setTextColor(getResources().getColor(R.color.colorWhitee));
        t28.setTextColor(getResources().getColor(R.color.colorWhitee));
        t29.setTextColor(getResources().getColor(R.color.colorWhitee));
        t30.setTextColor(getResources().getColor(R.color.colorWhitee));
        t31.setTextColor(getResources().getColor(R.color.colorWhitee));
        t32.setTextColor(getResources().getColor(R.color.colorWhitee));
    }
}
