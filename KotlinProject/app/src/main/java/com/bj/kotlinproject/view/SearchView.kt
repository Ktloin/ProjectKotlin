package com.bj.kotlinproject.view

import com.bj.kotlinproject.bean.SearchBean

/**
 * Created by 郑文杰 on 2017/12/28.
 */
interface SearchView {
    abstract fun getSearchData(searchBean:SearchBean)
}