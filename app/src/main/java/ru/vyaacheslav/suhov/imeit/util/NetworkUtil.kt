package ru.vyaacheslav.suhov.imeit.util

import android.content.Context
import android.net.ConnectivityManager
import io.reactivex.Observable
import ru.vyaacheslav.suhov.imeit.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.Scheduler.Worker
import android.os.Looper
import org.reactivestreams.Subscription
import android.net.NetworkInfo
import android.content.Intent
import android.content.BroadcastReceiver
import android.content.IntentFilter
import org.reactivestreams.Subscriber


class NetworkUtil(private val context: Context) {

    private fun isConnected(): Boolean {
        val cm: ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo?.isConnected ?: false
    }

    fun getNetworkObservable(): Observable<Boolean> = Observable.just(isConnected())
}