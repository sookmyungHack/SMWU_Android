package org.smwu.smwuandroid.ui.category

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_detailcategory.view.*
import org.smwu.smwuandroid.model.get.GetCategoryListData
import org.smwu.smwuandroid.model.get.GetCategoryListDataResponse
import org.smwu.smwuandroid.network.ApplicationController
import org.smwu.smwuandroid.network.Proj
import org.smwu.smwuandroid.ui.category.adapter.DetailCategoryAdapter
import org.smwu.smwuandroid.ui.detail.DetailActivity
import org.smwu.smwuandroid.ui.service_dialog.ServiceDialog
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import smwu.com.smwuandroid.R

class DetailCategoryFragment : Fragment() {
    lateinit var detailCategoryAdapter: DetailCategoryAdapter
    lateinit var categoryItems : ArrayList<GetCategoryListData>
    var networkService = ApplicationController.instance.networkService
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_detailcategory,container,false)

        var num = Proj.category

        if(num==0){
            v.cate_name_detailcategory.text = "펀딩"

        }else if(num==1){
            v.cate_name_detailcategory.text = "행사"
        }else if(num==2){
            v.cate_name_detailcategory.text = "서명"
        }else if(num==3){
            v.cate_name_detailcategory.text = "보이콧"
        }else if(num==4){
            v.cate_name_detailcategory.text = "기부"
        }

        categoryItems = ArrayList()

        var requestManager = Glide.with(this)

        v.btn_write_detailcategory.setOnClickListener {
            val dialog_serice = ServiceDialog(requireContext())
            dialog_serice.show()
        }

        val getCategoryList = networkService.getCategoryList(num)
        getCategoryList.enqueue(object:Callback<GetCategoryListDataResponse>{
            override fun onFailure(call: Call<GetCategoryListDataResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetCategoryListDataResponse>?, response: Response<GetCategoryListDataResponse>?) {
                if(response!!.isSuccessful){
                    categoryItems = response.body().data
                    detailCategoryAdapter = DetailCategoryAdapter(categoryItems,requestManager)

                    v.rcv_detailcategory.layoutManager = LinearLayoutManager(context)
                    v.rcv_detailcategory.adapter = detailCategoryAdapter

                    detailCategoryAdapter.setOnItemClickListener(View.OnClickListener {
                        var position = v.rcv_detailcategory.getChildAdapterPosition(it)
                        var idx = response.body().data[position].idx
                        Proj.idx = idx

                        context!!.startActivity(Intent(context,DetailActivity::class.java))
                    })



                }
            }

        })

        return v
    }
}
