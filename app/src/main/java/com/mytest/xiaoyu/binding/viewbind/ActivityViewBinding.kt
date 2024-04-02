package com.mytest.xiaoyu.binding.viewbind

import android.app.Activity
import androidx.viewbinding.ViewBinding
import com.mytest.xiaoyu.binding.base.ActivityDelegate
import com.mytest.xiaoyu.binding.ext.inflateMethod
import kotlin.reflect.KProperty


class ActivityViewBinding<T : ViewBinding>(
    classes: Class<T>,
    val activity: Activity
) : ActivityDelegate<T>(activity) {

    private var layoutInflater = classes.inflateMethod()

    override fun getValue(thisRef: Activity, property: KProperty<*>): T {
        return viewBinding?.run {
            this

        } ?: let {
            addLifecycleFragment(activity)
            val bind = layoutInflater.invoke(null, thisRef.layoutInflater) as T
            thisRef.setContentView(bind.root)
            return bind.apply { viewBinding = this }
        }
    }

}