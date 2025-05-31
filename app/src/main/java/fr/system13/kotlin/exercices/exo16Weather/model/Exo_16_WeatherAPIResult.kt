package fr.system13.kotlin.exercices.exo16Weather.model

data class Exo_16_WeatherAPIResult(
    val cod: String,
    val message: Int,
    val cnt: Int,
    val list: List<WeatherDetail>,
    val city: WeatherDetailCity
)

data class WeatherDetail(
    val dt: Long,
    val main: WeatherDetailMain,
    val weather: List<WeatherDetailWeather>,
    val clouds: WeatherDetailClouds,
    val wind: WeatherDetailWind,
    val visibility: Int,
    val pop: Float,
    val sys: WeatherDetailSys,
    val dt_txt: String
)

data class WeatherDetailMain(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Int,
    val sea_level: Int,
    val grnd_level: Int,
    val humidity: Int,
    val temp_kf: Double
)

data class WeatherDetailWeather(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)

data class WeatherDetailClouds(
    val all: Int
)

data class WeatherDetailWind(
    val speed: Double,
    val deg: Int,
    val gust: Double
)

data class WeatherDetailCity(
    val id: Int,
    val name: String,
    val coord: WeatherDetailCityCoord,
    val country: String,
    val population: Int,
    val timezone: Int,
    val sunrise: Int,
    val sunset: Int
)

data class WeatherDetailCityCoord(
    val lat: Double,
    val lon: Double
)

data class WeatherDetailSys(
    val pod: String
)