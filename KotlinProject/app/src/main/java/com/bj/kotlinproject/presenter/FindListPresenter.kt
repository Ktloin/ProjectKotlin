package com.bj.kotlinproject.presenter

import com.bj.kotlinproject.bean.FindListBean
import com.bj.kotlinproject.model.FindListModel
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.view.FindListView

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindListPresenter(findListView: FindListView):OnFinish<FindListBean> {

    var findListModel:FindListModel= FindListModel()
    var findListView: FindListView =findListView
    fun relevance(categoryName:String ,strategy:String,udid:String ,vc:Int){
        findListModel.getData(this,categoryName,strategy,udid,vc)
    }
    override fun onSuccess(t: FindListBean) {
        findListView.getFindListData(t!!)
    }
}