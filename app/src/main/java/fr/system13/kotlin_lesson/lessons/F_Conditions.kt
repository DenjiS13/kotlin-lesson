package fr.system13.kotlin_lesson.lessons

import fr.system13.kotlin_lesson.Logger

class F_Conditions {

    fun callAll() {
        ifElse()
        whenExpression()
        nullables()
    }

    fun ifElse() {

        val speedLimit = 75

        if (speedLimit <= 30) {
            println("Proche d'une école")
        } else if (speedLimit <= 50) {
            println("en ville")
        } else if (speedLimit <= 80) {
            println("en campagne")
        } else if (speedLimit <= 110) {
            println("Voie rapide")
        } else {
            println("Autoroute")
        }

        // Sur une seule ligne
        val isSunny = false
        val message = if (isSunny) "Tous à la plage" else "Mario Party!"
        Logger.debug("ifElse", message)
    }

    fun whenExpression() {

        val speedLimit = 75

        when (speedLimit) {
            30 -> println("Proche d'une école")
            50 -> println("en ville")
            80 -> println("en campagne")
            110 -> println("Voie rapide")
            else -> println("Autoroute")
        }
    }

    fun nullables() {

        val name: String? = null

        Logger.debug("nullables", " name?.length : ${name?.length}") // Int?

        if (name != null) {
            Logger.debug("nullables", " if (name != null) : ${name.length}") // Int?

        } else {
            Logger.debug("nullables", " else : C'est une variable null") // Int?
        }

        Logger.debug("nullables", "si name == null,  name!!.length génère une exception") // Int?

        Logger.debug("nullables", " name?.length ?: 35 : ${name?.length ?: 35}") // Int?
    }

}