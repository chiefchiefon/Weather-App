package com.github.chiefchiefon.whatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.whatherapp.days.view.WeatherDaysAdapter

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherDAysList = findViewById<RecyclerView>(R.id.weatherDaysList)

        val adapter = WeatherDaysAdapter()

        weatherDAysList.adapter = adapter
    }
}