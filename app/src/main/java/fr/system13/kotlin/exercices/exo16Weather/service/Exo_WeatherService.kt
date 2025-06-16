package fr.system13.kotlin.exercices.exo16Weather.service

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private var scalarsConverterFactory = ScalarsConverterFactory.create()

private const val API_ID_1 = "0191d1df"
private const val API_ID_2 = "945fbe6e"
private const val API_ID_3 = "c5873f6b"
private const val API_ID_4 = "1e4c95ab"
private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

// construction du retrofit
private val retrofit = Retrofit
    .Builder()
    .baseUrl(BASE_URL)
    .addConverterFactory(scalarsConverterFactory).build()

// Interface d'appel
interface Exo_WeatherService {
    @GET("forecast")
    suspend fun getForecast(
        @Query("q") city: String,
        @Query("cnt") count: Int = 21,
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "fr",
        @Query("appid") appid: String = API_ID_1 + API_ID_2 + API_ID_3 + API_ID_4
    ): String
}

// Objet d'appel
object Exo_16_WeatherAPI {
    val service: Exo_WeatherService by lazy { retrofit.create(Exo_WeatherService::class.java) }
}