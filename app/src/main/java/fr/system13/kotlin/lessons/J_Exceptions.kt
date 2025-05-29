package fr.system13.kotlin.lessons

import fr.system13.kotlin.Logger

class J_Exceptions {

    fun callAll() {
        tryAndCatch(1, 0)
        tryAndCatch(0, 2)
    }

    private fun tryAndCatch(numerator: Int, denominator: Int) {
        try {
            val a = numerator / denominator
            if (a == 0) {
                throw Exception("Zéro")
            }
        } catch (e: Exception) {
            Logger.debug("tryAndCatch", "Exception : $numerator / $denominator = $e")
        }
    }
}