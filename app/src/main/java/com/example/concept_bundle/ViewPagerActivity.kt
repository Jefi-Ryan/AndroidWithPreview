package com.example.concept_bundle

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.TabLayoutOnPageChangeListener
import com.google.android.material.tabs.TabLayoutMediator

class ViewPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        val data = listOf<Int>(
            R.drawable.portrait_1,
            R.drawable.portrait_2,
            R.drawable.portrait_3,
            R.drawable.portrait_4,
            R.drawable.portrait_5,
            R.drawable.portrait_6,
            R.drawable.portrait_7,
        )

        val adapterobj = ViewPagerAdapter(data)
        val viewpager = findViewById<ViewPager2>(R.id.viewPager2)
        viewpager.adapter = adapterobj

        val tablayout = findViewById<TabLayout>(R.id.tabViewPager)

        TabLayoutMediator(tablayout, viewpager){tab, position ->
            tab.text = (position + 1).toString()
        }.attach()

        tablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "tab ${tab?.text} is selected",Toast.LENGTH_SHORT).show()
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "tab ${tab?.text} is unselected",Toast.LENGTH_SHORT).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@ViewPagerActivity, "tab ${tab?.text} is reselected",Toast.LENGTH_SHORT).show()
            }
        })
    }
}