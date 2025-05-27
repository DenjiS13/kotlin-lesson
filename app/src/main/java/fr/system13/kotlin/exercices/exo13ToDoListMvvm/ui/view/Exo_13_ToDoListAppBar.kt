package fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_13_ToDoListAppBar() {
    TopAppBar(title = { Text(text = "To Do List") })
}

