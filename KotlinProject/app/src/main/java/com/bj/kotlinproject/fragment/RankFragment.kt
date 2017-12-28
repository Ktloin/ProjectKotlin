package com.bj.kotlinproject.fragment

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseFragment
import com.bj.kotlinproject.bean.HotBean
import com.bj.kotlinproject.presenter.HotPresenter
import com.bj.kotlinproject.view.HotView
import com.tt.lvruheng.eyepetizer.adapter.RankAdapter
import kotlinx.android.synthetic.main.rank_fragment.*

/**
 * Created by 努力努力再努力 on 2017/12/27.
 */
class RankFragment() : BaseFragment<HotPresenter>(),HotView {


    override fun setView(): Int =R.layout.rank_fragment


    override fun initView(view: View) {
        recyclerView.layoutManager = LinearLayoutManager(context)
    }

    override fun getPresenter(): HotPresenter {
       return HotPresenter(this)
    }

    override fun initData() {
        if (arguments != null) {
            var mStrategy = arguments.getString("strategy")
            presenter!!.relevance(mStrategy)
        }
    }
    override fun getHotData(hotBean: List<HotBean>) {
        var mAdapter = RankAdapter(context, hotBean)
        recyclerView.adapter = mAdapter
        mAdapter.setOniteClickListener(object : RankAdapter.OnItemClickLitener {
            override fun onItemClick(position: Int) {
                Toast.makeText(activity,"我点击了"+position, Toast.LENGTH_LONG).show()

            }

        })
        mAdapter.notifyDataSetChanged()

    }
}