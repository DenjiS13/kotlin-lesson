package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.codabee.nfl.ui.view.Exo_12_DetailSectionStadium
import com.codabee.nfl.ui.view.Exo_12_DetailSectionTeam
import com.codabee.nfl.ui.view.Exo_12_DetailSectionTitle
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise

@Composable
fun Exo_12_DetailView(franchise: Exo_12_Franchise, modifier: Modifier = Modifier) {

    val team = franchise.team
    val stadium = franchise.stadium

    Column(modifier = modifier) {
        Exo_12_DetailSectionTeam(team = team)
        HorizontalDivider()
        Exo_12_DetailSectionTitle(titles = franchise.titles)
        HorizontalDivider()
        Exo_12_DetailSectionStadium(stadium = stadium)
    }
}