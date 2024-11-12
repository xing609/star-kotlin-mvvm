package com.star.lib_common.base

import android.view.LayoutInflater
import androidx.viewbinding.ViewBinding
import com.star.lib_common.extend.saveAs
import com.star.lib_common.extend.saveAsUnChecked
import java.lang.reflect.ParameterizedType
/**
* Description:dataBinding Activity基类
* Author:star
**/
abstract class BaseViewBindActivity<DB : ViewBinding> : BaseActivity() {
    lateinit var mBinding: DB

    override fun setContentLayout() {
        val type = javaClass.genericSuperclass
        val vbClass: Class<DB> = type!!.saveAs<ParameterizedType>().actualTypeArguments[0].saveAs()
        val method = vbClass.getDeclaredMethod("inflate", LayoutInflater::class.java)
        mBinding = method.invoke(this, layoutInflater)!!.saveAsUnChecked()
        setContentView(mBinding.root)
    }

    override fun getLayoutResId(): Int = 0
}