package com.example.a7minuteworkoutapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hitory-table")
data class HistoryEntity(
    @PrimaryKey
    val date:String
)
