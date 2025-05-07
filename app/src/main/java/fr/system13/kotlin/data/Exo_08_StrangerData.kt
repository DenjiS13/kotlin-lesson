package fr.system13.kotlin.data

import fr.system13.kotlin.R
import fr.system13.kotlin.model.StrangerPost
import fr.system13.kotlin.model.StrangerUser

val lucas = StrangerUser(name = "Lucas", imageName = R.drawable.exo_08_stranger_user_lucas)
val eleven = StrangerUser(name = "Eleven", imageName = R.drawable.exo_08_stranger_user_eleven)
val eddie = StrangerUser(name = "Eddie", imageName = R.drawable.exo_08_stranger_user_eddie)


val bats = StrangerPost(user = eddie, imageId = R.drawable.exo_08_stranger_post_bats, description = "Dis moi Dustin? Tu es toujours fan de Batman?", likes = 90, comments = 0, didLike = false)
val crush = StrangerPost(user = lucas, imageId = R.drawable.exo_08_stranger_post_crush, description = "Woah ! J'ose pas trop l'aborder", likes = 88, comments = 4, didLike = true)
val father = StrangerPost(user = eleven, imageId = R.drawable.exo_08_stranger_post_father, description = "Bonne fête des pères à tous les PAPA", likes = 13, comments = 12, didLike = true)
val fireworks = StrangerPost(user = eleven, imageId = R.drawable.exo_08_stranger_post_fireworks, description = "Quand le vois Mike", likes = 64, comments = 34, didLike = false)
val grass = StrangerPost(
    user = lucas,
    imageId = R.drawable.exo_08_stranger_post_grass,
    description = "La mère de Dustin nous a dit: Regardez, dehors c'est de l'herbe, c'est pas toxique, vous pouvez sortir et jouer",
    likes = 83,
    comments = 4,
    didLike = false
)
val haircut = StrangerPost(user = eddie, imageId = R.drawable.exo_08_stranger_post_haircut, description = "La dernière coupe à la mode.On a juste besoin de ciseaux et d'un bol", likes = 16, comments = 8, didLike = false)
val marine = StrangerPost(
    user = lucas,
    imageId = R.drawable.exo_08_stranger_post_marine,
    description = "C'est quand j'ai vu cet uniforme que je me suis décidé à m'inscrire au basket plutôt que trainer au centre commercial",
    likes = 45,
    comments = 56,
    didLike = false
)
val roller = StrangerPost(user = eleven, imageId = R.drawable.exo_08_stranger_post_roller, description = "Love Love Love ❤️‍🔥", likes = 98, comments = 29, didLike = false)
val snow = StrangerPost(
    user = eleven,
    imageId = R.drawable.exo_08_stranger_post_snow,
    description = "La dernière fois que beau papa m'a dit: Viens on va à la neige, ca va être sympa !",
    likes = 323,
    comments = 1,
    didLike = false
)
val vecna = StrangerPost(user = eddie, imageId = R.drawable.exo_08_stranger_post_vecna, description = "Il n'a pas mis de crème solaire ce gars la", likes = 456, comments = 79, didLike = false)

fun allPosts(): List<StrangerPost> {
    return listOf(bats, crush, father, fireworks, grass, haircut, marine, roller, snow, vecna)
}