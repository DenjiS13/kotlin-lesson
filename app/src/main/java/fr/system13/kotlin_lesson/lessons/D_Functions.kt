package fr.system13.kotlin_lesson.lessons

class D_Functions {

    fun callAll() {

        val name: String = if ((0..100).random() < 13) "Toto" else "Anonyme"
        val age: Int = (0..100).random()

        basicFunction()
        basicFunction(name)
        basicFunctionWithDefault(name)
        basicFunctionWithDefault()
        basicFunctionWithMultipleParam(name, age)
        basicFunctionWithMultipleParam(age = age, name = name) // on peut préciser les paramètres dans le désordre
        basicFunctionWithMultipleParamWithReturn(name, age)
    }

    // Fonction simple sans retour
    private fun basicFunction() { // Unit signifie que la fonction ne retourne rien
        println("Salut les apprenants! Je suis une fonction")
    }

    // Fonction avec paramètre, sans retour
    private fun basicFunction(name: String) {
        println("Salut $name")
    }

    // Fonction avec paramètre par défaut, sans retour
    private fun basicFunctionWithDefault(name: String = "Anonyme") {
        println("Salut $name")
    }

    // Fonction avec plusieurs paramètres, sans retour
    private fun basicFunctionWithMultipleParam(name: String, age: Int) {
        println("Salut $name, tu as $age ans")
    }

    // Fonction avec plusieurs paramètres, avec retour
    private fun basicFunctionWithMultipleParamWithReturn(name: String, age: Int): String {
        return "Salut $name, tu as $age ans"
    }
}