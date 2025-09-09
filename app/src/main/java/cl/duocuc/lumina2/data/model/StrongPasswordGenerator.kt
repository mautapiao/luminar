package cl.duocuc.lumina2.data.model

// CLASE HIJA: Agrega simbolos especiales
// Sobreescribe el metodo generate para hacer contraseñas más seguras
// Agregando símbolos especiales
class StrongPasswordGenerator(length: Int) : BasePasswordGenerator(length) {
    override fun generate(): String {
        val chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789!@#\$%^&*"
        return (1..length).map { chars.random() }.joinToString("")
    }
}
