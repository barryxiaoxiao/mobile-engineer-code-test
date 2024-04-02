package com.mytest.xiaoyu.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit

interface MyTestNetwork{
    var okHttpClient: () -> OkHttpClient
    var retrofit: () -> Retrofit
}