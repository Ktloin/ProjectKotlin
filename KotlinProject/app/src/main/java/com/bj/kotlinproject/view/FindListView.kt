package com.bj.kotlinproject.view

import com.bj.kotlinproject.bean.FindListBean

/**
 * Created by 郑文杰 on 2017/12/27.
 */
interface FindListView {
    abstract fun getFindListData(findListBean: FindListBean)
}