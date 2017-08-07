package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vyaacheslav.suhov.imeit.R;

public class TimeClock extends Fragment {


    public TimeClock() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.time_clock, container, false);
    }

}
