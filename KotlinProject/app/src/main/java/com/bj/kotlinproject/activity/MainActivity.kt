package com.bj.kotlinproject.activity

import android.graphics.Color
import android.widget.TabHost
import com.bj.kotlinproject.R
import com.bj.kotlinproject.base.BaseActivity
import com.bj.kotlinproject.bean.FindBean
import com.bj.kotlinproject.fragment.FindFragment
import com.bj.kotlinproject.fragment.HomeFragment
import com.bj.kotlinproject.fragment.HotFragment
import com.bj.kotlinproject.fragment.MySelfFragment
import com.bj.kotlinproject.presenter.FindPresenter
import com.bj.kotlinproject.view.FindView
import com.hjm.bottomtabbar.BottomTabBar
import com.jaeger.library.StatusBarUtil
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<FindPresenter>(),FindView {
    override fun getFindData(findBean: List<FindBean>) {

    }
    override fun layoutId(): Int = R.layout.activity_main

    override fun initView() {
        /*if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            var vindow=window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.statusBarColor=resources.getColor(Color.BLUE)
        }*/
        //目的是让状态栏全透明
        StatusBarUtil.setTranslucent(this,15)
        bottom_tab_bar.init(supportFragmentManager)
                .setImgSize(50F, 50F)
                .setFontSize(12F)
                .setTabPadding(4F, 6F, 10F)
                .setChangeColor(Color.BLACK, Color.DKGRAY)
                .addTabItem("首页", R.mipmap.home_selected, R.mipmap.home_normal, HomeFragment::class.java)
                .addTabItem("发现", R.mipmap.find_selected, R.mipmap.find_normal, FindFragment::class.java)
                .addTabItem("热门", R.mipmap.hot_selected, R.mipmap.hot_normal, HotFragment::class.java)
                .addTabItem("我的", R.mipmap.mine_selected, R.mipmap.mine_normal, MySelfFragment::class.java)
                .isShowDivider(false)
                .setOnTabChangeListener(object : TabHost.OnTabChangeListener, BottomTabBar.OnTabChangeListener {
                    override fun onTabChanged(tabId: String?) {
                    }

                    override fun onTabChange(position: Int, name: String?) {
                    }

                })

    }

    override fun getPresenter(): FindPresenter {
        var find=FindPresenter(this)
        return find
    }

    override fun initData() {

    }


}
