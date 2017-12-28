package com.bj.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.SearchBean
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 郑文杰 on 2017/12/28.
 */
class SearchListAdapter(context: Context, itemList: List<SearchBean.ItemListBean>?) : RecyclerView.Adapter<SearchListAdapter.MyViewHolder>() {


    var context: Context = context
    var itemList: List<SearchBean.ItemListBean>? = itemList

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.search_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.sdv?.setImageURI(itemList!!.get(position).data!!.cover!!.feed)
        holder?.tvTitle?.text=""+itemList!!.get(position).data!!.title
        holder?.tvType?.text=itemList!!.get(position).data!!.category
    }


    override fun getItemCount(): Int =itemList!!.size

    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var sdv = itemView!!.findViewById<SimpleDraweeView>(R.id.sdv) as SimpleDraweeView
        var tvTitle = itemView!!.findViewById<TextView>(R.id.tvTilte) as TextView
        var tvType = itemView!!.findViewById<TextView>(R.id.tvType) as TextView
    }
}