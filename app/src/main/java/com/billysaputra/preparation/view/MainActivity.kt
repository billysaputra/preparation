package com.billysaputra.preparation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.billysaputra.preparation.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.appbar_home.*

class MainActivity : AppCompatActivity() {
    private var isDoubleBackPressedTriggered = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListener()
    }

    override fun onBackPressed() {
        if (isDoubleBackPressedTriggered) {
            super.onBackPressed()
            return
        }

        this.isDoubleBackPressedTriggered = true
        Toast.makeText(this, getString(R.string.double_back_pressed_to_exit), Toast.LENGTH_SHORT).show()
        Handler().postDelayed({ isDoubleBackPressedTriggered = false }, 2000)
    }

    private fun setOnClickListener() {
        btn_tab_activity.setOnClickListener {
            startActivity(Intent(this, TabActivity::class.java))
        }
        iv_chat.setOnClickListener {

        }
        iv_notification.setOnClickListener {

        }
        iv_cart.setOnClickListener {

        }
    }
}
