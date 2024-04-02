package com.mytest.xiaoyu.binding.viewbind

import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mytest.xiaoyu.binding.base.FragmentDelegate
import com.mytest.xiaoyu.binding.ext.bindMethod
import com.mytest.xiaoyu.binding.ext.inflateMethod
import kotlin.reflect.KProperty


class FragmentViewBinding<T : ViewBinding>(
    classes: Class<T>,
    fragment: Fragment
) : FragmentDelegate<T>(fragment) {

    private val layoutInflater = classes.inflateMethod()
    private val bindView = classes.bindMethod()

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        return viewBinding?.run {
            return this

        } ?: let {

            val bind: T = if (thisRef.view == null) {
                layoutInflater.invoke(null, thisRef.layoutInflater) as T
            } else {
                bindView.invoke(null, thisRef.view) as T
            }

            return bind.apply { viewBinding = this }
        }
    }
}