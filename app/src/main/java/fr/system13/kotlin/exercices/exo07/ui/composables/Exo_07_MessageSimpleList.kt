package fr.system13.kotlin.exercices.exo07.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo07.data.messagesAll
import fr.system13.kotlin.exercices.exo07.model.Message

@Composable
fun MessageSimpleList(messages: List<Message>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(
                enabled = true,
                state = rememberScrollState()
            )
    ) {
        for (message in messages) {
            MessageCard(message = message)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SimpleListPreview() {
    MessageSimpleList(messages = messagesAll)
}

