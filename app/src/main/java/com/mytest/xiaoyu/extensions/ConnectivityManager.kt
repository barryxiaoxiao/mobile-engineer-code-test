package com.mytest.xiaoyu.extensions

import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.annotation.RequiresApi

@RequiresApi(Build.VERSION_CODES.M)
fun ConnectivityManager.isInternetConnected(): Boolean {
    return getNetworkCapabilities(activeNetwork)?.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
        ?: false
}

@Suppress("DEPRECATION")
@Deprecated(
    "After setting minimum SDK to API23 this method can be removed.",
    ReplaceWith("ConnectivityManager.checkConnectivity")
)
private fun ConnectivityManager.legacyCheckConnectivity(): Boolean =
    activeNetworkInfo?.isConnectedOrConnecting ?: false