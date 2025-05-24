package com.codabee.nfl.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Stadium

@Composable
fun Exo_12_DetailSectionStadium(stadium: Exo_12_Stadium) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp,
            pressedElevation = 8.dp,
            hoveredElevation = 8.dp,
            focusedElevation = 8.dp,
            draggedElevation = 8.dp,
            disabledElevation = 0.dp
        ),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onSurface
        )
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            AsyncImage(
                model = stadium.image,
                contentDescription = null,
                placeholder = painterResource(id = R.drawable.exo_11_nfl_nfl)
            )
            Text(
                text = stadium.name,
                style = MaterialTheme.typography.bodySmall
            )
            Text(text = "Capacité: ${stadium.capacity} places")
        }
    }
}