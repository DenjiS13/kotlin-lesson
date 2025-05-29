package fr.system13.kotlin.exercices.exo15AlienCoroutine.model

import androidx.annotation.DrawableRes
import fr.system13.kotlin.R

data class Exo_15_Alien(
    @DrawableRes val image: Int = R.drawable.exo_15_alien0,
    val timeToAttack: Int = 600,
    val distance: Int = 600,
    val position: Float = 1.0f,
    val isActive: Boolean = false
)