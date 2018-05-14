package com.example.jmpokou.androidjetpack.ui.detail

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.jmpokou.androidjetpack.data.database.WeatherEntry

class DetailActivityViewModel : ViewModel() {

    private var weatherEntries: MutableLiveData<Array<WeatherEntry>> = MutableLiveData()

    fun getWeatherEntries(): MutableLiveData<Array<WeatherEntry>> {
        return weatherEntries
    }

    fun setWeatherEntries(entry: WeatherEntry) {
        weatherEntries.postValue(arrayOf(entry))
    }

}