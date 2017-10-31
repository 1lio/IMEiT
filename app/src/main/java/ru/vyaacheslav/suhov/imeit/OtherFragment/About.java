package ru.vyaacheslav.suhov.imeit.OtherFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import ru.vyaacheslav.suhov.imeit.R;


public class About extends Fragment implements View.OnClickListener {

    Button neo0, neo1;


    public About() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_about, container, false);

        neo0 = v.findViewById(R.id.neo0);
        neo1 = v.findViewById(R.id.neo1);

        neo0.setOnClickListener(this);
        neo1.setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.neo0:
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=ru.vyaacheslav.suhov.imeit")); // Указать ссылку на новое приложение
                startActivity(intent);
                break;
            case R.id.neo1:
                Toast.makeText(getActivity(), "Спасибо не нужно! Лучше поставь оценку!", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
