package cl.duocuc.lumina2.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cl.duocuc.lumina2.data.dao.UserDao
import cl.duocuc.lumina2.data.model.User

// Base de datos local con Room (concepto: persistencia de datos a largo plazo)
// Anotación que indica que esta clase es una base de datos de Room
// - entities = [User::class] -> incluye la tabla "users" (definida en la data class User)
// - version = 2 -> versión actual del esquema de la base de datos (se cambia cuando se modifique el modelo)
@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase() { // Hereda de RoomDatabase, clase base de Room

    // Método abstracto que le dice a Room cómo obtener el DAO de usuarios
    abstract fun userDao(): UserDao

    companion object { // Bloque estático -> permite crear una sola instancia (singleton) de la BD

        // Variable que guarda la instancia única de la base de datos en memoria
        // @Volatile asegura que los cambios sean visibles para todos los hilos
        @Volatile private var INSTANCE: AppDatabase? = null

        // Método para obtener la base de datos. Si no existe, la crea.
        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) { // Si aún no está creada, la creamos de forma segura
                val instance = Room.databaseBuilder(
                    context.applicationContext,   // Contexto de la app (evita fugas de memoria)
                    AppDatabase::class.java,     // Clase de la BD
                    "app_db_lumina"              // Nombre del archivo físico de la BD
                )
                    .fallbackToDestructiveMigration() // * solo pruebas, Si cambia la versión y no hay migración, borra y recrea la BD
                    .build()
                INSTANCE = instance // Guardamos la instancia creada
                instance            // La retornamos
            }
        }
    }
}

// El context indica a Room dónde crear/guardar la base de datos dentro de la app
