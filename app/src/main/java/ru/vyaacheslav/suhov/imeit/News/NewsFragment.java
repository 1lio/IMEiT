package ru.vyaacheslav.suhov.imeit.News;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import ru.vyaacheslav.suhov.imeit.R;

public class NewsFragment extends Fragment {


    public volatile List<News> newsList;
    Thread trKurdpress;
    RecyclerView recyclerView;
    public NewsFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.news, container, false);

        recyclerView = v.findViewById(R.id.recyclerNews);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(mLayoutManager);
        EventBus bus = EventBus.getDefault();
        bus.register(this);
        newsList=new ArrayList<>();

        ImeitNews imeitNews =new ImeitNews(newsList);

        trKurdpress=new Thread(imeitNews);

        trKurdpress.start();

        try {
            trKurdpress.join();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }



        fillRecycler();
        return v;
    }



    public void fillRecycler(){

        NewsAdapter newsAdapter=new NewsAdapter(newsList,getActivity());
        recyclerView.setAdapter(newsAdapter);
        newsAdapter.notifyDataSetChanged();

    }

    @Subscribe(threadMode = ThreadMode.MAIN)

    public void doAction(News news)  {

        String newsUrl =news.getNewsUrl();

        Log.e("url is=,",newsUrl);
        Intent i=new Intent(getActivity(),CompleteNewsActivity.class);
        i.putExtra("newsURL",newsUrl);
        startActivity(i);
    }

}
