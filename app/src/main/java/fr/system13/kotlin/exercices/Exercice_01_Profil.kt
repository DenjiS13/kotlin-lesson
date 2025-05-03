package fr.system13.kotlin.exercices

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
import fr.system13.kotlin.ui.theme.KotlinLessonTheme
import fr.system13.kotlin.R

class Exercice_01_Profil : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Exercice_00().callAll()
        enableEdgeToEdge()
        setContent {
            KotlinLessonTheme {
                ProfilSurface()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun Preview() {
        KotlinLessonTheme {
            ProfilSurface()
        }
    }

    @Composable
    fun ProfilSurface() {
        Surface {                                           // SURFACE
            Column(                                         // COLUMN
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier.fillMaxHeight()
            )
            {
                ProfilBanner()
                ProfilBox()
            }
        }
    }

    @Composable
    fun ProfilBox() {
        Box(                                                    // BOX
            modifier = Modifier.fillMaxWidth(),
            propagateMinConstraints = false,
            contentAlignment = Alignment.TopStart
        )
        {
            ProfilBackground()
            ProfilColumn()
        }
    }

    @Composable
    fun ProfilColumn() {
        Column(Modifier.padding(12.dp)) {                   // COLUMN

            ProfilRow()
            // Ligne de séparation
            HorizontalDivider(                              // HORIZONTAL DIVIDER
                color = Color.LightGray, thickness = 1.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp)
            )
            ProfilText(R.string.exo_01_basic_content, 16, TextAlign.Center)

            // Espacement
            Spacer(modifier = Modifier.height(20.dp))       // SPACER
        }
    }

    @Composable
    fun ProfilRow() {
        Row(                                                // ROW
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        )
        {
            ProfilImage()
            // Ligne d'icônes
            ProfilText(R.string.exo_01_basic_name, 24, TextAlign.Right)
        }
    }

    @Composable
    fun ProfilBanner() {
        return MyImage(
            R.drawable.exo_01_basic_banner, R.string.exo_01_basic_banner,
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

    @Composable
    fun ProfilImage() {
        return MyImage(
            R.drawable.exo_01_basic_profile, R.string.exo_01_basic_profil,
            Modifier
                .padding(3.dp)
                .border(2.dp, Color.White, CircleShape)
                .size(100.dp)
                .clip(CircleShape)
        )
    }

    @Composable
    fun ProfilBackground() {
        return MyImage(
            R.drawable.exo_01_basic_background, R.string.exo_01_basic_background,
            Modifier.fillMaxHeight()
        )
    }

    @Composable
    fun MyImage(resource: Int, description: Int, modifier: Modifier) {
        return Image(                                     // IMAGE
            painter = painterResource(resource),
            contentDescription = stringResource(description),
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun ProfilText(resource: Int, fontSize: Int, textAlign: TextAlign) {
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