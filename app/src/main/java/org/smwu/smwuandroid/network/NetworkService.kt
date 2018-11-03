package org.smwu.smwuandroid.network

import org.smwu.smwuandroid.model.get.*
import org.smwu.smwuandroid.model.post.*
import retrofit2.Call
import retrofit2.http.*

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

    // 인기 프로젝트
    @GET("/api/main/popular")
    fun getMainPopular():Call<GetMainNewResponse>


    // 카테고리 리스트
    @GET("/api/category")
    fun getCategoryList(@Query("num")num:Int):Call<GetCategoryListDataResponse>

    // 북마크 추가
    @POST("/api/main/bookmark/add")
    fun postAddBookmark(@Header("token") token : String, @Body projData : PostProjData):Call<PostProjResponse>

    // 북마크 제거
    @POST("/api/main/bookmark/cancel")
    fun postRemoveBookmark(@Header("token") token : String, @Body projData : PostProjData):Call<PostProjResponse>

    // 상세보기 0 - 펀딩
    @GET("/api/main/detail")
    fun getDetail0(@Path("idx") idx : Int, @Path("category") cate : Int) : Call<GetDetailResponse0>

    // 상세보기 1 - 행사
    @GET("/api/main/detail")
    fun getDetail1(@Path("idx") idx : Int, @Path("category") cate : Int) : Call<GetDetailResponse1>

    // 상세보기 2 - 서명
    @GET("/api/main/detail")
    fun getDetail2(@Path("idx") idx : Int, @Path("category") cate : Int) : Call<GetDetailResponse2>

    // 상세보기 3 - 보이콧
    @GET("/api/main/detail")
    fun getDetail3(@Path("idx") idx : Int, @Path("category") cate : Int) : Call<GetDetailResponse3>

    // 상세보기 4 - 기부
    @GET("/api/main/detail")
    fun getDetail4(@Path("idx") idx : Int, @Path("category") cate : Int) : Call<GetDetailResponse4>
}