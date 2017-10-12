package ru.vyaacheslav.suhov.imeit;

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
import android.widget.RelativeLayout;
import android.widget.Toast;

import ru.vyaacheslav.suhov.imeit.Maps.MapsFragment;
import ru.vyaacheslav.suhov.imeit.News.NewsFragment;
import ru.vyaacheslav.suhov.imeit.OtherFragment.Info;
import ru.vyaacheslav.suhov.imeit.OtherFragment.TimeClock;

public class MainActivity extends AppCompatActivity {

    public NavigationView navigationView;
    public DrawerLayout drawerLayout;
    public FragmentTransaction FT;
    public RelativeLayout dexp;
    public FragmentManager FM;
    public Toolbar toolbar;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(R.style.ThemeWrithe);
        setContentView(R.layout.activity_main);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            Intent intent = new Intent(MainActivity.this, SettingsPref.class);
            startActivity(intent);
        } else { }
        prefs.edit().putBoolean("isFirstRun", false).apply();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        navigationView = (NavigationView) findViewById(R.id.shitstuff);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        dexp = (RelativeLayout) findViewById(R.id.dexs);

        // Костомизация меню. Вообщем ненужная хрень. Нужно убрать потом
        Menu menu = navigationView.getMenu();
        MenuItem tools2 = menu.findItem(R.id.tools2);
        SpannableString b = new SpannableString(tools2.getTitle());
        b.setSpan(new TextAppearanceSpan(this, R.style.MenuLine), 0, b.length(), 0); // Меняем цвет полоски разделяющей группы
        tools2.setTitle(b);

        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit();

        // Обработка нажатий на пункты меню. Я все это знаю - передаю потомкам

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                if (item.getItemId() == R.id.main_tab) {
                    loadName();
                    FragmentTransaction fragmentTransaction = FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();                        // Нужно автоматизировать эту хрень
                    Toast.makeText(getApplicationContext(), "Текущая неделя: Знаменатель", Toast.LENGTH_SHORT).show();  // Вызов тоста о том какая неделя
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
                    MainActivity.this.getSupportActionBar().setSubtitle("Контакты");
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new Info()).commit();
                }

                if (item.getItemId() == R.id.map) {
                    MainActivity.this.getSupportActionBar().setSubtitle("Учебные корпуса");
                    FragmentTransaction fragmentTransaction1 = FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView, new MapsFragment()).commit();
                }
                return false;
            }
        });

        loadName(); // Загрузка имени группы согласно настройкам
        LoadPreferences(); //  Загрузка темы основной темы приложения
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, SettingsPref.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.ssas:
                toast = Toast.makeText(getApplicationContext(), "Текущая неделя: Знаменатель", Toast.LENGTH_SHORT);
                toast.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void loadName() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); // Название группы берется из String-array
        String regular = prefs.getString(getString(R.string.pref_style), "");
        MainActivity.this.getSupportActionBar().setSubtitle(regular);
    }


    private boolean isNetworkConnected() { // Обход ошибки соеденения с помощью велосипеда
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

    private void LoadPreferences() {

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String regular = prefs.getString(getString(R.string.pref_theme), "");

        switch (regular) {
            case "Светлая":
                ThemeWrithe();
                break;
            case "Темная":
                ThemeDark();
                break;
        }
    }
    // Кастомизация тем  Светлая и Темная
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