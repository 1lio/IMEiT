package ru.vyaacheslav.suhov.imeit.Teachers;

import android.widget.Filter;

import java.util.ArrayList;

public class CustomFilter extends Filter {

    private ArrayList<TechClassAb> filterList;
    private TechAdapterAb adapter;

     CustomFilter(ArrayList<TechClassAb> filterList, TechAdapterAb adapter) {
        this.filterList = filterList;
        this.adapter = adapter;
    }

    @Override
    protected FilterResults performFiltering(CharSequence constraint) {


        FilterResults results=new FilterResults();

        if(constraint != null && constraint.length()>0)
        {


            constraint=constraint.toString().toUpperCase();

            ArrayList<TechClassAb> filteredMovies=new ArrayList<>();

            for(int i=0;i<filterList.size();i++)
            {
                //FILTER
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    filteredMovies.add(filterList.get(i));
                }
            }

            results.count=filteredMovies.size();
            results.values=filteredMovies;
        }else
        {
            results.count=filterList.size();
           results.values=filterList;
        }

        return results;
    }


    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.movies= (ArrayList<TechClassAb>) results.values;
        adapter.notifyDataSetChanged();

    }
}
