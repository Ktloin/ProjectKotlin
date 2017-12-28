package com.bj.kotlinproject.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<T> : AppCompatActivity() {

    var presenter:T?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutId())

        initView()
        initData()
        presenter=getPresenter()
    }

    //加载布局
    abstract fun layoutId():Int
    //初始化布局
    abstract fun initView()
    //初始化p层
    internal abstract fun getPresenter(): T
    //初始化数据
    abstract fun initData()


}
