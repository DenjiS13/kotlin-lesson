package fr.system13.kotlin.ui.composables

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.data.allPosts

@Composable
fun StrangerLazyList() {
    LazyColumn(
    ) {
        items(allPosts().size) { index ->
            StrangerCard(post = allPosts()[index])
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StrangerLazyListPreview() {
    StrangerLazyList()
}