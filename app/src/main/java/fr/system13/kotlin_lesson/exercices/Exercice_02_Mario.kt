package fr.system13.kotlin_lesson.exercices

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin_lesson.R
import fr.system13.kotlin_lesson.ui.theme.KotlinLessonTheme
import fr.system13.kotlin_lesson.ui.theme.Shapes

class Exercice_02_Mario : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                ScaffoldComposable02()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview02() {
    KotlinLessonTheme {
        ScaffoldComposable02()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldComposable02() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            topBar = { AppBar02() },
            content = { Body02(name = "Mario") }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar02() {
    TopAppBar(
        title = {
            Text(
                text = "Mario",
                style = MaterialTheme.typography.headlineSmall,
            )
        },
        navigationIcon = {
            Image(
                painter = painterResource(id = R.drawable.mario_appstore),
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clip(Shapes.medium)
            )
        }
    )
}


@SuppressLint("ConfigurationScreenWidthHeight")
@Composable
fun Body02 (name: String) {
    val localConfiguration = LocalConfiguration.current
    val height = localConfiguration.screenHeightDp
    val width = localConfiguration.screenWidthDp

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "It's a me!: $name", style = MaterialTheme.typography.headlineMedium)
        Surface(
            shadowElevation = 12.dp,
            modifier = Modifier.width((width * 0.66).dp),
            shape = Shapes.small
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Image(
                    painter = painterResource(id = R.drawable.mario_profile),
                    contentDescription = "Image Mario",
                    modifier = Modifier
                        .height((height / 5).dp)
                        .width((height / 5).dp)
                        .padding(25.dp)
                        .clip(Shapes.large)
                )
                Text(text = name, style = MaterialTheme.typography.headlineLarge, color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(top = 8.dp, bottom = 8.dp))
                HorizontalDivider()
                Text(
                    "Je suis un plombier d'une quarantaine d'années vivant à New York City.\nMa grande passion? \n Passer quelques temps à Champignon city pour sauver des princesses et jouer avec des carapaces de tortues",
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp, start = 16.dp, end = 16.dp),
                    textAlign = TextAlign.Left
                )
            }
        }
        Spacer(modifier = Modifier)
    }
}