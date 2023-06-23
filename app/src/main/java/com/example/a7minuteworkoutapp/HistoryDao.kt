package com.example.a7minuteworkoutapp

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface HistoryDao {
    @Insert
    suspend fun insert(historyEntity: HistoryEntity)

    @Query("SELECT * FROM 'hitory-table'")
    fun fetchAllDates(): Flow<List<HistoryEntity>>
}