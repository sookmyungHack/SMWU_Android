package org.smwu.smwuandroid.ui.category

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_category.view.*
import org.smwu.smwuandroid.network.Proj
import smwu.com.smwuandroid.R

class CategoryFragment : Fragment() {
    var num:Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_category,container,false)

        v.first_category.setOnClickListener { //서명
            Proj.category = 2
            replaceFragment(DetailCategoryFragment())


        }
        v.second_category.setOnClickListener { //펀드
            Proj.category= 0
            replaceFragment(DetailCategoryFragment())
        }
        v.third_category.setOnClickListener { //행사
            Proj.category = 1
            replaceFragment(DetailCategoryFragment())

        }
        v.fourth_category.setOnClickListener { //기부
            Proj.category = 4
            replaceFragment(DetailCategoryFragment())

        }
        v.fifth_category.setOnClickListener { //보이콧
            Proj.category = 3
            replaceFragment(DetailCategoryFragment())
        }
        return v
    }

    //Fragment 교체
    fun replaceFragment(fragment: Fragment){
        val fm = activity!!.supportFragmentManager
        val transaction = fm.beginTransaction()
        transaction.replace(R.id.home_main_frame,fragment)
        transaction.commit()
    }
}