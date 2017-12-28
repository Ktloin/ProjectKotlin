package com.bj.kotlinproject.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.activity.FindDetailActivity
import com.bj.kotlinproject.activity.HomeDetaiActivity
import com.bj.kotlinproject.activity.SearchActivity
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
class HomeFragment<T : HomeModel> : Fragment(), HomeView {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = inflater!!.inflate(R.layout.fragment_home, container, false)
        var ll_rlv = view.findViewById(R.id.ll_rlv) as RecyclerView
        val textView = view.findViewById<TextView>(R.id.tvTitle) as TextView
        val ivBars = view.findViewById<ImageView>(R.id.ivBar) as ImageView
        textView.text = "Wedneday"
        ivBars.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                var intent= Intent()
                intent.setClass(context, SearchActivity::class.java)
                startActivity(intent)
            }
        })
        val homePresenter = HomePresenter(this)
        homePresenter.relevance(2, "26868b32e808498db32fd51fb422d00175e179df", 83)
        return view
    }

    override fun getHomeData(homeBean: HomeBean) {
        val itemList = homeBean.issueList!!.get(0).itemList!!
        val homeAdpterr = HomeAdapter(activity, itemList)
        var linearLayoutManager = LinearLayoutManager(activity)
        ll_rlv.setLayoutManager(linearLayoutManager)
        ll_rlv.adapter = homeAdpterr


        homeAdpterr.setOniteClickListener(object : HomeAdapter.OnItemClickLitener {
            override fun onItemClick(position: Int) {

                val playUrl = itemList.get(position).data!!.playUrl
                val description = itemList.get(position).data!!.description
                val title = itemList.get(position).data!!.title
                //val blurred = itemList.get(position).data!!.cover!!.blurred
                //val feed = itemList.get(position).data!!.cover!!.feed
                var intent: Intent = Intent()
                intent.setClass(context, HomeDetaiActivity::class.java)
                intent.putExtra("playUrls", playUrl)
                intent.putExtra("descriptions", description)
                //intent.putExtra("feeds", feed)
                intent.putExtra("titles", title)
                //intent.putExtra("blurreds", blurred)
                startActivity(intent)
            }
        })
    }


}