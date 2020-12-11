package com.github.chiefchiefon.whatherapp.days.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.whatherapp.R
import java.util.*

class WeatherDaysAdapter : RecyclerView.Adapter<WeatherDaysAdapter.WeatherDaysViewHolder>() {
    var weatherDAys: List<WeatherDay> = emptyList()

    class WeatherDaysViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val weatherIcon: ImageView = itemView.findViewById(R.id.centerIcon)
        val condition: TextView = itemView.findViewById(R.id.firstTV)
        val dateView: TextView = itemView.findViewById(R.id.secondTV)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherDaysViewHolder {
        return WeatherDaysViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.weather_day_item, parent, true)
        )
    }

    override fun onBindViewHolder(holder: WeatherDaysViewHolder, position: Int) {
        val weatherDay = weatherDAys[position]
        holder.condition.text = weatherDay.condition
        holder.dateView.text = weatherDay.date.toString()
        holder.weatherIcon.setImageResource(R.drawable.ic_cloudy_line)
    }

    override fun getItemCount(): Int {
        return weatherDAys.size
    }
    data class WeatherDay(val date: Date, val condition: String, val degrees: String)
}