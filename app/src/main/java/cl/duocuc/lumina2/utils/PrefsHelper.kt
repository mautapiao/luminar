package cl.duocuc.lumina2.utils

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
// Kotlin implementa el patrón Singleton de forma nativa
// Declaro un "object" para que sea un Singleton.
// Esto significa que solo existirá una única instancia de PrefsHelper en toda la app.
object PrefsHelper {

    private const val PREF_NAME = "Limuna2_Prefs" // Nombre del archivo de preferencias
    private const val KEY_USER_NAME = "user_name" // Clave para guardar el nombre del usuario

    // Creo una función privada que me da acceso al archivo de SharedPreferences.
    private fun getPrefs(context: Context): SharedPreferences {
        // Aquí obtengo el archivo de preferencias en modo privado (solo mi app puede leerlo)
        return context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
    }

    // Guardo el nombre del usuario en SharedPreferences
    fun saveUserName(context: Context, name: String?) {
        // Edito el archivo de preferencias y guardo el valor con la clave "user_name"
        getPrefs(context).edit { putString(KEY_USER_NAME, name) }
    }

    // Recupero el nombre del usuario guardado
    fun getUserName(context: Context): String? {
        // Leo el valor guardado, si no existe retorno null
        return getPrefs(context).getString(KEY_USER_NAME, null)
    }

    // Elimino el nombre del usuario (por ejemplo, cuando cierro sesión)
    fun clearUserName(context: Context) {
        // Limpio la clave específica del nombre de usuario
        getPrefs(context).edit { remove(KEY_USER_NAME) }
    }
}
