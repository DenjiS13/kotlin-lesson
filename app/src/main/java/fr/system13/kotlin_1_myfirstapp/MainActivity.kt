package fr.system13.kotlin_1_myfirstapp

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import fr.system13.kotlin_1_myfirstapp.ui.theme.Kotlin_1_MyFirstAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Kotlin_1_MyFirstAppTheme {
                GetSurface()
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        Kotlin_1_MyFirstAppTheme {
            GetSurface()
        }
    }

    @Composable
    fun GetSurface() {
        Surface() {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(0.dp),
                modifier = Modifier.fillMaxHeight()
            )
            {
                GetBanner()
                GetBox()
            }
        }
    }

    @Composable
    fun GetBox() {
        Box(
            modifier = Modifier.fillMaxWidth(),
            propagateMinConstraints = false,
            contentAlignment = Alignment.TopStart
        )
        {
            GetBackground()
            GetColumn()
        }
    }

    @Composable
    fun GetColumn() {
        Column(Modifier.padding(12.dp), ) {

            GetRow()
            // Ligne de séparation
            HorizontalDivider(color = Color.LightGray, thickness = 1.dp,
                modifier = Modifier.fillMaxWidth().padding(12.dp))
            GetText(R.string.content, 16, TextAlign.Center)

            // Espacement
            Spacer(modifier = Modifier.height(20.dp))
        }
    }

    @Composable
    fun GetRow() {
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        )
        {
            GetProfilImage()
            // Ligne d'icônes
            GetText(R.string.name, 24, TextAlign.Right)
        }
    }

    @Composable
    fun GetBanner() {
        return GetImage(
            R.drawable.banner, R.string.image_description,
            Modifier
                .fillMaxWidth()
                .height(200.dp)
        )
    }

    @Composable
    fun GetProfilImage() {
        return GetImage(
            R.drawable.profile, R.string.image_description,
            Modifier
                .padding(3.dp)
                .border(2.dp, Color.White, CircleShape)
                .size(100.dp)
                .clip(CircleShape)
        )
    }

    @Composable
    fun GetBackground() {
        return GetImage(
            R.drawable.background, R.string.image_description,
            Modifier.fillMaxHeight()
        )
    }

    @Composable
    fun GetImage(resource: Int, description: Int, modifier: Modifier) {
        return Image(
            painter = painterResource(resource),
            contentDescription = stringResource(description),
            modifier = modifier,
            contentScale = ContentScale.Crop
        )
    }

    @Composable
    fun GetIcon(icon: ImageVector) {
        return Image(imageVector = icon, contentDescription = null)
    }

    @Composable
    fun GetText(resource: Int, fontSize: Int, textAlign: TextAlign) {
        return Text(
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