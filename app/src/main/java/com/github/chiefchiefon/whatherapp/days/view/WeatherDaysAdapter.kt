package com.github.chiefchiefon.whatherapp.days.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.whatherapp.R
import com.github.chiefchiefon.whatherapp.data.WeatherCondition
import com.github.chiefchiefon.whatherapp.data.WeatherCondition.*
import java.util.*

class WeatherDaysAdapter : RecyclerView.Adapter<WeatherDaysAdapter.WeatherDaysViewHolder>() {

    private val today = Date()

    var weatherDays: List<WeatherDay> = emptyList()

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
        holder.weatherIcon.setImageResource(when(weatherDay.condition) {
            rain_heavy -> R.drawable.ic_heavy_showers_line
            rain -> R.drawable.ic_showers_line
            rain_light,
            freezing_rain_heavy,
            freezing_rain,
            freezing_rain_light -> R.drawable.ic_rainy_line
            freezing_drizzle,
            drizzle -> R.drawable.ic_drizzle_line
            ice_pellets_heavy,
            ice_pellets,
            ice_pellets_light,
            snow_heavy,
            snow,
            snow_light -> R.drawable.ic_snowy_line
            flurries,
            tstorm -> R.drawable.ic_thunderstorms_line
            fog_light -> R.drawable.ic_sun_foggy_line
            fog -> R.drawable.ic_foggy_line
            cloudy -> R.drawable.ic_cloudy_line
            mostly_cloudy,
            partly_cloudy -> R.drawable.ic_sun_cloudy_line
            mostly_clear,
            clear -> R.drawable.ic_moon_clear_line
            else -> R.drawable.ic_fahrenheit_line
        })
    }

    override fun getItemCount(): Int {
        return weatherDays.size
    }
    data class WeatherDay(val dayOfWeek: Int, val condition: WeatherCondition, val degrees: String)
}