package com.example.jmpokou.androidjetpack.ui.detail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.jmpokou.androidjetpack.R

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: DetailActivityViewModel
    private val TAG = DetailActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        viewModel = ViewModelProviders.of(this).get(DetailActivityViewModel::class.java)


        viewModel.getWeatherEntries().observe(this, Observer {

            it?.let {
                val item = it[0]
                Log.d(TAG, item.id.toString())
                Toast.makeText(applicationContext, "value has changed", Toast.LENGTH_SHORT).show()
            }
        })

    }
}
