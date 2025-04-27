package fr.system13.kotlin_1_myfirstapp.lessons

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import fr.system13.kotlin_1_myfirstapp.ui.theme.Kotlin_1_MyFirstAppTheme

class G_JetPackCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_1_MyFirstAppTheme {
            }
        }
    }

    // region Récupération de la taille de l'appareil

    var screeHeight = 0
    var screenWidth = 0

    @Composable
    fun GetScreenSize() {
        val localConfiguration = LocalConfiguration.current;
        screeHeight = localConfiguration.screenHeightDp
        screenWidth = localConfiguration.screenWidthDp
    }

    // endregion

    // region Colors

    val colorConstant = Color.Red
    val colorHex = Color(0xFF00FF00) // forme 0xAARRGGBB
    val colorInt = Color(alpha = 255, red = 255, green = 255, blue = 0)

    // endregion
}