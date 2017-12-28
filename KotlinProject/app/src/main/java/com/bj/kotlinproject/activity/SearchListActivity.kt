package com.bj.kotlinproject.activity

import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.bj.kotlinproject.R
import com.bj.kotlinproject.adapter.SearchListAdapter
import com.bj.kotlinproject.base.BaseActivity
import com.bj.kotlinproject.bean.SearchBean
import com.bj.kotlinproject.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search_list.*

class SearchListActivity : BaseActivity<SearchPresenter>(), com.bj.kotlinproject.view.SearchView {

    override fun layoutId(): Int = R.layout.activity_search_list

    override fun initView() {
        search_rv.layoutManager=LinearLayoutManager(this)
        ivBack.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })

    }

    override fun getPresenter(): SearchPresenter {
        var presenter = SearchPresenter(this)
        return presenter
    }

    override fun initData() {
        val keyWord = intent.getStringExtra("keyword")
        val presenter = getPresenter()
        textTitle.text="'"+keyWord+"'"+"相关"
        presenter.relevance(10,keyWord,10)
    }
    override fun getSearchData(searchBean: SearchBean) {
        val itemList = searchBean.itemList
        var adapter=SearchListAdapter(this,itemList)
        search_rv.adapter=adapter
    }

}
