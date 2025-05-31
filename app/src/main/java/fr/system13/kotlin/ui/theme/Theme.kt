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
    background = DEFAULT_BACKGROUND_DARK,            // Couleur de l'arrière-plan (fond)
    onBackground = DEFAULT_ON_BACKGROUND_DARK,       // Couleur du texte de l'arrière-plan
    surface = DEFAULT_SURFACE_DARK,                  // Couleur de l'arrière-plan des composants (AppBar, Card, etc.)
    onSurface = DEFAULT_ON_SURFACE_DARK,             // Couleur du texte de l'arrière-plan des composants
    primary = DEFAULT_PRIMARY_DARK,                  // Couleur principale de l'application (Boutons principaux, etc.)
    onPrimary = DEFAULT_ON_PRIMARY_DARK,             // Couleur du texte sur la couleur principale (Texte des Boutons principaux, etc.)
    secondary = DEFAULT_SECONDARY_DARK,              // Couleur secondaire de l'application (FAB, etc.)
    onSecondary = DEFAULT_ON_SECONDARY_DARK,         // Couleur du texte sur la couleur secondaire (Couleur de l'icône sur le FAB, etc.)
    error = DEFAULT_ERROR_DARK                       // Couleur d'erreur
)

private val LightColorScheme = lightColorScheme(
    background = DEFAULT_BACKGROUND,            // Couleur de l'arrière-plan (fond)
    onBackground = DEFAULT_ON_BACKGROUND,       // Couleur du texte de l'arrière-plan
    surface = DEFAULT_SURFACE,                  // Couleur de l'arrière-plan des composants (AppBar, etc.) ne marche pas sur les Card
    onSurface = DEFAULT_ON_SURFACE,             // Couleur du texte de l'arrière-plan des composants
    primary = DEFAULT_PRIMARY,                  // Couleur principale de l'application (Boutons principaux, etc.)
    onPrimary = DEFAULT_ON_PRIMARY,             // Couleur du texte sur la couleur principale (Texte des Boutons principaux, etc.)
    secondary = DEFAULT_SECONDARY,              // Couleur secondaire de l'application (FAB, etc.)
    onSecondary = DEFAULT_ON_SECONDARY,         // Couleur du texte sur la couleur secondaire (Couleur de l'icône sur le FAB, etc.)
    error = DEFAULT_ERROR,                       // Couleur d'erreur

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

// region NFL

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