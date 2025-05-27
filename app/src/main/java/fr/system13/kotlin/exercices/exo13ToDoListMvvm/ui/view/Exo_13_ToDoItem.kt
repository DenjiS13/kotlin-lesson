package fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.model.Exo_13_ToDo

@Composable
fun Exo_13_ToDoItem(
    todo: Exo_13_ToDo,
    onDoneChanged: () -> Unit,
    onDeleteClicked: () -> Unit
) {
    Row(
        modifier =
            Modifier
                .fillMaxWidth()
                .height(50.dp)
    ) {

        Text(text = todo.title)
        Spacer(modifier = Modifier.weight(1f))
        Switch(
            checked = todo.isDone,
            onCheckedChange = { onDoneChanged() }
        )
        IconButton(onClick = { onDeleteClicked() }) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete",
                tint = MaterialTheme.colorScheme.error
            )
        }
    }
}