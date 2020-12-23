package com.github.chiefchiefon.weatherapp.data
import kotlinx.serialization.Serializable
import java.text.SimpleDateFormat
import java.util.*

@Serializable
data class ForecastDay (
    val lat: Double,
    val lon: Double,
    val observation_time: ObservationTime,
    val weather_code: WeatherCode,
    val temp: List<Temperature>
    ) {
    fun getAverageTemp(): TemperatureValue {
        return TemperatureValue(temp.sumByDouble { it.either().value } / temp.size,
        units = temp.first().either().units) // we need units only, and it appears in both temps., so we arbitrarily take the first one.
    }
}

@Serializable
data class ObservationTime(val value: String) {
    fun toCalendar(): Calendar {
        val date = SimpleDateFormat("yyyy-MM-dd").parse(value)
        val calendar = Calendar.getInstance()
        calendar.time = date
        return calendar
    }
}

@Serializable
data class WeatherCode(val value: WeatherCondition)

@Serializable
data class Temperature(val observation_time: String, val min:TemperatureValue? = null, val max:TemperatureValue? = null) {
    fun either(): TemperatureValue {
        return (min ?: max)!!
    }
}

@Serializable
data class TemperatureValue(val value: Double, val units: String) {
    fun formatted(): String {
        return "%.${1}f".format(value) + " $units"
    }
}

enum class WeatherCondition {
    rain_heavy,
    rain,
    rain_light,
    freezing_rain_heavy,
    freezing_rain,
    freezing_rain_light,
    freezing_drizzle,
    drizzle,
    ice_pellets_heavy,
    ice_pellets,
    ice_pellets_light,
    snow_heavy,
    snow,
    snow_light,
    flurries,
    tstorm,
    fog_light,
    fog,
    cloudy,
    mostly_cloudy,
    partly_cloudy,
    mostly_clear,
    clear
}
