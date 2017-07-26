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
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

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

        final TextView  p1 = (TextView)findViewById(R.id.m_p1);
        final TextView  p1a = (TextView)findViewById(R.id.m_p1_a);
        final TextView  m_p1_t = (TextView)findViewById(R.id.m_p1_t);
        final TextView  m_p1_k = (TextView)findViewById(R.id.m_p1_k);
        final TextView  p1z = (TextView)findViewById(R.id.m_p1z);
        final TextView  p1az = (TextView)findViewById(R.id.m_p1_az);
        final TextView  m_p1_tz = (TextView)findViewById(R.id.m_p1_tz);
        final TextView  m_p1_kz = (TextView)findViewById(R.id.m_p1_kz);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int position, long id) {
                switch (position) {

                    // MF11
                    case 0:
                        //Пн первая пара числитель/ далее знаменатель (z)
                        p1.setText(getResources().getString(R.string.pcixol));
                        p1a.setText(getResources().getString(R.string.okuneva));
                        m_p1_t.setText(getResources().getString(R.string.pz));
                        m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");

                        p1z.setText(getResources().getString(R.string.pedagogic));
                        p1az.setText(getResources().getString(R.string.zaharova));
                        m_p1_tz.setText(getResources().getString(R.string.lk));
                        m_p1_kz.setText(getResources().getString(R.string.uk)+ " 4-24");


                        break;
                    // MI11
                    case 1:
                        p1.setText(getResources().getString(R.string.in_bez));
                        p1a.setText(getResources().getString(R.string.belix));
                        m_p1_t.setText(getResources().getString(R.string.pz));
                        m_p1_k.setText(getResources().getString(R.string.uk)+ " 4-24");


                        break;
                    // PM11
                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 5:

                        break;

                    case 6: //ИСиТ-11, епт ведь мы уже ..-21
                        p1.setText(getResources().getString(R.string.pcixol));
                        p1a.setText(getResources().getString(R.string.okuneva));
                        m_p1_t.setText(getResources().getString(R.string.pz));
                        m_p1_k.setText(getResources().getString(R.string.uk)+ "4-24");

                        break;
                    case 7:

                        break;
                    case 8:

                        break;
                    case 9:

                        break;
                    case 10:

                        break;
                    case 11:

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


}
