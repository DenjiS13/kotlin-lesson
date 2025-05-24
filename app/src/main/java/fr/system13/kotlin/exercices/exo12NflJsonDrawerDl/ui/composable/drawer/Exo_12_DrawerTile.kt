package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.ui.composable.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Screens

@Composable
fun Exo_12_DrawerTile(screen: Exo_12_Screens, onSelected: (Exo_12_Screens) -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = screen.getIcon()),
            contentDescription = screen.title,
            modifier = Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.weight(1f))
        TextButton(onClick = { onSelected(screen) }) {
            Text(
                text = screen.title,
                color = MaterialTheme.colorScheme.onSurface,
                style = MaterialTheme.typography.bodyLarge
            )
        }
    }
}