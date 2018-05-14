package com.example.jmpokou.androidjetpack.data.database

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Index
import android.arch.persistence.room.PrimaryKey
import java.util.*


@Entity(tableName = "weather", indices = [Index(value = ["date"], unique = true)])
data class WeatherEntry(
        @PrimaryKey(autoGenerate = true)
        val id: Int,
        val weatherIconId: Int,
        val date: Date,
        val min: Double,
        val max: Double,
        val humidity: Int,
        val degrees: Int,
        val pressure: Double,
        val wind: Double
)
