package com.amrutha.amruthatestapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.amrutha.amruthatestapplication.database.CatRoomModel
import com.bumptech.glide.Glide

class MainViewAdapter() : RecyclerView.Adapter<MainViewAdapter.ViewHolder>() {

    var adapterList = mutableListOf<CatRoomModel>()

    fun setCatList(catList: List<CatRoomModel>) {
        this.adapterList = catList.toMutableList()
        notifyDataSetChanged()
    }

    class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val imageCat: ImageView = itemView.findViewById(R.id.image_cat)
        val textName: TextView = itemView.findViewById(R.id.name)
        val textOrigin: TextView = itemView.findViewById(R.id.origin)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MainViewAdapter.ViewHolder, position: Int) {
        val item = adapterList[position]
        holder.textName.text = item.name
        holder.textOrigin.text = item.origin
        Glide.with(holder.itemView.context).load(item.image).into(holder.imageCat)
    }

    override fun getItemCount(): Int {

        return adapterList.size
    }
}