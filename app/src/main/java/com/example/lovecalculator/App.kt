package com.example.lovecalculator

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.lovecalculator.room.AppDatabase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App: Application() {
    companion object{
        lateinit var appDatabase: AppDatabase

    }
    override fun onCreate() {
        super.onCreate()
        appDatabase = Room.databaseBuilder(applicationContext, AppDatabase::class.java,
            "love_data").allowMainThreadQueries().build()
    }
}