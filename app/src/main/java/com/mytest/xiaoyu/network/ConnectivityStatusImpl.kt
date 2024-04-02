package com.mytest.xiaoyu.network

import android.content.Context
import com.mytest.xiaoyu.extensions.isOnline
import javax.inject.Inject

class ConnectivityStatusImpl @Inject constructor(val context: Context) : ConnectivityStatus {
    override fun isConnected(): Boolean {
        return context.isOnline()
    }
}