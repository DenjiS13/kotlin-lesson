package fr.system13.kotlin_lesson.lessons

import fr.system13.kotlin_lesson.Logger

class B_Lists {

    fun callAll() {
        arrayOf()
        listOf()
        mutableListOf()
        setOfAndMutableSet()
        mapsAndMutableMaps()
    }

    /** Les arrays sont immutables */
    private fun arrayOf() {
        var boys = arrayOf("Jean", "Michel", "Jacques", "John")
        var girls = arrayOf("Marie", "Robert", "Myriam", "Sonia", "Cindy", "Helena", "Caroline")

        // Obtenir la taille d'un Array
        Logger.debug("arrayOf", "taille de boys : ${boys.size}")

        // Ajouter
        Logger.debug("arrayOf", "boys : ${boys.asList()}")
        boys += "Georges" // arrayOf est immutable
        Logger.debug("arrayOf", "boys + Georges : ${boys.asList()}")

        // Retirer
        girls = girls.filter { it != "Robert" }.toTypedArray()
        Logger.debug("arrayOf", "girls - Robert : ${girls.asList()}")

        // Concaténer
        val fullClass = boys + girls
        Logger.debug("arrayOf", "fullClass : ${fullClass.asList()}")

        // Obtenir la taille d'un Array
        Logger.debug("arrayOf", "taille de girls : ${girls.size}")

        // Obtenir un élément via l'index
        val chosenStudent = girls[1]

        //En choisissant l'index 1, on tombe sur Myriam, car l'index commence à zéro
        Logger.debug("arrayOf", "l'élève n°1 est : $chosenStudent")
    }

    /** Les listOf sont en readonly */
    private fun listOf() {

        val fruits = listOf("Banane", "Pomme", "Kiwi", "Fraise", "Ananas", "Poire", "Raisin")

        // Obtenir toute la liste
        Logger.debug("listOf", "fruits : $fruits")

        // Obtenir la taille d'une liste
        Logger.debug("listOf", "taille de fruits : ${fruits.size}")

        // Obtenir un élément via l'index
        Logger.debug("listOf", "fruits[0] : ${fruits[0]}")

        // Index Via le get
        Logger.debug("listOf", "fruits.get(3) : ${fruits.get(3)}")

        // Obtenir l'index par rapport à un nom de joueur
        Logger.debug("listOf", "fruits.indexOf(\"Poire\") : ${fruits.indexOf("Poire")}")
    }

    /** Les mutableListOf sont mutables */
    private fun mutableListOf() {

        val fruits: MutableList<String> = mutableListOf("Banane", "Pomme", "Kiwi", "Fraise", "Tomate", "Ananas", "Poire", "Raisin")

        Logger.debug("mutableListOf", "fruits : $fruits")

        // Ajouter (en fin de liste)
        fruits.add("Framboise")
        Logger.debug("mutableListOf", "fruits.add(\"Framboise\") : $fruits")

        // Ajouter selon un index précis
        fruits.add(1, "Mangue")
        Logger.debug("mutableListOf", "fruits.add(1, \"Mangue\") : $fruits")

        // supprimer selon une valeur
        fruits.remove("Tomate")
        Logger.debug("mutableListOf", "fruits.remove(\"Tomate\") : $fruits")

        //supprimer selon un index
        fruits.removeAt(7)
        Logger.debug("mutableListOf", "fruits.removeAt(7) : $fruits")

        //Voir si le joueur est là (est contenu dans la liste)
        Logger.debug("mutableListOf", "fruits.contains(\"Fraise\") : ${fruits.contains("Fraise")}")
    }

    private fun mapsAndMutableMaps() {

        val classroomResults: MutableMap<String, Int> = mutableMapOf(
            "Johnny" to 12, // clé : Johnny, valeur : 12
            "Quentin" to 15,
            "Sophie" to 11,
            "Axel" to 7,
            "Candice" to 17
        )

        // Voir la map
        Logger.debug("mapsAndMutableMaps", "classroomResults : $classroomResults")

        // Accéder à un élément selon sa clé
        Logger.debug("mapsAndMutableMaps", "classroomResults[\"Axel\"] : ${classroomResults["Axel"]}")

        // Compter
        Logger.debug("mapsAndMutableMaps", "classroomResults : ${classroomResults.size}")

        // Modifier une valeur selon la clé
        classroomResults["Sophie"] = 19
        Logger.debug("mapsAndMutableMaps", "classroomResults[\"Sophie\"] = 19 : $classroomResults")

        // Ajouter : Notez que c'est exactement comme modifier une valeur
        // Si la clé n'existe pas, elle est créée
        classroomResults["Mika"] = 5
        Logger.debug("mapsAndMutableMaps", "classroomResults[\"Mika\"] = 5 : $classroomResults")

        // Supprimer
        classroomResults.remove("Quentin")
        Logger.debug("mapsAndMutableMaps", "classroomResults.remove(\"Quentin\") : $classroomResults")
    }

    private fun setOfAndMutableSet() {

        // Création d'un ensemble
        val fruits: Set<String> = setOf("Pomme", "Banane", "Orange")

        // Affichage de l'ensemble
        Logger.debug("mapsAndMutableMaps", "fruits : $fruits")

        // Vérification de la présence d'un élément
        Logger.debug("mapsAndMutableMaps", "\"Banane\" in fruits : ${"Banane" in fruits}")

        // Création d'un ensemble mutable pour ajouter et supprimer des éléments
        val mutableFruits: MutableSet<String> = fruits.toMutableSet()

        // Ajout d'un élément
        mutableFruits.add("Fraise")
        Logger.debug("mapsAndMutableMaps", "mutableFruits.add(\"Fraise\") : $mutableFruits")

        // Suppression d'un élément
        mutableFruits.remove("Pomme")
        Logger.debug("mapsAndMutableMaps", "mutableFruits.remove(\"Pomme\") : $mutableFruits")

        // Itération à travers les éléments
        for (fruit in mutableFruits) {
            Logger.debug("mapsAndMutableMaps", "for (fruit in mutableFruits) : $fruit")
        }
    }
}