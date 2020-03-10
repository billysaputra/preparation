package com.billysaputra.preparation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.billysaputra.preparation.R
import com.billysaputra.preparation.adapter.TabAdapter
import kotlinx.android.synthetic.main.activity_tab.*

class TabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = getString(R.string.tab_activity)
        initTabAdapter()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.itemId){
            android.R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun initTabAdapter(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val fragmentTitle = arrayListOf<String>(getString(R.string.tab1), getString(R.string.tab2))
        val fragmentTab1 = SampleFragment.newInstance("")
        val fragmentTab2 = SampleFragment.newInstance("")
        val fragmentList = arrayListOf<Fragment>(fragmentTab1, fragmentTab2)
        val favoritePagerAdapter = TabAdapter(supportFragmentManager, fragmentTitle, fragmentList)
        vp_favorite.adapter = favoritePagerAdapter
        tl_favorite.setupWithViewPager(vp_favorite)
        supportActionBar?.elevation = 0F
    }
}
