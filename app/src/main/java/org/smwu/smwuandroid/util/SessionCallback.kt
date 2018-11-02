package org.smwu.smwuandroid.util

import android.content.Context
import android.util.Log
import com.kakao.auth.ISessionCallback
import com.kakao.network.ErrorResult
import com.kakao.usermgmt.UserManagement
import com.kakao.usermgmt.callback.MeResponseCallback
import com.kakao.usermgmt.response.model.UserProfile
import com.kakao.util.exception.KakaoException
import org.smwu.smwuandroid.network.ApplicationController

class SessionCallback(mContext : Context) : ISessionCallback {
    var mContext: Context = mContext
    val networkService = ApplicationController.instance.networkService
    // 로그인에 실패
    override fun onSessionOpenFailed(exception: KakaoException?) {
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
                val UUID = result.uuid


//                val postLoginResponse = networkService.postLogin(PostLoginData(UUID, nickname, profileImagePath))
//                postLoginResponse.enqueue(object : Callback<PostLoginResponse>{
//                    override fun onFailure(call: Call<PostLoginResponse>?, t: Throwable?) {
//                    }
//
//                    override fun onResponse(call: Call<PostLoginResponse>?, response: Response<PostLoginResponse>?) {
//                        if(response!!.isSuccessful) {
//                            Token.token = response.body().token!!
//                            mContext.startActivity(Intent(mContext, MainActivity::class.java))
//                        }
//                    }
//
//                })
            }

            override fun onSessionClosed(errorResult: ErrorResult?) {
                Log.e("SessionCallback :: ", "onSessionClosed : " + errorResult!!.errorMessage);
            }

            override fun onNotSignedUp() {
                Log.e("SessionCallback :: ", "onNotSignedUp");
            }
        })
    }
}