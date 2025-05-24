package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model

import fr.system13.kotlin.R

enum class Exo_12_Screens(val title: String) {
    LEAGUE("NFL"),
    AFC("AFC"),
    NFC("NFC"),
    FRANCHISE("Franchise");

    fun getIcon(): Int {
        return when (this) {
            LEAGUE -> R.drawable.exo_11_nfl_nfl
            AFC -> R.drawable.exo_11_nfl_afc
            NFC -> R.drawable.exo_11_nfl_nfc
            FRANCHISE -> R.drawable.exo_11_nfl_nfl
        }
    }

    fun getTeams(list: List<Exo_12_Franchise>): List<Exo_12_Franchise> {
        return when (this) {
            LEAGUE -> list
            AFC ->list.filter { it.conference == "AFC" }.toList()
            NFC -> list.filter { it.conference == "NFC" }.toList()
            FRANCHISE -> list.toList()
        }
    }
}