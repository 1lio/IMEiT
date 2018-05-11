package ru.vyaacheslav.suhov.imeit.ftagments;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import ru.vyaacheslav.suhov.imeit.R;

public class Exzam extends Fragment {
    public Exzam() {}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_exzam, container, false);
        DatabaseHelper mDBHelper = new DatabaseHelper(getActivity());

        try {
            mDBHelper.updateDataBase();
        } catch (IOException mIOException) {
            throw new Error("UnableToUpdateDatabase");
        }

        SQLiteDatabase mDb = mDBHelper.getWritableDatabase();
        ArrayList<HashMap<String, Object>> clients = new ArrayList<>();
        HashMap<String, Object> client;

        Cursor cursor = mDb.rawQuery("SELECT * FROM FMiI11", null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            client = new HashMap<>();
            client.put("name",  cursor.getString(1));
            client.put("age",  cursor.getString(2));
            clients.add(client);
            cursor.moveToNext();
        }
        cursor.close();

        String[] from = { "name", "age"};
        int[] to = { R.id.tex1, R.id.tex2};

        SimpleAdapter adapter = new SimpleAdapter(getActivity(), clients, R.layout.custom_list, from, to);
        ListView listView = v.findViewById(R.id.listView);
        listView.setAdapter(adapter);

        return v;
    }
}