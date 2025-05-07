package fr.system13.kotlin.model

import androidx.annotation.DrawableRes

data class StrangerPost(
    val user: StrangerUser,
    @DrawableRes val imageId: Int,
    val description: String,
    val likes: Int,
    val comments: Int,
    val didLike: Boolean)
// @DrawableRes : annotation pour signaler que le paramètre image doit être une ressource d'image