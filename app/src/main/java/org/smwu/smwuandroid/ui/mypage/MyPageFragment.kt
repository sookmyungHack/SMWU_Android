package org.smwu.smwuandroid.ui.mypage

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import kotlinx.android.synthetic.main.fragment_mypage.*
import org.smwu.smwuandroid.util.SharedPreferenceController
import smwu.com.smwuandroid.R

class MyPageFragment : Fragment() {
    lateinit var requestManager : RequestManager
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_mypage,container,false)
        requestManager = Glide.with(this)
        requestManager.load(SharedPreferenceController.sharedPreferenceController.getImg(requireContext())).into(img_profile_mypage)

        nickname_mypage.text = SharedPreferenceController.sharedPreferenceController.getName(requireContext())

        btn_logout_mypage.setOnClickListener {
            SharedPreferenceController.sharedPreferenceController.setToken(requireContext(),"")
        }

        //프로필바꾸기 아직 안함

        return v
    }
}