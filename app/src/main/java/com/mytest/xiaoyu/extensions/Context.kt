package com.mytest.xiaoyu.extensions

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Point
import android.net.ConnectivityManager
import android.view.WindowManager

@SuppressLint("MissingPermission")
fun Context.isOnline(): Boolean {
    val connectivityManager =
        this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    return connectivityManager.isInternetConnected()
}

fun Context.getWindowHeight(): Int {
    val point = Point()
    (getSystemService(Context.WINDOW_SERVICE) as WindowManager).defaultDisplay.getRealSize(point)
    return point.y
}

