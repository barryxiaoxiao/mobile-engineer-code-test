package com.mytest.xiaoyu.data.response

import com.mytest.xiaoyu.greendao.database.CurrencyDetail

data class CurrencyResponse(val msg: Msg, val code: Int)

data class Msg(
    val currencyDetails: List<CurrencyDetail>
)
