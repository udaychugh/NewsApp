package com.udaychugh.newapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class PagerAdapter(fm: FragmentManager, var tabcount: Int) : FragmentPagerAdapter(fm, tabcount) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> homefragment()
            1 -> sportsfragment()
            2 -> healthfragment()
            3 -> sciencefragment()
            4 -> entertainmentfragment()
            5 -> techfragment()
            else -> null
        }
    }

    override fun getCount(): Int {
        return tabcount
    }
}