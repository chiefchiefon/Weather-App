package com.github.chiefchiefon.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.github.chiefchiefon.weatherapp.data.ClimacellApiService
import com.github.chiefchiefon.weatherapp.data.ConditionToImage.conditionToImage
import com.github.chiefchiefon.weatherapp.data.ForecastDay
import com.github.chiefchiefon.weatherapp.days.view.WeatherDaysAdapter
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import java.util.*

class MainActivity : AppCompatActivity() {
    private var weatherDaysAdapter: WeatherDaysAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weatherDAysList = findViewById<RecyclerView>(R.id.weatherDaysList)

        weatherDaysAdapter = WeatherDaysAdapter()

        weatherDAysList.adapter = weatherDaysAdapter

        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.climacell.co/v3/")
            .addConverterFactory(Json.asConverterFactory(MediaType.get("application/json")))
            .build()

        val climacellService = retrofit.create(ClimacellApiService::class.java)

        val forecastCall = climacellService.getForecast(
            lat = 31.7683,
            lon = 35.2137,
            unit_system = "si",
            fields = arrayOf("weather_code", "temp"),
            start_time = "now",
            apikey = "UEPgicRS4WQMaQ2CkidjLlqHr2RdMEPV"
        )
        forecastCall.enqueue(ForecastCallback())
    }

    fun updateTodayView() {
        weatherDaysAdapter?.weatherToday?.let {
            findViewById<TextView>(R.id.weatherTV).setText(resources.getStringArray(R.array.days_of_week)[it.dayOfWeek - 1])
            findViewById<TextView>(R.id.tempTodayTV).setText(it.degrees)
            findViewById<ImageView>(R.id.topImage).setImageResource(conditionToImage(it.condition))
        }

    }
    inner class ForecastCallback: Callback<List<ForecastDay>> {
        override fun onResponse(
            call: Call<List<ForecastDay>>,
            response: Response<List<ForecastDay>>
        ) {
            if(response.isSuccessful) {
                val weatherDays = response.body()?.map { forecastDay: ForecastDay ->
                    WeatherDaysAdapter.WeatherDay(
                        dayOfWeek = forecastDay.observation_time.toCalendar().get(Calendar.DAY_OF_WEEK),
                        condition = forecastDay.weather_code.value,
                        degrees = forecastDay.getAverageTemp().formatted()
                    )
                }

                weatherDays?.let {
                    weatherDaysAdapter?.weatherDays = it.drop(1)
                    weatherDaysAdapter?.weatherToday = it[0]
                    updateTodayView()
                    weatherDaysAdapter?.notifyDataSetChanged()
                }
            }
            else {
                findViewById<TextView>(R.id.statusTV).setText("Something went wrong with the receiving data from server.")
            }
            //Toast.makeText(this@MainActivity, response.toString(), Toast.LENGTH_LONG).show()
        }

        override fun onFailure(call: Call<List<ForecastDay>>, t: Throwable) {
            val statusTV = findViewById<TextView>(R.id.statusTV)
            statusTV.setText("Neshama, somethi'n went wrong with the weather. Stay home'n stay safe, Kapara.")
            statusTV.setBackgroundColor(0xFF00000)
            //Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
        }
    }
}