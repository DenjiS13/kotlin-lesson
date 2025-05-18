package fr.system13.kotlin.exercices.exo07MessageList.ui.composable

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo07MessageList.data.messagesAll

@Composable
fun MessageLazyList() {
    LazyColumn(
    ) {
        items(messagesAll.size) { index ->
            MessageCard(message = messagesAll[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LazyListPreview() {
    MessageLazyList()
}

