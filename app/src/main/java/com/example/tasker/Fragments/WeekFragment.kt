package com.example.tasker.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tasker.Adapters.WeekPagerAdapter
import com.example.tasker.R
import kotlinx.android.synthetic.main.fragment_week.*

class WeekFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_week, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val fragmentAdapter = WeekPagerAdapter(activity?.supportFragmentManager!!)
        viewpager_week.adapter = fragmentAdapter

        tabs_week.setupWithViewPager(viewpager_week)
        super.onViewCreated(view, savedInstanceState)
    }
}