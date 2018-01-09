package ru.vyaacheslav.suhov.imeit.Cafedrs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vyaacheslav.suhov.imeit.R;

public class Matmod extends Fragment  {


    public Matmod() {    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragmen
        View v = inflater.inflate(R.layout.caf_matmod, container, false);


        return v;
    }



}
