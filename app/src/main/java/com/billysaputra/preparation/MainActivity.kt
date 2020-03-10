package com.billysaputra.preparation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.billysaputra.preparation.view.TabActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setOnClickListener()
    }

    private fun setOnClickListener(){
        btn_tab_activity.setOnClickListener {
            startActivity(Intent(this, TabActivity::class.java))
        }
    }
}
