package com.bj.kotlinproject.fragment


import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bj.kotlinproject.R
import com.bj.kotlinproject.activity.HomeDetaiActivity
import com.bj.kotlinproject.activity.SearchActivity
import com.bj.kotlinproject.adapter.HomeAdapter
import com.bj.kotlinproject.bean.HomeBean
import com.bj.kotlinproject.model.HomeModel
import com.bj.kotlinproject.presenter.HomePresenter
import com.bj.kotlinproject.view.HomeView
import kotlinx.android.synthetic.main.fragment_home.*

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
        var itemList = homeBean.issueList!!.get(0).itemList!!
        var homeAdpterr = HomeAdapter(activity, itemList)
        var linearLayoutManager = LinearLayoutManager(context)
        ll_rlv.setLayoutManager(linearLayoutManager)
        ll_rlv.adapter = homeAdpterr


        homeAdpterr.setOniteClickListener(object : HomeAdapter.OnItemClickLitener {
            override fun onItemClick(position: Int) {

                if (position==0){
                    val playUrl = itemList.get(position+3).data!!.playUrl
                    var play=itemList.get(position+3).data!!.playUrl
                    var blurred = itemList.get(position+3).data!!.cover!!.blurred
                    var feed = itemList.get(position+3).data!!.cover!!.feed
                    var description=itemList.get(position+3).data!!.description
                    var title=itemList.get(position+3).data!!.title
                    var intent=Intent()
                    intent.setClass(context, HomeDetaiActivity::class.java)
                    intent.putExtra("play",play)
                    intent.putExtra("blurred",blurred)
                    intent.putExtra("feed",feed)
                    intent.putExtra("descriptions", description)
                    intent.putExtra("title",title)
                    startActivity(intent)
                    Toast.makeText(context,"点击"+position+playUrl,Toast.LENGTH_LONG).show()

                }else{
                    val playUrl = itemList.get(position).data!!.playUrl
                    var play=itemList.get(position).data!!.playUrl
                    var blurred = itemList.get(position).data!!.cover!!.blurred
                    var feed = itemList.get(position).data!!.cover!!.feed
                    var description=itemList.get(position).data!!.description
                    var title=itemList.get(position).data!!.title
                    var intent=Intent()
                    intent.setClass(context, HomeDetaiActivity::class.java)
                    intent.putExtra("play",play)
                    intent.putExtra("blurred",blurred)
                    intent.putExtra("feed",feed)
                    intent.putExtra("descriptions", description)
                    intent.putExtra("title",title)
                    startActivity(intent)
                }
            }
        })
    }


}