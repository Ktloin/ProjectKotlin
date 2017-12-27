package com.bj.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.FindBean
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindAdapter(context: Context, list: List<FindBean>) : RecyclerView.Adapter<FindAdapter.MyViewHolder>() {

    private var context: Context = context
    private var list: List<FindBean> = list
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.find_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.tvName?.text=list.get(position).name
        holder?.sdv?.setImageURI(list.get(position).bgPicture)
    }

    override fun getItemCount(): Int =list.size

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var sdv = itemView!!.findViewById<SimpleDraweeView>(R.id.sdv) as SimpleDraweeView
        var tvName = itemView!!.findViewById<TextView>(R.id.tvName) as TextView
    }

}