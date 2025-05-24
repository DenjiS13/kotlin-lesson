package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model

data class Exo_12_Franchise(
    val team: Exo_12_Team,
    val stadium: Exo_12_Stadium,
    val conference: String,
    val titles: List<Int>
)