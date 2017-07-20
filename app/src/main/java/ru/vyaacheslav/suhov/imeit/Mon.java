package ru.vyaacheslav.suhov.imeit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class Mon extends Fragment {


    public Mon() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.mon,container,false);
       TextView ps1= (TextView)v.findViewById(R.id.p1);


        return v;
    }

}