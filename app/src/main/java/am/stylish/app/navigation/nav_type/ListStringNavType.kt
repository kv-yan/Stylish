package am.stylish.app.navigation.nav_type

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

object ListStringNavType {
    val listStringType = object : NavType<List<String>>(isNullableAllowed = false) {

        override fun get(bundle: Bundle, key: String): List<String>? {
            return Json.decodeFromString(string = bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): List<String> {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: List<String>): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: List<String>) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}