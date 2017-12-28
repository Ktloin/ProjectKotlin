package com.bj.kotlinproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseActivity
import kotlinx.android.synthetic.main.activity_home_detail.*

/**
 * Created by 吴丽杰 on 2017/12/28.
 */
class HomeDetaiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_detail)
        val playUrl = intent.getStringExtra("playUrls")
        val title = intent.getStringExtra("titles")
        //val blurred = intent.getStringExtra("blurreds")
        //val feed = intent.getStringExtra("feeds")
        val description = intent.getStringExtra("descriptions")
        li_videoplayer.setUp(playUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "")
        li_videoplayer.thumbImageView.setImageResource(R.mipmap.landing_background)
        li_tvTitle.text = title
        li_tvMark.text = description
        //li_sdv.setImageURI(blurred)
    }

    override fun onDestroy() {
        super.onDestroy()
        JZVideoPlayer.releaseAllVideos()
    }
}