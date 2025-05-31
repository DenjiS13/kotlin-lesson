package fr.system13.kotlin.exercices.exo16Weather.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo16Weather.model.WeatherDetail
import fr.system13.kotlin.exercices.exo16Weather.model.WeatherDetailCity
import fr.system13.kotlin.exercices.exo16Weather.service.Ex0_16_DateTimeHelper
import fr.system13.kotlin.exercices.exo16Weather.service.Exo_16_WeatherImageHelper
import java.util.Locale

@Composable
fun Exo_16_WeatherTile(forecast: WeatherDetail, city: WeatherDetailCity) {

    val imageHelper = Exo_16_WeatherImageHelper.getInstance()

    val main = forecast.main
    val weather = forecast.weather[0]
    val temp = String.format(Locale.FRENCH, "%.1f", main.temp)

    val datePattern = "EEEE dd MMMM"
    val hourPattern = "HH:mm"

    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    )
    {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = Ex0_16_DateTimeHelper.getInstance().getString(forecast.dt, city.timezone, datePattern))
                Text(text = Ex0_16_DateTimeHelper.getInstance().getString(forecast.dt, city.timezone, hourPattern))
            }

            Text(text = "$temp °C", style = MaterialTheme.typography.titleLarge)

            Column(
                modifier = Modifier.padding(8.dp),
                verticalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.End
            ) {
                Image(
                    painter = painterResource(imageHelper.getWeatherIcon(weather.icon)),
                    contentDescription = null,
                    modifier = Modifier
                        .height(50.dp)
                        .width(50.dp)
                        .padding(8.dp)
                )
                Text(text = weather.description, style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}