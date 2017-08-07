package ru.vyaacheslav.suhov.imeit.Days;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vyaacheslav.suhov.imeit.R;

public class Fri extends Fragment {


    public Fri() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fri, container, false);
        return v;
    }
}