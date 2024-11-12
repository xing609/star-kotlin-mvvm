package com.star.lib_common.network.callback

import com.hjq.toast.Toaster

/**
* Description:接口请求错误回调
* Author:star
**/
interface IApiErrorCallback {
    /**
     * 错误回调处理
     */
    fun onError(code: Int?, error: String?) {
        Toaster.show(error)
    }

    /**
     * 登录失效处理
     */
    fun onLoginFail(code: Int?, error: String?) {
        Toaster.show(error)
    }
}