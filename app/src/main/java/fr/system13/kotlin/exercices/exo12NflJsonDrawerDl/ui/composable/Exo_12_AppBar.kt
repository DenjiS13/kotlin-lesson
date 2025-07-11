package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Exo_12_AppBar(title: String, openDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = title) },
        navigationIcon = { IconButton(onClick = openDrawer) { Icon(imageVector = Icons.Default.Menu, contentDescription = null) } })
}
