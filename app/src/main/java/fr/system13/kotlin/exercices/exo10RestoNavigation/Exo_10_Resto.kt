package fr.system13.kotlin.exercices.exo10RestoNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo10RestoNavigation.ui.composable.Exo_10_RestoHome
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exo_10_Resto : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                Exo_10_RestoHome()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            Exo_10_RestoHome()
        }
    }
}