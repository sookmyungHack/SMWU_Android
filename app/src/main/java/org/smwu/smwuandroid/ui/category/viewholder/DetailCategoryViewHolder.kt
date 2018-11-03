package org.smwu.smwuandroid.ui.category.viewholder

import android.support.v7.view.menu.ActionMenuItemView
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_rcv_detailcategory.view.*
import org.w3c.dom.Text
import smwu.com.smwuandroid.R

class DetailCategoryViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    var img : ImageView = itemView!!.findViewById(R.id.img_detailcategory) as ImageView
    var title : TextView = itemView!!.findViewById(R.id.title_detailcategory) as TextView
    var nickname : TextView = itemView!!.findViewById(R.id.nickname_detailcategory) as TextView
    var percent : TextView = itemView!!.findViewById(R.id.percent_detailcategory) as TextView
    var day : TextView = itemView!!.findViewById(R.id.day_detailcategory) as TextView
}