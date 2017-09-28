package ru.vyaacheslav.suhov.imeit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    public static final String APP_PREFERENCES = "sasa";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    public Spinner spinner;
    public Switch eng, dec/*, vid*/, sw_save;
    public RadioGroup rg;
    public RadioButton r_s, r_d;
    public TextView name1, name2, name3, uss;
    public RelativeLayout setm;
    public LinearLayout l1, l2, mama;
    public Toolbar toolbar;
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        imageView = (ImageView) findViewById(R.id.imageView);
        spinner = (Spinner)findViewById(R.id.spinner);
        l1 = (LinearLayout) findViewById(R.id.ll1);
        l2 = (LinearLayout) findViewById(R.id.ll2);

        mama = (LinearLayout) findViewById(R.id.mama);

        eng = (Switch) findViewById(R.id.sw_eng);
        dec = (Switch) findViewById(R.id.sw_dec);
        sw_save = (Switch) findViewById(R.id.sw_save);
        rg = (RadioGroup) findViewById(R.id.rg);
        r_s = (RadioButton) findViewById(R.id.r_svet);
        r_d = (RadioButton) findViewById(R.id.r_dark);
        setm = (RelativeLayout) findViewById(R.id.setm);

        name1 = (TextView) findViewById(R.id.name1);
        name2 = (TextView) findViewById(R.id.name2);
        name3 = (TextView) findViewById(R.id.name3);
        uss = (TextView) findViewById(R.id.uss);

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
                saveP();
            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        SharedPreferences settings = getSharedPreferences("mysettings", 0);
        eng.setChecked(settings.getBoolean("check", false));
       /* SharedPreferences des = getSharedPreferences("dec", 1);
        dec.setChecked(des.getBoolean("zszs", false));*/
        /*SharedPreferences savess = getSharedPreferences("saves", 2);
        sw_save.setChecked(savess.getBoolean("af", false));*/
        LoadP();
        LoadPreferences();
        setBg();
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(Settings.this, MainActivity.class);
        startActivity(i);
        imageView.setVisibility(View.VISIBLE);
        mama.setVisibility(View.GONE);
        doSaves();
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
                imageView.setVisibility(View.VISIBLE);
                mama.setVisibility(View.GONE);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void saveP() {

        int spinnerPosition = spinner.getSelectedItemPosition();
        String[] choose = getResources().getStringArray(R.array.bak_groops);
        saveSpinnerPosition(spinnerPosition);
        saveSpinnerPositionName(spinnerPosition);
        Toast toast = Toast.makeText(getApplicationContext(),
                "Выбранна группа: " + choose[spinnerPosition], Toast.LENGTH_SHORT);
        toast.show();
    }
    public void setBg() {

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton checkedRadioButton = radioGroup.findViewById(i);
                int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);
                SavePreferences(KEY_RADIOBUTTON_INDEX, checkedIndex);
                switch (i) {
                    case R.id.r_svet:
                        ThemeWrithe();
                        break;
                    case R.id.r_dark:
                        ThemeDark();
                        break;
                }
            }
        });

        eng.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences settings = getSharedPreferences("mysettings", 0);
                SharedPreferences.Editor editor = settings.edit();
                boolean checkBoxValue = eng.isChecked();
                editor.putBoolean("check", checkBoxValue);
                editor.apply();
            }
        });

        dec.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences settings = getSharedPreferences("dec", 1);
                SharedPreferences.Editor editor = settings.edit();
                boolean checkBoxValue = dec.isChecked();
                editor.putBoolean("check", checkBoxValue);
                editor.apply();
            }
        });

        sw_save.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                SharedPreferences sa = getSharedPreferences("saves", 2);
                SharedPreferences.Editor editor = sa.edit();
                boolean checkBoxValue = sw_save.isChecked();
                editor.putBoolean("af", checkBoxValue);
                editor.apply();
            }
        });
    }

    private void SavePreferences(String key, int value) {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton) rg.getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
        switch (savedRadioIndex) {
            case 0:
                ThemeWrithe();
                break;
            case 1:
                ThemeDark();
                break;
        }
    }

    public void LoadPosition() {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int position = sharedPreferences.getInt("name", -1);
        spinner.setSelection(position);
    }

    public void doSaves() {

        SharedPreferences sharedPreferences = this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        int checkedRadioButtonId = rg.getCheckedRadioButtonId();
        if (sharedPreferences != null) {

            int checkedRadioButtonIds = sharedPreferences.getInt("checkedRadioButtonId", R.id.r_svet);
            rg.check(checkedRadioButtonIds);
            setm.setBackgroundResource(R.color.colorWhitee);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkD));
            }
            toolbar.setBackgroundResource(R.color.colorPrimaryD);

        } else {
            rg.check(R.id.r_svet);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
            }
            toolbar.setBackgroundResource(R.color.colorPrimary);
            setm.setBackgroundResource(R.color.colorWhitee);

        }

        editor.putInt("checkedRadioButtonId", checkedRadioButtonId);
        editor.apply();
    }

    public void LoadP() {
      /*  SharedPreferences settings = getSharedPreferences("saves", 2);
        sw_save.setChecked(settings.getBoolean("af", false));
        if (sw_save.isChecked()) {
            LoadPosition();
        }*/

    }

    public void ThemeWrithe() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        toolbar.setBackgroundResource(R.color.colorPrimary);
        l1.setBackgroundResource(R.color.colorNewstitle);
        l2.setBackgroundResource(R.color.colorNewstitle);

        setm.setBackgroundResource(R.color.colorWhitee);
        name1.setTextColor(getResources().getColor(R.color.colorTextBlack));
        name2.setTextColor(getResources().getColor(R.color.colorTextBlack));
        name3.setTextColor(getResources().getColor(R.color.colorTextBlack));
    }

    public void ThemeDark() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkD));
        }
        l1.setBackgroundResource(R.color.colorSigma);
        l2.setBackgroundResource(R.color.colorSigma);

        toolbar.setBackgroundResource(R.color.colorPrimaryD);
        setm.setBackgroundResource(R.color.colorPrimaryS);
        name1.setTextColor(getResources().getColor(R.color.colorWhitee));
        name2.setTextColor(getResources().getColor(R.color.colorWhitee));
        name3.setTextColor(getResources().getColor(R.color.colorWhitee));
    }
}