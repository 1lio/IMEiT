package ru.vyaacheslav.suhov.imeit.Cafedrs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ru.vyaacheslav.suhov.imeit.R;

public class Chemestry extends Fragment {


    ImageView ab_ch;
    FragmentManager FM;
    public Chemestry() {    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.caf_chemestry, container, false);
        ab_ch = v.findViewById(R.id.ab_ch);

        ab_ch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FM = getFragmentManager();
                FragmentTransaction fc = FM.beginTransaction();
                fc.replace(R.id.containerView, new CafedraMain()).commit();
            }
        });

        return v;

    }

}
