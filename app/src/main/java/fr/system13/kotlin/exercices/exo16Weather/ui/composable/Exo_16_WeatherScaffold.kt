package fr.system13.kotlin.exercices.exo16Weather.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Exo_16_WeatherScaffold() {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { Exo_16_WeatherAppBar(title = "Weather") },
        content = { paddingValues: PaddingValues -> Exo_16_WeatherContent(paddingValues, viewModel()) }
    )

}