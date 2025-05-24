package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.drawer

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Screens
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.detail.Exo_12_DetailScaffold
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.franchises.ScaffoldList
import kotlinx.coroutines.launch

@Composable
fun Exo_12_Drawer(nflFranchises: List<Exo_12_Franchise>) {

    // Naviguer
    val navController = rememberNavController()
    // État du drawer
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    // coroutineScope : permet de lancer des coroutines et de les annuler
    val coroutineScope = rememberCoroutineScope()
    // ouvrir le drawer :
    val openDrawer = { coroutineScope.launch { drawerState.open() } }
    // Écouter la franchise cliquée
    var franchise by remember { mutableStateOf<Exo_12_Franchise?>(null) }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = drawerState.isOpen,
        drawerContent = {
            Exo_12_DrawerMenu(
                onSelected = {
                    coroutineScope.launch { drawerState.close() }
                    navController.navigate(it.title) {
                        popUpTo(it.title) { inclusive = true } // supprimer la pile de screens
                    }
                }
            )
        })
    {
        NavHost(
            navController = navController,
            startDestination = Exo_12_Screens.LEAGUE.title
        ) {
            for (screen in Exo_12_Screens.entries) {
                composable(screen.title) {
                    if (screen == Exo_12_Screens.FRANCHISE) {
                        if (franchise != null) {
                            Exo_12_DetailScaffold(franchise!!, back = { navController.navigateUp() })
                        }
                    } else {
                        ScaffoldList(
                            conference = screen.title,
                            franchises = screen.getTeams(nflFranchises),
                            openDrawer = { openDrawer() },
                            onSelected = {
                                franchise = it
                                navController.navigate(Exo_12_Screens.FRANCHISE.title)
                            })
                    }
                }
            }
        }
    }
}