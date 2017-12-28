package com.bj.kotlinproject.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import cn.jzvd.JZVideoPlayer
import cn.jzvd.JZVideoPlayerStandard
import com.bj.kotlinproject.R
import kotlinx.android.synthetic.main.activity_hot_detail.*

class HotDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hot_detail)
        val playUrl = intent.getStringExtra("playUrl")
        val title = intent.getStringExtra("title")
        val category = intent.getStringExtra("category")
        val description = intent.getStringExtra("description")
        Log.i("aaa","playUrl:"+playUrl+"==========title:"+title+"==========category"+category+"==========description"+description)
        videoplayer_hot.setUp(playUrl, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "")
        videoplayer_hot.thumbImageView.setImageResource(R.mipmap.landing_background)
        title_hot.text=title
        category_hot.text=category
        description_hot.text=description
        //sdv_hot.setImageURI(Uri.parse())
    }
    override fun onDestroy() {
        super.onDestroy()
        JZVideoPlayer.releaseAllVideos()
    }
}
