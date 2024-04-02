package com.mytest.xiaoyu.util

import java.math.BigInteger

object BytesHexUtil {
    private val HEX_CHAR = charArrayOf(
        '0', '1', '2', '3', '4', '5',
        '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
    )

    private fun bytesToHex(bytes: ByteArray, size: Int): String {
        val buf = CharArray(bytes.size * 2)
        var a: Int
        var index = 0
        for (b in bytes) { // 使用除与取余进行转换
            a = if (b < 0) {
                256 + b
            } else {
                b.toInt()
            }
            buf[index++] = HEX_CHAR[a / 16]
            buf[index++] = HEX_CHAR[a % 16]
            if (index == size) {
                return String(buf).substring(0, size)
            }
        }
        return String(buf).substring(0, size)
    }

    fun byteToCardNumber(bytes: ByteArray, size: Int): String {
        val dataStr = BytesHexUtil.bytesToHex(bytes, size * 2)
        val cardNumHex =
            dataStr.substring(dataStr.length - 5 * 2, dataStr.length - 1 * 2)
        val cardNum = BigInteger(cardNumHex, 16)
        return if (cardNum.toString().length < 10) {
            if (cardNum.toString().length < 9) {
                "00$cardNum"
            } else "0$cardNum"
        } else cardNum.toString()
    }
}