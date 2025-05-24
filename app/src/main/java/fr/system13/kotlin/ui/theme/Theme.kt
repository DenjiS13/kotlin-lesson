package fr.system13.kotlin.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40

    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

// region Mario

private val MarioDarkColorScheme = darkColorScheme(
    primary = MARIO_RED,
    secondary = MARIO_BLUE,
    background = MARIO_DARK_BLUE,
    surface = MARIO_DARK_RED
)

private val MarioLightColorScheme = lightColorScheme(
    primary = MARIO_RED,
    secondary = MARIO_BLUE,
    background = MARIO_LIGHT_BLUE,
    surface = MARIO_LIGHT_RED
)

// endregion

// region Mario

private val NflDarkColorScheme = darkColorScheme(
    primary = NFL_BLUE,
    secondary = NFL_RED,
    background = NFL_BLUE_LIGHT,
    surface = NFL_RED_LIGHT
)

private val NflLightColorScheme = lightColorScheme(
    primary = NFL_BLUE,
    secondary = NFL_RED,
    background = NFL_BLUE_LIGHT,
    surface = NFL_RED_LIGHT
)

// endregion

@Composable
fun KotlinLessonTheme(
    isNfl: Boolean = false,
    isMario: Boolean = false,
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        isMario && darkTheme -> MarioDarkColorScheme
        isMario && !darkTheme -> MarioLightColorScheme
        isNfl && darkTheme -> NflDarkColorScheme
        isNfl && !darkTheme -> NflLightColorScheme
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = if (isMario) MarioTypography else Typography,
        content = content
    )
}