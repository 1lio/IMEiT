package ru.vyaacheslav.suhov.imeit.Maps;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ru.vyaacheslav.suhov.imeit.R;

public class Maps_Inst extends Fragment implements View.OnClickListener{


    public Maps_Inst() {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_maps__inst, container, false);

        return v;
    }


    @Override
    public void onClick(View view) {

    }
}
