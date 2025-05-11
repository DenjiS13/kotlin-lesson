package fr.system13.kotlin.exercices.exo09

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo09.ui.composables.ZooScaffold
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exo_09_Zoo : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                ZooScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            ZooScaffold()
        }
    }
}