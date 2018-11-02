package org.smwu.smwuandroid.ui.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import smwu.com.smwuandroid.R

class NewItemViewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
   var projImage = itemView!!.findViewById(R.id.proj_img_iv) as ImageView
   var titleName = itemView!!.findViewById(R.id.proj_title_tv) as TextView
   var cateName = itemView!!.findViewById(R.id.proj_cate_tv) as TextView
}