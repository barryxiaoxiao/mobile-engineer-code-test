package com.mytest.xiaoyu.network

sealed class MyTestResult<out R> {

    data class Success<out T>(val data: T) : MyTestResult<T>()
    data class Error(val exception: Exception) : MyTestResult<Nothing>()
}