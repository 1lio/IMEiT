package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TimePicker;

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.R;

public class TimeClock extends Fragment {

    LinearLayout l1,l2,l3,l4,l5,l6;
    TimePicker timePicker;
    Calendar calendar;

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

        timePicker = v.findViewById(R.id.timePicker);
        calendar = Calendar.getInstance();

        TimeOne();
        return v;
}

    public void TimeOne(){

        int getHour = timePicker.getHour(); // - Точность до часа
       //  int getMinute = timePicker.getMinute(); - Проблема с точностью до минут не решена!

        calendar.set(Calendar.MINUTE, timePicker.getMinute());
        calendar.set(Calendar.HOUR, timePicker.getHour());


        if ((getHour > 8)/*&&(getMinute > 30)*/){
            updateClock();
            l1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
        }
        if  ((getHour > 10)/*&&(getMinute > 15)*/){
            updateClock();
            l2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
        }

        if ((getHour > 12)/*&&(getMinute > 30)*/){
            updateClock();
            l3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
        }
        if ((getHour > 14)/*&&(getMinute > 15)*/){
            updateClock();
            l4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
        }
        if  ((getHour > 16)/*&&(getMinute > 0)*/){
            updateClock();
            l5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
        }

        if ((getHour > 17)/*&&(getMinute > 45)*/){
            updateClock();
            l6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));

        }

        if  ((getHour > 19)/*&&(getMinute > 0)*/){
            updateClock();
        }
    }

    public void updateClock(){

        l1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
        l2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
        l3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
        l4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
        l5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
        l6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));

    }
}
