package ru.vyaacheslav.suhov.imeit.OtherFragment;

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
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Info extends Fragment implements View.OnClickListener {

    public Intent intent;
    private LinearLayout tel, webs, group, email, mapl;
    private TextView p1, p2, p3, p4, p5;
    private RelativeLayout mapa;

    public Info() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        tel = v.findViewById(R.id.tel);
        webs = v.findViewById(R.id.webs);
        group = v.findViewById(R.id.groups);
        email = v.findViewById(R.id.emal_l);
        mapl = v.findViewById(R.id.map_l);

        p1 = v.findViewById(R.id.p1);
        p2 = v.findViewById(R.id.p2);
        p3 = v.findViewById(R.id.p3);
        p4 = v.findViewById(R.id.p4);
        p5 = v.findViewById(R.id.p5);
        mapa = v.findViewById(R.id.mapa);

        tel.setOnClickListener(this);
        webs.setOnClickListener(this);
        group.setOnClickListener(this);
        email.setOnClickListener(this);
        mapl.setOnClickListener(this);

        LoadPreferences();
        return v;
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

        mapa.setBackgroundColor(getResources().getColor(R.color.colorWhitee));
        tel.setBackground(getResources().getDrawable(R.drawable.card_row1));
        webs.setBackground(getResources().getDrawable(R.drawable.card_row1));
        group.setBackground(getResources().getDrawable(R.drawable.card_row1));
        email.setBackground(getResources().getDrawable(R.drawable.card_row1));
        mapl.setBackground(getResources().getDrawable(R.drawable.card_row1));
        p1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p4.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p5.setTextColor(getResources().getColor(R.color.colorTextBlack));
    }
    public void ThemeDark() {

        mapa.setBackgroundColor(getResources().getColor(R.color.colorPrimaryF));
        tel.setBackground(getResources().getDrawable(R.drawable.card_row0));
        webs.setBackground(getResources().getDrawable(R.drawable.card_row0));
        group.setBackground(getResources().getDrawable(R.drawable.card_row0));
        email.setBackground(getResources().getDrawable(R.drawable.card_row0));
        mapl.setBackground(getResources().getDrawable(R.drawable.card_row0));
        p1.setTextColor(getResources().getColor(R.color.colorWhitee));
        p2.setTextColor(getResources().getColor(R.color.colorWhitee));
        p3.setTextColor(getResources().getColor(R.color.colorWhitee));
        p4.setTextColor(getResources().getColor(R.color.colorWhitee));
        p5.setTextColor(getResources().getColor(R.color.colorWhitee));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tel:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74746722426"));
                startActivity(intent);
                break;
            case R.id.webs:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://imet.elsu.ru/"));
                startActivity(intent);
                break;
            case R.id.groups:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/imet.elsu"));
                startActivity(intent);
                break;
            case R.id.emal_l:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"DEK_F@MAIL.RU"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Выберите email клиент :"));
                break;
            case R.id.map_l:
                Uri adress = Uri.parse("geo:0,0?q=ул. Ленина, д. 86,+Елец,+Липецкая+обл.");
                Intent agr = new Intent(Intent.ACTION_VIEW, adress);
                agr.setPackage("com.google.android.apps.maps");
                startActivity(agr);
                break;
            default:
                break;
        }
    }
}