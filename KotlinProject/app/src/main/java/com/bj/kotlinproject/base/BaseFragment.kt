package com.bj.kotlinproject.base

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager

/**
 * Created by 郑文杰 on 2017/12/27.
 */
abstract class BaseFragment<T> : Fragment() {

    var presenter:T?=null
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            val window = activity.window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor=activity.resources.getColor(Color.BLUE)
        }
        var view = LayoutInflater.from(context).inflate(setView(), container, false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view!!)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        presenter=getPresenter()
        initData()
    }
    //初始化布局
    abstract fun setView(): Int
    //初始化view
    abstract fun initView(view:View)
    //初始化p层
    internal abstract fun getPresenter():T
    //初始化数据
    abstract fun initData()

}