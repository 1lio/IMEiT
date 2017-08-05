package ru.vyaacheslav.suhov.imeit;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;


public class Thu extends Fragment {


    private static TextView textview;
    Spinner spinner;


    public Thu() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.thu, container, false);
        spinner = (Spinner)getActivity().findViewById(R.id.spinner);
        textview = (TextView) v.findViewById(R.id.th1);

        loadMethod();
        return v;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu, menu);
        return;

    }


    public void loadMethod(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        int position= sharedPreferences .getInt("spnCalorieRange",-1);

        switch (position){
            case 0:
                textview.setText(getResources().getString(R.string.pravo));
                break;
            case 1:
                textview.setText(getResources().getString(R.string.vis_tex));
                break;

        }

    }
}