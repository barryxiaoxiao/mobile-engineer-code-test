package com.mytest.xiaoyu.network

import com.mytest.xiaoyu.data.response.CurrencyResponse
import com.mytest.xiaoyu.data.response.CurrencyTotalResponse
import retrofit2.http.*

interface MyTestApiService {

    @GET("{proxy}/mytest/xiaoyu/getCurrencyDetailsByUserId")
    suspend fun getCurrencyDetailsByUserId(
        @Path(value = "proxy", encoded = true) proxy: String = "https://xiaoyu.aliyun.ccc",
        @Query(value = "userId") userId: String
    ):CurrencyResponse

    @GET("{proxy}/mytest/xiaoyu/getCurrencyTotalDetailsByUserId")
    suspend fun getCurrencyTotalDetailsByUserId(
        @Path(value = "proxy", encoded = true) proxy: String = "https://xiaoyu.aliyun.ccc",
        @Query(value = "userId") userId: String
    ):CurrencyTotalResponse
}