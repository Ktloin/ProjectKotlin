package com.bj.kotlinproject.activity

import android.content.Intent
import android.text.TextUtils
import android.view.View
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseActivity
import com.bj.kotlinproject.bean.SearchBean
import com.bj.kotlinproject.presenter.SearchPresenter
import kotlinx.android.synthetic.main.activity_search.*

class SearchActivity : BaseActivity<SearchPresenter>(),com.bj.kotlinproject.view.SearchView {


    override fun layoutId(): Int = R.layout.activity_search

    override fun initView() {
        ivBack.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                finish()
            }
        })

    }

    override fun getPresenter(): SearchPresenter {
        var presenter=SearchPresenter(this)
        return presenter
    }

    override fun initData() {
        ivSearch.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var keyWord=edSearch.text!!.toString()
                if (TextUtils.isEmpty(keyWord)){
                    Toast.makeText(this@SearchActivity,"请输入关键字",Toast.LENGTH_LONG).show()
                    return
                }
                var intent=Intent()
                intent.setClass(this@SearchActivity,SearchListActivity::class.java)
                intent.putExtra("keyword",keyWord)
                startActivity(intent)
            }
        })

    }

    override fun getSearchData(searchBean: SearchBean) {

    }

}
