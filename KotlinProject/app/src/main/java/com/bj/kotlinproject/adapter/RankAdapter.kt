package com.tt.lvruheng.eyepetizer.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.HotBean

/**
 * Created by lvruheng on 2017/7/7.
 */
class RankAdapter(context: Context, list: List<HotBean>) : RecyclerView.Adapter<RankAdapter.RankViewHolder>() {
    var context: Context? = null;
    var list: List<HotBean>? = null
    var inflater: LayoutInflater? = null

    init {
        this.context = context
        this.list = list
        this.inflater = LayoutInflater.from(context)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RankViewHolder {
        return RankViewHolder(inflater?.inflate(R.layout.item_rank, parent, false), context!!)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: RankViewHolder?, position: Int) {
        val dataBean = list?.get(0)?.itemList?.get(position)?.data
        holder?.tv_title?.text = dataBean?.title
        holder?.ll_hot?.setOnClickListener{
            litener?.onItemClick(position)
        }
    }


    class RankViewHolder(itemView: View?, context: Context) : RecyclerView.ViewHolder(itemView) {
        var iv_photo: ImageView = itemView?.findViewById(R.id.iv_photo) as ImageView
        var tv_title: TextView = itemView?.findViewById(R.id.tv_title) as TextView
        var tv_time: TextView = itemView?.findViewById(R.id.tv_time) as TextView
        var ll_hot: LinearLayout =itemView?.findViewById(R.id.ll_hot) as LinearLayout
    }
    interface OnItemClickLitener {
        fun onItemClick(position : Int)
    }
    var litener:OnItemClickLitener? =null
    fun setOniteClickListener(litener : OnItemClickLitener ){
        this.litener=litener
    }
}