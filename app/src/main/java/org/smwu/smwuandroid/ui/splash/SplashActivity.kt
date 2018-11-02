package org.smwu.smwuandroid.ui.splash

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import org.smwu.smwuandroid.ui.login.LoginActivity
import smwu.com.smwuandroid.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handler = Handler()
        handler.postDelayed({

            startActivity(Intent(applicationContext,LoginActivity::class.java))
            finish()


        }, 3100) // 밀리세컨드=초*1000
    }
}
