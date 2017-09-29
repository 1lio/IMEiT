package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;

public class Info extends Fragment  {

    public static final String APP_PREFERENCES = "sasa";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    LinearLayout tel, webs, group, email;
    TextView p1, p2, p3, p4;
    RelativeLayout mapa;
    ImageView im1, im2, im3, im4;


    public Info() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        tel = v.findViewById(R.id.tel);
        webs = v.findViewById(R.id.webs);
        group = v.findViewById(R.id.groups);
        email = v.findViewById(R.id.emal_l);

        p1 = v.findViewById(R.id.p1);
        p2 = v.findViewById(R.id.p2);
        p3 = v.findViewById(R.id.p3);
        p4 = v.findViewById(R.id.p4);

        im1 = v.findViewById(R.id.im1);
        im2 = v.findViewById(R.id.im2);
        im3 = v.findViewById(R.id.im3);
        im4 = v.findViewById(R.id.im4);

        mapa = v.findViewById(R.id.mapa);

        LoadPreferences();

        tel.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent intent;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    tel.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74746722426"));
                    startActivity(intent);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                  tel.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        webs.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent intent;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    webs.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://imet.elsu.ru/"));
                    startActivity(intent);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    webs.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        group.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent intent;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    group.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/imet.elsu"));
                    startActivity(intent);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    group.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });
        email.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    email.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Intent email = new Intent(Intent.ACTION_SEND);
                    email.putExtra(Intent.EXTRA_EMAIL, new String[]{"DEK_F@MAIL.RU"});
                    email.setType("message/rfc822");
                    startActivity(Intent.createChooser(email, "Выберите email клиент :"));
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    email.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }
        });
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

        im1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        im2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        im3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        im4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        mapa.setBackgroundResource(R.color.colorWhitee);
        tel.setBackgroundResource(R.color.colorWhitee);
        webs.setBackgroundResource(R.color.colorTes);
        group.setBackgroundResource(R.color.colorWhitee);
        email.setBackgroundResource(R.color.colorTes);
        p1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p3.setTextColor(getResources().getColor(R.color.colorTextBlack));
        p4.setTextColor(getResources().getColor(R.color.colorTextBlack));
    }

    public void ThemeDark() {

        im1.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        im2.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        im3.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        im4.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        mapa.setBackgroundResource(R.color.colorPrimaryF);
        tel.setBackgroundResource(R.color.colorPrimaryF);
        webs.setBackgroundResource(R.color.colorPrimaryS);
        group.setBackgroundResource(R.color.colorPrimaryF);
        email.setBackgroundResource(R.color.colorPrimaryS);
        p1.setTextColor(getResources().getColor(R.color.colorWhitee));
        p2.setTextColor(getResources().getColor(R.color.colorWhitee));
        p3.setTextColor(getResources().getColor(R.color.colorWhitee));
        p4.setTextColor(getResources().getColor(R.color.colorWhitee));
    }
}
