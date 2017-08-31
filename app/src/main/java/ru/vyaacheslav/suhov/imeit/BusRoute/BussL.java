package ru.vyaacheslav.suhov.imeit.BusRoute;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import ru.vyaacheslav.suhov.imeit.R;

public class BussL extends Fragment {
    String[] catNames;
    Spinner spinner;
    ListView listView;

    public BussL() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_buss_l, container, false);
        spinner = v.findViewById(R.id.spiner2);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.bussRoute, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        listView = v.findViewById(R.id.lv);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                switch (position) {
                    // MF11
                    case 0:
                        catNames = new String[] {
                                "Посёлок Солидарность", "АЗС", "Мурзик", "Мурка", "Васька",
                                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                                "Китти", "Масяня", "Симба"
                        };

                        break;
                    // MI11
                    case 1:

                        catNames = new String[] {
                                "Дымка", "Кузя",
                                "Китти", "Масяня", "Симба"
                        };

                        break;
                }
                ArrayAdapter adapters = new ArrayAdapter<>(getActivity(),
                        android.R.layout.simple_list_item_1, catNames);

                listView.setAdapter(adapters);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });


        return v;
    }
}