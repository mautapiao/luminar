package cl.duocuc.lumina2.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import cl.duocuc.lumina2.data.model.User

@Dao
// DAO (Data Access Object) -> Define cómo accedemos a la base de datos Room
interface UserDao {

    @Insert
    suspend fun insert(user: User)
    // Inserta un nuevo usuario en la tabla "users"
    // Como es "suspend", se debe ejecutar dentro de una corrutina (no en el hilo principal)

    @Query("SELECT * FROM users WHERE email = :email LIMIT 1")
    suspend fun getUserByEmail(email: String): User?
    // Busca un usuario en la tabla por su email
    // Retorna un objeto User si lo encuentra, o null si no existe
    // El ":email" hace referencia al parámetro del método

    @Query("SELECT * FROM users")
    suspend fun getAll(): List<User>
    // Obtiene todos los registros de la tabla "users"
    // Devuelve una lista de usuarios (puede ser vacía si no hay registros)

    @Update
    suspend fun updateUser(user: User)
}

/*

En Room, los métodos están marcados como suspend porque acceder a la base de datos
puede tardar un poco.
Si esas operaciones se hicieran directamente en el hilo principal (UI Thread),
la aplicación se congelaría y podría dar un error de “Application Not Responding (ANR)”.
suspend permite que la función se ejecute dentro de una corrutina,
es decir, de forma asíncrona y sin bloquear la interfaz. De esta manera, la app sigue
respondiendo al usuario mientras Room trabaja en segundo plano con la base de datos.

 */