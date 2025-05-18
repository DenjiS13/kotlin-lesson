package fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import fr.system13.kotlin.exercices.exo10RestoNavigation.data.Exo_10_RestoDataService
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoMenu

@Composable
fun Exo_10_RestoHomeScreen(onClick: (Exo_10_RestoMenu) -> Unit) {
    LazyColumn(
    ) {
        val menus = Exo_10_RestoDataService().allExo10RestoMenus
        items(menus.size) { index -> RestoMenuView(menus[index], { onClick(it) }) }
    }
}