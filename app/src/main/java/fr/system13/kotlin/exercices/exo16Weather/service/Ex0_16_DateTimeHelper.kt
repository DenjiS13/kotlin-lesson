package fr.system13.kotlin.exercices.exo16Weather.service

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale

class Ex0_16_DateTimeHelper private constructor() {

    companion object {
        @Volatile
        private var instance: Ex0_16_DateTimeHelper? = null

        fun getInstance() =
            instance ?: synchronized(this) {
                instance ?: Ex0_16_DateTimeHelper().also { instance = it }
            }
    }

    fun getString(timestamp: Long, timezoneShift: Int ,format: String): String {
        val dateLong = (timestamp + timezoneShift) * 1000 // Convertir les secondes en millisecondes
        val instant = Instant.ofEpochMilli(dateLong)
        val zonedDateTime = instant.atZone(ZoneId.systemDefault())
        val dateFormatter = DateTimeFormatter.ofPattern(format, Locale.FRANCE)
        return zonedDateTime.format(dateFormatter)
    }

}