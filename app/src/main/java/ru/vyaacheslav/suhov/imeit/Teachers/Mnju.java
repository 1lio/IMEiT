package ru.vyaacheslav.suhov.imeit.Teachers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.Toast;

import java.util.ArrayList;

import ru.vyaacheslav.suhov.imeit.R;

public class Mnju extends BaseAdapter implements Filterable {

    Context c;
    ArrayList<Movie> movies;
    LayoutInflater inflater;

    ArrayList<Movie> filterList;
    CustomFilter filter;

    public Mnju(Context c, ArrayList<Movie> movies) {
        this.c = c;
        this.movies = movies;
        this.filterList=movies;
    }

    //TOTLA NUM OF MOVIES
    @Override
    public int getCount() {
        return movies.size();
    }

    //GET A SINGLE MOVIE
    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    //IDENTITDIER
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if(inflater==null)
        {
            inflater= (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView==null)
        {
            convertView=inflater.inflate(R.layout.custom_list,null);
        }

        //BIND DATA TO VIEWS
        MyViewHolder holder=new MyViewHolder(convertView);
        holder.nameTxt.setText(movies.get(position).getName());
        holder.img.setBackgroundResource(movies.get(position).getImage());

        holder.setItemClickListener(new ItemClickListener() {
            @Override
            public void onItemClick(View v) {
                Toast.makeText(c,movies.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

        //RETURN A ROW
        return convertView;
    }

    @Override
    public Filter getFilter() {

        if(filter==null)
        {
            filter=new CustomFilter(filterList,this);
        }

        return filter;
    }
}
