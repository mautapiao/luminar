package cl.duocuc.lumina2.data.interfaces

interface UserRepositoryInterface {
    suspend fun login(email: String, password: String): Boolean
}
