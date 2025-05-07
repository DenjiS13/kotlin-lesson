package fr.system13.kotlin.model

import androidx.annotation.DrawableRes

data class StrangerUser(
    val name: String,
    @DrawableRes val imageName: Int
    )
// @DrawableRes : annotation pour signaler que le paramètre image doit être une ressource d'image