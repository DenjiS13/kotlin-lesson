package fr.system13.kotlin.exercices.exo14BottomNavigation.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

// Classe restreinte
sealed class Exo_14_BottomNavigationItemNav(
    val name: String,
    val icon: ImageVector,
    val route: String,
    val color: Color) {

    object First : Exo_14_BottomNavigationItemNav("Accueil", Icons.Default.Home, "home", Color.Blue)
    object Second : Exo_14_BottomNavigationItemNav("À propos", Icons.Default.Person, "about", Color.Red)
    object Third : Exo_14_BottomNavigationItemNav("Portfolio", Icons.Default.Star, "portfolio", Color.Green)
    object Fourth : Exo_14_BottomNavigationItemNav("Contact", Icons.Default.Email, "contact", Color.Magenta)
}