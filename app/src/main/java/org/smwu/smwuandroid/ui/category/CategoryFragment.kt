package org.smwu.smwuandroid.ui.category

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import smwu.com.smwuandroid.R

class CategoryFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater.inflate(R.layout.fragment_category,container,false)
        return super.onCreateView(inflater, container, savedInstanceState)
    }
}