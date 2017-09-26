package ru.vyaacheslav.suhov.imeit;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableString;
import android.text.style.TextAppearanceSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.Maps.MapsFragment;
import ru.vyaacheslav.suhov.imeit.News.NewsFragment;
import ru.vyaacheslav.suhov.imeit.OtherFragment.Info;
import ru.vyaacheslav.suhov.imeit.OtherFragment.TimeClock;

public class MainActivity extends AppCompatActivity {
    public static final String APP_PREFERENCES = "sasa";
    final String KEY_RADIOBUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";
    public RadioGroup rg;
    RelativeLayout dexp;
    int NOTIFICATION_ID = 123;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;
    Toast toast;
    NotificationManager nm;
    Calendar calendar;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeWrithe);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);
        } else {
        }
        prefs.edit().putBoolean("isFirstRun", false).apply();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.shitstuff);
        dexp = (RelativeLayout) findViewById(R.id.dexs);
        rg = (RadioGroup) findViewById(R.id.rg);

        calendar = Calendar.getInstance();

        Menu menu = navigationView.getMenu();
        MenuItem tools2 = menu.findItem(R.id.tools2);
        SpannableString b = new SpannableString(tools2.getTitle());
        b.setSpan(new TextAppearanceSpan(this, R.style.MenuLine), 0, b.length(), 0);
        tools2.setTitle(b);

        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit();

        nm = (NotificationManager)getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);


        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();


                if (item.getItemId() == R.id.main_tab) {
                    loadName();
                    FragmentTransaction fragmentTransaction = FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (item.getItemId() == R.id.you_tab) {
                    MainActivity.this.getSupportActionBar().setSubtitle("Время звонков");
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new TimeClock()).commit();

                }
                if (item.getItemId() == R.id.news) {
                    isNetworkConnected();

                }

                if (item.getItemId() == R.id.info) {
                    MainActivity.this.getSupportActionBar().setSubtitle("Основные сведения");
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new Info()).commit();

                }
          /*      if (item.getItemId() == R.id.examen) {
                    loadName();
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new Exam()).commit();
                }*/

                if (item.getItemId() == R.id.map) {
                    MainActivity.this.getSupportActionBar().setSubtitle("Учебные корпуса");
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new MapsFragment()).commit();
                }
                return false;
            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadName();
        LoadPreferences();

      /*  dayNotifications();*/
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, Settings.class);
                startActivity(intent);
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadName() {

        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int position = sharedPreferences.getInt("name", -1);
        String[] choose = getResources().getStringArray(R.array.bak_groops);
        MainActivity.this.getSupportActionBar().setSubtitle(choose[position]);

    }

    private boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo ni = cm.getActiveNetworkInfo();
        if (ni == null) {
            toast = Toast.makeText(getApplicationContext(), "Проверте интернет соединение", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        } else
            MainActivity.this.getSupportActionBar().setSubtitle("Новости");
        FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
        fragmentTransaction1.replace(R.id.containerView, new NewsFragment()).commit();

        return true;
    }

   /* public void dayNotifications() {


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int position = sharedPreferences.getInt("name", -1);

        int day = calendar.get(Calendar.DAY_OF_WEEK);
        switch (day) {
            case Calendar.SUNDAY:

                break;
            case Calendar.MONDAY:
                switch (position){
                    case 0:

                        Notification.Builder builder = new Notification.Builder(getApplicationContext());

                        builder
                                .setSmallIcon(R.drawable.notif)
                                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_mat))
                                .setTicker("Расписание на понедельник")
                                .setWhen(System.currentTimeMillis())
                                .setAutoCancel(true)
                                .setContentTitle("Понедельник:")
                                .setContentText("1пара - Математика; 2пара - История");
                        Notification notification = builder.build();

                        nm.notify(NOTIFICATION_ID, notification);
                        break;
                    case 1:


                        Notification.Builder builder2 = new Notification.Builder(getApplicationContext());

                        builder2
                                .setSmallIcon(R.drawable.notif)
                                .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_mat))
                                .setTicker("Расписание на понедельник")
                                .setWhen(System.currentTimeMillis())
                                .setAutoCancel(true)
                                .setContentTitle("Понедельник:")
                                .setContentText("1пара - Физика; 2пара - Математика");
                        Notification notification2 = builder2.build();

                        nm.notify(NOTIFICATION_ID, notification2);
                        break;
                }

                break;
            case Calendar.TUESDAY:
                // Вт.
                break;
            case Calendar.WEDNESDAY:
                // Вт.
                break;
            case Calendar.THURSDAY:

                Notification.Builder builder12 = new Notification.Builder(getApplicationContext());
             *//*   Intent intent = new Intent(MainActivity.this,MainActivity.class);*//*

                builder12
              *//*          .setContentIntent(PendingIntent.readPendingIntentOrNullFromParcel())*//*
                        .setSmallIcon(R.drawable.notif)
                        .setLargeIcon(BitmapFactory.decodeResource(getApplication().getResources(), R.drawable.ic_mat))
                        .setTicker("Расписание на четверг")
                        .setWhen(System.currentTimeMillis())
                        .setAutoCancel(true)
                        .setContentTitle("Четверг:")
                        .setContentText("1пара - веты; 2пара - Математика");
                Notification notification2 = builder12.build();

                nm.notify(NOTIFICATION_ID, notification2);
                break;
            case Calendar.FRIDAY:
                break;
        }
    }*/

    private void LoadPreferences() {
        SharedPreferences sharedPreferences = getSharedPreferences(
                APP_PREFERENCES, MODE_PRIVATE);
        int savedRadioIndex = sharedPreferences.getInt(
                KEY_RADIOBUTTON_INDEX, 0);
        switch (savedRadioIndex) {
            case 0:
                ThemeWrithe();
                break;
            case 1:
                ThemeDark();
                break;
        }
    }

    public void ThemeWrithe() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));

        }
        navigationView.setBackgroundResource(R.color.colorWhitee);
        navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        navigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        toolbar.setBackgroundResource(R.color.colorPrimary);
    }

    public void ThemeDark() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkD));
        }
        navigationView.setBackgroundResource(R.color.colorPrimarySS);
        navigationView.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        navigationView.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        toolbar.setBackgroundResource(R.color.colorPrimaryD);
    }

}