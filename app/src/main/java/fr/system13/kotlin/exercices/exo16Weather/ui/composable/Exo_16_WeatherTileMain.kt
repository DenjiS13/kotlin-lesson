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
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo16Weather.model.WeatherDetail
import fr.system13.kotlin.exercices.exo16Weather.model.WeatherDetailCity
import fr.system13.kotlin.exercices.exo16Weather.service.Ex0_16_DateTimeHelper
import fr.system13.kotlin.exercices.exo16Weather.service.Exo_16_WeatherImageHelper
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

@Composable
fun Exo_16_WeatherTileMain(forecast: WeatherDetail, city: WeatherDetailCity) {

    val imageHelper = Exo_16_WeatherImageHelper.getInstance()

    val weather = forecast.weather[0]
    val temp = String.format(Locale.FRENCH, "%.1f", forecast.main.temp)

    val hourPattern = "HH:mm"

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp),
        shape = MaterialTheme.shapes.small,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    )
    {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(text = city.name, style = MaterialTheme.typography.headlineMedium)
                Text(
                    text = "lon : ${city.coord.lon}, lat : ${city.coord.lat}",
                    style = MaterialTheme.typography.bodySmall
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    painter = painterResource(imageHelper.getWeatherIcon(weather.icon)),
                    contentDescription = null,
                    modifier = Modifier
                        .height(80.dp)
                        .width(80.dp)
                        .padding(8.dp)
                )
                Text(text = "$temp °C", style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.secondary)
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Lever : " + Ex0_16_DateTimeHelper.getInstance().getString(city.sunrise.toLong(), city.timezone, hourPattern),
                    style = MaterialTheme.typography.bodySmall
                )
                Text(
                    text = weather.description,
                    style = MaterialTheme.typography.bodyLarge,
                    fontStyle = FontStyle.Italic
                )
                Text(
                    text = "Coucher : " + Ex0_16_DateTimeHelper.getInstance().getString(city.sunset.toLong(), city.timezone, hourPattern),
                    style = MaterialTheme.typography.bodySmall
                )
            }
        }
    }
}