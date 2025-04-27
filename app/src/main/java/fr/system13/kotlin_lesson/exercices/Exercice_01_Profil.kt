package fr.system13.kotlin_lesson.exercices

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.system13.kotlin_lesson.R
import fr.system13.kotlin_lesson.ui.theme.KotlinLessonTheme

class Exercice_01_Profil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Exercice_00().callAll()
        enableEdgeToEdge()
        setContent {
            KotlinLessonTheme {
                GetSurface01()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview01() {
        KotlinLessonTheme {
            GetSurface01()
        }
    }

    @Composable
    fun GetSurface01() {
        Surface {                                           // SURFACE
            Column(                                         // COLUMN
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier.fillMaxHeight()
            )
            {
                GetBanner01()
                GetBox01()
            }
        }
    }

    @Composable
    fun GetBox01() {
        Box(                                                    // BOX
            modifier = Modifier.fillMaxWidth(),
            propagateMinConstraints = false,
            contentAlignment = Alignment.TopStart
        )
        {
            GetBackground01()
            GetColumn01()
        }
    }

    @Composable
    fun GetColumn01() {
        Column(Modifier.padding(12.dp)) {                   // COLUMN

            GetRow01()
            // Ligne de séparation
            HorizontalDivider(                              // HORIZONTAL DIVIDER
                color = Color.LightGray, thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            GetText01(R.string.content, 16, TextAlign.Center)

            // Espacement
            Spacer(modifier = Modifier.height(20.dp))       // SPACER
        }
    }

    @Composable
    fun GetRow01() {
        Row(                                                // ROW
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        )
        {
            GetProfilImage01()
            // Ligne d'icônes
            GetText01(R.string.name, 24, TextAlign.Right)
        }
    }

    @Composable
    fun GetBanner01() {
        return GetImage01(
            R.drawable.basic_banner, R.string.image_description,
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

    @Composable
    fun GetProfilImage01() {
        return GetImage01(
            R.drawable.basic_profile, R.string.image_description,
            Modifier
                .padding(3.dp)
                .border(2.dp, Color.White, CircleShape)
                .size(100.dp)
                .clip(CircleShape)
        )
    }

    @Composable
    fun GetBackground01() {
        return GetImage01(
            R.drawable.basic_background, R.string.image_description,
            Modifier.fillMaxHeight()
        )
    }

    @Composable
    fun GetImage01(resource: Int, description: Int, modifier: Modifier) {
        return Image(                                     // IMAGE
            painter = painterResource(resource),
            contentDescription = stringResource(description),
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun GetText01(resource: Int, fontSize: Int, textAlign: TextAlign) {
        return Text(                                        // TEXT
            text = stringResource(resource),
            color = Color.LightGray,
            textAlign = textAlign,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal,
            fontSize = fontSize.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp)
        )
    }
}