package com.bj.kotlinproject.fragment

import android.content.Intent
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.bj.kotlinproject.R
import com.bj.kotlinproject.activity.FindListActivity
import com.bj.kotlinproject.adapter.FindAdapter
import com.bj.kotlinproject.base.BaseFragment
import com.bj.kotlinproject.bean.FindBean
import com.bj.kotlinproject.presenter.FindPresenter
import com.bj.kotlinproject.view.FindView
import kotlinx.android.synthetic.main.fragment_find.*
import kotlinx.android.synthetic.main.title_bar.*

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindFragment : BaseFragment<FindPresenter>(),FindView {


    override fun setView(): Int = R.layout.fragment_find

    override fun initView(view: View) {
        tvTitle.text="Discover"
        rv.layoutManager=GridLayoutManager(context,2)

    }

    override fun initData() {
        val presenter = getPresenter()
        presenter.relevance("26868b32e808498db32fd51fb422d00175e179df",83)
    }

    override fun getPresenter(): FindPresenter {
        var presenter=FindPresenter(this)
        return presenter
    }

    override fun getFindData(findBean: List<FindBean>) {
        val adapter=FindAdapter(context,findBean)
        rv.adapter=adapter
        adapter.setOnItemClickListener(object : FindAdapter.OnItemClickLitener{
            override fun OnItemClick(position: Int) {
                val name = findBean.get(position).name
                //Toast.makeText(context,findBean.get(position).name,Toast.LENGTH_LONG).show()
                val intent=Intent()
                intent.setClass(context,FindListActivity::class.java)
                intent.putExtra("titleName",name)
                startActivity(intent)
            }

        })
    }
}