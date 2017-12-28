package com.bj.kotlinproject.model

import com.bj.kotlinproject.bean.HomeBean
import com.bj.kotlinproject.net.Api
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 吴丽杰 on 2017/12/27.
 */
class HomeModel {
    fun getDate(onFinish: OnFinish<List<HomeBean>>, num: Int, udid: String, vc: Int) {
        val service = RetrofitUtil.getInstance()?.getApiService(Api.BASEURL, ApiService::class.java)
        val homeData = service!!.getJXData(num, udid, vc)
        homeData!!.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeWith(object : DisposableSubscriber<List<HomeBean>>() {
                    override fun onNext(t: List<HomeBean>?) {
                        onFinish.onSuccess(t!!)
                    }
                    override fun onComplete() {
                    }
                    override fun onError(t: Throwable?) {
                    }
                })
    }
}