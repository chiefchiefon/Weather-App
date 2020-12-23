package com.github.chiefchiefon.weatherapp.data

import com.github.chiefchiefon.weatherapp.R

object ConditionToImage {
    fun conditionToImage(condition: WeatherCondition): Int {
        return when(condition) {
            WeatherCondition.rain_heavy -> R.drawable.ic_heavy_showers_line
            WeatherCondition.rain -> R.drawable.ic_showers_line
            WeatherCondition.rain_light,
            WeatherCondition.freezing_rain_heavy,
            WeatherCondition.freezing_rain,
            WeatherCondition.freezing_rain_light -> R.drawable.ic_rainy_line
            WeatherCondition.freezing_drizzle,
            WeatherCondition.drizzle -> R.drawable.ic_drizzle_line
            WeatherCondition.ice_pellets_heavy,
            WeatherCondition.ice_pellets,
            WeatherCondition.ice_pellets_light,
            WeatherCondition.snow_heavy,
            WeatherCondition.snow,
            WeatherCondition.snow_light -> R.drawable.ic_snowy_line
            WeatherCondition.flurries,
            WeatherCondition.tstorm -> R.drawable.ic_thunderstorms_line
            WeatherCondition.fog_light -> R.drawable.ic_sun_foggy_line
            WeatherCondition.fog -> R.drawable.ic_foggy_line
            WeatherCondition.cloudy -> R.drawable.ic_cloudy_line
            WeatherCondition.mostly_cloudy,
            WeatherCondition.partly_cloudy -> R.drawable.ic_sun_cloudy_line
            WeatherCondition.mostly_clear,
            WeatherCondition.clear -> R.drawable.ic_moon_clear_line
            else -> R.drawable.ic_fahrenheit_line
        }
    }
}