package com.amrutha.amruthatestapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amrutha.amruthatestapplication.api.ApiService
import com.amrutha.amruthatestapplication.database.AppDatabase
import com.amrutha.amruthatestapplication.factory.MainViewModelFactory
import com.amrutha.amruthatestapplication.repository.MainRepository
import com.amrutha.amruthatestapplication.viewmodel.MainViewModel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var viewModel: MainViewModel
    private val apiService = ApiService.getInstance()
    private val mainViewAdapter = MainViewAdapter()

    private val appDatabase by lazy { AppDatabase.getDatabase(this).appDao() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel = ViewModelProvider(
            this,
            MainViewModelFactory(MainRepository(apiService))
        )[MainViewModel::class.java]

        recyclerView.adapter = mainViewAdapter

        viewModel.catList.observe(this, Observer {
            for (i in 0..it.size - 1) {
                lifecycleScope.launch {
                    appDatabase.addData(CatDataItemToCatRoomModelConverter().fromAPItoDB(it[i]))
                }
            }
        })

        viewModel.errorMessage.observe(this, Observer {
        })

        viewModel.getAllCats()
        getRoomData()
    }

    private fun getRoomData() {
        lifecycleScope.launch {
            appDatabase.getData().collect { dataList ->
                if (dataList.isNotEmpty()) {
                    Log.e(TAG, "getRoomData: ${dataList[0].name}")
                    mainViewAdapter.setCatList(dataList)
                }
            }
        }
    }
}