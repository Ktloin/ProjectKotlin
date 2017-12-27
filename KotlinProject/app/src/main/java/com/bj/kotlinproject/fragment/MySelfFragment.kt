package com.bj.kotlinproject.fragment

import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bj.kotlinproject.R
import com.bj.kotlinproject.activity.GKActivity
import com.bj.kotlinproject.activity.HCActivity
import com.bj.kotlinproject.activity.SetActivity
import com.bj.kotlinproject.activity.YJActivity
import kotlinx.android.synthetic.main.fragment_myself.view.*

/**
 * Created by 郑文杰 on 2017/12/27.
 */
class MySelfFragment  :Fragment(){

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_myself, container, false)


        initView(view)






        return view
    }

    private fun initView(view: View) {
        view.bai_huancun.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(v: View?) {

                var intent = Intent(activity, HCActivity::class.java)
                startActivity(intent)

            }

            override fun onClick(dialog: DialogInterface?, which: Int) {

            }

        })


        view.bai_jilu.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(v: View?) {

                var intent = Intent(activity, GKActivity::class.java)
                startActivity(intent)

            }

            override fun onClick(dialog: DialogInterface?, which: Int) {

            }

        })

        view.bai_yijian.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(v: View?) {

                var intent = Intent(activity, YJActivity::class.java)
                startActivity(intent)

            }

            override fun onClick(dialog: DialogInterface?, which: Int) {

            }

        })

        view.bai_set.setOnClickListener(object : DialogInterface.OnClickListener, View.OnClickListener {
            override fun onClick(v: View?) {

                var intent = Intent(activity, SetActivity::class.java)
                startActivity(intent)

            }

            override fun onClick(dialog: DialogInterface?, which: Int) {

            }

        })

    }
}