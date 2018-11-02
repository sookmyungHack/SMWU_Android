package org.smwu.smwuandroid.network

import org.smwu.smwuandroid.model.post.PostKaKaoLoginData
import org.smwu.smwuandroid.model.post.PostKaKaoLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkService {

    //카카오 로그인
    @POST("/api/user/login")
    fun postLoginData(@Body login : PostKaKaoLoginData ):Call<PostKaKaoLoginResponse>

}