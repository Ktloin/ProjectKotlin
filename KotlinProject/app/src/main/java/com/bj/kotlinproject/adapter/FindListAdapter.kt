package com.bj.kotlinproject.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.TextView
import com.bj.kotlinproject.R
import com.bj.kotlinproject.bean.FindListBean
import com.facebook.drawee.view.SimpleDraweeView

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class FindListAdapter(context: Context, findListBean: List<FindListBean.ItemListBean>?) : RecyclerView.Adapter<FindListAdapter.MyViewHolder>() {

/*val itemList = findListBean.itemList
        for (index in itemList!!.indices){
             feed=itemList[index].data?.cover?.feed
            val title = itemList[index].data?.title

        }*/

    /*holder?.sdv?.setImageURI()
    holder?.tvName?.text =""+title*/

    var context: Context = context
    var findListBean: List<FindListBean.ItemListBean>? = findListBean
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.find_list_item, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
        holder?.sdv?.setImageURI(findListBean!!.get(position)?.data?.cover?.feed)
        holder?.tvName?.text=findListBean!!.get(position)?.data?.title
        holder?.fram?.setOnClickListener {
            litener?.OnItemClick(position)
        }

    }

    override fun getItemCount(): Int =findListBean!!.size


    class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        var sdv = itemView!!.findViewById<SimpleDraweeView>(R.id.sdv) as SimpleDraweeView
        var tvName = itemView!!.findViewById<TextView>(R.id.tvName) as TextView
        var fram=itemView!!.findViewById<FrameLayout>(R.id.fl) as FrameLayout
    }

    //定义接口回调
    var litener:OnItemClickLitener?=null
    interface OnItemClickLitener{
        fun OnItemClick(position: Int)
    }
    fun setOnItemClickListener(litener: OnItemClickLitener){
        this.litener=litener
    }

}