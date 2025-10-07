package cl.duocuc.lumina2

import cl.duocuc.lumina2.ui.screens.auth.LoginViewModel
import cl.duocuc.lumina2.data.model.User
// runBloquing permite ejecutar funciones suspend (corutinas) de forma sincrona
// dentro del test, es útil para test simples que llamen a suspend functions
import kotlinx.coroutines.runBlocking
// importa las aserciones de JUnit: asertTrue, assertFalse, assertEquals
import org.junit.Assert.*
// @before marca un metodo que se ejecuta antes de casa @test
import org.junit.Before
// @Test marca un metodo como prueba que jUnit debe ejecutar
import org.junit.Test

class LoginViewModelTest {


    private lateinit var fakeRepo: FakeUserRepository
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        fakeRepo = FakeUserRepository()
        viewModel = LoginViewModel(fakeRepo)
    }

    @Test
    fun `login exitoso`() = runBlocking {
        fakeRepo.insert(User(1,"Ana", "ana@mail.com", "1234", "Chile"))

        val result = viewModel.login("ana@mail.com", "1234")

        assertTrue(result.success)
        assertEquals("Login exitoso", result.message) // valida el mensaje
    }

    @Test
    fun `login falla con password incorrecto`() = runBlocking {
        fakeRepo.insert(User(1,"Ana", "ana@mail.com", "1234", "Chile"))

        val result = viewModel.login("ana@mail.com", "wrong")

        assertFalse(result.success)
        assertEquals("Credenciales inválidas", result.message)
    }

    @Test
    fun `login con campos vacíos retorna error`() = runBlocking  {
        val result = viewModel.login("", "")

        assertFalse(result.success)
        assertEquals("Campos vacíos", result.message)
    }

}