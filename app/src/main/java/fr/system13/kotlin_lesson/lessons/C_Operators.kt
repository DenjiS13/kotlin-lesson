package fr.system13.kotlin_lesson.lessons

import fr.system13.kotlin_lesson.Logger

class C_Operators {

    fun callAll() {
        unaryOperators()
        arithmeticOperators()
        booleanOperators()
        interoperabilityOperators()
    }

    fun unaryOperators() {

        // Assignation d'une variable
        var value = 12

        // Incrémentation
        value++                 // 14, lecture de la variable, puis incrémentation
        ++value                 // 15, incrémentation, puis lecture de la variable

        // Decrémentation
        value--                 // 14, lecture de la variable, puis décrémentation
        --value                 // 13, décrémentation, puis lecture de la variable

        // négation
        value = -value          // -13

        // Not
        val boolValue = true
        !boolValue              // false

        // Ajout, puis affectation
        value += 5              // 18

        // Décrémentation, puis affectation
        value -= 5              // 13

        // Multiplication, puis affectation
        value *= 5              // 65

        // Division, puis affectation
        value /= 5              // 13
    }

    fun arithmeticOperators() {

        // Addition
        val sum = 1 + 2         // 3

        // Soustraction
        val difference = 1 - 2  // -1

        // Multiplication
        val product = 1 * 2     // 2

        // Division
        val quotient = 1 / 2    // 0.5

        // Modulo
        val modulo = 11 % 3     // 2

        println(sum)
        println(difference)
        println(product)
        println(quotient)
        println(modulo)
    }

    fun interoperabilityOperators() {

        val numberA = 3
        val numberB = 7.5F
        val numberC = 35.345

        // calcul entre Int
        val resultInt: Int = numberA + numberC.toInt()
        Logger.debug("interoperabilityOperators", " numberA + numberC.toInt() : $resultInt")

        // calcul entre Float
        val resultFloat: Float = numberB - numberC.toFloat()
        Logger.debug("interoperabilityOperators", " numberB + numberC.toFloat() : $resultFloat")

        // calcul entre Double
        val resultDouble: Double = numberC - numberA.toDouble()
        Logger.debug("interoperabilityOperators", " numberC + numberA.toDouble() : $resultDouble")
    }

    fun booleanOperators() {
        val a = true
        val b = false
        val c = Any()
        val d = Any()
        var result = false

        // And
        result = a && b     // false
        Logger.debug("booleanOperators", " a && b : $result")

        // Or
        result = a || b         // true
        Logger.debug("booleanOperators", " a || b : $result")

        // Xor
        result = a xor b // true
        Logger.debug("booleanOperators", " a xor b : $result")

        // Not
        result = !a // false
        Logger.debug("booleanOperators", " !a : $result")

        // Equals
        result = a == b // false
        Logger.debug("booleanOperators", " a == b : $result")

        // Not Equals
        result = a != b // true
        Logger.debug("booleanOperators", " a != b : $result")

        // Triple Equals

        result = c === d // Teste l'identité de deux objets, c'est une comparaison de l'adresse de deux objets
        Logger.debug("booleanOperators", " c === d : $result")

        // Triple Not Equals
        result = c !== d // Teste l'identité de deux objets, c'est une comparaison de l'adresse de deux objets
        Logger.debug("booleanOperators", " c !== d : $result")

        val age = (10..20).random()
        val isSunday = true
        val homeworkDone = false
        val average = (10..20).random()

        // Ici nous vérifions si la personne a 18 ans ou plus ET si c'est dimanche
        val canGoOut = age >= 18 && isSunday
        Logger.debug("booleanOperators", " age >= 18 && isSunday : $canGoOut")

        //Ici nous vérifions si les devoirs sont faits et si sa moyenne OU plus de 10
        val restTime = homeworkDone || average > 10
        Logger.debug("booleanOperators", " homeworkDone || average > 10 : $restTime")
    }
}