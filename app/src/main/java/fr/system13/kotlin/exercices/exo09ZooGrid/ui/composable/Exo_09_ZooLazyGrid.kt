package fr.system13.kotlin.exercices.exo09ZooGrid.ui.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo09ZooGrid.data.ZooDataModel

@Composable
fun Exo_09_ZooLazyGrid() {
    LazyVerticalGrid(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp),
        contentPadding = PaddingValues(8.dp),
        columns = GridCells.Fixed(2),
        content = {
            val animals = ZooDataModel().allAnimals()
            items(animals.size) { index -> ZooAnimalView(animals[index]) }
        })
}

