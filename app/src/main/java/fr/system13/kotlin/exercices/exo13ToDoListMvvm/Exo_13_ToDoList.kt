package fr.system13.kotlin.exercices.exo13ToDoListMvvm

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo13ToDoListMvvm.ui.view.Exo_13_ToDoListScaffold
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exo_13_ToDoList : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme(isNfl = true) {
                Exo_13_ToDoListScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            Exo_13_ToDoListScaffold()
        }
    }
}