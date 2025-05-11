package fr.system13.kotlin.exercices.exo09.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults.cardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo09.model.ZooAnimal

@Composable
fun ZooAnimalView(animal: ZooAnimal) {
    Card(
        elevation = cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
            hoveredElevation = 8.dp,
            focusedElevation = 8.dp,
            draggedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(percent = 10)
    ) {
        Column {
            Image(
                painter = painterResource(animal.image),
                contentDescription = animal.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.height((LocalConfiguration.current.screenWidthDp / 2).dp) // Set the height to half of the screen width
            )
            Text(
                text = animal.name,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier
                    .padding(14.dp)
                    .fillMaxWidth()
            )
        }
    }
}