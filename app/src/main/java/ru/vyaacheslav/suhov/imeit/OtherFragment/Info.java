package ru.vyaacheslav.suhov.imeit.OtherFragment;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import ru.vyaacheslav.suhov.imeit.R;

public class Info extends Fragment  implements View.OnClickListener{

    LinearLayout tel, webs, group, email;

    public Info() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_info, container, false);

        tel = v.findViewById(R.id.tel);
        webs = v.findViewById(R.id.webs);
        group = v.findViewById(R.id.groups);
        email = v.findViewById(R.id.emal_l);

        tel.setOnClickListener(this);
        webs.setOnClickListener(this);
        group.setOnClickListener(this);
        email.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()){
            case R.id.tel:
                intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:+74746722426"));
                startActivity(intent);
                break;
            case R.id.webs:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://imet.elsu.ru/"));
                startActivity(intent);
                break;
            case R.id.groups:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/imet.elsu"));
                startActivity(intent);
                break;
            case R.id.emal_l:
                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, new String[]{"DEK_F@MAIL.RU"});
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Выберите email клиент :"));
                break;
        }
    }
}
