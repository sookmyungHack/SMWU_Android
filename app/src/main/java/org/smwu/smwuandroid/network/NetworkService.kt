package org.smwu.smwuandroid.network

import org.smwu.smwuandroid.model.get.GetMainNewResponse
import org.smwu.smwuandroid.model.get.GetRecommandResponse
import org.smwu.smwuandroid.model.post.PostKaKaoLoginData
import org.smwu.smwuandroid.model.post.PostKaKaoLoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface NetworkService {

    // 카카오 로그인
    @POST("/api/user/login")
    fun postLoginData(@Body login : PostKaKaoLoginData ):Call<PostKaKaoLoginResponse>

    // 추천 리스트
    @GET("/api/main/recommand")
    fun getRecommandList():Call<GetRecommandResponse>

    // 새로운 프로젝트
    @GET("/api/main/new")
    fun getMainNew():Call<GetMainNewResponse>
}