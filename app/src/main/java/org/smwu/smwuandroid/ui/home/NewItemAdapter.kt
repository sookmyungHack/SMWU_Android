package org.smwu.smwuandroid.ui.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import org.smwu.smwuandroid.model.get.GetProjectItem
import smwu.com.smwuandroid.R


class NewItemAdapter (private var projectItem : ArrayList<GetProjectItem>, val context : Context) : RecyclerView.Adapter<NewItemViewholder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewItemViewholder {

        val mainView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_project,parent,false)
        return  NewItemViewholder(mainView)
    }

    override fun getItemCount(): Int  = projectItem.size

    override fun onBindViewHolder(holder: NewItemViewholder, position: Int) {
        Glide.with(context).load(projectItem[position].img).into(holder!!.projImage)
        holder.titleName.text = projectItem[position].title
        when(projectItem[position].category){
            0 -> holder.cateName.text = "펀딩"
            1 -> holder.cateName.text = "행사"
            2 -> holder.cateName.text = "서명"
            3 -> holder.cateName.text = "보이콧"
            4 -> holder.cateName.text = "기부"
        }
    }
}