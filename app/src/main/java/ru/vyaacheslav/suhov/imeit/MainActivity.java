package ru.vyaacheslav.suhov.imeit;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
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
import android.widget.Toast;

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.Maps.MapsFragment;
import ru.vyaacheslav.suhov.imeit.News.NewsFragment;
import ru.vyaacheslav.suhov.imeit.OtherFragment.Info;
import ru.vyaacheslav.suhov.imeit.OtherFragment.TimeClock;

public class MainActivity extends AppCompatActivity {

    int NOTIFICATION_ID = 123;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;
    Toast toast;
    NotificationManager nm;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.shitstuff);

        calendar = Calendar.getInstance();

        Menu menu = navigationView.getMenu();
        MenuItem tools = menu.findItem(R.id.tools);
        MenuItem tools2 = menu.findItem(R.id.tools2);
        SpannableString s = new SpannableString(tools.getTitle());
        SpannableString b = new SpannableString(tools2.getTitle());
        s.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, s.length(), 0);
        b.setSpan(new TextAppearanceSpan(this, R.style.TextAppearance44), 0, b.length(), 0);
        tools.setTitle(s);
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
                if (item.getItemId() == R.id.examen) {
                    loadName();
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new Exam()).commit();


                }

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


        switch (position) {
            case 0:
                MainActivity.this.getSupportActionBar().setSubtitle("ФМиИ-11");
                break;
            case 1:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-11");
                break;
            case 2:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-12");
                break;
            case 3:
                MainActivity.this.getSupportActionBar().setSubtitle("ИСиТ-11");
                break;

            case 4:
                MainActivity.this.getSupportActionBar().setSubtitle("МИ-21");
                break;

            case 5:
                MainActivity.this.getSupportActionBar().setSubtitle("МФ-21");
                break;
            case 6:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-21");
                break;
            case 7:
                MainActivity.this.getSupportActionBar().setSubtitle("БИ-21");
                break;
            case 8:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-21");
                break;
            case 9:
                MainActivity.this.getSupportActionBar().setSubtitle("ИСиТ-21");
                break;
            case 10:
                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-21");
                break;
            case 11:
                MainActivity.this.getSupportActionBar().setSubtitle("БХ-21");
                break;
            case 12:
                MainActivity.this.getSupportActionBar().setSubtitle("ЕГ-21");
                break;
            case 13:
                MainActivity.this.getSupportActionBar().setSubtitle("МФ-31");
                break;
            case 14:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-31");
                break;
            case 15:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-31");
                break;
            case 16:
                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-31");
                break;
            case 17:
                MainActivity.this.getSupportActionBar().setSubtitle("М-41");
                break;
            case 18:
                MainActivity.this.getSupportActionBar().setSubtitle("ФМ-41");
                break;
            case 19:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-41");
                break;
            case 20:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-41");
                break;
            case 21:
                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-41");
                break;
            case 22:
                MainActivity.this.getSupportActionBar().setSubtitle("МиИТм-11");
                break;
            case 23:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМм-11");
                break;
            case 24:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВтМ-11");
                break;
            case 25:
                MainActivity.this.getSupportActionBar().setSubtitle("Мм-21");
                break;
            case 26:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМм-21");
                break;
            case 27:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТм-21");
                break;

        }
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

    public void dayNotifications() {


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
             /*   Intent intent = new Intent(MainActivity.this,MainActivity.class);*/

                builder12
              /*          .setContentIntent(PendingIntent.readPendingIntentOrNullFromParcel())*/
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


    }
}