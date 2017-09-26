package ru.vyaacheslav.suhov.imeit.Maps;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

import static android.content.Context.MODE_PRIVATE;

public class Maps_Other extends Fragment implements View.OnClickListener {

    public static final String APP_PREFERENCES = "sasa";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    LinearLayout hos1, hos2, hos3, hos4, otf;
    Intent agr;
    Uri adress;
    TextView l1, l2, l3, l4;

    public Maps_Other() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hostel, container, false);

        hos1=v.findViewById(R.id.hos1);
        hos2=v.findViewById(R.id.hos2);
        hos3=v.findViewById(R.id.hos3);
        hos4=v.findViewById(R.id.hos4);

        l1 = v.findViewById(R.id.l1);
        l2 = v.findViewById(R.id.l2);
        l3 = v.findViewById(R.id.l3);
        l4 = v.findViewById(R.id.l4);

        otf = v.findViewById(R.id.sda);

        hos1.setOnClickListener(this);
        hos2.setOnClickListener(this);
        hos3.setOnClickListener(this);
        hos4.setOnClickListener(this);

        LoadPreferences();
        return v;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.hos1:
                    adress = Uri.parse("geo:0,0?q=ул.Коммунаров,д.28,+Елец,+Липецкая+обл.");
                break;
            case R.id.hos2:
                  adress = Uri.parse("geo:0,0?q=ул. Ленина,д.88,+Елец,+Липецкая+обл.");
                break;
            case R.id.hos3:
                    adress = Uri.parse("geo:0,0?q=ул.Допризывников,д.1,+Елец,+Липецкая+обл.");
                break;
            case R.id.hos4:
                    adress = Uri.parse("geo:0,0?q=Липецкая обл.,+Задонский район.");
                break;
        }
        agr = new Intent(Intent.ACTION_VIEW, adress);
        agr.setPackage("com.google.android.apps.maps");
        startActivity(agr);
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        switch (savedRadioIndex) {
            case 0:
                ThemeWrite();
                break;
            case 1:
                ThemeDark();
                break;
        }
    }

    public void ThemeWrite() {

        hos1.setBackgroundResource(R.color.colorWhitee);
        hos2.setBackgroundResource(R.color.colorTes);
        hos3.setBackgroundResource(R.color.colorWhitee);
        hos4.setBackgroundResource(R.color.colorTes);
        l1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        l2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        l3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        l4.setTextColor(getResources().getColor(R.color.colorTextBlack));
        otf.setBackgroundResource(R.color.colorWhitee);
    }

    public void ThemeDark() {

        otf.setBackgroundResource(R.color.colorPrimaryF);
        hos1.setBackgroundResource(R.color.colorPrimaryF);
        hos2.setBackgroundResource(R.color.colorPrimaryS);
        hos3.setBackgroundResource(R.color.colorPrimaryF);
        hos4.setBackgroundResource(R.color.colorPrimaryS);
        l1.setTextColor(getResources().getColor(R.color.colorWhitee));
        l2.setTextColor(getResources().getColor(R.color.colorWhitee));
        l3.setTextColor(getResources().getColor(R.color.colorWhitee));
        l4.setTextColor(getResources().getColor(R.color.colorWhitee));

    }
}
