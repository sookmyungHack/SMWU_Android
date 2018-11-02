package org.smwu.smwuandroid.util

import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.util.exception.KakaoException
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.RequestBody
import org.smwu.smwuandroid.model.post.PostKaKaoLoginData
import org.smwu.smwuandroid.model.post.PostKaKaoLoginResponse
import org.smwu.smwuandroid.network.ApplicationController
import org.smwu.smwuandroid.ui.main.MainActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SessionCallback(mContext : Context) : ISessionCallback {
    var mContext: Context = mContext
    val networkService = ApplicationController.instance.networkService
    // 로그인에 실패
    override fun onSessionOpenFailed(exception: KakaoException?) {
        //Toast.makeText(mContext,"아예실패",Toast.LENGTH_SHORT).show()
    }

    // 로그인에 성공
    override fun onSessionOpened() {
        requestMe()
    }
    fun requestMe(){
        val user : UserManagement = UserManagement.getInstance()
        user.requestMe(object : MeResponseCallback(){
            override fun onSuccess(result: UserProfile?) {
                val nickname = result!!.nickname
                val profileImagePath = result.profileImagePath
                val UUID = result.id

                Log.d("nickname",nickname)
                Log.d("profileImagePath",profileImagePath)
                Log.d("UUID",UUID.toString())

                val postKaKaoLoginResponse = networkService.postLoginData(PostKaKaoLoginData(UUID.toString(),nickname,profileImagePath))
                postKaKaoLoginResponse.enqueue(object : Callback<PostKaKaoLoginResponse>{
                    override fun onFailure(call: Call<PostKaKaoLoginResponse>?, t: Throwable?) {
                       // Toast.makeText(mContext,"실패",Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<PostKaKaoLoginResponse>?, response: Response<PostKaKaoLoginResponse>?) {
                        if(response!!.isSuccessful){
                           // Toast.makeText(mContext,"성공",Toast.LENGTH_SHORT).show()
                            val intent = Intent(mContext,MainActivity::class.java)
                            mContext.startActivity(intent)
                            SharedPreferenceController.sharedPreferenceController.setToken(mContext, response.body().token!!)
                            SharedPreferenceController.sharedPreferenceController.setName(mContext, nickname)
                            SharedPreferenceController.sharedPreferenceController.setImg(mContext, profileImagePath)
                        }
                    }
                })

            }

            override fun onSessionClosed(errorResult: ErrorResult?) {
                Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult!!.errorMessage)
            }

            override fun onNotSignedUp() {
                Log.e("SessionCallback :: ", "onNotSignedUp")
            }
        })
    }
}