package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Screens

@Composable
fun Exo_12_DrawerMenu(onSelected: (Exo_12_Screens) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.primary),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painterResource(id = R.drawable.exo_11_nfl_nfl), contentDescription = "NFL Logo")
        HorizontalDivider()
        Exo_12_DrawerTile(screen = Exo_12_Screens.LEAGUE, onSelected = { onSelected(Exo_12_Screens.LEAGUE) })
        Exo_12_DrawerTile(screen = Exo_12_Screens.NFC, onSelected = { onSelected(Exo_12_Screens.NFC) })
        Exo_12_DrawerTile(screen = Exo_12_Screens.AFC, onSelected = { onSelected(Exo_12_Screens.AFC) })
    }
}