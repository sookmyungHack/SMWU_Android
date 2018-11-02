package org.smwu.smwuandroid.ui.home.item_viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.smwu.smwuandroid.model.get.GetRecommandDonate
import org.smwu.smwuandroid.model.get.GetRecommandResponse
import org.smwu.smwuandroid.network.ApplicationController
import retrofit2.Call
import retrofit2.Response
import smwu.com.smwuandroid.R
import javax.security.auth.callback.Callback

class FifthViewPager : Fragment() { //기부
    val networkService = ApplicationController.instance.networkService
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.vpitem_home_fifth,container,false)

        val getRecommandDonate = networkService.getRecommandList()
        getRecommandDonate.enqueue(object:retrofit2.Callback<GetRecommandResponse>{
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