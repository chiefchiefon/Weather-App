package com.github.chiefchiefon.weatherapp.days.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.weatherapp.R
import com.github.chiefchiefon.weatherapp.data.ConditionToImage.conditionToImage
import com.github.chiefchiefon.weatherapp.data.WeatherCondition
import com.github.chiefchiefon.weatherapp.data.WeatherCondition.*
import java.util.*

class WeatherDaysAdapter : RecyclerView.Adapter<WeatherDaysAdapter.WeatherDaysViewHolder>() {

    private val today = Date()

    var weatherDays: List<WeatherDay> = emptyList()
    var weatherToday: WeatherDay? = null

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
        val weatherDay = weatherDays[position]

        holder.condition.text = weatherDay.degrees
        holder.dateView.text = holder.itemView.context.resources.getStringArray(R.array.days_of_week)[weatherDay.dayOfWeek - 1]
        holder.weatherIcon.setImageResource(conditionToImage(weatherDay.condition))
    }

    override fun getItemCount(): Int {
        return weatherDays.size
    }
    data class WeatherDay(val dayOfWeek: Int, val condition: WeatherCondition, val degrees: String)
}