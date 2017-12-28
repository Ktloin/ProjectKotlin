package com.bj.kotlinproject.activity

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.v7.app.AppCompatActivity
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import com.bj.kotlinproject.R

class YDActivity : AppCompatActivity() {


    private var i = 3
    private val handler = object : Handler() {
        override fun handleMessage(msg: Message) {
            super.handleMessage(msg)
            val what = msg.what
            if (what == 0) {
                val intent = Intent(this@YDActivity, MainActivity::class.java)
                startActivity(intent)
            }

        }
    }
    private var animation: Animation? = null
    private var img: ImageView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_yd)



        animation = AnimationUtils.loadAnimation(this@YDActivity, R.anim.aa)

        img = findViewById(R.id.img) as ImageView

        img!!.startAnimation(animation)

        object : Thread() {
            override fun run() {
                super.run()
                while (i > 0) {
                    try {
                        i--
                        Thread.sleep(1000)

                        handler.sendEmptyMessage(i)

                    } catch (e: InterruptedException) {
                        e.printStackTrace()
                    }

                }

            }
        }.start()


    }

}
