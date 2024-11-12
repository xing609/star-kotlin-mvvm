package com.star.module_main.view.home

import android.os.Bundle
import android.view.View
import com.star.lib_common.base.BaseMvvmActivity
import com.star.lib_common.network.constant.HomeActivity
import com.star.lib_common.utils.DataStoreUtils
import com.star.module_main.R
import com.star.module_main.databinding.ActivityHomeBinding
import com.hjq.toast.Toaster
import com.therouter.router.Route
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Route(path = HomeActivity)
class HomeActivity : BaseMvvmActivity<ActivityHomeBinding, HomeViewModel>(), View.OnClickListener {

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.post.setOnClickListener(this)
        mBinding.get.setOnClickListener(this)

        /*mViewModel.getCategoryData(){ showLoading ->
            if (showLoading) {
                showLoading()
            } else {
                dismissLoading()
            }
        }*/

        CoroutineScope(Dispatchers.Main).launch {
            Toaster.show(DataStoreUtils.getSyncData("WWW","0"))
        }
    }

    override fun createObserver() {
        mViewModel.run {
            post.observe(this@HomeActivity) {
                Toaster.show("post请求成功")
            }
            get.observe(this@HomeActivity) {
                Toaster.show("get请求成功")
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.get -> {
                mViewModel.getCategoryData()
            }
            R.id.post -> {
                mViewModel.login()
            }
        }
    }
}