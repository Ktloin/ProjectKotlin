package com.bj.kotlinproject.activity

import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseActivity
import com.bj.kotlinproject.bean.FindListBean
import com.bj.kotlinproject.presenter.FindListPresenter
import com.bj.kotlinproject.view.FindListView
import kotlinx.android.synthetic.main.activity_find_detail.*


class FindDetailActivity : BaseActivity<FindListPresenter>(),FindListView {


    override fun layoutId(): Int= R.layout.activity_find_detail

    override fun initView() {


    }
    override fun initData() {
        var cate=intent.getStringExtra("cate")
        val presenter = getPresenter()
        presenter.relevance(cate,"date","26868b32e808498db32fd51fb422d00175e179df",83)
    }

    override fun getPresenter(): FindListPresenter {
        var presenter=FindListPresenter(this)
        return presenter
    }

    override fun getFindListData(findListBean: FindListBean) {
        var position=intent.getIntExtra("position",0)
        val playUrl = findListBean.itemList!!.get(position)!!.data!!.playUrl
        videoplayer.setUp(playUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "")
        videoplayer.thumbImageView.setImageResource(R.mipmap.landing_background)
        sdv.setImageURI(findListBean.itemList!!.get(position)!!.data!!.cover!!.blurred)
        tvTitle.text=findListBean.itemList!!.get(position)!!.data!!.title
        tvMark.text=findListBean.itemList!!.get(position)!!.data!!.remark

    }

    override fun onDestroy() {
        super.onDestroy()
        JZVideoPlayer.releaseAllVideos()
    }

}
