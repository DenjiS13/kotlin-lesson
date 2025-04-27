package fr.system13.kotlin_lesson.exercices

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.system13.kotlin_lesson.ui.theme.KotlinLessonTheme
import fr.system13.kotlin_lesson.ui.theme.Shapes

class Exercice_03_Button : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KotlinLessonTheme {
                ScaffoldComposable03()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview03() {
    KotlinLessonTheme {
        ScaffoldComposable03()
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ScaffoldComposable03() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Scaffold(
            content = { Body03() }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Body03() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        var fruits = listOf("Banane", "Pomme", "Kiwi", "Fraise", "Ananas", "Poire", "Raisin")
        var index by remember { mutableIntStateOf(0) }
        var count by remember { mutableIntStateOf(0) }
        var color by remember { mutableStateOf(Color.White) }

        val click: (Boolean) -> Unit = {
            if (it) {
                if (index < fruits.size - 1) index++
            } else {
                if (index > 0) index--
            }
        }

        Text(text = "J'aime le fruit : ${fruits[index]}", color = color)
        Row {
            IconButton(enabled = index < fruits.size - 1, onClick = { click(true) }) { Icon(imageVector = Icons.Default.KeyboardArrowUp, contentDescription = "Ajouter un click") }
            IconButton(enabled = index > 0, onClick = { click(false) }) { Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = "Supprimer un click") }
        }

        TextButton(
            shape = Shapes.small,
            elevation = ButtonDefaults.buttonElevation(
                defaultElevation = 8.dp
            ),
            onClick = {
                color = if (color == Color.White) {
                    Color.Yellow
                } else
                    Color.White
            }) { Text("Changer la couleur", color = color) }


        Button(
            shape = Shapes.small,
            border = BorderStroke(width = 4.dp, color = Color.DarkGray),
            onClick = { count++ }) {
            Row {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Ajouter un click")
                Text("Nb de click : $count")
            }
        }
        Row {
            FloatingActionButton(onClick = { count = 0 }) { Icon(imageVector = Icons.Default.Refresh, contentDescription = "Remettre à zéro") }
            FloatingActionButton(onClick = { index = fruits.indices.random() }) { Icon(imageVector = Icons.Default.Favorite, contentDescription = "Remettre à zéro") }
        }
    }
}