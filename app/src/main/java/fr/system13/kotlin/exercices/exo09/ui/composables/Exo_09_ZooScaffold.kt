package fr.system13.kotlin.exercices.exo09.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import fr.system13.kotlin.exercices.exo08.ui.composables.StrangerLazyList

@Composable
fun ZooScaffold() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = { ZooAppBar() },

            )
        { contentPadding ->
            Column(modifier = Modifier.padding(contentPadding)) {
                Exo_09_ZooLazyGrid()
            }
        }
    }
}