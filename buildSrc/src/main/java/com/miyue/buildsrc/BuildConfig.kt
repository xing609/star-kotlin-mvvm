package com.miyue.buildsrc

/**
* Description:统一配置
* Author:star
**/
object Super{
    // isModule 为 true 时可以使每个组件独立运行, false 则可以将所有组件集成到宿主 App 中
    const val isModule = false
}

object Versions {
    const val compileSdk = 34
    const val buildToolsVersion = "34.0.0"
    const val minSdk = 21
    const val targetSdk = 34
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object SigningConfig {
    const val storePassword = "123456"
    const val keyAlias = "superstar"
    const val keyPassword = "123456"
}

object DependenciesLibs {
    const val coreKtx = "androidx.core:core-ktx:+"
    const val appcompat = "androidx.appcompat:appcompat:1.6.1"
    const val material = "com.google.android.material:material:1.8.0"
    const val constraintlayout = "androidx.constraintlayout:constraintlayout:2.1.4"
    const val liveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.5.1"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.5.1"
    const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:2.3.5"
    const val navigationUI = "androidx.navigation:navigation-ui-ktx:2.3.5"

    //三方库 material-dialogs
    private const val materialDialogVersion = "3.3.0"
    const val materialDialogsLifecycle = "com.afollestad.material-dialogs:lifecycle:${materialDialogVersion}"
    const val materialDialogsCore = "com.afollestad.material-dialogs:core:${materialDialogVersion}"
    const val materialDialogsColor = "com.afollestad.material-dialogs:color:${materialDialogVersion}"

    //room数据库
    const val roomKtx = "androidx.room:room-ktx:2.5.0"
    const val roomCompiler = "androidx.room:room-compiler:2.5.0"

    const val multidex = "androidx.multidex:multidex:2.0.1"
    //网络请求
    const val okhttp = "com.squareup.okhttp3:okhttp:4.11.0"
    const val retrofit2 = "com.squareup.retrofit2:retrofit:2.9.0"
    const val retrofit2Gson = "com.squareup.retrofit2:converter-gson:2.4.0"
    //日志打印
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.11.0"

    const val gson = "com.google.code.gson:gson:2.10.1"
    const val xlog = "com.tencent.mars:mars-xlog:1.2.5"

    //下拉刷新
    private const val refreshLayoutVersion = "2.0.5"
    const val refreshLayout = "io.github.scwang90:refresh-layout-kernel:${refreshLayoutVersion}"
    const val refreshHeader = "io.github.scwang90:refresh-header-classics:${refreshLayoutVersion}"
    const val refreshFooter = "io.github.scwang90:refresh-footer-classics:${refreshLayoutVersion}"

    //图片加载
    private const val glideVersion = "4.15.0"
    const val glide = "com.github.bumptech.glide:glide:${glideVersion}"
    const val glideCompiler = "com.github.bumptech.glide:compiler:${glideVersion}"

    //权限处理
    const val rxPermission = "com.github.tbruyelle:rxpermissions:0.12"
    const val rxjava = "io.reactivex.rxjava3:rxjava:3.1.6"
    const val rxandroid = "io.reactivex.rxjava3:rxandroid:3.0.2"

    // Toaster框架：https://github.com/getActivity/Toaster
    const val toaster = "com.github.getActivity:Toaster:12.6"
    // utilcodex工具类：https://blankj.com/2016/07/31/android-utils-code/
    const val utilcodex = "com.blankj:utilcodex:1.30.1"

    private const val therouterVersion = "1.1.3"
    const val therouterApt = "cn.therouter:apt:${therouterVersion}"
    const val therouter = "cn.therouter:router:${therouterVersion}"
    // 键值对存取工具，类似SP
    const val datastore = "androidx.datastore:datastore-preferences:1.0.0"
    // 协程
    const val coroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.1"
}