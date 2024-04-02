package com.mytest.xiaoyu.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

class MyTestNetworkImpl(private val connectivityStatus: ConnectivityStatus) :
    MyTestNetwork {

    private fun getRetrofitClient(): Retrofit {
        val baseUrl =
            "https://xiaoyu.aliyun.ccc"
        return RetrofitAPIClient(
            connectivityStatus
        ).getRetrofitClient(baseUrl)
    }

    private fun getOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            val loggingInterceptor =
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.HEADERS)
            addInterceptor(loggingInterceptor)
        }.build()
    }

    override var okHttpClient: () -> OkHttpClient = { getOkHttpClient() }
    override var retrofit: () -> Retrofit = { getRetrofitClient() }
}