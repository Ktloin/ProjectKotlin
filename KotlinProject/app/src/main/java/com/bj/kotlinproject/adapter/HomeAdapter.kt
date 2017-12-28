package com.bj.kotlinproject.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.HomeBean

/**
 * Created by 吴丽杰 on 2017/12/27.
 */
class HomeAdapter(context: Context, list: List<HomeBean.IssueListBean.ItemListBean>) : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private var context: Context = context
    private var list: List<HomeBean.IssueListBean.ItemListBean> = list

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        var view = LayoutInflater.from(context).inflate(R.layout.home_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        val bean = list?.get(position)
        val title = bean?.data?.title

    }

    override fun getItemCount(): Int = list.size ?: 0

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var tv_detail : TextView?= null
        var tv_title : TextView ? = null
        var tv_time : TextView ? = null
        var iv_photo : ImageView? = null
        var iv_user : ImageView ? = null
        init {
            tv_detail = itemView?.findViewById(R.id.ll_tv_detail) as TextView?
            tv_title = itemView?.findViewById(R.id.ll_tv_title) as TextView?
            iv_photo = itemView?.findViewById(R.id.ll_iv_photo) as ImageView?
            iv_user =  itemView?.findViewById(R.id.ll_iv_user) as ImageView?
            //tv_title?.typeface = Typeface.createFromAsset( "fonts/FZLanTingHeiS-DB1-GB-Regular.TTF")

        }
    }
}