package ru.vyaacheslav.suhov.imeit.News;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;


 class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView textNewsTitle;
    TextView textNewsSummary;
    ImageView imgNews;
    private View itemView;

    NewsViewHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        this.textNewsTitle = itemView.findViewById(R.id.textTitle);
        this.textNewsSummary = itemView.findViewById(R.id.textNewsSummary);
        this.imgNews = itemView.findViewById(R.id.imgNews);
    }

    View getItemView() {
        return itemView;
    }

}
