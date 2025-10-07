package cl.duocuc.lumina2

import cl.duocuc.lumina2.data.interfaces.UserRepositoryInterface
import cl.duocuc.lumina2.data.model.User

//  Fake repo definido fuera del archivo de test
class FakeUserRepository : UserRepositoryInterface {
    private val users = mutableListOf<User>()

    suspend fun insert(user: User) {
        users.add(user)
    }

    override suspend fun login(email: String, password: String): Boolean {
        val user = users.find { it.email == email }
        return user?.password == password
    }
}