package fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.service

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import fr.system13.kotlin.exercices.exo12NflJsonDrawerDl.model.Exo_12_Franchise
import java.io.IOException

class JsonParser {
    fun convertJsonToString(context: Context, fileName: String): String? {

        try {
            val assets = context.assets
            val inputStream = assets.open(fileName)
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()
            return String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return null

    }

    fun getFranchisesFromJson(context: Context): List<Exo_12_Franchise>? {

        val json = convertJsonToString(context, "nfl.json")
        var franchises :List<Exo_12_Franchise>? = null
        if (json != null) {
            val gson = Gson()
            val type = object : TypeToken<List<Exo_12_Franchise>>() {}.type
            franchises = gson.fromJson(json, type)
        }
        return franchises
    }
}