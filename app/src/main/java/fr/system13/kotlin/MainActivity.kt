package fr.system13.kotlin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.ui.composables.StrangerScaffold
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                StrangerScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            StrangerScaffold()
        }
    }
}