package com.example.tasker.Fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tasker.Adapters.IdeaListAdapter
import com.example.tasker.Module.IdeaSupplier
import com.example.tasker.R
import com.example.tasker.Util.DragManageAdapter
import kotlinx.android.synthetic.main.fragment_ideas.*

/**
 * A simple [Fragment] subclass.
 */
class IdeasFragment : Fragment() {

    


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_ideas, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setPointer()


    }

    private fun setPointer() {

        
        setRecycleView()

        FB_Add_Customer.setOnClickListener {
            Toast.makeText(activity,"ololo",Toast.LENGTH_LONG).show()
        }



        }

    private fun setRecycleView() {

        //set layout manager
        val manager  = LinearLayoutManager(activity)
        MyRecycleView.layoutManager = manager
        //set adapter
        val adapter = IdeaListAdapter(IdeaSupplier.IdeaList)
        MyRecycleView.adapter = adapter

        //todo check what this do
        val dividerItemDecoration = DividerItemDecoration(activity , manager.orientation)
        MyRecycleView.addItemDecoration(dividerItemDecoration)


        // Setup ItemTouchHelper todo learn it
        val callback = DragManageAdapter(adapter, activity!!,
            ItemTouchHelper.UP.or(ItemTouchHelper.DOWN), ItemTouchHelper.LEFT.or(ItemTouchHelper.RIGHT))
        val helper = ItemTouchHelper(callback)
        helper.attachToRecyclerView(MyRecycleView)




       //Hide FAB on Scroll
        MyRecycleView!!.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                recyclerView.let { super.onScrolled(it, dx, dy) }
                if (dy > 0 && FB_Add_Customer.visibility == View.VISIBLE) {
                    FB_Add_Customer.hide()
                } else if (dy < 0 && FB_Add_Customer.visibility != View.VISIBLE) {
                    FB_Add_Customer.show()
                }
            }
        })




    }

   


}
