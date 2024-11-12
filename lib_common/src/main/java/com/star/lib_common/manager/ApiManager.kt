package com.star.lib_common.manager

import com.star.lib_common.network.api.ApiInterface
/**
* Description:API管理器
* Author:star
**/
object ApiManager {
    val api by lazy { HttpManager.create(ApiInterface::class.java) }
}