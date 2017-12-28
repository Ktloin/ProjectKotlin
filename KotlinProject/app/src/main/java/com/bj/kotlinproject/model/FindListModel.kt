package com.bj.kotlinproject.model

import com.bj.kotlinproject.bean.FindListBean
import com.bj.kotlinproject.net.Api
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindListModel {
    fun getData(onFinish: OnFinish<FindListBean>,categoryName:String ,strategy:String,udid:String ,vc:Int){
        val apiService = RetrofitUtil.getInstance()?.getApiService(Api.BASEURL, ApiService::class.java)
        val findListData = apiService!!.getFindListData(categoryName, strategy, udid, vc)
        findListData!!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<FindListBean>() {
                    override fun onNext(t: FindListBean?) {
                        onFinish.onSuccess(t!!)
                    }

                    override fun onError(t: Throwable?) {
                    }

                    override fun onComplete() {
                    }

                })
    }
}