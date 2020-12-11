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
//        val weatherTV = findViewById<TextView>(R.id.weatherTV)
//        val tempTodayTV = findViewById<TextView>(R.id.tempTodayTV)
//        val topImage = findViewById<ImageView>(R.id.topImage)
//
//        val cityTV = findViewById<TextView>(R.id.cityTV)
//
//
//        weatherTV.setText(R.string.weatherText)
//        weatherTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, resources.getDimension(R.dimen.today_weather_text_size))
//
//        tempTodayTV.setText(R.string.celsiusTempToday)
//        tempTodayTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, resources.getDimension(R.dimen.today_temp_size))
//
//        topImage.setImageDrawable(resources.getDrawable(R.drawable.ic_celsius_line, resources.newTheme()))
//        //I couldn't delete the android:src="@mipmap/weather_64 of ImageView @ activity_main.xml
//        topImage.contentDescription = R.drawable.ic_celsius_line.toString()
//
//        cityTV.setText(R.string.city_name)
//        cityTV.setTextSize(TypedValue.COMPLEX_UNIT_SP, resources.getDimension(R.dimen.city_name_size))
    }
}