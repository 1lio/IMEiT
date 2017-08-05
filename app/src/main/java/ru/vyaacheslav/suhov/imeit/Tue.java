package ru.vyaacheslav.suhov.imeit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Tue extends Fragment {

    Spinner spinner;
    TextView textview;

    public Tue() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tue, container, false);
        spinner = (Spinner)getActivity().findViewById(R.id.spinner);
        textview = (TextView) v.findViewById(R.id.t1);
        loadMethod();
        return v;
    }

    public void loadMethod(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int position= sharedPreferences .getInt("spnCalorieRange",-1);

        switch (position){
            case 0:
                textview.setText(getResources().getString(R.string.chemistry));
                break;
            case 1:
                textview.setText(getResources().getString(R.string.inlang));
                break;

        }

    }
}