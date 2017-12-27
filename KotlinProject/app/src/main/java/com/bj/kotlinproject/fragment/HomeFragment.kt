package com.bj.kotlinproject.fragment

import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.bj.kotlinproject.R
import com.bj.kotlinproject.adapter.HomeAdapter
import com.bj.kotlinproject.base.BaseFragment
import com.bj.kotlinproject.bean.HomeBean
import com.bj.kotlinproject.presenter.HomePresenter
import com.bj.kotlinproject.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.title_bar.*

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class HomeFragment : BaseFragment<HomePresenter>(), HomeView {

    override fun setView(): Int =R.layout.fragment_home

    override fun initView(view: View) {
        tvTitle.text="WedneDay"
        ll_rlv.layoutManager=GridLayoutManager(context,1)
    }

    override fun initData() {
        val presenter = getPresenter()
        presenter.relevance(2,"26868b32e808498db32fd51fb422d00175e179df",83)
    }

    override fun getPresenter(): HomePresenter {
        val homePresenter = HomePresenter(this)
        return homePresenter
    }

    override fun getHomeData(homeBean: List<HomeBean>) {
        val adapter = HomeAdapter(context,homeBean)
        ll_rlv.adapter=adapter
    }

}