package org.smwu.smwuandroid.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import org.smwu.smwuandroid.util.GlobalApplication

class ApplicationController : GlobalApplication(){
    lateinit var networkService: NetworkService
    private val baseUrl = "http://52.78.129.27:3003"

    companion object {
        lateinit var instance : ApplicationController
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
        buildNetwork()
    }

    fun buildNetwork() {
        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        networkService = retrofit.create(NetworkService::class.java)
    }
}