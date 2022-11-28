package com.amrutha.amruthatestapplication.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AppDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addData(catData: CatRoomModel)

    @Query("SELECT * FROM cat_table")
    fun getData(): Flow<List<CatRoomModel>>
}