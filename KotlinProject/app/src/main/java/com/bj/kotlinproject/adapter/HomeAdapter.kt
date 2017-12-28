package com.bj.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.HomeBean
import com.facebook.drawee.view.SimpleDraweeView


class HomeAdapter(context: Context, list: List<HomeBean.IssueListBean.ItemListBean>) : RecyclerView.Adapter<HomeAdapter.MoHoder>() {
    override fun getItemCount(): Int {
        return list.size
    }

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
        val bean = list?.get(position)


        if (position > 0) {
            var bean = list.get(position)


            feed = list?.get(position)?.data?.cover?.feed
            icon = list?.get(position)?.data?.author?.icon
            title = list?.get(position)?.data?.title
        } else {
            feed = list?.get(5)?.data?.cover?.feed
            icon = list?.get(5)?.data?.author?.icon
            title = list?.get(5)?.data?.title
        }
        holder?.home_feed?.setImageURI(feed)
        holder?.home_category?.text = "发布于 $category"
        holder?.home_icon?.setImageURI(icon)

        holder?.home_feed?.setOnClickListener {
            litener?.onItemClick(position)
        }
    }

    class MoHoder(itemview: View) : RecyclerView.ViewHolder(itemview) {
        var home_icon: SimpleDraweeView = itemview!!.findViewById(R.id.ll_iv_user) as SimpleDraweeView
        var home_feed: SimpleDraweeView = itemview!!.findViewById(R.id.ll_iv_photo) as SimpleDraweeView
        var home_category: TextView = itemview!!.findViewById(R.id.ll_tv_title) as TextView
    }


    interface OnItemClickLitener {
        fun onItemClick(position: Int)
    }

    var litener: OnItemClickLitener? = null
    fun setOniteClickListener(litener: OnItemClickLitener) {
        this.litener = litener
    }

}