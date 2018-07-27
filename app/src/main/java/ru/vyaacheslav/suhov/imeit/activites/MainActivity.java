package ru.vyaacheslav.suhov.imeit.activites;

import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.Toast;

import java.util.Calendar;
import java.util.Objects;

import ru.vyaacheslav.suhov.imeit.R;
import ru.vyaacheslav.suhov.imeit.ftagments.Session;
import ru.vyaacheslav.suhov.imeit.ftagments.TabFragment;
import ru.vyaacheslav.suhov.imeit.ftagments.time.TimeListFragment;
import ru.vyaacheslav.suhov.imeit.maps.MapsFragment;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public ActionBarDrawerToggle toggle;
    public java.util.Calendar calendar;
    public FragmentTransaction FT;
    private FragmentManager FM;
    private SharedPreferences prefs;
    public String typeTheme, typeWeek, typeGroupe;
    private Intent settingsIntent;
    public Toolbar tb;
    public NavigationView nv;
    private int weekYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
    private Menu menu;
    private DrawerLayout dl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        typeTheme = prefs.getString(getString(R.string.pref_theme), "");
        typeWeek = prefs.getString(getString(R.string.week_i), "");
        typeGroupe = prefs.getString(getString(R.string.pref_groupe), "");

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            if (Objects.equals(typeTheme, "Светлая")) {
                setTheme(R.style.ThemeWrithe);
            } else {
                setTheme(R.style.ThemeDark);
            }
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Интент для запуска окна с настройками
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(intent);
        }
        prefs.edit().putBoolean("isFirstRun", false).apply();

        // Стандартная инициализация компонетов
        tb = findViewById(R.id.toolbar);
        nv = findViewById(R.id.shitstuff);
        dl = findViewById(R.id.drawerLayout);

        calendar = Calendar.getInstance();
        setSupportActionBar(tb);
        //ActionBarToggle - Это иконка DrawerLayout
        toggle = new ActionBarDrawerToggle(this, dl, tb, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        // Инициализация транзакции фрагментов
        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit(); // По умолчанию - расписание.

        // Обработка нажатий на пункты меню.
        nv.setNavigationItemSelectedListener(this);

        settingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
        loadName(); // Загрузка имени группы согласно настройкам;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;
        getMenuInflater().inflate(R.menu.menu, menu);
        weekIndicator();
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(settingsIntent);
                finish();
                return true;
            case R.id.weekIndicator:
                weekIndicator();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void weekIndicator() {

            if (weekYear % 2 == 0) {
                Toast.makeText(getApplicationContext(), "Текущая неделя: Числитель", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ch));
            } else {
                Toast.makeText(getApplicationContext(), "Текущая неделя: Знаменатель", Toast.LENGTH_SHORT).show();
                menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.ze));
        }
    }

    public void loadName() {
        // В качестве подзоголовка берем значение выбранной группы.
        typeGroupe = prefs.getString(getString(R.string.pref_groupe), "");
        // Для DB имена групп указаны английским алфавитом без пробелов и символов
        // Поэтому создаем второй массив на русском, сравниваем их по id

        String[] asu = getResources().getStringArray(R.array.groups_value);
        String[] names = getResources().getStringArray(R.array.all_group);

        int index = -1;

        for (int i = 0; (i < asu.length) && (index == -1); i++) {

            if (asu[i].equals(typeGroupe)) {
                index = i;
            }
        }
        // затем подставляем значение в качестве заголовка
        MainActivity.this.tb.setSubtitle(names[index]);

        // Если пользователь очистил данные в окне настроек, то строка будет пуста. Делаем проверку.
        if ((typeGroupe.length() == 0)) {
            startActivity(settingsIntent);
            finish();
        }
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
                MainActivity.this.tb.setSubtitle("Учебные корпуса");
                FragmentTransaction ft2 = FM.beginTransaction();
                ft2.replace(R.id.containerView, new MapsFragment()).commit();
                break;
          case R.id.time_alarm:
                MainActivity.this.tb.setSubtitle("Время звонков");
                FragmentTransaction ft3 = FM.beginTransaction();
                ft3.replace(R.id.containerView, new TimeListFragment()).commit();
                break;
            case R.id.exzam:
                MainActivity.this.tb.setSubtitle("Экзаменационная сессия");
                FragmentTransaction ft4 = FM.beginTransaction();
                ft4.replace(R.id.containerView, new Session()).commit();
                break;
            default:
                break;
        }
        dl.closeDrawer(GravityCompat.START);
        return true;

    }
}