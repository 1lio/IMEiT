package ru.vyaacheslav.suhov.imeit.Note;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ru.vyaacheslav.suhov.imeit.R;

public class Note extends Fragment {

    DbHelper dbHelper;
    ArrayAdapter<String> mAdapter;
    ListView lstTask;
    ImageView newNote, del;
    public Note() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.note_list, container, false);

        del = v.findViewById(R.id.btnDelete);
        dbHelper = new DbHelper(getActivity());
        lstTask = (ListView)v.findViewById(R.id.lstTask);
        newNote = (ImageView) v.findViewById(R.id.newNote);

        newNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final EditText taskEditText = new EditText(getActivity());
                AlertDialog dialog = new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)

                        .setTitle("Новая заметка")
                        .setMessage("Добавте описание заметки")
                        .setView(taskEditText)
                        .setPositiveButton("Добавить", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String task = String.valueOf(taskEditText.getText());
                                dbHelper.insertNewTask(task);
                                loadTaskList();
                            }
                        })
                        .setNegativeButton("Отмена",null)
                        .create();
                dialog.show();

            }
        });

        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View parent = (View)view.getParent();
                TextView taskTextView = (TextView)parent.findViewById(R.id.task_title);
                Log.e("String", (String) taskTextView.getText());
                String task = String.valueOf(taskTextView.getText());
                dbHelper.deleteTask(task);
                loadTaskList();
            }
        });

        loadTaskList();
        return v;
    }

 private void loadTaskList() {
        ArrayList<String> taskList = dbHelper.getTaskList();
        if(mAdapter==null){
            mAdapter = new ArrayAdapter<String>(getActivity(),R.layout.note_row,R.id.task_title,taskList);
            lstTask.setAdapter(mAdapter);
        }
        else{
            mAdapter.clear();
            mAdapter.addAll(taskList);
            mAdapter.notifyDataSetChanged();
        }
    }

}
