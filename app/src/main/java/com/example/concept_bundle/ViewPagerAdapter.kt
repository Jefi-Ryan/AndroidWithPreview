package com.example.concept_bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class ViewPagerAdapter(val data : List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {
    inner class ViewPagerViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.view_pager_item,parent,false)
        return ViewPagerViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        holder.itemView.apply {
            val img_view = findViewById<ImageView>(R.id.ivViewPager)
            img_view.setImageResource(data[position])
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}