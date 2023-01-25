package com.test.sasapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({


                val intent = Intent(this, MainActivity::class.java)

                startActivity(intent)
                overridePendingTransition(R.anim.right_in, R.anim.left_out)
                finish()



        },2000)
    }

}