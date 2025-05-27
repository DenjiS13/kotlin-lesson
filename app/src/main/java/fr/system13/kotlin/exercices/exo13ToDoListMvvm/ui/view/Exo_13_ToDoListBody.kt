package fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.viewModel.Exo_13_ToDoListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_13_ToDoListBody(paddingValues: PaddingValues, viewModel: Exo_13_ToDoListViewModel) {

    // collectAsState permet de relier le viewModel au composant
    val state = viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(8.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Surface(modifier = Modifier.fillMaxWidth()) {
            OutlinedTextField(
                value = state.value.textFieldValue,
                onValueChange = { viewModel.onTextFieldValueChange(it) },
                label = { Text(text = "New To Do") },
                trailingIcon = {
                    IconButton(onClick = { viewModel.addToDo() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.Send,
                            contentDescription = null
                        )
                    }
                }
            )
        }
        HorizontalDivider()
        Text(text = "Pourcentage effectué : ${state.value.percentDone} %")
        HorizontalDivider()

        if (state.value.items.isEmpty()) {
            Text(text = "Rien pour le moment")
        } else {
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.value.items.size) { index ->
                    Exo_13_ToDoItem(
                        todo = state.value.items[index],
                        onDoneChanged = { viewModel.updateIsDone(state.value.items[index]) },
                        onDeleteClicked = { viewModel.deleteToDo(state.value.items[index]) })
                }
            }
        }
    }
}

//itemsIndexed( // itemsIndexed permet de fournir une clef unique pour chaque item
//items = state.value.items,
//key = { _, item -> item.hashCode() }
//) { index, item ->
//    Exo_13_ToDoItem(
//        todo = item,
//        onDoneChanged = { viewModel.updateIsDone(item) },
//        onDeleteClicked = { viewModel.deleteToDo(item) }
//    )
//}