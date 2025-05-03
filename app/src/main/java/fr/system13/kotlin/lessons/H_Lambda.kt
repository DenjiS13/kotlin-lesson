package fr.system13.kotlin.lessons

import fr.system13.kotlin.Logger

class H_Lambda {

    fun callAll() {
        basicLambda()
        lambdaWithParameters()
        lambdaWithReturn()
        lambdaAsParameter()
    }

    private fun basicLambda() {

        // Définition d'une expression Lambda
        val lambda = { println("Je viens de créer ma première expression Lambda") }

        // Exécuter l'expression
        lambda()
    }

    private fun lambdaWithParameters() {

        // Définition d'une expression Lambda simple
        val lambda = { name: String -> println("Bonjour $name") }
        lambda("Ferdinand")

        // $it : paramètre de l'expression Lambda par défaut
        val lambda2: (String) -> Unit = { println("Bonjour $it") }
        lambda2("Ferdinand")

        // Plusieurs paramètres v1
        val lambda3 = { name: String, age: Int -> println("Bonjour $name, tu as $age ans") }
        lambda3("Ferdinand", 53)

        // Plusieurs paramètres v1
        val lambda4: (String, Int) -> Unit = { name, age -> println("Bonjour $name, tu as $age ans") }
        lambda4("Ferdinand", 53)
    }

    private fun lambdaWithReturn() {

        // Définition d'une expression Lambda simple
        val lambda = { name: String -> "Bonjour $name" }
        lambda("Ferdinand")

        // $it : paramètre de l'expression Lambda par défaut
        val lambda2: (String) -> String = { "Bonjour $it" }
        lambda2("Ferdinand")

        // exemple : Double to Int
        val doubleToIntV1: (Double) -> Int = { it.toInt() }
        println(doubleToIntV1(3.14))
        val doubleToIntV2: (Double) -> Int = { dbl -> dbl.toInt() }
        doubleToIntV2(3.14)

        // Plusieurs paramètres
        val lambda3 = { name: String, age: Int -> "Bonjour $name, tu as $age ans" }
        lambda3("Ferdinand", 53)
        val lambda4: (String, Int) -> String = { name, age -> "Bonjour $name, tu as $age ans" }
        lambda4("Ferdinand", 53)
    }

    private fun lambdaAsParameter() {
        val toUpper: (String) -> String = String::uppercase
        val toLower: (String) -> String = String::lowercase

        val callCase: (string: String, function: (String) -> String) -> String = { string, function -> function(string) }

        val name = "Ferdinand"
        Logger.debug("lambdaAsParameter", "toUpper(name) : " + callCase(name, toUpper))
        Logger.debug("lambdaAsParameter", "toLower(name) : " + callCase(name, toLower))
    }
}