package org.smwu.smwuandroid.ui.home.item_viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.smwu.smwuandroid.model.get.GetRecommandResponse
import org.smwu.smwuandroid.network.ApplicationController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import smwu.com.smwuandroid.R

class FirstViewPager :Fragment() { //펀딩
    val networkService  = ApplicationController.instance.networkService
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.vpitem_home_first,container,false)
        val getRecommandFund = networkService.getRecommandList()
        getRecommandFund.enqueue(object :Callback<GetRecommandResponse>{
            override fun onFailure(call: Call<GetRecommandResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetRecommandResponse>?, response: Response<GetRecommandResponse>?) {
                if(response!!.isSuccessful){

                }
            }

        })
        return v
    }
}