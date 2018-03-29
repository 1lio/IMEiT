package ru.vyaacheslav.suhov.imeit.maps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class Maps_Other extends Fragment implements View.OnClickListener {

    public Intent agr;
    public LinearLayout hos1, hos2, hos3, hos4, otf;
    public View v;
    private Uri adress;

    public Maps_Other() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v = inflater.inflate(R.layout.fragment_hostel, container, false);

        hos1 = v.findViewById(R.id.hos1);
        hos2 = v.findViewById(R.id.hos2);
        hos3 = v.findViewById(R.id.hos3);
        hos4 = v.findViewById(R.id.hos4);
        otf = v.findViewById(R.id.sda);

        hos1.setOnClickListener(this);
        hos2.setOnClickListener(this);
        hos3.setOnClickListener(this);
        hos4.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.hos1:
                adress = Uri.parse("geo:0,0?q=ул.Коммунаров,д.28,+Елец,+Липецкая обл.");
                break;
            case R.id.hos2:
                adress = Uri.parse("geo:0,0?q=ул. Ленина,д.88,+Елец,+Липецкая обл.");
                break;
            case R.id.hos3:
                adress = Uri.parse("geo:0,0?q=ул.Допризывников,д.1,+Елец,+Липецкая обл.");
                break;
            case R.id.hos4:
                adress = Uri.parse("geo:0,0?q=Липецкая обл.,+Задонский район.");
                break;
        }
        agr = new Intent(Intent.ACTION_VIEW, adress);
        agr.setPackage("com.google.android.apps.maps");
        startActivity(agr);
    }

}
