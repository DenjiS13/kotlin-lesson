package fr.system13.kotlin.exercices.exo14BottomNavigation.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import fr.system13.kotlin.exercices.exo14BottomNavigation.model.Exo_14_BottomNavigationItemNav

@Composable
fun Exo_14_BottomNavigationSelectedScreen(item: Exo_14_BottomNavigationItemNav, paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    )
    {
        Text(text = item.name, fontSize = 40.sp, color = item.color)
    }
}