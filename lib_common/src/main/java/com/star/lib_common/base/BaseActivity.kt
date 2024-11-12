package com.star.lib_common.base

import android.os.Bundle
import android.os.Parcelable
import androidx.annotation.StringRes
import androidx.appcompat.app.AppCompatActivity
import com.star.lib_common.extend.dismissLoadingDialog
import com.star.lib_common.extend.showLoadingDialog
import com.star.lib_common.network.constant.routerKey
import com.hjq.toast.Toaster
import com.star.lib_common.R
import com.therouter.TheRouter
import java.io.Serializable

/**
* Description:BaseActivity 基类
* Author:star
**/
abstract class BaseActivity : AppCompatActivity() {
    protected var Tag: String? = this::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentLayout()
        TheRouter.inject(this)
        initView(savedInstanceState)
        initData()
    }

    /**
     * 设置布局
     */
    open fun setContentLayout() {
        setContentView(getLayoutResId())
    }

    /**
     * 初始化视图
     * @return Int 布局id
     * 仅用于不继承BaseDataBindActivity类的传递布局文件
     */
    abstract fun getLayoutResId(): Int

    /**
     * 初始化布局
     * @param savedInstanceState Bundle?
     */
    abstract fun initView(savedInstanceState: Bundle?)

    /**
     * 初始化数据
     */
    open fun initData() {

    }

    /**
     * 加载中……弹框
     */
    fun showLoading() {
        showLoading(getString(R.string.default_loading))
    }

    /**
     * 加载提示框
     */
    fun showLoading(msg: String) {
        showLoadingDialog(msg)
    }

    /**
     * 加载提示框
     */
    fun showLoading(@StringRes res: Int) {
        showLoading(getString(res))
    }

    /**
     * 关闭提示框
     */
    fun dismissLoading() {
        dismissLoadingDialog()
    }

    /**
     * TheRouter页面导航
     */
    fun navigation(url: String, key: String = routerKey, value: Any? = null) {
        val build = TheRouter.build(url)
        value?.let {
            when (value) {
                is String -> {
                    build.withString(key, it as String)
                }
                is Int -> {
                    build.withInt(key, it as Int)
                }
                is Byte -> {
                    build.withByte(key, it as Byte)
                }
                is Boolean -> {
                    build.withBoolean(key, it as Boolean)
                }
                is Char -> {
                    build.withChar(key, it as Char)
                }
                is Double -> {
                    build.withDouble(key, it as Double)
                }
                is Float -> {
                    build.withFloat(key, it as Float)
                }
                is Long -> {
                    build.withLong(key, it as Long)
                }
                is Bundle -> {
                    build.withBundle(key, it as Bundle)
                }
                is Parcelable -> {
                    build.withParcelable(key, it as Parcelable)
                }
                is Serializable -> {
                    build.withSerializable(key, it as Serializable)
                }
                else -> {
                    build.withObject(key, it)
                }
            }
        }
        build.navigation()
    }

    /**
     * Toaster
     * @param msg Toast内容
     */
    fun showToast(msg: String) {
        Toaster.show(msg)
    }

    /**
     * Toaster
     * @param resId 字符串id
     */
    fun showToast(@StringRes resId: Int) {
        Toaster.show(resId)
    }
}