package com.bj.kotlinproject.activity

import android.content.Intent
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bj.kotlinproject.R
import com.bj.kotlinproject.adapter.FindListAdapter
import com.bj.kotlinproject.base.BaseActivity
import com.bj.kotlinproject.bean.FindListBean
import com.bj.kotlinproject.presenter.FindListPresenter
import com.bj.kotlinproject.view.FindListView
import com.umeng.analytics.MobclickAgent
import kotlinx.android.synthetic.main.activity_find_list.*

class FindListActivity : BaseActivity<FindListPresenter>(),FindListView {

    override fun layoutId(): Int = R.layout.activity_find_list

    override fun initView() {
        rlv.layoutManager=LinearLayoutManager(this)

    }

    override fun getPresenter(): FindListPresenter {
        var findListPresenter=FindListPresenter(this)
        return findListPresenter
    }

    override fun initData() {
        var name=intent.getStringExtra("titleName")
        textTitle.text=name
        ivBack.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })
        val presenter = getPresenter()
        presenter.relevance(name,"date","26868b32e808498db32fd51fb422d00175e179df",83)
    }

    override fun getFindListData(findListBean: FindListBean) {
        val itemList = findListBean.itemList
        var adapter=FindListAdapter(this,itemList)
        rlv.adapter=adapter
        adapter.setOnItemClickListener(object : FindListAdapter.OnItemClickLitener{
            override fun OnItemClick(position: Int) {
                MobclickAgent.onEvent(this@FindListActivity, "click_bt");
                val playUrl = itemList!!.get(position)!!.data!!.playUrl
                val category = itemList!!.get(position)!!.data!!.category
                var intent=Intent()
                intent.setClass(this@FindListActivity,FindDetailActivity::class.java)
                intent.putExtra("cate",category)
                intent.putExtra("position",position)
                startActivity(intent)
            }

        })
    }

}
