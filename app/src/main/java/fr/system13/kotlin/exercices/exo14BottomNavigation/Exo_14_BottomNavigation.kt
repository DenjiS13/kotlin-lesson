package fr.system13.kotlin.exercices.exo14BottomNavigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import fr.system13.kotlin.exercices.exo14BottomNavigation.ui.view.Exo_14_BottomNavigationScaffold
import fr.system13.kotlin.ui.theme.KotlinLessonTheme

class Exo_14_BottomNavigation : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme(isNfl = true) {
                Exo_14_BottomNavigationScaffold()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            Exo_14_BottomNavigationScaffold()
        }
    }
}