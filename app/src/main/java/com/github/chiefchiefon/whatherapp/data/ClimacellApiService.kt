package com.github.chiefchiefon.whatherapp.data

/**
 * object-structures of data in retrofit2 body response
 * it's received as JSON and converted to kotlin data class
 */

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ClimacellApiService {
    @GET("weather/forecast/daily")
    fun getForecast(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("unit_system") unit_system: String,
        @Query("fields") fields: Array<String>,
        @Query("start_time") start_time: String,
        @Query("apikey") apikey: String
    ): Call<List<ForecastDay>>
}