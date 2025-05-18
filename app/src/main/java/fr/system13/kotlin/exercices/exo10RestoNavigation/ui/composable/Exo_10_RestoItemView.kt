package fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo10RestoNavigation.data.Exo_10_RestoDataService
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoItem

@Composable
fun RestoItemView(item: Exo_10_RestoItem, buttonTitle: String, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(12.dp)
            .clickable {

            },
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Text(
            text = item.name,
            style = MaterialTheme.typography.headlineLarge,
        )

        Image(painter = painterResource(item.image), contentDescription = item.name)

        Button(onClick = onClick) { Text(text = buttonTitle) }
    }
}

@Preview(showBackground = true)
@Composable
fun RestoItemViewPreview() {
    RestoItemView(Exo_10_RestoDataService().burger, "Suivant", {})
}