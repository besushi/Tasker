package com.example.tasker.Activitys

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.tasker.Fragments.IdeasFragment
import com.example.tasker.Fragments.MonthFragment
import com.example.tasker.Fragments.TaskFragment
import com.example.tasker.Fragments.WeekFragment
import com.example.tasker.R


class MainActivity : AppCompatActivity() {


    internal var bottomNav: BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        

        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(
                R.id.fragment_container,IdeasFragment()
            ).commit()


            bottomNav = findViewById(R.id.bottom_navigation)
            bottomNav?.setOnNavigationItemSelectedListener { item ->
                var selectedFragment: Fragment? = null

                when (item.itemId) {
                    R.id.IdeasFrag -> selectedFragment = IdeasFragment()
                    R.id.TasksFrag -> selectedFragment = TaskFragment()
                    R.id.WeekFrag -> selectedFragment = WeekFragment()
                    R.id.MonthFrag -> selectedFragment = MonthFragment()
                }

                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, selectedFragment!!).commit()
                true
            }

        }

}

}
