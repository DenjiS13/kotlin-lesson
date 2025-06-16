package fr.system13.kotlin.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import fr.system13.kotlin.R

val mario_super_mario_font = FontFamily(
    Font(R.font.mario_super_mario, FontWeight.Normal)
)

val stranger_font = FontFamily(
    Font(R.font.stranger_corpus_gaii_caps, FontWeight.Normal)
)

val mario_philosopher_font = FontFamily(
    Font(R.font.mario_philosopher_regular, FontWeight.Normal),
    Font(R.font.mario_philosopher_bold, FontWeight.Bold),
    Font(R.font.mario_philosopher_italic, FontWeight.Normal, FontStyle.Italic),
    Font(R.font.mario_philosopher_bold_italic, FontWeight.Bold, FontStyle.Italic)
)

// Set of Material typography styles to start with
val typography = Typography(

    /**

    1. Display (Grands titres)
    Large : Pour les titres principaux d'une page (ex : page d'accueil)
    Medium : Pour les titres de section importants
    Small : Pour les sous-titres ou titres de section secondaires
     */
    displayLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 57.sp,
        lineHeight = 64.sp,
        letterSpacing = (-0.25).sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 45.sp,
        lineHeight = 52.sp,
        letterSpacing = 0.sp
    ),
    displaySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = 0.sp
    ),
    /**

    2. Headline
    Large : Titres de section majeurs
    Medium : Titres de section standards
    Small : Sous-titres ou titres de carte
     */
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 32.sp,
        lineHeight = 40.sp,
        letterSpacing = 0.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp
    ),
    /**

    3. Title
    Large : Titres de cartes ou de sections
    Medium : Sous-titres
    Small : En-têtes de liste ou de section
     */
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.4.sp
    ), titleSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    /**

    4. Label (Boutons)
    Large : Boutons importants
    Medium : Boutons standards
    Small : Petits boutons ou états inactifs
     */
    labelLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        letterSpacing = 0.1.sp
    ),
    labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    /**

    5. Body
    Large : Paragraphes importants
    Medium : Texte courant
    Small : Détails, légendes, texte secondaire
     */
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
)

val MarioTypography = Typography(
    bodyLarge = TextStyle(
        fontFamily = mario_philosopher_font,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        color = MARIO_LIGHT_GRAY
    ),
    headlineLarge = TextStyle(
        fontFamily = mario_super_mario_font,
        fontWeight = FontWeight.Normal,
        fontSize = 28.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = mario_super_mario_font,
        fontWeight = FontWeight.Normal,
        fontSize = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = mario_philosopher_font,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp
    )

)