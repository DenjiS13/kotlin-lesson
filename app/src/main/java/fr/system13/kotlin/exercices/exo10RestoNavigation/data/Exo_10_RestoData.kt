package fr.system13.kotlin.exercices.exo10RestoNavigation.data

import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoItem
import fr.system13.kotlin.exercices.exo10RestoNavigation.model.Exo_10_RestoMenu

class Exo_10_RestoDataService {
    val burger = Exo_10_RestoItem(name = "Burger", image = R.drawable.exo_10_resto_burger)
    val charcuterie = Exo_10_RestoItem(name = "Charcuterie", image = R.drawable.exo_10_resto_charcuterie)
    val cheesecake = Exo_10_RestoItem(name = "Cheesecake citron Litchee", image = R.drawable.exo_10_resto_cheesecake)
    val churros = Exo_10_RestoItem(name = "Churros framboise", image = R.drawable.exo_10_resto_churros)
    val crevette = Exo_10_RestoItem(name = "Crevette aigre doux", image = R.drawable.exo_10_resto_crevette)
    val fajitas = Exo_10_RestoItem(name = "Fajitas", image = R.drawable.exo_10_resto_fajitas)
    val fondue = Exo_10_RestoItem(name = "Fondue", image = R.drawable.exo_10_resto_fondue)
    val gaz = Exo_10_RestoItem(name = "Gazpacho", image = R.drawable.exo_10_resto_gazpacho)
    val gateau = Exo_10_RestoItem(name = "Gateau au chocolat suisse", image = R.drawable.exo_10_resto_gateau)
    val glace = Exo_10_RestoItem(name = "Glace thé vert", image = R.drawable.exo_10_resto_glace)
    val mozza = Exo_10_RestoItem(name = "mozzarella", image = R.drawable.exo_10_resto_mozzarella)
    val nachos = Exo_10_RestoItem(name = "nachos", image = R.drawable.exo_10_resto_nachos)
    val nem = Exo_10_RestoItem(name = "nem", image = R.drawable.exo_10_resto_nem)
    val nuggets = Exo_10_RestoItem(name = "nuggets", image = R.drawable.exo_10_resto_nuggets)
    val pizza = Exo_10_RestoItem(name = "pizza", image = R.drawable.exo_10_resto_pizza)
    val paella = Exo_10_RestoItem(name = "paella", image = R.drawable.exo_10_resto_paella)
    val sopapilla = Exo_10_RestoItem(name = "sopapilla", image = R.drawable.exo_10_resto_sopapilla)
    val sundae = Exo_10_RestoItem(name = "sundae", image = R.drawable.exo_10_resto_sundae)
    val sushis = Exo_10_RestoItem(name = "sushis", image = R.drawable.exo_10_resto_sushis)
    val teriyaki = Exo_10_RestoItem(name = "teriyaki", image = R.drawable.exo_10_resto_teriyaki)
    val tiramisu = Exo_10_RestoItem(name = "tiramisu", image = R.drawable.exo_10_resto_tiramisu)


    val americain = Exo_10_RestoMenu(name = "Americain", starter = nuggets, mainCourse = burger, dessert = sundae)
    val chinois = Exo_10_RestoMenu(name = "Chinois", starter = nem, mainCourse = crevette, dessert = cheesecake)
    val espagnol = Exo_10_RestoMenu(name = "Espagnol", starter = gaz, mainCourse = paella, dessert = churros)
    val italien = Exo_10_RestoMenu(name = "Italien", starter = mozza, mainCourse = pizza, dessert = tiramisu)
    val japonais = Exo_10_RestoMenu(name = "Japonais", starter = sushis, mainCourse = teriyaki, dessert = glace)
    val mexicain = Exo_10_RestoMenu(name = "Mexicain", starter = nachos, mainCourse = fajitas, dessert = sopapilla)
    val suisse = Exo_10_RestoMenu(name = "Suisse", starter = charcuterie, mainCourse = fondue, dessert = gateau)

    val allExo10RestoMenus = listOf<Exo_10_RestoMenu>(americain, chinois, espagnol, italien, japonais, mexicain, suisse)
}