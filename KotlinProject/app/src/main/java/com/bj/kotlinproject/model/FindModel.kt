package com.bj.kotlinproject.model

import com.bj.kotlinproject.bean.FindBean
import com.bj.kotlinproject.net.Api
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindModel {
    fun getData(onFinish: OnFinish<List<FindBean>>,udid:String,vc:Int){
        val apiService = RetrofitUtil.getInstance()?.getApiService(Api.BASEURL, ApiService::class.java)
        val findData = apiService!!.getFindData(udid, vc)
        findData!!.subscribeOn(Schedulers.io())
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribeWith(object : DisposableSubscriber<List<FindBean>>() {
                    override fun onNext(t: List<FindBean>?) {
                        onFinish.onSuccess(t!!)
                    }

                    override fun onComplete() {
                    }

                    override fun onError(t: Throwable?) {
                    }

                })
    }
}