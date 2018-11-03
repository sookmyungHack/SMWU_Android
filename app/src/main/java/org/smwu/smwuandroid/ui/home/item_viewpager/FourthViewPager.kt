package org.smwu.smwuandroid.ui.home.item_viewpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.vpitem_home_fourth.*
import kotlinx.android.synthetic.main.vpitem_home_fourth.view.*
import org.smwu.smwuandroid.model.get.GetRecommandResponse
import org.smwu.smwuandroid.network.ApplicationController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import smwu.com.smwuandroid.R

class FourthViewPager : Fragment() { //서명
    val networkService = ApplicationController.instance.networkService
    lateinit var requestManager: RequestManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.vpitem_home_fourth,container,false)
        requestManager = Glide.with(this)
        val getRecommandSign = networkService.getRecommandList()
        getRecommandSign.enqueue(object : Callback<GetRecommandResponse>{
            override fun onFailure(call: Call<GetRecommandResponse>?, t: Throwable?) {

            }

            override fun onResponse(call: Call<GetRecommandResponse>?, response: Response<GetRecommandResponse>?) {
                if(response!!.isSuccessful){
                    requestManager.load(response.body().recommandSign.sign_img).centerCrop().into(v.vp_img_fourth)
                    v.title_fourth.text = response.body().recommandSign.sign_title
                    v.user_fourth.text = response.body().recommandSign.user_nickname
                }
            }

        })
        return v
    }
}