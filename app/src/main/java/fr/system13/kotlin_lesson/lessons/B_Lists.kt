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
    fun arrayOf() {
        var boys = arrayOf<String>("Jean", "Michel", "Jacques", "John")
        var girls = arrayOf<String>("Marie", "Robert", "Myriam", "Sonia", "Cindy", "Helena", "Caroline")

        // Obtenir la taille d'un Array
        Logger.debug("arrayOf", "taille de boys : ${boys.size}")

        // Ajouter
        Logger.debug("arrayOf", "boys : ${boys.asList()}")
        boys += "Georges" // arrayOf est immutable
        Logger.debug("arrayOf", "boys + Georges : ${boys.asList()}")

        // Retirer
        girls = girls.filter { it != "Robert" }.toTypedArray()
        Logger.debug("arrayOf", "girls - Robert : ${girls.asList()}")

        // Concatener
        val fullClass = boys + girls
        Logger.debug("arrayOf", "fullClass : ${fullClass.asList()}")

        // Obtenir la taille d'un Array
        Logger.debug("arrayOf", "taille de girls : ${girls.size}")

        // Obtenir un élément via l'index
        val chosenStudent = girls[1]

        //En choisissant l'index 1, on tombe sur Myriam, car l'index commence à 0
        Logger.debug("arrayOf", "l'élève n°1 est : $chosenStudent")

        // Obtenir un élément via l'index
        val chosenStudent2 = girls.get(5)

        //En choisissant l'index 1, on tombe sur Myriam, car l'index commence à 0
        Logger.debug("arrayOf", "l'élève n°5 est : $chosenStudent2")
    }

    /** Les listOf sont en readonly */
    fun listOf() {

        val nflPlayers = listOf<String>(
            "Brady", "Kamara", "Kupp", "Garropolo", "Mahomes", "OBJ", "Kittle", "Kelce",
            "Bosa"
        )

        // Obtenir toute la liste
        Logger.debug("listOf", "nflPlayers : $nflPlayers")

        // Obtenir la taille d'une liste
        Logger.debug("listOf", "taille de nflPlayers : ${nflPlayers.size}")

        // Obtenir un élément via l'index
        Logger.debug("listOf", "nflPlayers[0] : ${nflPlayers[0]}")

        // Index Via le get
        Logger.debug("listOf", "nflPlayers.get(3) : ${nflPlayers.get(3)}")

        // Obtenir l'index par rapport a un nom de joueur
        Logger.debug("listOf", "nflPlayers.indexOf(\"Kittle\") : ${nflPlayers.indexOf("Kittle")}")
    }

    /** les mutableListOf sont mutables */
    fun mutableListOf() {

        val nflPlayers: MutableList<String> = mutableListOf<String>("Brady", "Kamara", "Kupp", "Garropolo", "Mahomes", "OBJ", "Kittle", "Kelce", "Bosa")

        Logger.debug("mutableListOf", "nflPlayers : $nflPlayers")

        // Ajouter (en fin de liste)
        nflPlayers.add("Rodgers")
        Logger.debug("mutableListOf", "nflPlayers.add(\"Rodgers\") : $nflPlayers")

        // Ajouter selon un index précis
        nflPlayers.add(1, "Gronkowski")
        Logger.debug("mutableListOf", "nflPlayers.add(1, \"Gronkowski\") : $nflPlayers")

        // supprimer selon une valeur
        nflPlayers.remove("OBJ")
        Logger.debug("mutableListOf", "nflPlayers.remove(\"OBJ\") : $nflPlayers")

        //supprimer selon un index
        nflPlayers.removeAt(7)
        Logger.debug("mutableListOf", "nflPlayers.removeAt(7) : $nflPlayers")

        //Voir si le joueur est là (est contenu dans la liste)
        Logger.debug("mutableListOf", "flPlayers.contains(\"Brady\") : ${nflPlayers.contains("Brady")}")
    }

    fun mapsAndMutableMaps() {

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

        // Ajouter: Notez que c'est exactement comme modifier une valeur
        // Si la clé n'existe pas elle est créée
        classroomResults["Mika"] = 5
        Logger.debug("mapsAndMutableMaps", "classroomResults[\"Mika\"] = 5 : $classroomResults")

        // Supprimer
        classroomResults.remove("Quentin")
        Logger.debug("mapsAndMutableMaps", "classroomResults.remove(\"Quentin\") : $classroomResults")
    }

    fun setOfAndMutableSet() {

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