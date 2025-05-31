package fr.system13.kotlin.exercices.exo14BottomNavigation.ui.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import fr.system13.kotlin.exercices.exo14BottomNavigation.data.Exo_14_BottomNavigationData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_14_BottomNavigationBottomBar(navigationController: NavController) {

    fun onClick(route: String) {
        navigationController.navigate(route) {
            navigationController.graph.startDestinationRoute?.let { route ->
                popUpTo(route) { saveState = true }
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    NavigationBar {

        // Récupération de la dernière entrée de la pile (= l'écran actuel)
        val backStackEntry by navigationController.currentBackStackEntryAsState()
        // Récupération de la route actuelle
        val currentRoute = backStackEntry?.destination?.route

        // Loop pour créer les vues
        Exo_14_BottomNavigationData().items.forEach { item ->
            NavigationBarItem(
                label = { Text(text = item.name) },
                selected = currentRoute == item.route,
                icon = { Icon(imageVector = item.icon, contentDescription = item.name) },
                onClick = { onClick(item.route) },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.White,
                    selectedTextColor = item.color,
                    unselectedIconColor = Color.DarkGray,
                    unselectedTextColor = Color.White
                )
            )
        }
    }
}

