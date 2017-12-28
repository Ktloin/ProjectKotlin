package com.bj.kotlinproject.presenter

import com.bj.kotlinproject.bean.HotBean
import com.bj.kotlinproject.model.HotModel
import com.bj.kotlinproject.net.OnFinish
import com.bj.kotlinproject.view.HotView

/**
 * Created by 姚梦可 on 2017/12/27.
 */
class HotPresenter(hotView:HotView): OnFinish<HotBean> {

    var hotmodel:HotModel?= HotModel()
    var hotView:HotView?=hotView
    fun relevance(mStrategy:String){
        hotmodel!!.getHot(this,mStrategy)
    }
    override fun onSuccess(t: HotBean) {

        hotView!!.getHotData(t!!)
    }

}