package fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestoAppBar(
    screen: Exo_10_RestoScreen,
    canGoBack: Boolean,
    onBackPressed: () -> Unit,
) {
    TopAppBar(
        navigationIcon = {
            if (canGoBack) {
                IconButton(onClick = onBackPressed) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Default.ArrowBack,
                        contentDescription = "Retour",
                        modifier = Modifier.padding(8.dp),
                    )
                }
            } else {
                Image(
                    painter = painterResource(R.drawable.exo_10_resto_logo),
                    contentDescription = "Mon resto",
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(percent = 40))
                )
            }
        },
        title = {
            Text(text = if (canGoBack) screen.title else "Mon resto", style = MaterialTheme.typography.headlineLarge)
        },
        colors = TopAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor = MaterialTheme.colorScheme.onPrimary,
            scrolledContainerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Preview(showBackground = true)
@Composable
fun RestoAppBarPreview() {
    RestoAppBar(Exo_10_RestoScreen.Home, false, {})
}