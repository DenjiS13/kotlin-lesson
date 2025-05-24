package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.franchises

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise

@Composable
fun Exo_12_FranchiseList(
    franchises: List<Exo_12_Franchise>?,
    modifier: Modifier = Modifier,
    onSelected: (Exo_12_Franchise) -> Unit = {}
) {

    if (franchises == null) return

    LazyColumn() {
        items(franchises.size) { index -> Exo_12_FranchiseCard(franchises[index], { onSelected(franchises[index]) }) }
    }

}