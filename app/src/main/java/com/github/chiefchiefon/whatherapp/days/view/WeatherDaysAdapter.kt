package com.github.chiefchiefon.whatherapp.days.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.whatherapp.R
import java.text.SimpleDateFormat
import java.util.*

class WeatherDaysAdapter : RecyclerView.Adapter<WeatherDaysAdapter.WeatherDaysViewHolder>() {

    var weatherDAys: List<WeatherDay> = listOf(

            WeatherDay(Date(), "Sunny", "22"),
            WeatherDay(Date(), "Cloudy", "21"),
            WeatherDay(Date(), "Sun-cloudy", "20"),
            WeatherDay(Date(), "Rainy", "19")
    )

    class WeatherDaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weatherIcon: ImageView = itemView.findViewById(R.id.centerIcon)
        val condition: TextView = itemView.findViewById(R.id.firstTV)
        val dateView: TextView = itemView.findViewById(R.id.secondTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDaysViewHolder {
        return WeatherDaysViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.weather_day_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: WeatherDaysViewHolder, position: Int) {
        val weatherDay = weatherDAys[position]

        holder.condition.text = weatherDay.degrees
        holder.dateView.text = weatherDay.date.toString()
        when(weatherDay.condition) {
            "Sunny" -> holder.weatherIcon.setImageResource(R.drawable.ic_fahrenheit_line)
            "Sun-cloudy" -> holder.weatherIcon.setImageResource(R.drawable.ic_sun_cloudy_line)
            "Rainy" -> holder.weatherIcon.setImageResource(R.drawable.ic_showers_line)
            "Cloudy" -> holder.weatherIcon.setImageResource(R.drawable.ic_cloudy_line)
        }
    }

    override fun getItemCount(): Int {
        return weatherDAys.size
    }
    data class WeatherDay(val date: Date, val condition: String, val degrees: String)
}