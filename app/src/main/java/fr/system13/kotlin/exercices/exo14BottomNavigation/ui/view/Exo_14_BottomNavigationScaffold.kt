package fr.system13.kotlin.exercices.exo14BottomNavigation.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Exo_14_BottomNavigationScaffold() {
    val navigationController = rememberNavController()

    Scaffold(
        topBar = { Exo_14_BottomNavigationAppBar("Apprendre bottom bar") },
        content = { paddingValues: PaddingValues -> Exo_14_BottomNavigationHostController(paddingValues = paddingValues, navHostController = navigationController) },
        bottomBar = { Exo_14_BottomNavigationBottomBar(navigationController) }
    )
}

