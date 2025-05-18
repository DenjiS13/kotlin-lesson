package fr.system13.kotlin.exercices.exo07MessageList.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Message(
    @StringRes val name: Int,
    @DrawableRes val image: Int,
    val msg : String
    )
// @StringRes : annotation pour signaler que le paramètre name doit être une ressource de chaîne
// @DrawableRes : annotation pour signaler que le paramètre image doit être une ressource d'image