package ru.vyaacheslav.suhov.imeit.Teachers;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import ru.vyaacheslav.suhov.imeit.R;

public class Prepods extends Fragment {

    SearchView sv;
    ListView lv;
    RelativeLayout pinf;
    TechAdapterAb adapter;
    ImageView back,imgP, iconcaf;
    TextView name,subname,namecaf;
    LinearLayout p_tel, p_email,p_address;

    public Prepods() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.prepods, container, false);

        sv = v.findViewById(R.id.mSearch);
        lv = v.findViewById(R.id.lv);
        pinf = v.findViewById(R.id.prepodinfo);
        back = v.findViewById(R.id.back);
        imgP = v.findViewById(R.id.imgP);
        name= v.findViewById(R.id.name);
        subname= v.findViewById(R.id.subname);
        p_tel=v.findViewById(R.id.p_tel);
        p_email=v.findViewById(R.id.p_email);
        p_address=v.findViewById(R.id.p_address);
        namecaf=v.findViewById(R.id.name_caf);
        iconcaf=v.findViewById(R.id.icon_caf);
        adapter = new TechAdapterAb(getActivity(), getMovies());
        lv.setAdapter(adapter);

        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                adapter.getFilter().filter(query);
                return false;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pinf.setVisibility(View.GONE);
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View itemClicked, int position,
                                    long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        pinf.setVisibility(View.VISIBLE);
                        imgP.setBackground(getResources().getDrawable(R.drawable.gladkix));
                        name.setText(getResources().getString(R.string.gladkix2));
                        subname.setText(getResources().getString(R.string.kanfizmat));
                        p_address.setVisibility(View.GONE);
                        iconcaf.setImageDrawable(getResources().getDrawable(R.drawable.ic_code_white_36dp));
                        namecaf.setText(getResources().getString(R.string.cfa_comptex));
                        break;
                    default:
                        break;
                }
            }
        });

        return v;
    }

    private ArrayList<TechClassAb> getMovies() {

        ArrayList<TechClassAb> movies = new ArrayList<>();

        TechClassAb movie = new TechClassAb(getResources().getString(R.string.belix2), R.drawable.belyx);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.gladkix2), R.drawable.gladkix);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.gubin2), R.drawable.gubin);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.gubina2), R.drawable.gubina);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.dvoryadkina2), R.drawable.dvoryadkina);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.eletcki2), R.drawable.eletski);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.elchaninova2), R.drawable.elchaninova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.juk2), R.drawable.zhug);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.zaicev2), R.drawable.zaicev);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.zubareva2), R.drawable.zubaeva);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.kornienkodv2), R.drawable.kornienko_b);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.kornienko_dv2), R.drawable.korn_d);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.masina2), R.drawable.masina);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.melnikov), R.drawable.melnicov);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.nechaev2), R.drawable.nechaev);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.padaeva2), R.drawable.padaeva);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.pahomova2), R.drawable.pahomova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.petricheva_tu), R.drawable.senchakova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.pechkov2), R.drawable.pechkov);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.prokuratova2), R.drawable.prokuratova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.roshupkin2), R.drawable.roshp);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.rimanova), R.drawable.rymanova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.savvina2), R.drawable.savvina);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.safronova2), R.drawable.safronova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.simanovasaya2), R.drawable.kim);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.spirin2), R.drawable.spirin);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.tarov2), R.drawable.tarov);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.tarova2), R.drawable.tarova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.trofimova2), R.drawable.trofimova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.fortunova2), R.drawable.fortunova);
        movies.add(movie);
        movie = new TechClassAb(getResources().getString(R.string.chernousova2), R.drawable.chernousova);
        movies.add(movie);
        return movies;
    }
}
