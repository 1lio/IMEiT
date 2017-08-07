package ru.vyaacheslav.suhov.imeit.News;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import ru.vyaacheslav.suhov.imeit.R;


public class NewsViewHolder extends RecyclerView.ViewHolder {

    TextView textNewsTitle;
    TextView textNewsSummary;
    ImageView imgNews;
    View itemView;

    public NewsViewHolder(View itemView) {
        super(itemView);
        this.itemView=itemView;
        this.textNewsTitle = (TextView) itemView.findViewById(R.id.textTitle);
        this.textNewsSummary = (TextView) itemView.findViewById(R.id.textNewsSummary);
        this.imgNews = (ImageView) itemView.findViewById(R.id.imgNews);



    }

    public View getItemView() {
        return itemView;
    }

    public void setItemView(View itemView) {
        this.itemView = itemView;
    }
}
