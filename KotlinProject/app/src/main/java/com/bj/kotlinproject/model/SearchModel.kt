package com.bj.kotlinproject.model

import com.bj.kotlinproject.bean.SearchBean
import com.bj.kotlinproject.net.Api
import com.bj.kotlinproject.net.ApiService
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.net.RetrofitUtil
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber

/**
 * Created by 郑文杰 on 2017/12/28.
 */
class SearchModel {
    fun getData(onFinish: OnFinish<SearchBean>,num:Int,query:String,start:Int){
        val apiService = RetrofitUtil.getInstance()?.getApiService(Api.BASEURL, ApiService::class.java)
        val searchData = apiService!!.getSearchData(num, query, start)
        searchData.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSubscriber<SearchBean>() {
                    override fun onNext(t: SearchBean?) {
                        onFinish.onSuccess(t!!)
                    }

                    override fun onError(t: Throwable?) {
                    }

                    override fun onComplete() {
                    }

                })
    }
}