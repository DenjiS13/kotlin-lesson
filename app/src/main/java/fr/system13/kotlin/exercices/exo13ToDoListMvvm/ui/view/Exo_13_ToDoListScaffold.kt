package fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.viewModel.Exo_13_ToDoListViewModel

@Composable
// viewModel() permet d'obtenir une instance de ViewModel dans un composable
fun Exo_13_ToDoListScaffold(viewModel:  Exo_13_ToDoListViewModel = viewModel()) {
    Scaffold(
        topBar = { Exo_13_ToDoListAppBar() },
        content = { paddingValues: PaddingValues -> Exo_13_ToDoListBody(paddingValues,  viewModel) }
    )
}

