package com.billysaputra.preparation.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.billysaputra.preparation.R
import com.billysaputra.preparation.helper.inTransaction
import com.billysaputra.preparation.view_model.ExperimentViewModel

class ExperimentActivity : AppCompatActivity() {

    private val TAG = ExperimentActivity::class.java.simpleName
    private lateinit var experimentViewModel: ExperimentViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_experiment)
        Log.i(TAG, "onCreate")
        experimentViewModel = ViewModelProvider(this).get(ExperimentViewModel::class.java)
        experimentViewModel.setMovie()
        experimentViewModel.getMovie().observe(this, Observer {
            println("Movie Size : ${it.size}")
        })

        val experimentFragment = ExperimentFragment()
        experimentFragment.arguments = getBundle()
        supportFragmentManager.inTransaction { add(R.id.fragment, experimentFragment,"expFragment") }
    }

    private fun getBundle() : Bundle{
        val bundle = Bundle()
        bundle.putString("TEST", "This is bundle from experiment activity")
        return bundle
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Log.i(TAG, "onConfigurationChanged $newConfig")
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Log.i(TAG, "onSaveInstanceState")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle?) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.i(TAG, "onRestoreInstanceState")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "onDestroy")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i(TAG, "onRestart")
    }
}
