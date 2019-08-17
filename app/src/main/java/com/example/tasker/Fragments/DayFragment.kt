package com.example.tasker.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tasker.Adapters.TaskListAdapter
import com.example.tasker.Module.TaskSupplier
import com.example.tasker.R

class DayFragment : Fragment() {

    var MyRecycleView: RecyclerView? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_day, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setPointer(view)
    }

    private fun setPointer(view: View) {

        MyRecycleView = view.findViewById(R.id.MyRecycleView) as RecyclerView
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        MyRecycleView!!.layoutManager = layoutManager


        val adapter = TaskListAdapter(TaskSupplier.TaskList)
        MyRecycleView?.adapter = adapter
    }

}