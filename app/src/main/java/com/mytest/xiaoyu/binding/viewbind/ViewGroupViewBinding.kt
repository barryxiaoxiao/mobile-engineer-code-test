package com.mytest.xiaoyu.binding.viewbind

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.mytest.xiaoyu.binding.ext.inflateMethod
import com.mytest.xiaoyu.binding.ext.inflateMethodWithViewGroup
import java.lang.reflect.Method
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


class ViewGroupViewBinding<T : ViewBinding>(
    classes: Class<T>,
    private val inflater: LayoutInflater,
    private val viewGroup: ViewGroup? = null
) : ReadOnlyProperty<ViewGroup, T> {

    private var viewBinding: T? = null
    private var layoutInflater: Method = if (viewGroup != null) {
        classes.inflateMethodWithViewGroup()
    } else {
        classes.inflateMethod()
    }

    override fun getValue(thisRef: ViewGroup, property: KProperty<*>): T {
        return viewBinding?.run {
            this
        } ?: let {
            val bind: T = if (viewGroup != null) {
                layoutInflater.invoke(null, inflater, viewGroup,true) as T
            } else {
                layoutInflater.invoke(null, inflater) as T
            }
            bind.apply {
                if (viewGroup == null) {
                    thisRef.addView(bind.root)
                }
                viewBinding = this
            }
        }
    }
}