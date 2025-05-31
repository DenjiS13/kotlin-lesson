package fr.system13.kotlin.exercices.exo16Weather.viewModel

import android.net.http.HttpException
import android.os.Build
import androidx.annotation.RequiresExtension
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import fr.system13.kotlin.exercices.exo16Weather.model.Exo_16_WeatherAPIResult
import fr.system13.kotlin.exercices.exo16Weather.service.Exo_16_WeatherAPI
import fr.system13.kotlin.exercices.exo16Weather.ui.state.Ex0_16_WeatherUIState
import kotlinx.coroutines.launch
import java.io.IOException

class Exo_16_WeatherViewModel : ViewModel() {

    // Text field
    var textFieldcity: String by mutableStateOf("")

    // État de l'appel API
    var weatherState: Ex0_16_WeatherUIState by mutableStateOf(Ex0_16_WeatherUIState.IDLE)

    fun updateCityTextField(city: String) {
        this.textFieldcity = city
    }

    @RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
    fun launchAPI() {

        // lance un coroutine avec WeatherService
        viewModelScope.launch {

            weatherState = Ex0_16_WeatherUIState.LOADING

            try {
                val result = Exo_16_WeatherAPI.service.getForecast(city = textFieldcity)
                weatherState = Ex0_16_WeatherUIState.SUCCESS(convertData(result))
            } catch (ioException: IOException) {
                weatherState = Ex0_16_WeatherUIState.ERROR(("IOException : " + ioException.message))
            } catch (httpException: HttpException) {
                weatherState = Ex0_16_WeatherUIState.ERROR(("HttpException : " + httpException.message))
            } catch (exception: Exception) {
                weatherState = Ex0_16_WeatherUIState.ERROR(("Exception : " + exception.message))
            }
        }
    }

    fun convertData(apiResult: String): Exo_16_WeatherAPIResult {

        val gson = Gson()
        val result = gson.fromJson(apiResult, Exo_16_WeatherAPIResult::class.java)
        return result

    }
}