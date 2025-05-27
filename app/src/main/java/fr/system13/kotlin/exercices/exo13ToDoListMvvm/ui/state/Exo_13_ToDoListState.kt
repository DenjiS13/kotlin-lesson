package fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.state

import fr.system13.kotlin.exercices.exo13ToDoListMvvm.model.Exo_13_ToDo

// State de l'application, représente le contenu de l'UI
// Toutes les variables doivent être initialisées car elles seront observées
data class Exo_13_ToDoListState(
    val textFieldValue: String = "",
    val percentDone: Int = 0,
    val items: List<Exo_13_ToDo> = emptyList()
)