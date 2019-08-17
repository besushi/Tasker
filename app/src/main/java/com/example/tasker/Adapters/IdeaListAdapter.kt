package com.example.tasker.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.tasker.Module.IdeaData
import com.example.tasker.R
import kotlinx.android.synthetic.main.card_task.view.*
import kotlinx.android.synthetic.main.item_card_idea.view.*
import kotlinx.android.synthetic.main.item_card_init.view.*


class IdeaListAdapter (var Ideas:MutableList<IdeaData> ): RecyclerView.Adapter<IdeaListAdapter.ViewHolder>(){

    private var swipedPosition: Int = 0
    private var swipedItem: IdeaData? = null


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_card_idea, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val Idea = Ideas[position]
        holder.setDataToRecycleViewItems(Idea, position)
    }

    override fun getItemCount(): Int {
      return Ideas.size
    }


    fun swapItems(fromPosition: Int, toPosition: Int) {
        if (fromPosition < toPosition) {
            for (i in fromPosition..toPosition - 1) {
                Ideas.set(i, Ideas.set(i+1, Ideas.get(i)))
            }
        } else {
            for (i in fromPosition..toPosition + 1) {
                Ideas.set(i, Ideas.set(i-1, Ideas.get(i)))
            }
        }

        notifyItemMoved(fromPosition, toPosition)
    }



    fun removeItem(position: Int, viewHolder: RecyclerView.ViewHolder) {
        swipedItem = Ideas[position]
        swipedPosition = position

        Ideas.removeAt(position)
        notifyItemRemoved(position)

        Snackbar.make(viewHolder.itemView, "${swipedItem!!.title} removed", Snackbar.LENGTH_LONG).setAction("UNDO") {
            Ideas.add(swipedPosition, swipedItem!!)
            notifyItemInserted(swipedPosition)

        }.show()
    }


    fun StartnewActivity(context: Context,position: Int) {
        swipedItem = Ideas[position]
        swipedPosition = position
        notifyItemChanged(swipedPosition)

        Toast.makeText(context, swipedItem!!.title,Toast.LENGTH_SHORT).show()

//        val intent = Intent(context, Activity2::class.java)
//        context.startActivity(intent)


    }







    inner class ViewHolder(idea: View) : RecyclerView.ViewHolder(idea) {




        var currentIdea: IdeaData? = null
        var currentPosition: Int = 0


        init {



        }

        @SuppressLint("SetTextI18n")
        fun setDataToRecycleViewItems(idea: IdeaData, position: Int) {
            itemView.title.text = idea.title

            itemView.include_progress.visibility =View.GONE

            if(idea.tasklist.isEmpty()){
                itemView.include_init.visibility = View.GONE

            }   else{

                itemView.include_init.visibility = View.VISIBLE
                itemView.init_title1.text = idea.tasklist[0].title

            }

            


            this.currentIdea = idea
            this.currentPosition = position


        }


    }

}






