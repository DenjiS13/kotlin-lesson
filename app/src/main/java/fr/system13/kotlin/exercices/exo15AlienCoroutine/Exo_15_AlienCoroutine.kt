package fr.system13.kotlin.exercices.exo15AlienCoroutine

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo15AlienCoroutine.ui.view.Exo_15_AlienCoroutineView
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exo_15_AlienCoroutine : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme(isNfl = true) {
                Exo_15_AlienCoroutineView()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            Exo_15_AlienCoroutineView()
        }
    }
}