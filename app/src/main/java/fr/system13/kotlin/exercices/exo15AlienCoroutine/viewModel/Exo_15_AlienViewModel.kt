package fr.system13.kotlin.exercices.exo15AlienCoroutine.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo15AlienCoroutine.model.Exo_15_Alien
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.Int

class Exo_15_AlienViewModel : ViewModel() {

    // STATE
    private val _uiState = MutableStateFlow(Exo_15_Alien())
    var uiState: StateFlow<Exo_15_Alien> = _uiState.asStateFlow()

    // Setup Coroutine
    var alienCoroutine: Job = Job()

    // onStart
    internal fun onStart() {

        if (uiState.value.isActive)
            return

        // Active l'alien
        setAlienIsActive(true)

        // Lance la coroutine
        viewModelScope.launch {
            alienCoroutine = launch {
                attack()
            }
        }
    }

    // onCancel
    internal fun onCancel() {
        setAlienIsActive(false)
        alienCoroutine.cancel()
    }

    // Update isActive
    fun setAlienIsActive(isActive: Boolean) {
        _uiState.update { it.copy(isActive = isActive) }
    }

    // onReset
    internal fun onReset() {

        // on remet les valeurs par défaut
        _uiState.update {
            it.copy(
                image = R.drawable.exo_15_alien0,
                position = 1.0F,
                distance = 600
            )
        }

    }

    // Attaque
    suspend fun attack() {

        while (_uiState.value.distance > 0) {

            delay(50)

            _uiState.update {
                it.copy(
                    image = nextAlienImage(),
                    position = nextAlienPosition(),
                    distance = nextDistance()
                )
            }

        }
    }

    // prochaine position
    fun nextAlienPosition(): Float {

        val current = _uiState.value.distance.toFloat()
        val total = _uiState.value.timeToAttack.toFloat()
        val position = current / total
        if (position == 0F)
            return 1.01F

        return position
    }

    // prochaine image
    fun nextAlienImage(): Int {

        val nextImage = when (_uiState.value.image) {
            R.drawable.exo_15_alien0 -> R.drawable.exo_15_alien1
            R.drawable.exo_15_alien1 -> R.drawable.exo_15_alien2
            R.drawable.exo_15_alien2 -> R.drawable.exo_15_alien3
            R.drawable.exo_15_alien3 -> R.drawable.exo_15_alien4
            R.drawable.exo_15_alien4 -> R.drawable.exo_15_alien5
            R.drawable.exo_15_alien5 -> R.drawable.exo_15_alien6
            R.drawable.exo_15_alien6 -> R.drawable.exo_15_alien7
            R.drawable.exo_15_alien7 -> R.drawable.exo_15_alien8
            else -> R.drawable.exo_15_alien0
        }

        return nextImage
    }

    // prochaine distance
    fun nextDistance(): Int {
        return _uiState.value.distance - 5
    }

}