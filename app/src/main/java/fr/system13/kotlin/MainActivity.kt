package fr.system13.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo16Weather.ui.composable.Exo_16_WeatherScaffold
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme() {
                Exo_16_WeatherScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            Exo_16_WeatherScaffold()
        }
    }
}