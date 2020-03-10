package com.billysaputra.preparation.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

/**
 * Created by Billy Saputra on 2020-03-10.
 */
class TabAdapter(fm: FragmentManager, private val fragmentTitle : ArrayList<String>, private val fragmentList : ArrayList<Fragment>) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return fragmentTitle[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }
}