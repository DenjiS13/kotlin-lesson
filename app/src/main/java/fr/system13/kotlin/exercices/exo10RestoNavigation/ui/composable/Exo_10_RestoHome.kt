package fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Exo_10_RestoHome() {
    Scaffold(
        topBar = { RestoAppBar() },
        )
    { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
           Exo_10_RestoHomeScreen(contentPadding)
        }
    }
}