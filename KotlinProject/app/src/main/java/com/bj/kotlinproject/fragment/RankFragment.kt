package com.bj.kotlinproject.fragment

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.activity.HotDetailActivity
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
    override fun getHotData(hotBean: HotBean) {
        val list = hotBean.itemList
        var mAdapter = RankAdapter(context, list!!)
        recyclerView.adapter = mAdapter
        mAdapter.setOniteClickListener(object : RankAdapter.OnItemClickLitener {
            override fun onItemClick(position: Int) {
                val playUrl = hotBean.itemList!!.get(position).data!!.playUrl
                val description = hotBean.itemList!!.get(position).data!!.description
                val category = hotBean.itemList!!.get(position).data!!.category
                val title = hotBean.itemList!!.get(position).data!!.title;
                val feed = list!!.get(position)?.data?.cover?.feed
                val blurred = list?.get(position)?.data?.cover?.blurred
                Toast.makeText(activity,"我点击了"+position, Toast.LENGTH_LONG).show()
                var intent= Intent()
                intent.setClass(activity, HotDetailActivity::class.java)
                intent.putExtra("playUrl",playUrl)
                intent.putExtra("title",title)
                intent.putExtra("description",description)
                intent.putExtra("category",category)
                intent.putExtra("position",position)
                intent.putExtra("feed",feed)
                intent.putExtra("blurred",blurred)
                startActivity(intent)
            }

        })
        mAdapter.notifyDataSetChanged()

    }
}