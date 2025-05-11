package fr.system13.kotlin.exercices.exo07

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo07.ui.composables.MessagesScaffold
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exercice_07_Message : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                MessagesScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            MessagesScaffold()
        }
    }
}