package ru.vyaacheslav.suhov.imeit.Cafedrs;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class Chemestry extends Fragment {

    public Intent intent;
    ImageView ab_ch;
    FragmentManager FM;
    LinearLayout tel, mail, address;

    public Chemestry() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.caf_chemestry, container, false);

        ab_ch = v.findViewById(R.id.ab_ch);
        tel = v.findViewById(R.id.tel_ch);
        mail = v.findViewById(R.id.main_sh);
        address = v.findViewById(R.id.map_ch);

        ab_ch.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                FM = getFragmentManager();
                FragmentTransaction fc = FM.beginTransaction();
                fc.replace(R.id.containerView, new CafedraMain()).commit();
            }
        });


        tel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74746765971"));
                startActivity(intent);
            }
        });
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"kafbiolagro@mail.ru"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Выберите email клиент :"));
            }
        });

        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri adress = Uri.parse("geo:0,0?q=ул. Допризывников, д.1,+Елец,+Липецкая+обл.");
                Intent agr = new Intent(Intent.ACTION_VIEW, adress);
                agr.setPackage("com.google.android.apps.maps");
                startActivity(agr);
            }
        });

        return v;
    }
}
