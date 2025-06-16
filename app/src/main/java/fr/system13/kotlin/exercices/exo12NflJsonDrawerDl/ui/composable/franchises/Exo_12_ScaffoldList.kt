package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.franchises

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.Exo_12_AppBar

@Composable
fun ScaffoldList(
    conference: String,
    franchises: List<Exo_12_Franchise>?,
    openDrawer: () -> Unit,
    onSelected: (Exo_12_Franchise) -> Unit
) {
    Scaffold(
        topBar = { Exo_12_AppBar(conference, openDrawer) },
        content = { paddingValues: PaddingValues ->
            Exo_12_FranchiseList(
                franchises = franchises,
                modifier = Modifier.padding(paddingValues),
                onSelected = onSelected
            )
        }
    )
}