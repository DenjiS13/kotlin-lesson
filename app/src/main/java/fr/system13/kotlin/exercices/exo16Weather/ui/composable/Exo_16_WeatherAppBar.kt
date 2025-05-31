package fr.system13.kotlin.exercices.exo16Weather.ui.composable

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_16_WeatherAppBar(title: String) {
    TopAppBar(title = { Text(text = title) })
}