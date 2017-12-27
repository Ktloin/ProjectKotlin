package com.bj.kotlinproject.view

import com.bj.kotlinproject.bean.HomeBean

/**
 * Created by 吴丽杰 on 2017/12/27.
 */
interface HomeView {
    abstract fun getHomeData(homeBean: List<HomeBean>)
}