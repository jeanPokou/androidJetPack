package com.example.jmpokou.androidjetpack.data.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import android.content.Context
import com.example.jmpokou.androidjetpack.data.converters.DateConverter

@Database(entities = [WeatherEntry::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class SunshineDatabase : RoomDatabase() {

    // Creation of Database instance singleton
    companion object {
        private val DATABASE_NAME: String = "weather"
        @Volatile
        private lateinit var instance: SunshineDatabase

        fun getInstance(context: Context): SunshineDatabase {
            synchronized(lock = this) {
                instance = Room.databaseBuilder(context.applicationContext, SunshineDatabase::class.java, DATABASE_NAME).build()
            }
            return instance
        }
    }

    // Add weatherEntry entities to Database
    abstract fun weatherDao(): WeatherDao
}