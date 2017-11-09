package ru.vyaacheslav.suhov.imeit.NewsPa;

import android.os.SystemClock;

import java.lang.ref.WeakReference;


public class Worker extends Thread{

    private WeakReference<FragmentN> activity;

    Worker(FragmentN activity){
        this.activity = new WeakReference<>(activity);
    }

    @Override
    public void run() {
        super.run();

        while (activity.get() != null){
            SystemClock.sleep(6000);
            new SearchArtilhariaRequest(activity.get()).execute();
        }
    }
}