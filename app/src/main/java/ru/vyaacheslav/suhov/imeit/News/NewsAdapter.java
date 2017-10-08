package ru.vyaacheslav.suhov.imeit.News;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.Target;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import ru.vyaacheslav.suhov.imeit.R;


public class NewsAdapter extends RecyclerView.Adapter<NewsViewHolder> {
    Context ctx;
    private List<News> newsList;
    private EventBus bus = EventBus.getDefault();

    public NewsAdapter(Context ctx) {
        this.ctx = ctx;
    }

    public NewsAdapter(List<News> newsList, Context ctx) {
        this.newsList = newsList;
        this.ctx = ctx;
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_row, parent, false);


        NewsViewHolder myViewHolder = new NewsViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        TextView textNewsSummary = holder.textNewsSummary;
        TextView textNewsTitle = holder.textNewsTitle;

        final News news = newsList.get(position);

        textNewsSummary.setText(news.getSummary());
        textNewsTitle.setText(newsList.get(position).getTitle());


        Log.e("url=", news.getImageUrl());
        Glide.with(ctx).load(news.getImageUrl())
                .thumbnail(0.5f)
                .crossFade()
                .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imgNews);

        holder.getItemView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bus.post(news);
            }
        });
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }


}
