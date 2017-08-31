package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class Info extends Fragment  {

    LinearLayout tel, webs, group, email;

    public Info() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        tel = v.findViewById(R.id.tel);
        webs = v.findViewById(R.id.webs);
        group = v.findViewById(R.id.groups);
        email = v.findViewById(R.id.emal_l);

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
                    webs.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
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
                    email.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }
        });
        return v;
    }
}
