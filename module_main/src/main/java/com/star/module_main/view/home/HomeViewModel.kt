package com.star.module_main.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.star.lib_common.base.BaseViewModel
import com.star.lib_common.manager.ApiManager
import com.star.lib_common.network.callback.IApiErrorCallback
import com.star.lib_common.model.CategoryItem
import com.star.lib_common.model.User
import com.hjq.toast.Toaster

/**
* Description:todo 示例
* Author:star
**/
class HomeViewModel : BaseViewModel() {

    val get = MutableLiveData<MutableList<CategoryItem>?>()
    val post = MutableLiveData<User?>()
    val loginRepository by lazy { LoginRepository() }

    fun getCategoryData() {
        launchUIWithResult(responseBlock = {
            ApiManager.api.getCategoryData()
        }, errorCall = object : IApiErrorCallback {
            override fun onError(code: Int?, error: String?) {
                super.onError(code, error)
                Toaster.show(error)
                get.value = null
            }
        }) {
            get.value = it
        }
    }

    fun login(username: String = "12345678", password: String = "12345678"): LiveData<User?> {
        launchUI(errorBlock = { _, error ->
            Toaster.show(error)
            post.value = null
        }) {
            val data = loginRepository.login(username, password)
            post.value = data
        }
        return post
    }

    /**
     * 带对话框的请求
     */
    fun getCategoryData(showLoading: (Boolean) -> Unit): MutableLiveData<MutableList<CategoryItem>?> {
        launchFlow(errorCall = object : IApiErrorCallback {
            override fun onError(code: Int?, error: String?) {
                super.onError(code, error)
                get.value = null
            }

            override fun onLoginFail(code: Int?, error: String?) {
                super.onLoginFail(code, error)
                get.value = null
            }
        }, requestCall = {
            ApiManager.api.getCategoryData()
        }, showLoading = showLoading) {
            get.value = it
        }
        return get
    }
}