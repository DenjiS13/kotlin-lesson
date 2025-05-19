package fr.system13.kotlin.exercices.exo11PhotoPicker

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin.ui.theme.KotlinLessonTheme
import coil3.compose.rememberAsyncImagePainter
import coil3.request.ImageRequest
import coil3.size.Size

class Exo_11_PhotoPicker : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                PhotoPicker()
            }
        }
    }

    @Composable
    fun PhotoPicker() {

        val config = LocalConfiguration.current
        val photoHeight = (config.screenHeightDp * 0.75).toInt()
        val photoWidth = (config.screenWidthDp * 0.9).toInt()

        // Image de type URI
        var image by remember { mutableStateOf<Uri?>(null) }

        // Contrat : Récupérer un contenu
        val contract = ActivityResultContracts.GetContent()

        // Type de fichiers à récupérer
        val typeFilter = "image/*"

        // Setup du picker
        val imagePicker = rememberLauncherForActivityResult(
            contract = contract,
            onResult = { uri -> image = uri } // ou image = it
        )

        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Surface(
                    modifier = Modifier
                        .height(photoHeight.dp)
                        .width(photoWidth.dp)
                ) {
                    if (image == null) {
                        Text(text = "Aucune image sélectionnée")
                    } else {                    // Affichage de l'image récupérée du picker
                        Image(
                            painter = rememberAsyncImagePainter(
                                model = ImageRequest
                                    .Builder(LocalContext.current)
                                    .data(image)
                                    .size(Size.ORIGINAL)
                                    .build()
                            ),
                            contentDescription = image?.path ?: "Aucune image",
                            modifier = Modifier
                                .fillMaxSize()
                                .clip(RoundedCornerShape(percent = 8))
                                .shadow(elevation = 4.dp, shape = RoundedCornerShape(percent = 4))
                        )
                    }
                }

                Button(onClick = {
                    // Récupération de la photo
                    imagePicker.launch(typeFilter)

                }) {
                    Text(text = "Choisir une photo")
                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        KotlinLessonTheme {
            PhotoPicker()
        }
    }
}