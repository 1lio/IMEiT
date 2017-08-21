package ru.vyaacheslav.suhov.imeit.Maps;


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

public class Maps_Other extends Fragment {

    LinearLayout hos1,hos2,hos3,hos4;

    public Maps_Other() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_hostel, container, false);

        hos1=v.findViewById(R.id.hos1);
        hos2=v.findViewById(R.id.hos2);
        hos3=v.findViewById(R.id.hos3);
        hos4=v.findViewById(R.id.hos4);

        hos1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    hos1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 28,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    hos1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        hos1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    hos1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 28,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    hos1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        hos2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    hos2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Ленина, д. 88,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    hos2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        hos3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    hos3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Допризывников, д.1,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    hos3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });
        hos4.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    hos4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=Липецкая обл., +Задонский район.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    hos4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });


        return v;
    }

}
