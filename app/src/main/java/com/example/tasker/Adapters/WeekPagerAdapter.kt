package com.example.tasker.Adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.tasker.Fragments.DayFragment

class WeekPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> DayFragment()
            1 -> DayFragment()
            2 -> DayFragment()
            3 -> DayFragment()
            4 -> DayFragment()
            5 -> DayFragment()
            6 -> DayFragment()

            else -> {
                return DayFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 7
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Sunday"
            1 -> "Monday"
            2 -> "Tuesday"
            3 -> "Wednesday"
            4 -> "Thursday"
            5 -> "Friday"
            else -> "Saturday"
        }
    }
}