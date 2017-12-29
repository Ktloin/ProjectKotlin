package com.bj.kotlinproject.activity

import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseActivity
import com.bj.kotlinproject.bean.SearchBean
import com.bj.kotlinproject.presenter.SearchPresenter
import com.bj.kotlinproject.view.SearchView
import kotlinx.android.synthetic.main.activity_find_detail.*

class SearchDetailActivity : BaseActivity<SearchPresenter>(),SearchView {

    override fun layoutId(): Int = R.layout.activity_search_detail

    override fun initView() {
    }

    override fun getPresenter(): SearchPresenter {
        var presenter=SearchPresenter(this)
        return presenter
    }

    override fun initData() {
        var playUrl=intent.getStringExtra("playUrl")
        var description=intent.getStringExtra("description")
        var feed=intent.getStringExtra("feed")
        var title=intent.getStringExtra("title")
        videoplayer.setUp(playUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "")
        videoplayer.thumbImageView.setImageResource(R.mipmap.landing_background)
        sdv.setImageURI(feed)
        tvTitle.text=title
        tvMark.text=description
    }

    override fun onDestroy() {
        super.onDestroy()
        JZVideoPlayer.releaseAllVideos()
    }
    override fun getSearchData(searchBean: SearchBean) {

    }

}
