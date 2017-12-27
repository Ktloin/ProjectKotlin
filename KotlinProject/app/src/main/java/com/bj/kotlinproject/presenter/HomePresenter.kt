package com.bj.kotlinproject.presenter

import com.bj.kotlinproject.bean.HomeBean
import com.bj.kotlinproject.model.HomeModel
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.view.HomeView

/**
 * Created by 吴丽杰 on 2017/12/27.
 */
class HomePresenter(homeView: HomeView):OnFinish<List<HomeBean>> {
    var homeModel:HomeModel?= HomeModel()
    var homeView:HomeView?=homeView
    fun relevance(num:Int,udid:String,vc:Int){
        homeModel!!.getDate(this,num, udid, vc)
    }
    override fun onSuccess(t: List<HomeBean>) {
        homeView!!.getHomeData(t!!)
    }
}