package com.bj.kotlinproject.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.adapter.HomeAdapter
import com.bj.kotlinproject.base.BaseFragment
import com.bj.kotlinproject.bean.HomeBean
import com.bj.kotlinproject.model.HomeModel
import com.bj.kotlinproject.presenter.HomePresenter
import com.bj.kotlinproject.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.title_bar.*

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class HomeFragment<T:HomeModel>: Fragment(), HomeView {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.fragment_home, container, false)
        var ll_rlv=view.findViewById(R.id.ll_rlv) as RecyclerView
        val homePresenter = HomePresenter(this)
        homePresenter.relevance(2,"26868b32e808498db32fd51fb422d00175e179df",83)
        return view
    }
    override fun getHomeData(homeBean: HomeBean) {
        val itemList = homeBean.issueList!!.get(1).itemList!!
        val homeAdpterr = HomeAdapter(activity, itemList)
        var linearLayoutManager=LinearLayoutManager(activity)
        ll_rlv.setLayoutManager(linearLayoutManager)

        /*homeAdpterr.setOnItemClickListener(object :HomeAdapter.OnItemClickLitener{

        })*/
        /*homeAdpterr.setOniteClickListener(object :HomeAdpterr.OnItemClickLitener{
            override fun onItemClick(position: Int) {
                var intent:Intent=Intent()
                intent.setClass(activity,ShipingActivity::class.java)
                startActivity(intent)
            }
        })*/
        ll_rlv.adapter=homeAdpterr
    }


}