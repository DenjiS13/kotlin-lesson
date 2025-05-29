package fr.system13.kotlin.exercices.exo15AlienCoroutine.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import fr.system13.kotlin.exercices.exo15AlienCoroutine.viewModel.Exo_15_AlienViewModel

@SuppressLint("ConfigurationScreenWidthHeight", "UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Exo_15_AlienCoroutineView(viewModel: Exo_15_AlienViewModel = viewModel()) {

    // STATE
    val alienState = viewModel.uiState.collectAsState()

    val config = LocalConfiguration.current
    val screenWidth = config.screenWidthDp
    val third = screenWidth / 3
    val thirdInDp = third.dp

    val buttonColors: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.background,
        disabledContainerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.5F),
        disabledContentColor = MaterialTheme.colorScheme.background
    )

    Scaffold(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier.fillMaxSize().padding(12.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Alien attack !",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Black,
            )

            Row(modifier = Modifier.height(thirdInDp)) {
                Spacer(modifier = Modifier.width(((screenWidth - third) * alienState.value.position).dp))
                Image(painter = painterResource(id = alienState.value.image), contentDescription = "Alien")
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                Button(onClick = { viewModel.onStart() }, enabled = !alienState.value.isActive, colors = buttonColors) { Text("Start") }
                Button(onClick = { viewModel.onCancel() }, enabled = alienState.value.isActive, colors = buttonColors) { Text("Cancel") }
                Button(onClick = { viewModel.onReset() }, enabled = alienState.value.position < 1.0F, colors = buttonColors) { Text("Reset") }
            }
        }
    }
}