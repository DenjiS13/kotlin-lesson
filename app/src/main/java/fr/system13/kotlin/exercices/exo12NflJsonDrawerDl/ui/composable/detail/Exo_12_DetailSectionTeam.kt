package com.codabee.nfl.ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Team

@Composable
fun Exo_12_DetailSectionTeam(team: Exo_12_Team) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp),
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        AsyncImage(
            model = team.logo,
            contentDescription = null,
            placeholder = painterResource(id = R.drawable.exo_11_nfl_nfl),
            modifier = Modifier.height(100.dp)
        )
        Text(
            text = "${team.location} ${team.name}",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}