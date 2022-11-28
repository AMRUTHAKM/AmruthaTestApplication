package com.amrutha.amruthatestapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrutha.amruthatestapplication.api.ApiService
import com.amrutha.amruthatestapplication.factory.MainViewModelFactory
import com.amrutha.amruthatestapplication.model.Items
import com.amrutha.amruthatestapplication.repository.MainRepository
import com.amrutha.amruthatestapplication.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private val itemList = ArrayList<Items>()
    private lateinit var viewModel: MainViewModel
    private val apiService = ApiService.getInstance()
    private val mainViewAdapter = MainViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(this, MainViewModelFactory(MainRepository(apiService)))
            .get(MainViewModel::class.java)

        recyclerView.adapter = mainViewAdapter

        viewModel.catList.observe(this, Observer {
            Log.e(TAG, "size:$it")

            mainViewAdapter.setCatList(it)
        })

        viewModel.errorMessage.observe(this, Observer {
        })

        viewModel.getAllCats()


        /*for (i in 0..10) {
            itemList.add(Items("abc", "abc"))
        }

        val mainViewAdapter = MainViewAdapter(itemList)*/


    }
}