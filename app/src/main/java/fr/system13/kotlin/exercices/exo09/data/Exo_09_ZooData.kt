package fr.system13.kotlin.exercices.exo09.data

import fr.system13.kotlin.R
import fr.system13.kotlin.exercices.exo09.model.ZooAnimal

class ZooDataModel() {

    val maki = ZooAnimal(name = "Maki", image = R.drawable.exo_09_zoo_maki)
    val capucin = ZooAnimal(name = "Capucin brun", image = R.drawable.exo_09_zoo_capu)
    val fennec = ZooAnimal(name = "Fennec", image = R.drawable.exo_09_zoo_fennec)
    val ocelot = ZooAnimal(name = "Ocelot", image = R.drawable.exo_09_zoo_ocelot)
    val serval = ZooAnimal(name = "Serval", image = R.drawable.exo_09_zoo_serval)
    val elephant = ZooAnimal(name = "Éléphant", image = R.drawable.exo_09_zoo_elephant)
    val tigre = ZooAnimal(name = "Tigre", image = R.drawable.exo_09_zoo_tigre)
    val loutre = ZooAnimal(name = "Loutre d'Europe", image = R.drawable.exo_09_zoo_loutre)
    val ali = ZooAnimal(name = "Alligator", image = R.drawable.exo_09_zoo_alligator)
    val naja = ZooAnimal(name = "Naja", image = R.drawable.exo_09_zoo_naja)
    val iguane = ZooAnimal(name = "Iguane vert", image = R.drawable.exo_09_zoo_iguane)
    val tortue = ZooAnimal(name = "Tortue d'Hermann", image = R.drawable.exo_09_zoo_tortue)
    val aigle = ZooAnimal(name = "Pygargue à tête blanche", image = R.drawable.exo_09_zoo_eagle)
    val ara = ZooAnimal(name = "Ara bleu", image = R.drawable.exo_09_zoo_ara)
    val cagou = ZooAnimal(name = "Cagou", image = R.drawable.exo_09_zoo_cagou)
    val kiwi = ZooAnimal(name = "Kiwi Austral", image = R.drawable.exo_09_zoo_kiwi)

    fun allAnimals(): List<ZooAnimal> {
        return listOf(maki, capucin, fennec, ocelot, serval, elephant, tigre, loutre, ali, naja, iguane, tortue, aigle, ara, cagou, kiwi)
    }
}