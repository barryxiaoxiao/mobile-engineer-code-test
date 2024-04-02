package com.mytest.xiaoyu.network

import com.mytest.xiaoyu.data.response.*

interface MyTestRepository {

    suspend fun getCurrencyDetailsByUserId(userId: String): MyTestResult<CurrencyResponse>
    suspend fun getCurrencyTotalInfoByUserId(userId: String): MyTestResult<CurrencyTotalResponse>

}