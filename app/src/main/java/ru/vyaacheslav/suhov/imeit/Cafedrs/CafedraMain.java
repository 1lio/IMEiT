package ru.vyaacheslav.suhov.imeit.Cafedrs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class CafedraMain extends Fragment implements View.OnClickListener {

    public FragmentTransaction FT;
    public FragmentManager FM;
    LinearLayout caf1, caf2, caf3, caf4, caf5, caf6;

    public CafedraMain() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.cafedrs, container, false);

        caf1 = v.findViewById(R.id.cf_mat);
        caf2 = v.findViewById(R.id.cf_inf);
        caf3 = v.findViewById(R.id.cf_rad);
        caf4 = v.findViewById(R.id.cf_phy);
        caf5 = v.findViewById(R.id.ch_chx);
        caf6 = v.findViewById(R.id.cf_cmt);

        caf1.setOnClickListener(this);
        caf2.setOnClickListener(this);
        caf3.setOnClickListener(this);
        caf4.setOnClickListener(this);
        caf5.setOnClickListener(this);
        caf6.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View view) {

        FM = getFragmentManager();

            switch (view.getId()){
                case R.id.cf_mat:

                    FragmentTransaction fc = FM.beginTransaction();
                    fc.replace(R.id.containerView, new Matmod()).commit();
                    break;
                case R.id.cf_inf:

                    FragmentTransaction cd = FM.beginTransaction();
                    cd.replace(R.id.containerView, new Informat()).commit();
                    break;
                case R.id.cf_rad:

                    FragmentTransaction dd = FM.beginTransaction();
                    dd.replace(R.id.containerView, new Radiotex()).commit();
                    break;
                case R.id.cf_phy:

                    FragmentTransaction ss = FM.beginTransaction();
                    ss.replace(R.id.containerView, new Physucs()).commit();
                    break;
                case R.id.ch_chx:
                    FragmentTransaction aa = FM.beginTransaction();
                    aa.replace(R.id.containerView, new Chemestry()).commit();
                    break;
                case R.id.cf_cmt:

                    FragmentTransaction ee = FM.beginTransaction();
                    ee.replace(R.id.containerView, new CompTex()).commit();
                    break;
                    default:
                        break;
            }
    }
}
