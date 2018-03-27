package ru.vyaacheslav.suhov.imeit.Activities;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import ru.vyaacheslav.suhov.imeit.MainActivity;
import ru.vyaacheslav.suhov.imeit.R;
import ru.vyaacheslav.suhov.imeit.SettingsPref;

public class Docks extends AppCompatActivity {

    public TextView names, subnames,types,corps,znames,zsubnames,ztypes , zcorps;
    public TextView spDay, spPara;

    public SharedPreferences prefs;
    public String typeTheme,typeWeek, typeGroupe;
    FloatingActionButton fab;

    EditText editText;

    private static final String TAG = "Note";

    DatabaseHelper mDatabaseHelper;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        typeTheme = prefs.getString(getString(R.string.pref_theme), "");
        typeWeek = prefs.getString(getString(R.string.week_i), "");
        typeGroupe = prefs.getString(getString(R.string.pref_style), "");

        if (Objects.equals(typeTheme, "Светлая")) {
            setTheme(R.style.ThemeWrithe);
        }
        if(Objects.equals(typeTheme, "Темная")) {
            setTheme(R.style.ThemeDark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docks);

        Toolbar bar = findViewById(R.id.toolbar_zam);
        fab = findViewById(R.id.fab);

        bar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Docks.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        names = findViewById(R.id.name_z);
        subnames = findViewById(R.id.sub_name_z);
        types = findViewById(R.id.type_z);
        corps = findViewById(R.id.corp_z);
        znames = findViewById(R.id.z_name_z);
        zsubnames = findViewById(R.id.z_subname_z);
        ztypes = findViewById(R.id.ztype_z);
        zcorps = findViewById(R.id.z_coprz);
        editText = findViewById(R.id.editText);

        spDay =findViewById(R.id.spinner1);
        spPara =findViewById(R.id.spinner2);

        Intent intent = getIntent();

        final String day = intent.getStringExtra("day");
        final String para = intent.getStringExtra("para");

        final String name = intent.getStringExtra("name");
        final String subname = intent.getStringExtra("subname");
        final String type = intent.getStringExtra("type");
        final String corp = intent.getStringExtra("corp");
        final String zname = intent.getStringExtra("zname");
        final String zsubname = intent.getStringExtra("zsubname");
        final  String ztype = intent.getStringExtra("ztype");
        final  String zcorp = intent.getStringExtra("zcorp");

        spDay.setText(day);
        spPara.setText(para);

        names.setText(name);
        subnames.setText(subname);
        types .setText(type);
        corps.setText(corp);
        znames.setText(zname);
        zsubnames.setText(zsubname);
        ztypes.setText(ztype);
        zcorps.setText(zcorp);

        mDatabaseHelper = new DatabaseHelper(this);

        // TODO сделать переход по кнопке в лист

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {
                    AddData(newEntry);
                    editText.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }


            }
        });
    }

    public void AddData(String newEntry) {
        boolean insertData = mDatabaseHelper.addData(newEntry);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

    /**
     * customizable toast
     * @param message
     */
    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}


