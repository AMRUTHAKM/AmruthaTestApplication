package com.amrutha.amruthatestapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amrutha.amruthatestapplication.model.Items

class MainViewAdapter(var itemList: List<Items>) :
    RecyclerView.Adapter<MainViewAdapter.ViewHolder>() {

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textName: TextView = itemView.findViewById(R.id.name)
        val textOrigin: TextView = itemView.findViewById(R.id.origin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewAdapter.ViewHolder, position: Int) {
        val item = itemList[position]
        holder.textName.text = item.name
        holder.textOrigin.text = item.origin
    }

    override fun getItemCount(): Int {

        return itemList.size
    }
}