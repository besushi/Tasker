package com.example.tasker.Module

data class IdeaData (var title:String,var type:Int = 0 ,var tag:String = "",var tagColor:Int = 0 , var discription : String ="", var Av_DateFrom:String ="",var Av_DateTo: String ="", var importand: Int = 0 , var tasklist : List<TaskData> = TaskSupplier.TaskList )


object IdeaSupplier{
    var IdeaList = mutableListOf<IdeaData>(
        IdeaData("alex"),
        IdeaData("olo"),
        IdeaData("asdlex"),
        IdeaData("fsdaf"),
        IdeaData("asdf"),
        IdeaData("asdf"),
        IdeaData("gre"),
        IdeaData("gre"),
        IdeaData("gre"),
        IdeaData("gre"),
        IdeaData("gre")

    ) }