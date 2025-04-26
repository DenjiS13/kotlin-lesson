package fr.system13.kotlin_1_myfirstapp.lessons

class D_Functions() {

    init { // Constructeur principal
        basicFunction()
        basicFunction("Quentin")
        basicFunctionWithDefault("Quentin")
        basicFunctionWithDefault()
        basicFunctionWithMultipleParam("Quentin", 25)
        basicFunctionWithMultipleParam(age = 25, name = "Quentin") // on peut préciser les paramètres dans le désordre
        basicFunctionWithMultipleParamWithReturn("Quentin", 25)


    }

    // Fonction simple sans retour
    fun basicFunction(): Unit { // Unit signifie que la fonction ne retourne rien
        println("Salut les apprenants! Je suis une fonction")
    }

    // Fonction avec paramètre, sans retour
    fun basicFunction(name: String): Unit {
        println("Salut $name")
    }

    // Fonction avec paramètre par défaut, sans retour
    fun basicFunctionWithDefault(name: String = "Anonyme"): Unit {
        println("Salut $name")
    }

    // Fonction avec plusieurs paramètres, sans retour
    fun basicFunctionWithMultipleParam(name: String, age: Int): Unit {
        println("Salut $name, tu as $age ans")
    }

    // Fonction avec plusieurs paramètres, avec retour
    fun basicFunctionWithMultipleParamWithReturn(name: String, age: Int): String {
        return "Salut $name, tu as $age ans"
    }
}