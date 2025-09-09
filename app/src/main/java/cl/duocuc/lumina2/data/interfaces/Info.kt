package cl.duocuc.lumina2.data.interfaces

interface Info {
    fun showInfo(): String
}

/**
 * Interface: define un conjunto de métodos y propiedades que una clase debe implementar.
 * Se usa para establecer comportamientos comunes entre diferentes clases,
 * sin importar su jerarquía de herencia.
 * Puede contener:
 * Declaraciones abstractas (sin implementación).
 * Implementaciones por defecto (código dentro de la interfaz).
 * Propiedades (abstractas o con getter/setter por defecto).
 *
 * Ejemplo sencillo
 *
 * interface Animal {
 *     fun makeSound()   // método abstracto
 *     fun sleep() {     // implementación por defecto
 *         println("Durmiento...")
 *     }
 * }
 *
 * class Dog : Animal {
 *     override fun makeSound() {
 *         println("Ladrar!")
 *     }
 * }
 *
 * Ejemplo ejecución:
 *
 * fun main() {
 *     val myDog: Animal = Dog()   // se declara como tipo Animal (interface)
 *
 *     myDog.makeSound()           // ejecuta la implementación de Dog -> "Ladrar!"
 *     myDog.sleep()               // usa la implementación por defecto-> "Durmiendo..."
 * }
 *
 * o el ejemplo que se realizo en clases ver video
 *
 */