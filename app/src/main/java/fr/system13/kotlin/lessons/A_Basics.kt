package fr.system13.kotlin.lessons

import fr.system13.kotlin.Logger

/**
 * Exemples de types en Kotlin
 */
class A_Basics {

    fun callAll() {
        // Unit est un type qui n'a qu'une seule valeur, Unit.
        // C'est un peu comme le type void en Java ou C#.
//        var notNullableAny: Any = Unit // Unit = void
//
//        val constant: String = "Constant"
//        var nullableString: String? = null
//        var nullableInt: Int? = null
//        var nullableAny: Any? = null
//        var notNullableString: String = ""
//        var notNullableInt: Int = 0
//        var notNullableBoolean: Boolean = false
//        var notNullableDouble: Double = 0.0
//        var notNullableFloat: Float = 0.0f
//        var notNullableLong: Long = 0
//        var notNullableChar: Char = ' '
//        var notNullableByte: Byte = 0
//        var notNullableShort: Short = 0

        stringManipulation()
        pairAndTriple()
    }

    private fun stringManipulation() {

            // Interpolation
            val name = "Marseille"
            val arr = 16
            Logger.debug("stringManipulation", "\$name possède \$arr arrondissements : $name possède $arr arrondissements")

            // \ est un caractère d'échappement
            val jump = "Salut, je vais sauter à la ligne\nVoilà !"
            Logger.debug("stringManipulation", jump)

            // Triple quotes : permet de mettre plusieurs lignes
            val multiLine = """Salut, je vais sauter à la ligne
        Voilà !"""
            Logger.debug("stringManipulation", multiLine)

            // boucler sur chaque caractère
            for (c in name) {
                Logger.debug("stringManipulation", "for (c in name) :  $c")
            }

            // Changer la casse
            Logger.debug("stringManipulation", "name.uppercase() : " + name.uppercase())
            Logger.debug("stringManipulation", "name.lowercase() : " + name.lowercase())

            // Substring
            Logger.debug("stringManipulation", "name.substring(0, 5) : " + name.substring(0, 5))

            // Split
            val paris = "Paris 75"
            val arrondissement: List<String> = paris.split(" ")
            Logger.debug("stringManipulation", "arrondissement[0] : " + arrondissement[0])
            Logger.debug("stringManipulation", "arrondissement[1] : " + arrondissement[1])

            // Concatenation
            val name2 = "Marseille"
            val name3 = "Lyon"
            Logger.debug("stringManipulation", "\$name2 \$name3 : $name2 $name3")

    }

    private fun pairAndTriple() {

        // Pair
        val error = Pair(404, "Page not found")
        Logger.debug("pairAndTriple", "error : $error")
        Logger.debug("pairAndTriple", "error.first : " + error.first.toString())
        Logger.debug("pairAndTriple", "error.second : " + error.second)

        // Pair avec destructuration
        val (code, description) = Pair(404, "Page not found")
        Logger.debug("pairAndTriple", "code : $code")
        Logger.debug("pairAndTriple", "description : $description")

        // Triple
        val error2 = Triple(404, "Page not found", "Not found")
        Logger.debug("pairAndTriple", "error2.toString() : $error2")
        Logger.debug("pairAndTriple", "error2.first.toString() : " + error2.first.toString())
        Logger.debug("pairAndTriple", "error2.second  : " + error2.second)
        Logger.debug("pairAndTriple", "error2.third  : " + error2.third)
    }
}
