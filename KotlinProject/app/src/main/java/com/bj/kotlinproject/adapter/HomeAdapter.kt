package com.bj.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.HomeBean
import com.facebook.drawee.view.SimpleDraweeView


class HomeAdapter(context: Context, list: List<HomeBean.IssueListBean.ItemListBean>) : RecyclerView.Adapter<HomeAdapter.MoHoder>() {


    private var context: Context = context
    private var list: List<HomeBean.IssueListBean.ItemListBean> = list

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MoHoder {
        return MoHoder(LayoutInflater.from(context).inflate(R.layout.home_item, parent, false))
    }

    override fun onBindViewHolder(holder: MoHoder?, position: Int) {

        var feed: String? = null
        var title: String? = null
        var category: String? = null
        var icon: String? = null
        var playUrl:String?=null
        val bean = list?.get(position)

        if (position==0){
            var bean = list.get(position+3)
            feed = list!!.get(position+3)!!.data!!.cover!!.feed
            icon = list?.get(position+3)?.data?.author?.icon
            title = list?.get(position+3)?.data?.title
            playUrl=list?.get(position+3)?.data?.playUrl
        }else{
            feed = list?.get(position)?.data?.cover?.feed
            icon = list?.get(position)?.data?.author?.icon
            title = list?.get(position)?.data?.title
            playUrl=list?.get(position)?.data?.playUrl
        }

        holder?.home_feed?.setImageURI(feed)
        holder?.home_category?.text = title
        holder?.home_icon?.setImageURI(icon)


        holder?.rl?.setOnClickListener({
            litener!!.onItemClick(position)
        })
    }

    override fun getItemCount(): Int =list.size

    class MoHoder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var home_icon = itemview!!.findViewById(R.id.ll_iv_user) as SimpleDraweeView
        var home_feed = itemview!!.findViewById(R.id.ll_iv_photo) as SimpleDraweeView
        var home_category = itemview!!.findViewById(R.id.ll_tv_title) as TextView
        var rl=itemview!!.findViewById<RelativeLayout>(R.id.rl) as RelativeLayout
    }

    var litener: OnItemClickLitener? = null
    interface OnItemClickLitener {
        fun onItemClick(position: Int)
    }

    fun setOniteClickListener(litener: OnItemClickLitener) {
        this.litener = litener
    }

}