package com.bj.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bj.kotlinproject.bean.HomeBean

/**
 * Created by 吴丽杰 on 2017/12/27.
 */
class HomeAdapter(context: Context,list: List<HomeBean>): RecyclerView.Adapter<HomeAdapter.MyViewHolder>(){
    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    class MyViewHolder(itemView: View?):RecyclerView.ViewHolder(itemView){

    }
}