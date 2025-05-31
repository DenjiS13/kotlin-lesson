package fr.system13.kotlin.exercices.exo16Weather.ui.composable.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.Exo_16_WeatherTileMain
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.Exo_16_WeatherTile
import fr.system13.kotlin.exercices.exo16Weather.ui.state.Ex0_16_WeatherUIState
import fr.system13.kotlin.exercices.exo16Weather.viewModel.Exo_16_WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_16_WeatherSuccessView(viewModel: Exo_16_WeatherViewModel) {

    val forecast = (viewModel.weatherState as Ex0_16_WeatherUIState.SUCCESS).forecast

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Exo_16_WeatherTileMain(forecast.list[0], forecast.city)
        LazyColumn {
            items(forecast.list.size) { index -> Exo_16_WeatherTile(forecast.list[index], forecast.city) }
        }
    }
}