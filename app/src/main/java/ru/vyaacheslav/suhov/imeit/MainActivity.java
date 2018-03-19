package ru.vyaacheslav.suhov.imeit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

import ru.vyaacheslav.suhov.imeit.Maps.MapsFragment;
import ru.vyaacheslav.suhov.imeit.OtherFragment.TimeClock;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ActionBarDrawerToggle toggle;
    public java.util.Calendar calendar;
    public FragmentTransaction FT;
    public FragmentManager FM;
    public FrameLayout fl;
    int weekYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    SharedPreferences   prefs;
    private Menu menu;
    private Toolbar tb;
    private DrawerLayout dl;
    private NavigationView nv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        String regular = prefs.getString(getString(R.string.pref_theme), "");
        if (Objects.equals(regular, "Светлая")) {
            setTheme(R.style.ThemeWrithe);
        }
        if(Objects.equals(regular, "Темная")) {
            setTheme(R.style.ThemeDark);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences prefss = PreferenceManager.getDefaultSharedPreferences(getApplication());
        String dayWeek = prefss.getString(getString(R.string.week_i), "");

        // Проверка на первый запуск приложения
         prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            Intent intent = new Intent(MainActivity.this, SettingsPref.class);
            startActivity(intent);
        }
        prefs.edit().putBoolean("isFirstRun", false).apply();

        // Стандартная инициализация компонетов
        tb = findViewById(R.id.toolbar);
        nv = findViewById(R.id.shitstuff);
        dl = findViewById(R.id.drawerLayout);
        fl = findViewById(R.id.containerView);

        calendar = java.util.Calendar.getInstance();
        setSupportActionBar(tb);
        // Поддержка старых версий ActionBarToggle - Это иконка DrawerLayout
        toggle = new ActionBarDrawerToggle(this, dl, tb, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        nv.setNavigationItemSelectedListener(this);

        // Транзакция фрагментов
        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit(); // По умолчанию - расписание.

        // Обработка нажатий на пункты меню.
        loadName(); // Загрузка имени группы согласно настройкам;
        loadTheme(); //  Загрузка темы основной темы приложения
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        WeekIndicator();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            case R.id.settings:
                Intent intent = new Intent(MainActivity.this, SettingsPref.class);
                startActivity(intent);
                finish();
                return true;
            case R.id.weekIndicator:
                WeekIndicator();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void WeekIndicator() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String position = prefs.getString(getString(R.string.week_i), "");
        switch (position) {
            case "Числитель": {
               WeekCh();
            }
            break;

            case "Знаменатель": {
              WeekZn();
            }
            break;
        }
    }

    public void WeekCh(){

            if(weekYear% 2 == 0){
                Toast.makeText(getApplicationContext(), "Текущая неделя: Числитель", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ch));
            }
            else {
                Toast.makeText(getApplicationContext(), "Текущая неделя: Знаменатель", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ze));
            }
    }

    public void WeekZn(){

            if(weekYear% 2 == 0){
                Toast.makeText(getApplicationContext(), "Текущая неделя: Знаменатель", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ze));
            }
            else {
                Toast.makeText(getApplicationContext(), "Текущая неделя: Числитель", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ch));
            }
    }

    public void loadName() {                                                                   // В качестве подзоголовка берем имя выбранной группы.
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this); // Название группы берется из String-array
        String regular = prefs.getString(getString(R.string.pref_style), "");
        MainActivity.this.getSupportActionBar().setSubtitle(regular);

        // Если пользователь очистил память в окне настроек, то настройка будет пуста. Делаем проверку.
        if ((regular.length() == 0)){
            Intent intent = new Intent(MainActivity.this, SettingsPref.class);
            startActivity(intent);
            finish();
        }
    }
    // Загрузка выбора темы приложения
    private void loadTheme() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String regular = prefs.getString(getString(R.string.pref_theme), "");
        switch (regular) {
            case "Светлая":  // Русские символы в коде - непорядок
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
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkA));
        }
        nv.setBackgroundResource(R.color.colorWhite);
        nv.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimarySS)));
        nv.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorPrimarySS)));
        tb.setBackgroundResource(R.color.colorPrimaryA);
        fl.setBackgroundResource(R.color.colorWhite);

    }

    public void ThemeDark() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        nv.setBackgroundResource(R.color.colorPrimaryDark);
        nv.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhite)));
        nv.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorWhite)));
        tb.setBackgroundResource(R.color.colorPrimary);
        fl.setBackgroundResource(R.color.colorPrimaryDarkD);
    }

    public void onBackPressed() {

        FragmentManager fm = this.getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0)
            fm.popBackStack();
        else
            finish();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {

            case R.id.main_tab:
                FragmentTransaction ft1 = FM.beginTransaction();
                ft1.replace(R.id.containerView, new TabFragment()).commit();
                loadName();
                break;
            case R.id.map:
                MainActivity.this.getSupportActionBar().setSubtitle("Учебные корпуса");
                FragmentTransaction ft2 = FM.beginTransaction();
                ft2.replace(R.id.containerView, new MapsFragment()).commit();
                break;
            case R.id.time_alarm:
                MainActivity.this.getSupportActionBar().setSubtitle("Время звонков");
                FragmentTransaction ft3 = FM.beginTransaction();
                ft3.replace(R.id.containerView, new TimeClock()).commit();
                break;
            default:
                break;
        }

        dl.closeDrawer(GravityCompat.START);
        return true;
    }
}