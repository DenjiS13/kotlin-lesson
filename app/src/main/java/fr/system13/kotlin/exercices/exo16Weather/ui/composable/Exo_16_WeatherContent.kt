package fr.system13.kotlin.exercices.exo16Weather.ui.composable

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.view.Exo_16_WeatherErrorView
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.view.Exo_16_WeatherIdleView
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.view.Exo_16_WeatherLoadingView
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.view.Exo_16_WeatherSuccessView
import fr.system13.kotlin.exercices.exo16Weather.ui.state.Ex0_16_WeatherUIState
import fr.system13.kotlin.exercices.exo16Weather.viewModel.Exo_16_WeatherViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_16_WeatherContent(paddingValues: PaddingValues, viewModel: Exo_16_WeatherViewModel) {

    val manager = LocalFocusManager.current

    @SuppressLint("NewApi")
    fun launch() {
        viewModel.launchAPI()
        manager.clearFocus()
    }

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {

        OutlinedTextField(
            value = viewModel.textFieldcity,
            singleLine = true,
            onValueChange = { viewModel.updateCityTextField(it) },
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Done),
            keyboardActions = KeyboardActions(
                onDone = { launch() },
                onGo = { launch() },
                onSearch = { launch() },
                onSend = { launch() }
            ),
            label = { Text(text = "Entrer une ville") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            trailingIcon = {
                IconButton(onClick = { launch() }) {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null
                    )
                }
            },
        )
        when (viewModel.weatherState) {
            is Ex0_16_WeatherUIState.IDLE -> Exo_16_WeatherIdleView()
            is Ex0_16_WeatherUIState.LOADING -> Exo_16_WeatherLoadingView()
            is Ex0_16_WeatherUIState.ERROR -> Exo_16_WeatherErrorView(viewModel)
            is Ex0_16_WeatherUIState.SUCCESS -> Exo_16_WeatherSuccessView( viewModel)
        }
    }
}