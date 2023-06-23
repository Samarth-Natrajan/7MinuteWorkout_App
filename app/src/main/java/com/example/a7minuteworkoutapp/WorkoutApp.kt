package com.example.a7minuteworkoutapp

import android.app.Application

class WorkoutApp:Application() {
    val db by lazy {
        HistoryDatabase.getInstance(this)
    }
}