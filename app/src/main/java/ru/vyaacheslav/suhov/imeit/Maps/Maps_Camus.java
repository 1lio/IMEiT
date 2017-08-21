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

public class Maps_Camus extends Fragment {

    LinearLayout k1,k2,k3,k4,k5,k6,k7,k8,k9,k10,k11;

    public Maps_Camus() { }

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

        k1.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 28,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k1.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        k2.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Ленина, д. 91,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k2.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        k3.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 15,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k3.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        k4.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. 9 Декабря, д.72,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k4.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        k5.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Ленина, д. 86,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k5.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        k6.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. 9 Декабря, д. 13а,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k6.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        k7.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k7.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 37,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k7.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        k8.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k8.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Допризывников, д. 1,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k8.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        k9.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k9.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Орджоникидзе, д.78,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k9.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        k10.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k10.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 39,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k10.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryF));
                }
                return true;
            }

        });

        k11.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent event) {
                Intent agr;
                if (event.getAction() == android.view.MotionEvent.ACTION_DOWN) {
                    k11.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorTouch));
                    Uri gmmIntentUri = Uri.parse("geo:0,0?q=ул. Коммунаров, д. 28,+Елец,+Липецкая+обл.");
                    agr = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    agr.setPackage("com.google.android.apps.maps");
                    startActivity(agr);

                } else if (event.getAction() == android.view.MotionEvent.ACTION_UP) {
                    k11.setBackgroundColor(ContextCompat.getColor(getContext(), R.color.colorPrimaryS));
                }
                return true;
            }

        });

        return v;
    }

}
