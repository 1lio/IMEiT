package ru.vyaacheslav.suhov.imeit.NewsPa;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import ru.vyaacheslav.suhov.imeit.R;

public class FragmentN extends Fragment {

    View v;
    RelativeLayout newsBg;
    private ArrayList<Artilharia> artilharias;
    private ArtilhariaAdapter adapter;

    public FragmentN() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         v = inflater.inflate(R.layout.news_pa, container, false);
        newsBg = v.findViewById(R.id.news_bascgr);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        if (savedInstanceState != null) {
            artilharias = savedInstanceState.getParcelableArrayList(Artilharia.ART_KEY);
            initViews();
            retrieverArtStream();
        } else {
            artilharias = new ArrayList<>();
            initViews();
            retrieverArt();
        }


        LoadPreferences();
        return v;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putParcelableArrayList(Artilharia.ART_KEY, artilharias);
        super.onSaveInstanceState(outState);
    }

    private void initViews(){
        RecyclerView recyclerView = v.findViewById(R.id.rv_artilharia);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager mLinearManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLinearManager);

        DividerItemDecoration divider = new DividerItemDecoration(getActivity(),mLinearManager.getOrientation());
        recyclerView.addItemDecoration(divider);

        adapter = new ArtilhariaAdapter(getActivity(), artilharias);
        recyclerView.setAdapter(adapter);
    }

    public void retrieverArt(){
        new SearchArtilhariaRequest(this).execute();
        retrieverArtStream();
    }

    public void retrieverArtStream(){
        new Worker(this).start();
    }

    public void updateLista(List<Artilharia> a){
        artilharias.clear();
        artilharias.addAll(a);
        adapter.notifyDataSetChanged();
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
        newsBg.setBackgroundResource(R.color.colorWhitee);
    }

    public void ThemeDark() {
        newsBg.setBackgroundResource(R.color.colorPrimaryF);
    }
}
