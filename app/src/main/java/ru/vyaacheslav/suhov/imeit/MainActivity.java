package ru.vyaacheslav.suhov.imeit;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.view.Menu;
import android.view.MenuItem;

import ru.vyaacheslav.suhov.imeit.News.NewsFragment;
import ru.vyaacheslav.suhov.imeit.OtherFragment.TimeClock;


public class MainActivity extends AppCompatActivity {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView = (NavigationView) findViewById(R.id.shitstuff);

        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit();

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
                    MainActivity.this.getSupportActionBar().setSubtitle("Новости");
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new NewsFragment()).commit();

                }
                return false;
            }
        });


        toolbar = (Toolbar) findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        loadName();
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

    public void loadName(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        int position= sharedPreferences .getInt("name",-1);

        switch (position){
            case 0:
                MainActivity.this.getSupportActionBar().setSubtitle("МФ-11");
                break;
            case 1:
                MainActivity.this.getSupportActionBar().setSubtitle("МИ-11");
                break;
            case 2:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-11");
                break;
            case 3:
                MainActivity.this.getSupportActionBar().setSubtitle("БИ-11");
                break;
            case 4:
                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-11");
                break;
            case 5:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-11");
                break;
            case 6:
                MainActivity.this.getSupportActionBar().setSubtitle("ИСиТ-11");
                break;
            case 7:
                MainActivity.this.getSupportActionBar().setSubtitle("МФ-21");
                break;
            case 8:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-21");
                break;
            case 9:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-21");
                break;
            case 10:
                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-21");
                break;
            case 11:
                MainActivity.this.getSupportActionBar().setSubtitle("М-31");
                break;
            case 12:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-31");
                break;
            case 13:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-31");
                break;
            case 14:
                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-31");
                break;
            case 15:
                MainActivity.this.getSupportActionBar().setSubtitle("М-41");
                break;
            case 16:
                MainActivity.this.getSupportActionBar().setSubtitle("ФМ-41");
                break;
            case 17:
                MainActivity.this.getSupportActionBar().setSubtitle("ПМ-41");
                break;
            case 18:
                MainActivity.this.getSupportActionBar().setSubtitle("ИиВТ-41");
                break;
            case 19:

                MainActivity.this.getSupportActionBar().setSubtitle("НЭ-41");
                break;
            case 20:
                MainActivity.this.getSupportActionBar().setSubtitle("ИБ-41");
                break;

        }
    }
}