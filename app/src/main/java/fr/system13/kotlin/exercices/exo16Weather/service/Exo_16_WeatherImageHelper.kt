package fr.system13.kotlin.exercices.exo16Weather.service

import fr.system13.kotlin.R

class Exo_16_WeatherImageHelper private constructor() {

    companion object {
        @Volatile
        private var instance: Exo_16_WeatherImageHelper? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Exo_16_WeatherImageHelper().also { instance = it }
            }
    }

    fun getWeatherIcon(iconCode: String): Int {
        return when (iconCode) {
            "01d" -> R.drawable.exo_16_weather_sun
            "01n" -> R.drawable.exo_16_weather_night
            "02d" -> R.drawable.exo_16_weather_cloud_day
            "02n" -> R.drawable.exo_16_weather_cloud_night
            "03d" -> R.drawable.exo_16_weather_cloudy
            "03n" -> R.drawable.exo_16_weather_cloudy
            "04d" -> R.drawable.exo_16_weather_cloudy_max
            "04n" -> R.drawable.exo_16_weather_cloudy_max
            "09d" -> R.drawable.exo_16_weather_shower
            "09n" -> R.drawable.exo_16_weather_shower
            "10d" -> R.drawable.exo_16_weather_rain_day
            "10n" -> R.drawable.exo_16_weather_rain_night
            "11d" -> R.drawable.exo_16_weather_thunder_day
            "11n" -> R.drawable.exo_16_weather_thunder_night
            "13d" -> R.drawable.exo_16_weather_snow_day
            "13n" -> R.drawable.exo_16_weather_snow_night
            "50d" -> R.drawable.exo_16_weather_mist_day
            "50n" -> R.drawable.exo_16_weather_mist_night
            else -> R.drawable.exo_16_weather_temp
        }
    }

}