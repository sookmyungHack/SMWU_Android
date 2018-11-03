package org.smwu.smwuandroid.ui.category.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.RequestManager
import org.smwu.smwuandroid.model.get.GetCategoryListData
import org.smwu.smwuandroid.ui.category.viewholder.DetailCategoryViewHolder
import smwu.com.smwuandroid.R

class DetailCategoryAdapter(private var categoryItems : ArrayList<GetCategoryListData>, var requestManager: RequestManager): RecyclerView.Adapter<DetailCategoryViewHolder>() {
    private lateinit var onItemClick : View.OnClickListener

    fun setOnItemClickListener(l : View.OnClickListener){
        onItemClick = l
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailCategoryViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_rcv_detailcategory,parent,false)
        view.setOnClickListener(onItemClick)
        return DetailCategoryViewHolder(view)
    }

    override fun getItemCount(): Int = categoryItems.size

    override fun onBindViewHolder(holder: DetailCategoryViewHolder, position: Int) {
        holder.day.text = categoryItems[position].date.toString()
        holder.nickname.text = categoryItems[position].user_nickname.toString()
        holder.title.text = categoryItems[position].title.toString()
        var up =categoryItems[position].CurrentPerson
        var down =categoryItems[position].LimitPerson
        var percent = (up/down)*100
        holder.percent.text = percent.toString()
        requestManager.load(categoryItems[position].img).centerCrop().into(holder.img)
    }
}