package com.example.tasker.Adapters

import android.annotation.SuppressLint
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.tasker.Module.TaskData
import com.example.tasker.R
import kotlinx.android.synthetic.main.card_task.view.*








class TaskListAdapter (var Tasks:List<TaskData>): RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card_task, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return Tasks.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Task = Tasks[position]
        holder.setDataToRecycleViewItems(Task, position)
    }


    inner class ViewHolder(task: View) : RecyclerView.ViewHolder(task) {

        var currentTask: TaskData? = null
        var currentPosition: Int = 0

        init {
            task.setOnClickListener {

            }
        }

        @SuppressLint("SetTextI18n")
        fun setDataToRecycleViewItems(task: TaskData, position: Int) {
            itemView.title.text = task.title

            this.currentTask = task
            this.currentPosition = position
        }
    }


    }







