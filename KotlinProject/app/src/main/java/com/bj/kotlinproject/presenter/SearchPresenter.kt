package com.bj.kotlinproject.presenter

import com.bj.kotlinproject.bean.SearchBean
import com.bj.kotlinproject.model.SearchModel
import com.bj.kotlinproject.net.OnFinish

/**
 * Created by 郑文杰 on 2017/12/28.
 */
class SearchPresenter(searchView: com.bj.kotlinproject.view.SearchView):OnFinish<SearchBean> {

    var searchView: com.bj.kotlinproject.view.SearchView =searchView
    var searchModel:SearchModel= SearchModel()

    fun relevance(num:Int,query:String,start:Int){
        searchModel.getData(this,num,query,start)
    }
    override fun onSuccess(t: SearchBean) {
        searchView.getSearchData(t!!)
    }
}