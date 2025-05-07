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
val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    titleMedium = TextStyle(
        fontFamily = stranger_font,
        fontWeight = FontWeight.Normal,
        fontSize =20 .sp,
        lineHeight = 24.sp,
        letterSpacing = 0.4.sp
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