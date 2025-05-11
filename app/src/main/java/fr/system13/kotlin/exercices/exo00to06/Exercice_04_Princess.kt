package fr.system13.kotlin.exercices.exo00to06

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.lessons.screeHeight
import fr.system13.kotlin.lessons.screenWidth
import fr.system13.kotlin.ui.theme.KotlinLessonTheme
import fr.system13.kotlin.ui.theme.Shapes
import fr.system13.kotlin.R

class Exercice_04_Princess : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                PrincessScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            PrincessScaffold()
        }
    }

    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Composable
    fun PrincessScaffold() {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Scaffold(
                topBar = { PrincessAppBar() },

                )
            { contentPadding ->
                Column(modifier = Modifier.padding(contentPadding)) {
                    PrincessBody()
                }
            }
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun PrincessAppBar() {
        TopAppBar(
            title = {
                Text(
                    text = stringResource(R.string.exo_04_princess_top_bar),
                    style = MaterialTheme.typography.headlineSmall,
                )
            }
        )
    }

    @Composable
    fun PrincessBody() {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val princesses = listOf("all", "elsa", "merida", "mirabel", "pocahontas", "raiponce")
            var index by remember { mutableIntStateOf(0) }

            val localConfiguration = LocalConfiguration.current
            screeHeight = localConfiguration.screenHeightDp
            screenWidth = localConfiguration.screenWidthDp

            var state by remember { mutableStateOf(Pair("all", R.drawable.exo_04_princess_all)) }

            Image(
                painter = painterResource(id = state.second),
                contentDescription = state.first.capitalize(Locale.current),
                modifier = Modifier
                    .fillMaxWidth()
                    .height((screeHeight / 2).dp)
                    .width((screenWidth * 0.8).dp)
                    .padding(20.dp)
                    .clip(Shapes.small),
                contentScale = ContentScale.Crop
            )

            Text(
                text = stringResource(
                    R.string.exo_04_princess_response,
                    when (index) {
                        0 -> stringResource(R.string.exo_04_princess_response_default)
                        else -> state.first.capitalize(Locale.current)
                    }
                )
            )

            Row {
                TextButton(
                    elevation = ButtonDefaults.buttonElevation(
                        defaultElevation = 8.dp
                    ),
                    onClick = {
                        index = (1..<princesses.size).random()
                        state = getPrincess(index)
                    }) { Text(stringResource(R.string.exo_04_princess_go)) }

                IconButton(
                    onClick = {
                        index = 0
                        state = getPrincess(index)
                    }) {
                    Icon(
                        imageVector = Icons.Default.Refresh,
                        contentDescription = stringResource(R.string.exo_04_princess_reset)
                    )
                }
            }
        }
    }

    private fun getPrincess(index: Int): Pair<String, Int> {
        return when (index) {
            0 -> "all" to R.drawable.exo_04_princess_all
            1 -> "elsa" to R.drawable.exo_04_princess_elsa
            2 -> "merida" to R.drawable.exo_04_princess_merida
            3 -> "mirabel" to R.drawable.exo_04_princess_mirabel
            4 -> "pocahontas" to R.drawable.exo_04_princess_pocahontas
            5 -> "raiponce" to R.drawable.exo_04_princess_raiponce
            else -> "all" to R.drawable.exo_04_princess_all
        }
    }
}