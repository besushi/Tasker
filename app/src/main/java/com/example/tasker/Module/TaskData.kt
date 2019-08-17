package com.example.tasker.Module

data class TaskData (var title:String, var image:Int)


object TaskSupplier{
    var TaskList = listOf<TaskData>(
        TaskData("",0),
        TaskData("",0),
        TaskData("",0),
        TaskData("",0),
        TaskData("",0),
        TaskData("",0),
        TaskData("",0),
        TaskData("gre",0),
        TaskData("",0),
        TaskData("gre",0),
        TaskData("gre",0)

    ) }