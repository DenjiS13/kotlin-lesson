package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.drawer.Exo_12_Drawer

@Composable
fun Exo_12_Home(nflFranchises: List<Exo_12_Franchise>?) {
    if (nflFranchises != null) {
        Exo_12_Drawer(nflFranchises)
    } else {
        Image(painter = painterResource(id = R.drawable.exo_11_nfl_nfl), contentDescription = "NFL")
    }
}