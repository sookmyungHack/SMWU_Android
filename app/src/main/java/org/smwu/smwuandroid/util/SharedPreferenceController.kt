package org.smwu.smwuandroid.util

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences

class SharedPreferenceController private constructor() {
    // 이미 가입한 사람의 토큰
    fun setToken(context: Context, token: String) {
        val pref = context.getSharedPreferences("TOKEN", Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("TOKEN", token)
        editor.commit()
    }

    fun getToken(context: Context): String {
        val pref = context.getSharedPreferences("TOKEN", Activity.MODE_PRIVATE)
        return pref.getString("TOKEN","")
    }
    // 자동 로그인하는 사람의 이름
    fun setName(context: Context, name: String) {
        val pref = context.getSharedPreferences("NAME", Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("NAME", name)
        editor.commit()
    }

    fun getName(context: Context): String {
        val pref = context.getSharedPreferences("NAME", Activity.MODE_PRIVATE)
        return pref.getString("NAME","")
    }
    // 자동 로그인하는 사람의 사진
    fun setImg(context: Context, path: String) {
        val pref = context.getSharedPreferences("IMG", Activity.MODE_PRIVATE)
        val editor = pref.edit()
        editor.putString("IMG", path)
        editor.commit()
    }

    fun getImg(context: Context): String {
        val pref = context.getSharedPreferences("IMG", Activity.MODE_PRIVATE)
        return pref.getString("IMG","")
    }

    companion object {
        private var SINGLETON_INSTANCE: SharedPreferenceController? = null

        val sharedPreferenceController: SharedPreferenceController
            get() {
                if (SINGLETON_INSTANCE == null) {
                    SINGLETON_INSTANCE = SharedPreferenceController()
                }
                return SINGLETON_INSTANCE!!
            }
    }
}
