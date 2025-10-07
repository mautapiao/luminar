package cl.duocuc.lumina2.ui.screens.auth

import cl.duocuc.lumina2.data.interfaces.UserRepositoryInterface
import cl.duocuc.lumina2.data.model.LoginResult

class LoginViewModel(private val repo: UserRepositoryInterface) {

    suspend fun login(correo: String, password: String): LoginResult {
        if (correo.isBlank() || password.isBlank()) {
            return LoginResult (false,"Campos vacíos")
        }
        // se hacen algunos cambio ya que el login regresa true o false en repo
        val ok = repo.login(correo, password)

        return if (ok){
            LoginResult (true,"Login exitoso")
        }else{
            LoginResult (false,"Credenciales inválidas")
        }
    }
}