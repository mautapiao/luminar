package cl.duocuc.lumina2

import cl.duocuc.lumina2.data.dao.UserDao
import cl.duocuc.lumina2.data.model.User
import cl.duocuc.lumina2.data.repository.UserRepository
// runBloquing permite ejecutar funciones suspend (corutinas) de forma sincrona
// dentro del test, es útil para test simples que llamen a suspend functions
import kotlinx.coroutines.runBlocking
// importa las aserciones de JUnit: asertTrue, assertFalse, assertEquals
import org.junit.Assert.*
// @before marca un metodo que se ejecuta antes de casa @test
import org.junit.Before
// @Test marca un metodo como prueba que jUnit debe ejecutar
import org.junit.Test

// Fake DAO en memoria
class FakeUserDao : UserDao {
    // implementacion simple del DAO que guarda los datos en memoria para los tests

    // Lista mutable que actua como tabla en memoria, cada test usa su propia instancia
    // por que la instancia se crea en setup, por esto los test quedan aislados
    private val users = mutableListOf<User>()

    // Metodo suspend que busca en la lista el usuario por email
    // Devuelve null si no existe

    override suspend fun getUserByEmail(email: String): User? {
        return users.find { it.email == email }
    }

    // Inserta el usuario en la lista en memoria
    override suspend fun insert(user: User) {
        users.add(user)
    }

    // Devuelve una la lista mutable interna al test
    override suspend fun getAll(): List<User> {
        return users.toList()
    }

    override suspend fun updateUser(user: User) {
        val index = users.indexOfFirst { it.email == user.email }
        if (index != -1) {
            users[index] = user
        }
    }
}

class UserRepositoryTest {

    // lateint significa que la variable se  inicializara mas tarde en @before
    private lateinit var userDao: FakeUserDao
    private lateinit var repo: UserRepository

    @Before
    fun setup() {
        // cada test revibirá una nueva instancia del FakeUserDao asi los test no comparten estado
        userDao = FakeUserDao()
        // ceamos el repo pasándole el DAO false ahora el repo usara la "db" en memoria
        repo = UserRepository(userDao)
    }

    @Test
    fun `registrar usuario nuevo`() = runBlocking {
        // Nombre del test en backticks, Kotlin permite nombres descriptivos con espacios
        // runBlocking permite llamar a repo.register que es suspend

        // creamos el objeto User que usaremos como dato de prueba
        val user = User(name = "Ana Pérez", email = "ana@mail.com", password = "1234", country = "Chile")

        // llamamos al metrod a probar, Este metodo internamente llama a userDao.getUserByEmail
        // y unserDao.insert si no existe
        val result = repo.register(user)

        // verificamos que el metodo devolvio true (registro existoso)
        assertTrue(result)
        // verificamos que efectivamente fue insertado en el DAO en memoria
        assertEquals(1, userDao.getAll().size)
    }

    @Test
    fun `no permite registrar usuario duplicado`() = runBlocking {
        val user = User(name = "Ana Pérez", email = "ana@mail.com", password = "1234", country = "Chile")

        //Pre-condición: insetamos el usuario la primera vez
        repo.register(user)

        // inntentamos registrar al mismo usuario otra vez, que debe fallar
        val result = repo.register(user) // intentar registrar de nuevo

        // esperamos false porque el correo ya existe
        assertFalse(result)
        // confirmamos que no se insertó una segunda vez
        assertEquals(1, userDao.getAll().size)
    }

    @Test
    fun `login correcto`() = runBlocking {
        // Insertamos el usuario usando el metodo register del repo (prueba indirecta de register)
        val user = User(1, "Miguel", "miguel@mail.com", "1234", "Chile")
        repo.register(user)
        // Llamamos a login, que internamente hace getUserByEmail y compara la contraseña
        val result = repo.login("miguel@mail.com", "1234")
        // Debe retornar true porque la contraseña coincide
        assertTrue(result)
    }

    @Test
    fun `login falla con password incorrecta`() = runBlocking {
        val user = User(1,"Miguel", "miguel@mail.com", "1234", "Chile")
        repo.register(user)
        // Provocamos la condición de contraseña incorrecta
        val result = repo.login("miguel@mail.com", "wrong")
        // Esperamos false porque la contraseña no coincide.
        assertFalse(result)
    }

    @Test
    fun `retorna nombre correcto`() = runBlocking {
        val user = User(1,"Lucía", "lucia@mail.com", "abcd", "México")
        // Insertamos un usuario de prueba
        repo.register(user)
        // Llamamos al metodo que debería devolver el nombre del usuario
        val nombre = repo.userName("lucia@mail.com")
        // Verificamos que el nombre devuelto es el esperado
        assertEquals("Lucía", nombre)
    }
}