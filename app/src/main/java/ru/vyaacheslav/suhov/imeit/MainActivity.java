package ru.vyaacheslav.suhov.imeit;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z,t_l_4z, t_l_3z, t_l_2z, t_l_1z,
                        h_l_4z, h_l_3z, h_l_2z, h_l_1z, w_l_4z, w_l_3z, w_l_2z, w_l_1z,
                        f_l_4z, f_l_3z, f_l_2z, f_l_1z;
    public TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
                    p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
                    t1, t_p1_tz, t_p1_kz, t1a, t_p1_t, t_p1_k, t1z, t1az, t2, t_p2_tz, t_p2_kz, t2a, t_p2_t, t_p2_k, t2z, t2az,
                    t3, t_p3_tz, t_p3_kz, t3a, t_p3_t, t_p3_k, t3z, t3az, t4, t_p4_tz, t_p4_kz, t4a, t_p4_t, t_p4_k, t4z, t4az,
                    th1, h_p1_tz, h_p1_kz, h1a, h_p1_t, h_p1_k, h1z, h1az, h2, h_p2_tz, h_p2_kz, h2a, h_p2_t, h_p2_k, h2z, h2az,
                    h3, h_p3_tz, h_p3_kz, h3a, h_p3_t, h_p3_k, h3z, h3az, h4, h_p4_tz, h_p4_kz, h4a, h_p4_t, h_p4_k, h4z, h4az,
                    w1, w_p1_tz, w_p1_kz, w1a, w_p1_t, w_p1_k, w1z, w1az, w2, w_p2_tz, w_p2_kz, w2a, w_p2_t, w_p2_k, w2z, w2az,
                    w3, w_p3_tz, w_p3_kz, w3a, w_p3_t, w_p3_k, w3z, w3az, w4, w_p4_tz, w_p4_kz, w4a, w_p4_t, w_p4_k, w4z, w4az,
                    f1, f_p1_tz, f_p1_kz, f1a, f_p1_t, f_p1_k, f1z, f1az, f2, f_p2_tz, f_p2_kz, f2a, f_p2_t, f_p2_k, f2z, f2az,
                    f3, f_p3_tz, f_p3_kz, f3a, f_p3_t, f_p3_k, f3z, f3az, f4, f_p4_tz, f_p4_kz, f4a, f_p4_t, f_p4_k, f4z, f4az;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    FragmentManager FM;
    FragmentTransaction FT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        navigationView= (NavigationView) findViewById(R.id.shitstuff);

        FM= getSupportFragmentManager();
        FT= FM.beginTransaction();
        FT.replace(R.id.containerView, new TabFragment()).commit();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();

                if (item.getItemId()== R.id.main_tab) {
                    FragmentTransaction fragmentTransaction= FM.beginTransaction();
                    fragmentTransaction.replace(R.id.containerView, new TabFragment()).commit();
                }

                if (item.getItemId()==R.id.you_tab)
                {
                    FragmentTransaction fragmentTransaction1=FM.beginTransaction();
                    fragmentTransaction1.replace(R.id.containerView,new TabFragment()).commit();

                }
                return false;
            }
        });

        m_l_4z = (LinearLayout)findViewById(R.id.m_l_4z);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        ActionBarDrawerToggle toggle= new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);

        MenuItem item = menu.findItem(R.id.spinner);
        Spinner spinner = (Spinner) MenuItemCompat.getActionView(item);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.bak_groops, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(adapter);




        initGovno();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {



                switch (position) {
                    // MF11
                    case 0:

                        // Пн первая пара числитель/ далее знаменатель (z)
                        // Убирать layoutы вместо texview для экономии времени
                        // Велосипед! Костыль! и т.д и т.п.

                        p1.setText(getResources().getString(R.string.pcixol));
                        p1a.setText(getResources().getString(R.string.okuneva));
                        m_p1_t.setText(getResources().getString(R.string.pz));
                        m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                        p1z.setText(getResources().getString(R.string.pedagogic));
                        p1az.setText(getResources().getString(R.string.zaharova));
                        m_p1_tz.setText(getResources().getString(R.string.lk));
                        m_p1_kz.setText(getResources().getString(R.string.uk)+ " 4-24");

                        p2.setText(getResources().getString(R.string.pedagogic));
                        p2a.setText(getResources().getString(R.string.zaharova));
                        m_p2_t.setText(getResources().getString(R.string.pz));
                        m_p2_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                        m_l_2z.setVisibility(View.GONE);

                        p3.setText(getResources().getString(R.string.fk));
                        p3a.setVisibility(View.GONE);
                        m_p3_t.setVisibility(View.GONE);
                        m_p3_k.setText(getResources().getString(R.string.fok));
                        m_l_3z.setVisibility(View.GONE);

                        p4.setText(getResources().getString(R.string.bjd));
                        p4a.setText(getResources().getString(R.string.ivanov));
                        m_p4_t.setText(getResources().getString(R.string.lk));
                        m_p4_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                        p4z.setVisibility(View.GONE);
                        p4az.setVisibility(View.GONE);
                        m_p4_tz.setVisibility(View.GONE);
                        m_p4_kz.setVisibility(View.GONE);
                        // Вторник

                      w1.setText(getResources().getString(R.string.geometry));
                      w1a.setText(getResources().getString(R.string.prokuratova));
                      w_p1_t.setText(getResources().getString(R.string.pz));
                      w_p1_k.setText(getResources().getString(R.string.uk)+ " 4-26");
                      w1z.setText(getResources().getString(R.string.geometry));
                      w1az.setText(getResources().getString(R.string.prokuratova));
                      w_p1_tz.setText(getResources().getString(R.string.lk));
                      w_p1_kz.setText(getResources().getString(R.string.uk)+ " 4-26");

                      w2.setText(getResources().getString(R.string.chkm));
                      w2a.setText(getResources().getString(R.string.turtaeva));
                      w_p2_t.setText(getResources().getString(R.string.pz));
                      w_p2_k.setText(getResources().getString(R.string.gk)+ "-208");
                      w_l_2z.setVisibility(View.GONE);

                      w3.setText(getResources().getString(R.string.omoi));
                      w3a.setText(getResources().getString(R.string.tarov));
                      w_p3_t.setText(getResources().getString(R.string.lk));
                      w_p3_k.setText(getResources().getString(R.string.gk)+ "-300");
                      w3z.setText(getResources().getString(R.string.omoi));
                      w3az.setText(getResources().getString(R.string.tarov));
                      w_p3_tz.setText(getResources().getString(R.string.pz));
                      w_p3_kz.setText(getResources().getString(R.string.gk)+ "-300");

                      w4.setText(getResources().getString(R.string.omoi));
                      w4a.setText(getResources().getString(R.string.tarov));
                      w_p4_t.setText(getResources().getString(R.string.lk));
                      w_p4_k.setText(getResources().getString(R.string.gk)+ "-300");
                      w4z.setVisibility(View.GONE);
                      w4az.setVisibility(View.GONE);
                      w_p4_tz.setVisibility(View.GONE);
                      w_p4_kz.setVisibility(View.GONE);





                        // среда




                        break;
                    // MI11
                    case 1:
                        layoutVisable();

                        p1.setText(getResources().getString(R.string.pcixol));
                        p1a.setText(getResources().getString(R.string.okuneva));
                        m_p1_t.setText(getResources().getString(R.string.pz));
                        m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                        p1z.setText(getResources().getString(R.string.pedagogic));
                        p1az.setText(getResources().getString(R.string.zaharova));
                        m_p1_tz.setText(getResources().getString(R.string.lk));
                        m_p1_kz.setText(getResources().getString(R.string.uk)+ " 4-24");

                        p2.setText(getResources().getString(R.string.pedagogic));
                        p2a.setText(getResources().getString(R.string.zaharova));
                        m_p2_t.setText(getResources().getString(R.string.pz));
                        m_p2_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                        m_l_2z.setVisibility(View.GONE);

                        p3.setText(getResources().getString(R.string.fk));
                        p3a.setVisibility(View.GONE);
                        m_p3_t.setVisibility(View.GONE);
                        m_p3_k.setText(getResources().getString(R.string.fok));
                        m_l_3z.setVisibility(View.GONE);

                        p4.setText(getResources().getString(R.string.bjd));
                        p4a.setText(getResources().getString(R.string.ivanov));
                        m_p4_t.setText(getResources().getString(R.string.lk));
                        m_p4_k.setText(getResources().getString(R.string.uk)+ " 4-24");
                        p4z.setVisibility(View.GONE);
                        p4az.setVisibility(View.GONE);
                        m_p4_tz.setVisibility(View.GONE);
                        m_p4_kz.setVisibility(View.GONE);



                        break;
                    // PM11
                    case 2:
                        layoutVisable();

                        break;
                    case 3:
                        layoutVisable();

                        break;
                    case 4:
                        layoutVisable();

                        break;
                    case 5:
                        layoutVisable();

                        break;

                    case 6: //ИСиТ-11, епт ведь мы уже ..-21
                        layoutVisable();
                        p1.setText(getResources().getString(R.string.pcixol));
                        p1a.setText(getResources().getString(R.string.okuneva));
                        m_p1_t.setText(getResources().getString(R.string.pz));
                        m_p1_k.setText(getResources().getString(R.string.uk)+ "4-24");

                        break;
                    case 7:
                        layoutVisable();

                        break;
                    case 8:
                        layoutVisable();

                        break;
                    case 9:
                        layoutVisable();

                        break;
                    case 10:
                        layoutVisable();

                        break;
                    case 11:
                        layoutVisable();

                        break;
                    default:
                        break;
                }



            }
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        return true;

    }

    public void layoutVisable(){


        m_l_1z.setVisibility(View.VISIBLE);
        m_l_2z.setVisibility(View.VISIBLE);
        m_l_3z.setVisibility(View.VISIBLE);
        m_l_4z.setVisibility(View.VISIBLE);

    }

    public void initGovno(){
        m_l_1z = (LinearLayout)findViewById(R.id.m_l_1z);
        m_l_2z = (LinearLayout)findViewById(R.id.m_l_2z);
        m_l_3z = (LinearLayout)findViewById(R.id.m_l_3z);
        m_l_4z = (LinearLayout)findViewById(R.id.m_l_4z);

        p1 = (TextView)findViewById(R.id.m_p1);
        p1a = (TextView)findViewById(R.id.m_p1_a);
        m_p1_t = (TextView)findViewById(R.id.m_p1_t);
        m_p1_k = (TextView)findViewById(R.id.m_p1_k);
        p1z = (TextView)findViewById(R.id.m_p1z);
        p1az = (TextView)findViewById(R.id.m_p1_az);
        m_p1_tz = (TextView)findViewById(R.id.m_p1_tz);
        m_p1_kz = (TextView)findViewById(R.id.m_p1_kz);

        p2 = (TextView)findViewById(R.id.m_p2);
        p2a = (TextView)findViewById(R.id.m_p2_a);
        m_p2_t = (TextView)findViewById(R.id.m_p2_t);
        m_p2_k = (TextView)findViewById(R.id.m_p2_k);
        p2z = (TextView)findViewById(R.id.m_p2z);
        p2az = (TextView)findViewById(R.id.m_p2_az);
        m_p2_tz = (TextView)findViewById(R.id.m_p2_tz);
        m_p2_kz = (TextView)findViewById(R.id.m_p2_kz);

        p3 = (TextView)findViewById(R.id.m_p3);
        p3a = (TextView)findViewById(R.id.m_p3_a);
        m_p3_t = (TextView)findViewById(R.id.m_p3_t);
        m_p3_k = (TextView)findViewById(R.id.m_p3_k);
        p3z = (TextView)findViewById(R.id.m_p3z);
        p3az = (TextView)findViewById(R.id.m_p3_az);
        m_p3_tz = (TextView)findViewById(R.id.m_p3_tz);
        m_p3_kz = (TextView)findViewById(R.id.m_p3_kz);

        p4 = (TextView)findViewById(R.id.m_p4);
        p4a = (TextView)findViewById(R.id.m_p4_a);
        m_p4_t = (TextView)findViewById(R.id.m_p4_t);
        m_p4_k = (TextView)findViewById(R.id.m_p4_k);
        p4z = (TextView)findViewById(R.id.m_p4z);
        p4az = (TextView)findViewById(R.id.m_p4_az);
        m_p4_tz = (TextView)findViewById(R.id.m_p4_tz);
        m_p4_kz = (TextView)findViewById(R.id.m_p4_kz);

        t_l_1z = (LinearLayout)findViewById(R.id.t_l_1z);
        t_l_2z = (LinearLayout)findViewById(R.id.t_l_2z);
        t_l_3z = (LinearLayout)findViewById(R.id.t_l_3z);
        t_l_4z = (LinearLayout)findViewById(R.id.t_l_4z);

        t1 = (TextView)findViewById(R.id.t1);
        t1a = (TextView)findViewById(R.id.t_p1_a);
        t_p1_t = (TextView)findViewById(R.id.t_p1_t);
        t_p1_k = (TextView)findViewById(R.id.t_p1_k);
        t1z = (TextView)findViewById(R.id.t_p1z);
        t1az = (TextView)findViewById(R.id.t_p1_az);
        t_p1_tz = (TextView)findViewById(R.id.t_p1_tz);
        t_p1_kz = (TextView)findViewById(R.id.t_p1_kz);

        t2 = (TextView)findViewById(R.id.t_p2);
        t2a = (TextView)findViewById(R.id.t_p2_a);
        t_p2_t = (TextView)findViewById(R.id.t_p2_t);
        t_p2_k = (TextView)findViewById(R.id.t_p2_k);
        t2z = (TextView)findViewById(R.id.t_p2z);
        t2az = (TextView)findViewById(R.id.t_p2_az);
        t_p2_tz = (TextView)findViewById(R.id.t_p2_tz);
        t_p2_kz = (TextView)findViewById(R.id.t_p2_kz);

        t3 = (TextView)findViewById(R.id.t_p3);
        t3a = (TextView)findViewById(R.id.t_p3_a);
        t_p3_t = (TextView)findViewById(R.id.t_p3_t);
        t_p3_k = (TextView)findViewById(R.id.t_p3_k);
        t3z = (TextView)findViewById(R.id.t_p3z);
        t3az = (TextView)findViewById(R.id.t_p3_az);
        t_p3_tz = (TextView)findViewById(R.id.t_p3_tz);
        t_p3_kz = (TextView)findViewById(R.id.t_p3_kz);

        t4 = (TextView)findViewById(R.id.t_p4);
        t4a = (TextView)findViewById(R.id.t_p4_a);
        t_p4_t = (TextView)findViewById(R.id.t_p4_t);
        t_p4_k = (TextView)findViewById(R.id.t_p4_k);
        t4z = (TextView)findViewById(R.id.t_p4z);
        t4az = (TextView)findViewById(R.id.t_p4_az);
        t_p4_tz = (TextView)findViewById(R.id.t_p4_tz);
        t_p4_kz = (TextView)findViewById(R.id.t_p4_kz);

        h_l_1z = (LinearLayout)findViewById(R.id.h_l_1z);
        h_l_2z = (LinearLayout)findViewById(R.id.h_l_2z);
        h_l_3z = (LinearLayout)findViewById(R.id.h_l_3z);
        h_l_4z = (LinearLayout)findViewById(R.id.h_l_4z);

        th1 = (TextView)findViewById(R.id.th1);
        h1a = (TextView)findViewById(R.id.h_p1_a);
        h_p1_t = (TextView)findViewById(R.id.h_p1_t);
        h_p1_k = (TextView)findViewById(R.id.h_p1_k);
        h1z = (TextView)findViewById(R.id.h_p1z);
        h1az = (TextView)findViewById(R.id.h_p1_az);
        h_p1_tz = (TextView)findViewById(R.id.h_p1_tz);
        h_p1_kz = (TextView)findViewById(R.id.h_p1_kz);

        h2 = (TextView)findViewById(R.id.h_p2);
        h2a = (TextView)findViewById(R.id.h_p2_a);
        h_p2_t = (TextView)findViewById(R.id.h_p2_t);
        h_p2_k = (TextView)findViewById(R.id.h_p2_k);
        h2z = (TextView)findViewById(R.id.h_p2z);
        h2az = (TextView)findViewById(R.id.h_p2_az);
        h_p2_tz = (TextView)findViewById(R.id.h_p2_tz);
        h_p2_kz = (TextView)findViewById(R.id.h_p2_kz);

        h3 = (TextView)findViewById(R.id.h_p3);
        h3a = (TextView)findViewById(R.id.h_p3_a);
        h_p3_t = (TextView)findViewById(R.id.h_p3_t);
        h_p3_k = (TextView)findViewById(R.id.h_p3_k);
        h3z = (TextView)findViewById(R.id.h_p3z);
        h3az = (TextView)findViewById(R.id.h_p3_az);
        h_p3_tz = (TextView)findViewById(R.id.h_p3_tz);
        h_p3_kz = (TextView)findViewById(R.id.h_p3_kz);

        h4 = (TextView)findViewById(R.id.h_p4);
        h4a = (TextView)findViewById(R.id.h_p4_a);
        h_p4_t = (TextView)findViewById(R.id.h_p4_t);
        h_p4_k = (TextView)findViewById(R.id.h_p4_k);
        h4z = (TextView)findViewById(R.id.h_p4z);
        h4az = (TextView)findViewById(R.id.h_p4_az);
        h_p4_tz = (TextView)findViewById(R.id.h_p4_tz);
        h_p4_kz = (TextView)findViewById(R.id.h_p4_kz);

        w_l_1z = (LinearLayout)findViewById(R.id.w_l_1z);
        w_l_2z = (LinearLayout)findViewById(R.id.w_l_2z);
        w_l_3z = (LinearLayout)findViewById(R.id.w_l_3z);
        w_l_4z = (LinearLayout)findViewById(R.id.w_l_4z);

        w1 = (TextView)findViewById(R.id.w1);
        w1a = (TextView)findViewById(R.id.w_p1_a);
        w_p1_t = (TextView)findViewById(R.id.w_p1_t);
        w_p1_k = (TextView)findViewById(R.id.w_p1_k);
        w1z = (TextView)findViewById(R.id.w_p1z);
        w1az = (TextView)findViewById(R.id.w_p1_az);
        w_p1_tz = (TextView)findViewById(R.id.w_p1_tz);
        w_p1_kz = (TextView)findViewById(R.id.w_p1_kz);

        w2 = (TextView)findViewById(R.id.w_p2);
        w2a = (TextView)findViewById(R.id.w_p2_a);
        w_p2_t = (TextView)findViewById(R.id.w_p2_t);
        w_p2_k = (TextView)findViewById(R.id.w_p2_k);
        w2z = (TextView)findViewById(R.id.w_p2z);
        w2az = (TextView)findViewById(R.id.w_p2_az);
        w_p2_tz = (TextView)findViewById(R.id.w_p2_tz);
        w_p2_kz = (TextView)findViewById(R.id.w_p2_kz);

        w3 = (TextView)findViewById(R.id.w_p3);
        w3a = (TextView)findViewById(R.id.w_p3_a);
        w_p3_t = (TextView)findViewById(R.id.w_p3_t);
        w_p3_k = (TextView)findViewById(R.id.w_p3_k);
        w3z = (TextView)findViewById(R.id.w_p3z);
        w3az = (TextView)findViewById(R.id.w_p3_az);
        w_p3_tz = (TextView)findViewById(R.id.w_p3_tz);
        w_p3_kz = (TextView)findViewById(R.id.w_p3_kz);

        w4 = (TextView)findViewById(R.id.w_p4);
        w4a = (TextView)findViewById(R.id.w_p4_a);
        w_p4_t = (TextView)findViewById(R.id.w_p4_t);
        w_p4_k = (TextView)findViewById(R.id.w_p4_k);
        w4z = (TextView)findViewById(R.id.w_p4z);
        w4az = (TextView)findViewById(R.id.w_p4_az);
        w_p4_tz = (TextView)findViewById(R.id.w_p4_tz);
        w_p4_kz = (TextView)findViewById(R.id.w_p4_kz);

        f_l_1z = (LinearLayout)findViewById(R.id.f_l_1z);
        f_l_2z = (LinearLayout)findViewById(R.id.f_l_2z);
        f_l_3z = (LinearLayout)findViewById(R.id.f_l_3z);
        f_l_4z = (LinearLayout)findViewById(R.id.f_l_4z);

        f1 = (TextView)findViewById(R.id.f1);
        f1a = (TextView)findViewById(R.id.f_p1_a);
        f_p1_t = (TextView)findViewById(R.id.f_p1_t);
        f_p1_k = (TextView)findViewById(R.id.f_p1_k);
        f1z = (TextView)findViewById(R.id.f_p1z);
        f1az = (TextView)findViewById(R.id.f_p1_az);
        f_p1_tz = (TextView)findViewById(R.id.f_p1_tz);
        f_p1_kz = (TextView)findViewById(R.id.f_p1_kz);

        f2 = (TextView)findViewById(R.id.f_p2);
        f2a = (TextView)findViewById(R.id.f_p2_a);
        f_p2_t = (TextView)findViewById(R.id.f_p2_t);
        f_p2_k = (TextView)findViewById(R.id.f_p2_k);
        f2z = (TextView)findViewById(R.id.f_p2z);
        f2az = (TextView)findViewById(R.id.f_p2_az);
        f_p2_tz = (TextView)findViewById(R.id.f_p2_tz);
        f_p2_kz = (TextView)findViewById(R.id.f_p2_kz);

        f3 = (TextView)findViewById(R.id.f_p3);
        f3a = (TextView)findViewById(R.id.f_p3_a);
        f_p3_t = (TextView)findViewById(R.id.f_p3_t);
        f_p3_k = (TextView)findViewById(R.id.f_p3_k);
        f3z = (TextView)findViewById(R.id.f_p3z);
        f3az = (TextView)findViewById(R.id.f_p3_az);
        f_p3_tz = (TextView)findViewById(R.id.f_p3_tz);
        f_p3_kz = (TextView)findViewById(R.id.f_p3_kz);

        f4 = (TextView)findViewById(R.id.f_p4);
        f4a = (TextView)findViewById(R.id.f_p4_a);
        f_p4_t = (TextView)findViewById(R.id.f_p4_t);
        f_p4_k = (TextView)findViewById(R.id.f_p4_k);
        f4z = (TextView)findViewById(R.id.f_p4z);
        f4az = (TextView)findViewById(R.id.f_p4_az);
        f_p4_tz = (TextView)findViewById(R.id.f_p4_tz);
        f_p4_kz = (TextView)findViewById(R.id.f_p4_kz);

    }



}
