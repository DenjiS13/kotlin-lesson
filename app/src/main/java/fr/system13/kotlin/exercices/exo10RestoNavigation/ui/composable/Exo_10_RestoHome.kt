package fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import fr.system13.kotlin.exercices.exo10RestoNavigation.data.Exo_10_RestoDataService
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoMenu
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoScreen

@Composable
fun Exo_10_RestoHome() {

    // Création du contrôleur de navigation
    val navigationController = rememberNavController()

    // Menu où nous sommes
    var currentMenu: Exo_10_RestoMenu by remember { mutableStateOf(Exo_10_RestoDataService().americain) }

    // Récupération de la dernière entrée de la pile (= l'écran actuel)
    val backStackEntry by navigationController.currentBackStackEntryAsState()

    // Récupération de la route actuelle sous forme de Exo_10_RestoScreens
    val currentScreen = Exo_10_RestoScreen.valueOf(backStackEntry?.destination?.route ?: Exo_10_RestoScreen.Home.name)

    Scaffold(
        topBar = {
            RestoAppBar(
                screen = currentScreen,
                canGoBack = navigationController.previousBackStackEntry != null,
                onBackPressed = { navigationController.navigateUp() })
        },
    )
    { contentPadding ->
        NavHost(
            modifier = Modifier.padding(contentPadding),
            startDestination = Exo_10_RestoScreen.Home.name,
            navController = navigationController
        ) {
            composable(Exo_10_RestoScreen.Home.name) {
                Exo_10_RestoHomeScreen(onClick = { newMenu ->
                    currentMenu = newMenu
                    navigationController.navigate(Exo_10_RestoScreen.Starter.name)
                })
            }

            composable(Exo_10_RestoScreen.Starter.name) {
                RestoItemView(
                    currentMenu.starter, "Vers les plats",
                    onClick = {
                        navigationController.navigate(Exo_10_RestoScreen.MainCourse.name)
                    }
                )
            }

            composable(Exo_10_RestoScreen.MainCourse.name) {
                RestoItemView(
                    currentMenu.mainCourse, "Vers les desserts",
                    onClick = {
                        navigationController.navigate(Exo_10_RestoScreen.Dessert.name)
                    })
            }

            composable(Exo_10_RestoScreen.Dessert.name) {
                RestoItemView(
                    currentMenu.dessert, "Vers les menus",
                    onClick = {
                        // On revient à l'écran d'accueil, inclusive = false pour ne pas supprimer l'écran d'accueil
                        navigationController.popBackStack(Exo_10_RestoScreen.Home.name, inclusive = false)
                    })
            }
        }
    }
}