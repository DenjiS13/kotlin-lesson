package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.franchises

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import coil3.ImageLoader
import coil3.compose.AsyncImage
import coil3.request.crossfade
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise

@Composable
fun Exo_12_FranchiseCard(nflFranchise: Exo_12_Franchise, onSelected: () -> Unit) {
    Card(
        modifier = Modifier
            .padding(2.dp)
            .fillMaxWidth()
            .clip(RoundedCornerShape(percent = 4))
            .clickable { onSelected() },
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
        Row(verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                model = nflFranchise.team.logo,
                contentDescription = nflFranchise.team.name,
                placeholder = painterResource(R.drawable.exo_11_nfl_nfl),
                imageLoader = ImageLoader.Builder(LocalContext.current)
                    .crossfade(true)
                    .build(),
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = nflFranchise.team.name, style = MaterialTheme.typography.headlineMedium)
                Text(text = nflFranchise.team.location, style = MaterialTheme.typography.bodyLarge)
            }

            Image(
                painter = painterResource(if (nflFranchise.conference == "NFC") R.drawable.exo_11_nfl_nfc else R.drawable.exo_11_nfl_afc),
                contentDescription = nflFranchise.conference,
                modifier = Modifier
                    .width(60.dp)
                    .height(60.dp)
            )
        }
    }
}