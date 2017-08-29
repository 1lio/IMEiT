package ru.vyaacheslav.suhov.imeit.Maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class Maps_Inst extends Fragment implements View.OnClickListener{

    LinearLayout ins1, ins2,ins3,ins4,ins5,ins6,ins7,ins8;
    Intent agr;
    Uri adress;

    public Maps_Inst() { }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_maps__inst, container, false);

        ins1 = v.findViewById(R.id.ins1);
        ins2 = v.findViewById(R.id.ins2);
        ins3 = v.findViewById(R.id.ins3);
        ins4 = v.findViewById(R.id.ins4);
        ins5 = v.findViewById(R.id.ins5);
        ins6 = v.findViewById(R.id.ins6);
        ins7 = v.findViewById(R.id.ins7);
        ins8 = v.findViewById(R.id.ins8);

        ins1.setOnClickListener(this);
        ins2.setOnClickListener(this);
        ins3.setOnClickListener(this);
        ins4.setOnClickListener(this);
        ins5.setOnClickListener(this);
        ins6.setOnClickListener(this);
        ins7.setOnClickListener(this);
        ins8.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ins1:
                 adress = Uri.parse("geo:0,0?q=ул.+Допризывников,+3,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins2:
                adress = Uri.parse("geo:0,0?q=ул.+Коммунаров,+28,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins3:
                 adress = Uri.parse("geo:0,0?q=ул. Ленина, д. 86,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins4:
                 adress = Uri.parse("geo:0,0?q=ул.+Коммунаров,+28,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins5:
                 adress = Uri.parse("geo:0,0?q= ул. Коммунаров, д. 15,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins6:
                 adress = Uri.parse("geo:0,0?q= ул. Допризывников, д. 1а,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins7:
                 adress = Uri.parse("geo:0,0?q= ул. Коммунаров, д. 39,+Елец,+Липецкая+обл.");
                break;
            case R.id.ins8:
                 adress = Uri.parse("geo:0,0?q=ул. Допризывников, д. 1а,+Елец,+Липецкая+обл.");
                break;
        }
        agr = new Intent(Intent.ACTION_VIEW, adress);
        agr.setPackage("com.google.android.apps.maps");
        startActivity(agr);
    }
}
