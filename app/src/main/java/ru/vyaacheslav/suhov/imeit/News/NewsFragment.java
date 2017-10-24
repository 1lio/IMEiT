package ru.vyaacheslav.suhov.imeit.News;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import ru.vyaacheslav.suhov.imeit.R;

public class NewsFragment extends Fragment {

    public volatile List<News> newsList;
    EventBus bus;
    Thread trImeitNews;
    RecyclerView recyclerView;
    RelativeLayout newsBg;

    public NewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.news, container, false);

        recyclerView = v.findViewById(R.id.recyclerNews);
        newsBg = v.findViewById(R.id.news_bascgr);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mLayoutManager);
        bus = EventBus.getDefault();
        newsList = new ArrayList<>();

        ImeitNews imeitNews = new ImeitNews(newsList);

        trImeitNews = new Thread(imeitNews);

        trImeitNews.start();

        try {
            trImeitNews.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        fillRecycler();
        LoadPreferences();
        return v;
    }

    public void fillRecycler() {

        NewsAdapter newsAdapter = new NewsAdapter(newsList, getActivity());
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();

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
