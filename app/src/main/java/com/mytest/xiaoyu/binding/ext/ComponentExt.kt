package com.mytest.xiaoyu.binding.ext

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.mytest.xiaoyu.binding.viewbind.*


inline fun <reified T : ViewBinding> Activity.viewBind() =
    ActivityViewBinding(T::class.java, this)

inline fun <reified T : ViewBinding> Fragment.viewBind() =
    FragmentViewBinding(T::class.java, this)

inline fun <reified T : ViewBinding> viewBind() =
    ViewHolderViewBinding(T::class.java)

inline fun <reified T : ViewBinding> ViewGroup.viewBind() = ViewGroupViewBinding(
    T::class.java,
    LayoutInflater.from(context)
)

inline fun <reified T : ViewBinding> ViewGroup.viewBind(viewGroup: ViewGroup) =
    ViewGroupViewBinding(
        T::class.java,
        LayoutInflater.from(context),
        viewGroup
    )