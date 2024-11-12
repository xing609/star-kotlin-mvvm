package com.star.lib_common.network.api

import com.star.lib_common.model.CategoryItem
import com.star.lib_common.model.User
import com.star.lib_common.network.response.BaseResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
/**
* Description:API接口类
* Author:star
**/
interface ApiInterface {

    /**
     * todo 示例
     * 分类列表
     */
    @GET("/xxx/")
    suspend fun getCategoryData(): BaseResponse<MutableList<CategoryItem>>?

    /**
     * 登录
     * @param username  用户名
     * @param password  密码
     */
    @FormUrlEncoded
    @POST("/user/login")
    suspend fun login(
        @Field("username") username: String,
        @Field("password") password: String,
    ): BaseResponse<User?>?
}