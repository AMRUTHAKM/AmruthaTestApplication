package com.amrutha.amruthatestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrutha.amruthatestapplication.model.Items

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val itemList = ArrayList<Items>()
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


        for(i in 0..10){
            itemList.add(Items("abc","abc"))
        }

        val mainViewAdapter = MainViewAdapter(itemList)
            recyclerView.adapter = mainViewAdapter





    }
}