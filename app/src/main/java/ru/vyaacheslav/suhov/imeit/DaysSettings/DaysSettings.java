package ru.vyaacheslav.suhov.imeit.DaysSettings;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

public class DaysSettings {

    public String nameLess;
    public String namePrepod;
    public String typeLess;
    public String nameBuild;
    public String typeWeek;
    public SharedPreferences prefs;
    public boolean lessIndicator;
    private LinearLayout m_l_4z, m_l_3z, m_l_2z, m_l_1z, m_l1, m_l2, m_l3, m_l4, m_l5, m_l_4c, m_l_3c, m_l_2c, m_l_1c, m_l_5c;
    private TextView p1, m_p1_tz, m_p1_kz, p1a, m_p1_t, m_p1_k, p1z, p1az, p2, m_p2_tz, m_p2_kz, p2a, m_p2_t, m_p2_k, p2z, p2az,
            p3, m_p3_tz, m_p3_kz, p3a, m_p3_t, m_p3_k, p3z, p3az, p4, m_p4_tz, m_p4_kz, p4a, m_p4_t, m_p4_k, p4z, p4az,
            p5, m_p5_tz, m_p5_kz, p5a, m_p5_t, m_p5_k, p5az, p5z;
    private String danger = "danger";

    public void NullLess1Z(){
        p1z.setVisibility(View.GONE);
        p1az.setVisibility(View.GONE);
        m_p1_tz.setVisibility(View.GONE);
        m_p1_kz.setVisibility(View.GONE);
        m_l_1c.setVisibility(View.GONE);
    }

    public void NullLess2Z(){
        p2z.setVisibility(View.GONE);
        p2az.setVisibility(View.GONE);
        m_p2_tz.setVisibility(View.GONE);
        m_p2_kz.setVisibility(View.GONE);
        m_l_2c.setVisibility(View.GONE);
    }

    public void NullLess3Z(){
        p3z.setVisibility(View.GONE);
        p3az.setVisibility(View.GONE);
        m_p3_tz.setVisibility(View.GONE);
        m_p3_kz.setVisibility(View.GONE);
        m_l_3c.setVisibility(View.GONE);
    }

    public void NullLess4Z(){
        p4z.setVisibility(View.GONE);
        p4az.setVisibility(View.GONE);
        m_p4_tz.setVisibility(View.GONE);
        m_p4_kz.setVisibility(View.GONE);
        m_l_4c.setVisibility(View.GONE);
    }

    public void NullLess5Z(){
        p5z.setVisibility(View.GONE);
        p5az.setVisibility(View.GONE);
        m_p5_tz.setVisibility(View.GONE);
        m_p5_kz.setVisibility(View.GONE);
        m_l_5c.setVisibility(View.GONE);
    }


    public void NullMon1C() {
        p1.setVisibility(View.GONE);
        p1a.setVisibility(View.GONE);
        m_p1_t.setVisibility(View.GONE);
        m_p1_k.setVisibility(View.GONE);
        m_l1.setVisibility(View.GONE);
    }

    public void NullMon2C() {
        p2.setVisibility(View.GONE);
        p2a.setVisibility(View.GONE);
        m_p2_t.setVisibility(View.GONE);
        m_p2_k.setVisibility(View.GONE);

        m_l2.setVisibility(View.GONE);

    }

    public void NullMon3C() {
        p3.setVisibility(View.GONE);
        p3a.setVisibility(View.GONE);
        m_p3_t.setVisibility(View.GONE);
        m_p3_k.setVisibility(View.GONE);
        m_l3.setVisibility(View.GONE);

    }

    public void NullMon4C() {
        p4.setVisibility(View.GONE);
        p4a.setVisibility(View.GONE);
        m_p4_t.setVisibility(View.GONE);
        m_p4_k.setVisibility(View.GONE);
        m_l4.setVisibility(View.GONE);
    }

    public void NullMon5C() {
        p5.setVisibility(View.GONE);
        p5a.setVisibility(View.GONE);
        m_p5_t.setVisibility(View.GONE);
        m_p5_k.setVisibility(View.GONE);
        m_l5.setVisibility(View.GONE);
    }


    // Функция убирания пустой строки
    // В куске говница

    public void Danger() {

        //Дичь

        if (prefs.getBoolean(danger, false)) {
            Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);
            int weekYear = Calendar.getInstance().get(Calendar.WEEK_OF_YEAR);

            switch (typeWeek) {

                case "Числитель": {

                    if ((weekYear % 2 == 0)) {

                        NullLess1Z();
                        NullLess2Z();
                        NullLess3Z();
                        NullLess4Z();
                        NullLess5Z();
                    }
                    // знаменатель
                    else {
                        NullMon1C();
                        NullMon2C();
                        NullMon3C();
                        NullMon4C();
                        NullMon5C();
                    }

                }
                break;

                case "Знаменатель": {
                    if ((weekYear % 2 == 0)) {
                         NullMon1C();
                         NullMon2C();
                         NullMon3C();
                         NullMon4C();
                         NullMon5C();
                    }
                    // знаменатель
                    else {

                       NullLess1Z();
                       NullLess2Z();
                       NullLess3Z();
                       NullLess4Z();
                       NullLess5Z();
                    }
                }
                break;

                case "Авто": {
                    //числитель
                    if ((weekYear % 2 == 0)) {
                         NullMon1C();
                         NullMon2C();
                         NullMon3C();
                         NullMon4C();
                         NullMon5C();
                    }
                    // знаменатель
                    else {
                      NullLess1Z();
                      NullLess2Z();
                      NullLess3Z();
                      NullLess4Z();
                      NullLess5Z();
                    }
                }
                break;
                default:
                    break;
            }

        }
    }

}
