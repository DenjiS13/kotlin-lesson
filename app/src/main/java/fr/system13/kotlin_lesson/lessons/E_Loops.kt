package fr.system13.kotlin_lesson.lessons

class E_Loops {

    fun callAll() {
        forIn()
        forInRange()
        forInIndices()
        whileAndDoWhileLoop()
    }

    fun forIn() {

        // Sur une liste mutable
        val list = mutableListOf(1, 34, 89, 567, 2, 345, 4)
        for (item in list) {
            println(item)
        }

        // Sur une map
        val map = mutableMapOf("Jack" to 4.3, "John" to 7.8, "Simon" to 9.0)
        for ((key, value) in map) {
            println("$key possède $value €")
        }

        // Sur une String pour lire chaque caractère
        val string = "Essayez de passer à travers tous mes caractères"
        for (character in string) {
            println(character)
        }
    }

    fun forInRange(){

        // Range de 0 à 13
        for (index in 0..13) {
            println("Je suis l'index $index")
        }
    }

    fun forInIndices(){

        val list = mutableListOf(1, 34, 89, 567, 2, 345, 4)

        // Utilisation de l'index
        for (index in 0..list.size - 1) {
            println(list[index])
        }

        // Plus pratique car l'index est implicite
        for (index in list.indices) {
            println("Je suis l'index $index")
        }

        // Utilisation de l'index et de la valeur
        for ((index, value) in list.withIndex()) {
            println("L'$index est $value")
        }
    }

    fun whileAndDoWhileLoop() {
        var index = 0

        // While
        while (index < 10) {
            println("Je suis l'index $index")
            index++
        }

        // Do While
        do {
            println("Je suis l'index $index")
            index++
        } while (index < 10)
    }
}

