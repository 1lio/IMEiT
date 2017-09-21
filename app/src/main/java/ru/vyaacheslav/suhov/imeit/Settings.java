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

    public Spinner spinner;
    public Switch eng, dec/*, vid*/;
    public RadioGroup rg;
    public RadioButton r_s, r_d;
    public TextView name1, name2, name3, uss;
    RelativeLayout setm;
    LinearLayout l1, l2, mama;
    Toolbar toolbar;
    ImageView imageView;
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
     /*   vid = (Switch) findViewById(R.id.sw_ve);*/
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
        SharedPreferences des = getSharedPreferences("dec", 1);
        dec.setChecked(des.getBoolean("check", false));

       /* vids();*/
        setBg();
        themeSettings();

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
                doSaves();
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

     /*   vid.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (vid.isChecked()) {

                    r_s.setChecked(true);
                    r_s.setClickable(false);
                    r_d.setClickable(false);
                    setm.setBackgroundResource(R.color.colorWhitee);
                    name1.setTextSize(20);
                    name2.setTextSize(20);
                    name3.setTextSize(20);
                    eng.setTextSize(18);
                    dec.setTextSize(18);
                    r_d.setTextSize(18);
                    r_s.setTextSize(18);
                    vid.setTextSize(18);
                    uss.setTextSize(18);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkD));
                    }

                    toolbar.setBackgroundResource(R.color.colorPrimaryD);
////sx

                    eng.setTypeface(Typeface.DEFAULT_BOLD);
                    dec.setTypeface(Typeface.DEFAULT_BOLD);
                    r_d.setTypeface(Typeface.DEFAULT_BOLD);
                    r_s.setTypeface(Typeface.DEFAULT_BOLD);
                    vid.setTypeface(Typeface.DEFAULT_BOLD);

                    name1.setTypeface(Typeface.DEFAULT_BOLD);
                    name2.setTypeface(Typeface.DEFAULT_BOLD);
                    name3.setTypeface(Typeface.DEFAULT_BOLD);

                    name1.setTextColor(getResources().getColor(R.color.colorTextBlack));
                    name2.setTextColor(getResources().getColor(R.color.colorTextBlack));
                    name3.setTextColor(getResources().getColor(R.color.colorTextBlack));
                    vid.setTextColor(getResources().getColor(R.color.colorTextBlack));
                } else {

                    r_s.setChecked(true);
                    r_s.setClickable(true);
                    r_d.setClickable(true);

                    l1.setBackgroundResource(R.color.colorNewstitle);
                    l2.setBackgroundResource(R.color.colorNewstitle);
                    l3.setBackgroundResource(R.color.colorNewstitle);
                    l4.setBackgroundResource(R.color.colorNewstitle);

                    name1.setTextSize(16);
                    name2.setTextSize(16);
                    name3.setTextSize(16);
                    eng.setTextSize(14);
                    dec.setTextSize(14);
                    r_d.setTextSize(14);
                    r_s.setTextSize(14);
                    vid.setTextSize(14);
                    uss.setTextSize(14);

                    eng.setTypeface(Typeface.DEFAULT);
                    dec.setTypeface(Typeface.DEFAULT);
                    r_d.setTypeface(Typeface.DEFAULT);
                    r_s.setTypeface(Typeface.DEFAULT);
                    vid.setTypeface(Typeface.DEFAULT);
                    name1.setTypeface(Typeface.DEFAULT);
                    name2.setTypeface(Typeface.DEFAULT);
                    name3.setTypeface(Typeface.DEFAULT);

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        Window window = getWindow();
                        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                    }
                    toolbar.setBackgroundResource(R.color.colorPrimary);
                }
                SharedPreferences settings = getSharedPreferences("vid", 3);
                SharedPreferences.Editor editor = settings.edit();

                boolean checkBoxValue = vid.isChecked();
                editor.putBoolean("check", checkBoxValue);
                editor.apply();
                doSaves();

                saves();

            }
        });*/
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.r_svet:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            Window window = getWindow();
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
                        }
                        toolbar.setBackgroundResource(R.color.colorPrimary);
                        l1.setBackgroundResource(R.color.colorNewstitle);
                        l2.setBackgroundResource(R.color.colorNewstitle);
                     /*   l3.setBackgroundResource(R.color.colorNewstitle);
                        l4.setBackgroundResource(R.color.colorNewstitle);*/

                        setm.setBackgroundResource(R.color.colorWhitee);

                        name1.setTextColor(getResources().getColor(R.color.colorTextBlack));
                        name2.setTextColor(getResources().getColor(R.color.colorTextBlack));
                        name3.setTextColor(getResources().getColor(R.color.colorTextBlack));
                   /*     vid.setTextColor(getResources().getColor(R.color.colorTextBlack));*/

                        SharedPreferences settings = getSharedPreferences("status", 0);
                        SharedPreferences.Editor editor = settings.edit();

                        boolean checkBoxValue = dec.isChecked();
                        editor.putBoolean("blue", checkBoxValue);
                        editor.apply();

                        break;
                    case R.id.r_dark:

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            Window window = getWindow();
                            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkD));
                        }
                        l1.setBackgroundResource(R.color.colorSigma);
                        l2.setBackgroundResource(R.color.colorSigma);
                       /* l3.setBackgroundResource(R.color.colorSigma);
                        l4.setBackgroundResource(R.color.colorSigma);*/

                        toolbar.setBackgroundResource(R.color.colorPrimaryD);
                        setm.setBackgroundResource(R.color.colorPrimaryS);
                        name1.setTextColor(getResources().getColor(R.color.colorWhitee));
                        name2.setTextColor(getResources().getColor(R.color.colorWhitee));
                        name3.setTextColor(getResources().getColor(R.color.colorWhitee));
                      /*  vid.setTextColor(getResources().getColor(R.color.colorWhitee));*/

                        SharedPreferences settingsa = getSharedPreferences("status", 0);
                        SharedPreferences.Editor editors = settingsa.edit();

                        boolean checkBoxValues = dec.isChecked();
                        editors.putBoolean("orange", checkBoxValues);
                        editors.apply();
                        break;

                    default:
                        break;
                }
                saves();
            }
        });
    }

    private void themeSettings() {

        SharedPreferences sharedPreferences = this.getSharedPreferences("gameSetting", Context.MODE_PRIVATE);
        if (sharedPreferences != null) {

            int checkedRadioButtonId = sharedPreferences.getInt("checkedRadioButtonId", R.id.r_svet);
            rg.check(checkedRadioButtonId);

        } else {
            rg.check(R.id.r_svet);

        }

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

   /* public void vids() {
        SharedPreferences settings = this.getSharedPreferences("vid", 3);
        vid.setChecked(settings.getBoolean("check", false));
        if (vid.isChecked()) {
            name1.setTextSize(20);
            name2.setTextSize(20);
            name3.setTextSize(20);
            eng.setTextSize(18);
            dec.setTextSize(18);
            r_d.setTextSize(18);
            r_s.setTextSize(18);
            vid.setTextSize(18);
            name1.setTypeface(Typeface.DEFAULT_BOLD);
            name2.setTypeface(Typeface.DEFAULT_BOLD);
            name3.setTypeface(Typeface.DEFAULT_BOLD);
        } else {
            name1.setTextSize(16);
            name2.setTextSize(16);
            name3.setTextSize(16);

            name1.setTypeface(Typeface.DEFAULT);
            name2.setTypeface(Typeface.DEFAULT);
            name3.setTypeface(Typeface.DEFAULT);
        }
    }*/

    public void saves() {
        SharedPreferences settings = getSharedPreferences("status", 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean("blue", r_s.isChecked());
        editor.putBoolean("orange", r_d.isChecked());
        editor.apply();

    }
}