package ru.vyaacheslav.suhov.imeit.Teachers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

import java.util.ArrayList;

import ru.vyaacheslav.suhov.imeit.R;

public class Mnju extends BaseAdapter implements Filterable {

    ArrayList<Movie> movies;
    private Context c;
    private LayoutInflater inflater;

    private ArrayList<Movie> filterList;
    private CustomFilter filter;


    Mnju(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
        this.filterList = movies;

    }


    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {


        if (inflater == null) {
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_list, null);
        }

        MyViewHolder holder = new MyViewHolder(convertView);
        holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setBackgroundResource(movies.get(position).getImage());



        return convertView;
    }

    @Override
    public Filter getFilter() {

        if (filter == null) {
            filter = new CustomFilter(filterList, this);
        }

        return filter;
    }
}
