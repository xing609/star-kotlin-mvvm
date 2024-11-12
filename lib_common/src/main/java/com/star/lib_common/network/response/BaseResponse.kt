package com.star.lib_common.network.response
/**
* Description:请求返回数据基类
* Author:star
**/
data class BaseResponse<out T>(
    val data: T?,
    val errorCode: Int = 0,//服务器状态码 这里0表示请求成功
    val errorMsg: String = ""//错误信息
) {

    /**
     * 判定接口返回是否正常
     */
    fun isFailed(): Boolean {
        return errorCode != 0
    }
}
