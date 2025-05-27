package fr.system13.kotlin.exercices.exo14BottomNavigation.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import fr.system13.kotlin.exercices.exo14BottomNavigation.data.Exo_14_BottomNavigationData
import fr.system13.kotlin.exercices.exo14BottomNavigation.model.Exo_14_BottomNavigationItemNav

@Composable
fun Exo_14_BottomNavigationHostController(paddingValues: PaddingValues, navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = Exo_14_BottomNavigationItemNav.First.route
    )
    {
        Exo_14_BottomNavigationData().items.forEach { item ->
            composable(item.route)
            {
                Exo_14_BottomNavigationSelectedScreen(item = item, paddingValues = paddingValues)
            }
        }
    }
}
