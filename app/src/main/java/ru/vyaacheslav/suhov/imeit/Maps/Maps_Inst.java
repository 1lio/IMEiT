package ru.vyaacheslav.suhov.imeit.Maps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Maps_Inst extends Fragment implements View.OnClickListener {

    public static final String APP_PREFERENCES = "sasa";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    LinearLayout ins1, ins2, ins3, ins4, ins5, ins6, ins7, ins8;
    Intent agr;
    Uri adress;
    TextView d1, d2, d3, d4, d5, d6, d7, d8;

    public Maps_Inst() {
    }

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

        d1 = v.findViewById(R.id.d1);
        d2 = v.findViewById(R.id.d2);
        d3 = v.findViewById(R.id.d3);
        d4 = v.findViewById(R.id.d4);
        d5 = v.findViewById(R.id.d5);
        d6 = v.findViewById(R.id.d6);
        d7 = v.findViewById(R.id.d7);
        d8 = v.findViewById(R.id.d8);

        LoadPreferences();
        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
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

    private void LoadPreferences() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String regular = prefs.getString(getString(R.string.pref_theme), "");

        switch (regular) {
            case "Светлая":
                ThemeWrite();
                break;
            case "Темная":
                ThemeDark();
                break;
        }
    }

    public void ThemeWrite() {
        ins1.setBackgroundResource(R.color.colorWhitee);
        ins2.setBackgroundResource(R.color.colorTes);
        ins3.setBackgroundResource(R.color.colorWhitee);
        ins4.setBackgroundResource(R.color.colorTes);
        ins5.setBackgroundResource(R.color.colorWhitee);
        ins6.setBackgroundResource(R.color.colorTes);
        ins7.setBackgroundResource(R.color.colorWhitee);
        ins8.setBackgroundResource(R.color.colorTes);

        d1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d4.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d5.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d6.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d7.setTextColor(getResources().getColor(R.color.colorTextBlack));
        d8.setTextColor(getResources().getColor(R.color.colorTextBlack));
    }

    public void ThemeDark() {

        ins1.setBackgroundResource(R.color.colorPrimaryF);
        ins2.setBackgroundResource(R.color.colorPrimaryS);
        ins3.setBackgroundResource(R.color.colorPrimaryF);
        ins4.setBackgroundResource(R.color.colorPrimaryS);
        ins5.setBackgroundResource(R.color.colorPrimaryF);
        ins6.setBackgroundResource(R.color.colorPrimaryS);
        ins7.setBackgroundResource(R.color.colorPrimaryF);
        ins8.setBackgroundResource(R.color.colorPrimaryS);

        d1.setTextColor(getResources().getColor(R.color.colorWhitee));
        d2.setTextColor(getResources().getColor(R.color.colorWhitee));
        d3.setTextColor(getResources().getColor(R.color.colorWhitee));
        d4.setTextColor(getResources().getColor(R.color.colorWhitee));
        d5.setTextColor(getResources().getColor(R.color.colorWhitee));
        d6.setTextColor(getResources().getColor(R.color.colorWhitee));
        d7.setTextColor(getResources().getColor(R.color.colorWhitee));
        d8.setTextColor(getResources().getColor(R.color.colorWhitee));

    }
}
