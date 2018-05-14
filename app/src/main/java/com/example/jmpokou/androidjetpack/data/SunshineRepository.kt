package com.example.jmpokou.androidjetpack.data

import com.example.jmpokou.androidjetpack.data.database.WeatherDao
import com.example.jmpokou.androidjetpack.data.remote.WeatherNetworkDataSource

class SunshineRepository(private val dao: WeatherDao, private val network: WeatherNetworkDataSource, private val executor: AppExecutors) {

    private val TAG: String = SunshineRepository::class.java.simpleName

}