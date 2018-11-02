package org.smwu.smwuandroid.ui.main

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import org.smwu.smwuandroid.ui.category.CategoryFragment
import org.smwu.smwuandroid.ui.community.CommunityActivity
import org.smwu.smwuandroid.ui.mypage.MyPageFragment
import smwu.com.smwuandroid.R
import smwu.com.smwuandroid.ui.home.HomeFragment

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(v: View?) {
        when(v){
            main_home_btn->{
                replaceFragment(HomeFragment())
                main_home_btn.isSelected = true
                main_category_btn.isSelected = false
                main_community_btn.isSelected = false
                main_mypage_btn.isSelected = false
            }
            main_category_btn->{
                replaceFragment(CategoryFragment())
                main_home_btn.isSelected = false
                main_category_btn.isSelected = true
                main_community_btn.isSelected = false
                main_mypage_btn.isSelected = false
            }
            main_community_btn->{
                replaceFragment(CommunityActivity())
                main_home_btn.isSelected = false
                main_category_btn.isSelected = false
                main_community_btn.isSelected = true
                main_mypage_btn.isSelected = false
            }
            main_mypage_btn->{
                replaceFragment(MyPageFragment())
                main_home_btn.isSelected = false
                main_category_btn.isSelected = false
                main_community_btn.isSelected = false
                main_mypage_btn.isSelected = true
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addFragment(HomeFragment())

        main_home_btn.isSelected = true

        main_home_btn.setOnClickListener(this)
        main_category_btn.setOnClickListener(this)
        main_community_btn.setOnClickListener(this)
        main_mypage_btn.setOnClickListener(this)
    }

    //Fragment 붙이는 함수
    fun addFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.add(R.id.home_main_frame,fragment)
        transaction.commit()
    }

    //Fragment 교체
    fun replaceFragment(fragment: Fragment){
        val fm = supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.home_main_frame,fragment)
        transaction.commit()
    }
}
