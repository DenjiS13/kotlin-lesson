package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.detail

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise

@Composable
fun Exo_12_DetailScaffold(
    franchise: Exo_12_Franchise,
    back: () -> Unit
) {
    Scaffold(
        topBar = { Exo_12_DetailAppBar(franchise.team.name, back) },
        content = { paddingValues: PaddingValues -> Exo_12_DetailView(franchise, Modifier
            .padding(paddingValues)
            .fillMaxSize()) }
    )
}