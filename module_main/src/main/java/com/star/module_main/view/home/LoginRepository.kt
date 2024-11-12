package com.star.module_main.view.home

import com.star.lib_common.manager.ApiManager
import com.star.lib_common.model.User
import com.star.lib_common.network.repository.BaseRepository

/**
* Description:
* Author:star
**/
class LoginRepository : BaseRepository() {

    /**
     * 登录
     * @param username  用户名
     * @param password  密码
     */
    suspend fun login(username: String, password: String): User? {
        return requestResponse {
            ApiManager.api.login(username, password)
        }
    }
}