package fr.system13.kotlin.exercices.exo14BottomNavigation.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view.Exo_13_ToDoListAppBar
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view.Exo_13_ToDoListBody
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.viewModel.Exo_13_ToDoListViewModel

@Composable
fun Exo_14_BottomNavigationScaffold() {
    val navigationController = rememberNavController()

    Scaffold(
        topBar = { Exo_14_BottomNavigationAppBar("Apprendre bottom bar") },
        content = { paddingValues: PaddingValues -> Exo_14_BottomNavigationHostController(paddingValues = paddingValues, navHostController = navigationController) },
        bottomBar = { Exo_14_BottomNavigationBottomBar(navigationController) }
    )
}

