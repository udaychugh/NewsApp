package com.udaychugh.newapp

import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener

class MainActivity2 : AppCompatActivity() {
    var tabLayout: TabLayout? = null
    var mhome: TabItem? = null
    var mscience: TabItem? = null
    var mhealth: TabItem? = null
    var mtech: TabItem? = null
    var mentertainment: TabItem? = null
    var msports: TabItem? = null
    var pagerAdapter: PagerAdapter? = null
    var mtoolbar: Toolbar? = null
    var mMaintoolbarLayout: RelativeLayout? = null
    var api = "177f87c5e0034517b2b97590859612ab"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        mtoolbar = findViewById(R.id.toolbar)
        mMaintoolbarLayout = findViewById(R.id.main_toolbar_layout)
        setSupportActionBar(mtoolbar)
        mhome = findViewById(R.id.home)
        mscience = findViewById(R.id.science)
        mhealth = findViewById(R.id.health)
        mtech = findViewById(R.id.technology)
        mentertainment = findViewById(R.id.entertainment)
        msports = findViewById(R.id.sports)
        val viewPager = findViewById<ViewPager>(R.id.fragmentcontainer)
        tabLayout = findViewById(R.id.include)
        pagerAdapter = PagerAdapter(supportFragmentManager, 6)
        viewPager.adapter = pagerAdapter
        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
                if (tab.position == 0 || tab.position == 1 || tab.position == 2 || tab.position == 3 || tab.position == 4 || tab.position == 5) {
                    pagerAdapter!!.notifyDataSetChanged()
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}
            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
        viewPager.addOnPageChangeListener(TabLayoutOnPageChangeListener(tabLayout))
    }
}