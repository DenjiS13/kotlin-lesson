package fr.system13.kotlin.exercices.exo16Weather.ui.state

import fr.system13.kotlin.exercices.exo16Weather.model.Exo_16_WeatherAPIResult

// Cette interface suit le pattern d'état (State Pattern)
// couramment utilisé dans les applications Android avec Jetpack Compose
// pour gérer les différents états de l'UI de manière déclarative.
interface Ex0_16_WeatherUIState {

    object IDLE : Ex0_16_WeatherUIState             // Singleton
    object LOADING : Ex0_16_WeatherUIState          // Singleton
    data class ERROR(val message: String) : Ex0_16_WeatherUIState   // Data class avec le message d'erreur
    data class SUCCESS(val forecast: Exo_16_WeatherAPIResult) : Ex0_16_WeatherUIState // Data class avec les données de retour

}