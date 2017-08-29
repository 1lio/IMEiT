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

public class Maps_Camus extends Fragment implements View.OnClickListener {

    LinearLayout k1, k2, k3, k4, k5, k6, k7, k8, k9, k10, k11;
    Intent agr;
    Uri adresK;

    public Maps_Camus() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_campus, container, false);

        k1 = v.findViewById(R.id.k1);
        k2 = v.findViewById(R.id.k2);
        k3 = v.findViewById(R.id.k3);
        k4 = v.findViewById(R.id.k4);
        k5 = v.findViewById(R.id.k5);
        k6 = v.findViewById(R.id.k6);
        k7 = v.findViewById(R.id.k7);
        k8 = v.findViewById(R.id.k8);
        k9 = v.findViewById(R.id.k9);
        k10 = v.findViewById(R.id.k10);
        k11 = v.findViewById(R.id.k11);

        k1.setOnClickListener(this);
        k2.setOnClickListener(this);
        k3.setOnClickListener(this);
        k4.setOnClickListener(this);
        k5.setOnClickListener(this);
        k6.setOnClickListener(this);
        k7.setOnClickListener(this);
        k8.setOnClickListener(this);
        k9.setOnClickListener(this);
        k10.setOnClickListener(this);
        k11.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.k1:
                 adresK = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 28,+Елец,+Липецкая+обл.");
                break;
            case R.id.k2:
                 adresK = Uri.parse("geo:0,0?q=ул. Ленина, д. 91,+Елец,+Липецкая+обл.");
                break;
            case R.id.k3:
                adresK = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 15,+Елец,+Липецкая+обл.");
                break;
            case R.id.k4:
                adresK = Uri.parse("geo:0,0?q=ул. 9 Декабря, д.72,+Елец,+Липецкая+обл.");
                break;
            case R.id.k5:
                 adresK = Uri.parse("geo:0,0?q=ул. Ленина, д. 86,+Елец,+Липецкая+обл.");
                break;
            case R.id.k6:
                 adresK = Uri.parse("geo:0,0?q=ул. 9 Декабря, д. 13а,+Елец,+Липецкая+обл.");
                break;
            case R.id.k7:
                 adresK = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 37,+Елец,+Липецкая+обл.");
                break;
            case R.id.k8:
                 adresK = Uri.parse("geo:0,0?q=ул. Допризывников, д. 1,+Елец,+Липецкая+обл.");
                break;
            case R.id.k9:
                 adresK = Uri.parse("geo:0,0?q=ул. Орджоникидзе, д.78,+Елец,+Липецкая+обл.");
                break;
            case R.id.k10:
                adresK = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 39,+Елец,+Липецкая+обл.");
                break;
            case R.id.k11:
                adresK = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 28,+Елец,+Липецкая+обл.");
                break;
        }

        agr = new Intent(Intent.ACTION_VIEW, adresK);
        agr.setPackage("com.google.android.apps.maps");
        startActivity(agr);
    }
}
