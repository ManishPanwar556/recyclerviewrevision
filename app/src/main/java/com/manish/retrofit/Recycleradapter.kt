package com.manish.retrofit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.textview.view.*
import retrofit2.Response

class  rvadapter(val list: List<User>):RecyclerView.Adapter<rvadapter.listviewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listviewholder {
        return listviewholder(
            LayoutInflater.from(parent.context).inflate(R.layout.textview,parent,false)
        )
    }

    override fun getItemCount(): Int =list.size

    override fun onBindViewHolder(holder: listviewholder, position: Int) {
        val listarr=list[position]
        holder.view.textview.text=listarr.url
    }

    class listviewholder(val view: View): RecyclerView.ViewHolder(view)
}