package com.mytest.xiaoyu.network

import com.mytest.xiaoyu.data.response.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MyTestRepositoryImpl @Inject constructor(
    private val apiService: MyTestApiService

) : MyTestRepository {
    private var ioDispatcher: CoroutineDispatcher = Dispatchers.IO
    override suspend fun getCurrencyDetailsByUserId(userId: String): MyTestResult<CurrencyResponse> =
        withContext(ioDispatcher) {
            try {
                //mock userId
                val response = apiService.getCurrencyDetailsByUserId(userId = "10001")
                MyTestResult.Success(response)
            } catch (e: Exception) {
                MyTestResult.Error(e)
            }
        }

    override suspend fun getCurrencyTotalInfoByUserId(userId: String): MyTestResult<CurrencyTotalResponse> =
        withContext(ioDispatcher) {
            try {
                //mock userId
                val response = apiService.getCurrencyTotalDetailsByUserId(userId = "10001")
                MyTestResult.Success(response)
            } catch (e: Exception) {
                MyTestResult.Error(e)
            }
        }


}