package com.star.mvvm

import android.os.Bundle
import android.view.View
import com.star.lib_common.base.BaseViewBindActivity
import com.star.lib_common.network.constant.HomeActivity
import com.star.lib_common.utils.DataStoreUtils
import com.star.mvvm.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
* Description:主界面
* Author:star
**/
class MainActivity : BaseViewBindActivity<ActivityMainBinding>() {

    override fun initView(savedInstanceState: Bundle?) {

    }

    fun test(view: View) {
        CoroutineScope(Dispatchers.Main).launch {
            DataStoreUtils.saveStringData("WWW","www")
        }
        navigation(HomeActivity)
    }
}