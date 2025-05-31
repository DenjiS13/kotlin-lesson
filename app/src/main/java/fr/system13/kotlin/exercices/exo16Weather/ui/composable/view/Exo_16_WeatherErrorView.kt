package fr.system13.kotlin.exercices.exo16Weather.ui.composable.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo16Weather.ui.state.Ex0_16_WeatherUIState
import fr.system13.kotlin.exercices.exo16Weather.viewModel.Exo_16_WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_16_WeatherErrorView(viewModel: Exo_16_WeatherViewModel) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Une erreur est survenue : ${(viewModel.weatherState as Ex0_16_WeatherUIState.ERROR).message}",
            color = MaterialTheme.colorScheme.error,
            modifier = Modifier.padding(8.dp))
    }

}