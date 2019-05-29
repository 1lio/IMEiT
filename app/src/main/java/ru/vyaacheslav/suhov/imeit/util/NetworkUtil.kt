package ru.vyaacheslav.suhov.imeit.util

import android.content.Context
import android.net.ConnectivityManager
import io.reactivex.Observable

class NetworkUtil(private val context: Context) {

    fun isConnected(): Boolean {
        val cm:ConnectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo?.isConnected ?: false
    }

    fun getNetworkObservable(): Observable<Boolean> = Observable.just(isConnected())
}