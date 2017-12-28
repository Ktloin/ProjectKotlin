package com.bj.kotlinproject.model

import android.util.Log
import com.bj.kotlinproject.bean.HotBean
import com.bj.kotlinproject.net.Api
import com.bj.kotlinproject.net.ApiService
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 努力努力再努力 on 2017/12/27.
 */
class HotModel {
    //http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    fun getHot(onFinish: OnFinish<List<HotBean>>, mStrategy: String){
        val apiService = RetrofitUtil.getInstance()?.getApiService(Api.BASEURL, ApiService::class.java)
        val flowable = apiService!!.getHotData(10, mStrategy, "26868b32e808498db32fd51fb422d00175e179df", 83)
        flowable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<List<HotBean>>() {
                    override fun onNext(t: List<HotBean>?) {
                        onFinish.onSuccess(t!!)
                    }

                    override fun onError(t: Throwable?) {
                        Log.i("aaaa", t?.message)
                    }

                    override fun onComplete() {
                    }

                })
    }
}