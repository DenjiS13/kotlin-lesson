package fr.system13.kotlin.exercices.exo13ToDoListMvvm.viewModel

import androidx.lifecycle.ViewModel
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.model.Exo_13_ToDo
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.state.Exo_13_ToDoListState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class Exo_13_ToDoListViewModel : ViewModel() {

    // ui State,
    private val _uiState = MutableStateFlow<Exo_13_ToDoListState>(Exo_13_ToDoListState())

    // StateFlow : le stateFlow est un flux de donnée qui permet de mettre à jour l'UI
    val uiState: StateFlow<Exo_13_ToDoListState> = _uiState.asStateFlow()

    // TextField
    fun onTextFieldValueChange(title: String) {
        _uiState.update { it.copy(textFieldValue = title) }
    }

    // Percentage
    fun onPercentageChange() {
        val allItems = _uiState.value.items
        val completedItems = allItems.filter { it.isDone }.size
        val percentage = ((completedItems.toFloat() / allItems.size) * 100).toInt()
        _uiState.update { it.copy(percentDone = percentage) }
    }

    // Add To Do
    fun addToDo() {
        if (_uiState.value.textFieldValue.isEmpty()) {
            return
        }

        val allItems = _uiState.value.items
        _uiState.update {
            it.copy(
                items = allItems + Exo_13_ToDo(_uiState.value.textFieldValue),
                textFieldValue = ""
            )
        }
        onPercentageChange()
    }

    // Delete To Do
    fun deleteToDo(toDo: Exo_13_ToDo) {
        val allItems = _uiState.value.items
        _uiState.update { it.copy(items = allItems - toDo) }
        onPercentageChange()
    }

    // Update isDone
    fun updateIsDone(toDo: Exo_13_ToDo) {
        val allItems = _uiState.value.items.toMutableList()
        allItems.indexOf(toDo).let { index -> allItems[index] = toDo.copy(isDone = !toDo.isDone) }
        _uiState.update {
            it.copy(items = allItems, textFieldValue = "")
        }
        onPercentageChange()
    }
}