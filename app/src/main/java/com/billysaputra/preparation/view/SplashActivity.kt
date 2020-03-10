package com.billysaputra.preparation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.billysaputra.preparation.MainActivity
import com.billysaputra.preparation.R

class SplashActivity : AppCompatActivity() {

    private var splashHandler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        splashHandler.postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 2000)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        splashHandler.removeCallbacksAndMessages(null)
    }
}
