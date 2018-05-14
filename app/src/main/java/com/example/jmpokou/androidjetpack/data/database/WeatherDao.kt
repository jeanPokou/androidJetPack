package com.example.jmpokou.androidjetpack.data.database

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import java.util.*

@Dao
interface WeatherDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun bulkInsert(vararg weatherEntries: WeatherEntry)

    @Query("SELECT * FROM weather WHERE date = :date")
    fun getWeatherByDate(date: Date): WeatherEntry

}