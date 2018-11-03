package smwu.com.smwuandroid.ui.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.pm10.library.CircleIndicator
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import org.smwu.smwuandroid.model.get.GetMainNewResponse
import org.smwu.smwuandroid.network.ApplicationController
import org.smwu.smwuandroid.network.Proj
import org.smwu.smwuandroid.ui.detail.DetailActivity
import org.smwu.smwuandroid.ui.home.NewItemAdapter
import org.smwu.smwuandroid.ui.home.item_viewpager.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import smwu.com.smwuandroid.R

class HomeFragment : Fragment() {
    val networkService  = ApplicationController.instance.networkService

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_home, container, false)
        val viewPager : ViewPager = v.main_page_fragment_viewpager
        val indicator : CircleIndicator = v.main_page_fragment_indicator


        viewPager.adapter = PagerAdapter(fragmentManager)
        viewPager.pageMargin = 60
        viewPager.pageMargin = 2

        indicator.setupWithViewPager(viewPager)
        return v
    }

    override fun onStart() {
        super.onStart()

        val getMainNewResponse = networkService.getMainNew()
        getMainNewResponse.enqueue(object : Callback<GetMainNewResponse> {
            override fun onFailure(call: Call<GetMainNewResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMainNewResponse>?, response: Response<GetMainNewResponse>?) {
                if(response!!.isSuccessful){
                    var newItemAdapter = NewItemAdapter(response!!.body().data, context!!)
                    newItemAdapter.setOnItemClickListener(View.OnClickListener {
                        startActivity(Intent(context, DetailActivity::class.java))
                        Proj.category = response.body().data[main_page_fragment_rv1.getChildAdapterPosition(it)].category
                        Proj.idx = response.body().data[main_page_fragment_rv1.getChildAdapterPosition(it)].index1
                    })
                    main_page_fragment_rv1.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    main_page_fragment_rv1.adapter = newItemAdapter
                }
            }
        })

        val getMainPopularResponse = networkService.getMainPopular()
        getMainPopularResponse.enqueue(object : Callback<GetMainNewResponse> {
            override fun onFailure(call: Call<GetMainNewResponse>?, t: Throwable?) {
            }

            override fun onResponse(call: Call<GetMainNewResponse>?, response: Response<GetMainNewResponse>?) {
                if(response!!.isSuccessful){

                    var newItemAdapter = NewItemAdapter(response?.body().data, context!!)

                    newItemAdapter.setOnItemClickListener(View.OnClickListener {
                        startActivity(Intent(context, DetailActivity::class.java))
                        Proj.category = response.body().data[main_page_fragment_rv2.getChildAdapterPosition(it)].category
                        Proj.idx = response.body().data[main_page_fragment_rv2.getChildAdapterPosition(it)].index1
                    })
                    main_page_fragment_rv2.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                    main_page_fragment_rv2.adapter = newItemAdapter
                }
            }
        })
    }

    class PagerAdapter(fm: FragmentManager?) : FragmentStatePagerAdapter(fm) {
        override fun getItem(position: Int): Fragment? {
            when(position){
                0->{
                    return FirstViewPager()
                }
                1->{
                    return SecondViewPager()
                }
                2->{
                    return ThirdViewPager()
                }
                3->{
                    return FourthViewPager()
                }
                4->{
                    return FifthViewPager()
                }

            }
            return null
        }

        override fun getCount(): Int {
            return 5
        }
    }

}