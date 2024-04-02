package com.mytest.xiaoyu.extensions

import android.view.View

internal fun View.gone() {
    this.visibility = View.GONE
}

internal fun View.visible() {
    this.visibility = View.VISIBLE
}

internal fun View.inVisible() {
    this.visibility = View.INVISIBLE
}