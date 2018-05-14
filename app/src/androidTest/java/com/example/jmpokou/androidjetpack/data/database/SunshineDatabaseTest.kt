package com.example.jmpokou.androidjetpack.data.database

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import com.example.jmpokou.androidjetpack.data.database.SunshineDatabase
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.*

@RunWith(AndroidJUnit4::class)
class SunshineDatabaseTest {

    private lateinit var dao: WeatherDao
    private lateinit var db: SunshineDatabase
    private val date = Date()
    private val weatherEntries = arrayOf<WeatherEntry>(
            WeatherEntry(1, 3, date, 2.3, 4.4, 4, 39, 23.9, 0.03))

    @Before
    fun createDatabase() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(context, SunshineDatabase::class.java).build()
        dao = db.weatherDao()
    }

    @Test
    fun testBulkInsert() {
        dao.bulkInsert(*weatherEntries)
        val entry = dao.getWeatherByDate(date = date)
        Assert.assertEquals(1, entry.id)
    }
}