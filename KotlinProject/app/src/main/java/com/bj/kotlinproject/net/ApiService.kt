package com.bj.kotlinproject.net

import com.bj.kotlinproject.bean.FindBean
import com.bj.kotlinproject.bean.FindListBean
import com.bj.kotlinproject.bean.HomeBean
import com.bj.kotlinproject.bean.HotBean
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Query


/**
 * Created by 郑文杰 on 2017/12/27.
 */
interface ApiService {

    //每日精选  http://baobab.wandoujia.com/api/v2/feed?num=2&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v2/feed")
    fun getJXData(@Query("num") num: Int, @Query("udid") udid: String, @Query("vc") vc: Int): Flowable<List<HomeBean>>

    //发现更多 http://baobab.wandoujia.com/api/v2/categories?udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v2/categories")
    fun getFindData(@Query("udid") udid: String, @Query("vc") vc: Int) :Flowable<List<FindBean>>

    //发现列表http://baobab.wandoujia.com/api/v3/videos?categoryName=时尚&strategy=date&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v3/videos")
    fun getFindListData(@Query("categoryName")categoryName:String,@Query("strategy")strategy:String ,@Query("udid") udid:String ,@Query("vc") vc:Int) :Flowable<FindListBean>
    //热点 http://baobab.kaiyanapp.com/api/v3/ranklist?num=10&strategy=%s&udid=26868b32e808498db32fd51fb422d00175e179df&vc=83
    @GET("v3/ranklist")
    fun getHotData(@Query("num") num: Int, @Query("strategy") strategy: String, @Query("udid") udid: String,@Query("vc") vc: Int) :Flowable<List<HotBean>>
}