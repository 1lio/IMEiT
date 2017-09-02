package ru.vyaacheslav.suhov.imeit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        spinner = (Spinner)findViewById(R.id.spinner);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Settings.this.getSupportActionBar().setSubtitle("Настройки");

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bak_groops, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {

                int spinnerPosition = spinner.getSelectedItemPosition();

                switch (position) {
                    // MF11
                    case 0:
                        break;
                    // MI11
                    case 1:
                        break;

                }
                saveSpinnerPosition(spinnerPosition);
                saveSpinnerPositionName(spinnerPosition);
                Toast toast = Toast.makeText(getApplicationContext(),
                         "Настройки обновлены", Toast.LENGTH_SHORT);
                toast.show();

            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Settings.this, MainActivity.class);
        startActivity(i);
        finish();
    }
    public void saveSpinnerPosition(int position){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("spnCalorieRange",position);
        editor.apply();
    }

    public void saveSpinnerPositionName(int position){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("name",position);
        editor.apply();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent i = new Intent(Settings.this, MainActivity.class);
                startActivity(i);
                finish();
                return true;

            default:

        }
        return super.onOptionsItemSelected(item);
    }
}

