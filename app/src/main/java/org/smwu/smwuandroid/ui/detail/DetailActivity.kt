package org.smwu.smwuandroid.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_detail.*
import org.smwu.smwuandroid.model.post.PostProjData
import org.smwu.smwuandroid.model.post.PostProjResponse
import org.smwu.smwuandroid.network.ApplicationController
import org.smwu.smwuandroid.network.Proj
import org.smwu.smwuandroid.util.SharedPreferenceController
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import smwu.com.smwuandroid.R

class DetailActivity : AppCompatActivity() {
    val networkService  = ApplicationController.instance.networkService
    lateinit var postProjResponse : Call<PostProjResponse>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        when(Proj.category){
            0 -> detail_category_tv.text = "펀딩"
            1 -> detail_category_tv.text = "행사"
            2 -> detail_category_tv.text = "서명"
            3 -> detail_category_tv.text = "보이콧"
            4 -> detail_category_tv.text = "기부"
        }
        // 좋아요 아이콘 토글, 서버 통신
        detail_like_btn.setOnClickListener {
            Log.d("asdasd",SharedPreferenceController.sharedPreferenceController.getToken(this))
            if(detail_like_btn.isSelected){
                detail_like_btn.isSelected = false
                detail_like2_btn.isSelected = false
                removeBookmark()
            }else{
                detail_like_btn.isSelected = true
                detail_like2_btn.isSelected = true
                addBookmark()
            }
        }
        // 좋아요 아이콘 토글, 서버 통신
        detail_like2_btn.setOnClickListener {
            Log.d("asdasd",SharedPreferenceController.sharedPreferenceController.getToken(this))
            if(detail_like2_btn.isSelected){
                detail_like_btn.isSelected = false
                detail_like2_btn.isSelected = false
                removeBookmark()
            }else{
                detail_like_btn.isSelected = true
                detail_like2_btn.isSelected = true
                addBookmark()
            }
        }
    }
    fun addBookmark(){
        postProjResponse = networkService.postAddBookmark(
                SharedPreferenceController.sharedPreferenceController.getToken(this),
                PostProjData(Proj.category, Proj.idx))
        postProjResponse.enqueue(object : Callback<PostProjResponse> {
            override fun onFailure(call: Call<PostProjResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<PostProjResponse>?, response: Response<PostProjResponse>?) {
                Toast.makeText(applicationContext, "좋아요를 눌렀습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }
    fun removeBookmark(){
        postProjResponse = networkService.postRemoveBookmark(
                SharedPreferenceController.sharedPreferenceController.getToken(this),
                PostProjData(Proj.category, Proj.idx))
        postProjResponse.enqueue(object : Callback<PostProjResponse> {
            override fun onFailure(call: Call<PostProjResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<PostProjResponse>?, response: Response<PostProjResponse>?) {
                Toast.makeText(applicationContext, "좋아요를 취소했습니다.", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
