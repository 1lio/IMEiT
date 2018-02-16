package ru.vyaacheslav.suhov.imeit;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
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

import java.util.Calendar;

import ru.vyaacheslav.suhov.imeit.Cafedrs.CafedraMain;
import ru.vyaacheslav.suhov.imeit.Maps.MapsFragment;
import ru.vyaacheslav.suhov.imeit.OtherFragment.Info;
import ru.vyaacheslav.suhov.imeit.OtherFragment.TimeClock;

public class MainActivity extends AppCompatActivity {

    public ActionBarDrawerToggle toggle;
    public java.util.Calendar calendar;
    public FragmentTransaction FT;
    public MenuItem inst1,inst2;
    public FragmentManager FM;
    public RelativeLayout lm;
    private Menu menu;
    private Toolbar tb;
    private DrawerLayout dl;
    private NavigationView nv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Проверка на первый запуск приложения
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        if (prefs.getBoolean("isFirstRun", true)) {
            Intent intent = new Intent(MainActivity.this, SettingsPref.class);
            startActivity(intent);
        }
        prefs.edit().putBoolean("isFirstRun", false).apply();

        // Стандартная инициализация компонетов
        tb = findViewById(R.id.toolbar);
        nv = findViewById(R.id.shitstuff);
        dl = findViewById(R.id.drawerLayout);
        lm = findViewById(R.id.layout_main);

        calendar = java.util.Calendar.getInstance();
        setSupportActionBar(tb);

        // Поддержка старых версий ActionBarToggle - Это иконка DrawerLayout
        toggle = new ActionBarDrawerToggle(this, dl, tb, R.string.app_name, R.string.app_name);
        dl.addDrawerListener(toggle);
        toggle.syncState();

        // Костомизация меню. Вообщем ненужная хрень. Нужно убрать потом
        menu = nv.getMenu();
        inst1 = menu.findItem(R.id.instr1);
        inst2 = menu.findItem(R.id.instr2);

        SpannableString str1 = new SpannableString(inst1.getTitle());
        SpannableString str2 = new SpannableString(inst2.getTitle());

        str1.setSpan(new TextAppearanceSpan(this, R.style.MenuLine), 0, str1.length(), 0);
        str2.setSpan(new TextAppearanceSpan(this, R.style.MenuLine), 0, str2.length(), 0);

        inst1.setTitle(str1);
        inst2.setTitle(str2);

        // Дублирование, нужно подумать как этого избежать.

        // Транзакция фрагментов
        FM = getSupportFragmentManager();
        FT = FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit(); // По умолчанию - расписание.

        // Обработка нажатий на пункты меню.
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                dl.closeDrawers(); // После нажатия закрывать Drawer

                switch (item.getItemId()) {
                    case R.id.main_tab:
                        loadName();
                        FragmentTransaction ft1 = FM.beginTransaction();
                        ft1.replace(R.id.containerView, new TabFragment()).commit();
                        break;
                    case R.id.map:
                        MainActivity.this.getSupportActionBar().setSubtitle("Учебные корпуса");
                        FragmentTransaction ft2 = FM.beginTransaction();
                        ft2.replace(R.id.containerView, new MapsFragment()).commit();
                        break;
                    case R.id.you_tab:
                        MainActivity.this.getSupportActionBar().setSubtitle("Время звонков");
                        FragmentTransaction ft3 = FM.beginTransaction();
                        ft3.replace(R.id.containerView, new TimeClock()).commit();
                        break;
                    case R.id.info:
                        MainActivity.this.getSupportActionBar().setSubtitle("Об институте");
                        FragmentTransaction ft4 = FM.beginTransaction();
                        ft4.replace(R.id.containerView, new Info()).commit();
                        break;
                    case R.id.caf1:
                        MainActivity.this.getSupportActionBar().setSubtitle("Кафедры");
                        FragmentTransaction ft5 = FM.beginTransaction();
                        ft5.replace(R.id.containerView, new CafedraMain()).commit();
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

        loadName(); // Загрузка имени группы согласно настройкам
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
            case "Авто": {
                        // Ненужная настройка
             WeekCh();  // Новый семестр начинается по умолчанию с числителя.
                        // Функция дублирования
                        // Неправильно + некрасивая конструкция
            }
            break;
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

        Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        int weekYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

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

        Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
        int weekYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

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
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        nv.setBackgroundResource(R.color.colorWhitee);
        nv.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        nv.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorTextBlack)));
        tb.setBackgroundResource(R.color.colorPrimary);
    }

    public void ThemeDark() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDarkD));
        }
        nv.setBackgroundResource(R.color.colorPrimaryDarkD);
        nv.setItemIconTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        nv.setItemTextColor(ColorStateList.valueOf(getResources().getColor(R.color.colorWhitee)));
        tb.setBackgroundResource(R.color.colorPrimaryD);
    }

    public void onBackPressed() {
        FragmentManager fm = this.getSupportFragmentManager();
        if (fm.getBackStackEntryCount() > 0)
            fm.popBackStack();
        else
            finish();
    }

}