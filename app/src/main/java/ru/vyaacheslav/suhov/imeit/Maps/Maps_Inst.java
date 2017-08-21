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

public class Maps_Inst extends Fragment{

    LinearLayout ins1, ins2,ins3,ins4,ins5,ins6,ins7,ins8;
    public Maps_Inst() {    }
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

        ins1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул.+Допризывников,+3,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });
        ins2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул.+Коммунаров,+28,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });


        ins3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Ленина, д. 86,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        ins4.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул.+Коммунаров,+28,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        ins5.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q= ул. Коммунаров, д. 15,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        ins6.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q= ул. Допризывников, д. 1а,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        ins7.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins7.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q= ул. Коммунаров, д. 39,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins7.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        ins8.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent ist;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    ins8.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Допризывников, д. 1а,+Елец,+Липецкая+обл.");
                    ist = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    ist.setPackage("com.google.android.apps.maps");
                    startActivity(ist);
                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    ins8.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        return v;
    }
}
