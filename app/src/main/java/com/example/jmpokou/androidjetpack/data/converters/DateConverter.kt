package com.example.jmpokou.androidjetpack.data.converters

import android.arch.persistence.room.TypeConverter
import java.util.*

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: Long) = Date(timestamp)

    @TypeConverter
    fun toTimeStamp(date: Date) = date.time
}