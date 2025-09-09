# Luminar App para personas con discapacidad visual

- **Usuarios por defecto**
  - ana@demo.com
  - juan@demo.com
  - maria@demo.com
  - carlos@demo.com
  - lucia@demo.com

- Para todos clave: 123456

## Generador de contraseñas

Clase: BasePasswordGenerator, StrongPasswordGenerator.
Objeto: simpleGen, strongGen.
Método: generate().
Propiedad: length.
Constructor: (8) o (12).
Herencia: StrongPasswordGenerator hereda de BasePasswordGenerator.
Interfaces: PasswordGenerator define el contrato.
Polimorfismo: simpleGen y strongGen son del tipo PasswordGenerator, pero generan contraseñas distintas.

## Generador de contraseñas

ui/screens/lumina/info.kt 

## Nota

Se cumple con lo solicitado en cuanto a aplicar POO, 
incorporando clases, herencia, interfaces y polimorfismo. 
Sin embargo, queda la duda de cuándo es realmente necesario aplicar POO
y cuándo no, ya que en ejercicios pequeños, como un generador de contraseñas,
el uso de POO puede llegar a complicar más que ayudar.
Aun así, se trató de implementar los conceptos de la mejor manera posible.


## Revisar 

- utils -> Globals (variables globales)
- utils -> Helpers (funciones globales)
- Olvidé mi contraseña (algunas funciones y validaciones)
- Calculadora (minimalista)
- Pass Generación de contraseñas, relacionado a lo solcitado

## Descripción de la actividad

En esta cuarta semana, se realizará la actividad formativa 3, 
llamada "Integrando funcionalidades básicas a una aplicación 
móvil con Kotlin" donde deberán implementar funcionalidades 
básicas del lenguaje de programación Kotlin en una aplicación
móvil, a partir de un código real.

---

## Características del producto

- Adaptar al lenguaje de programación Kotlin la aplicación móvil que facilita una minuta nutricional semanal de recetas, desarrollada en la experiencia de aprendizaje 1 (actividad formativa 1).
- La aplicación móvil se diseñará con componentes UI específicamente para usuarios de baja habilidad informática, facilitando la usabilidad en el acceso a cada receta que la aplicación sugiera.

---

## Requerimientos generales

Para el desarrollo de la entrega solicitada, deberás considerar los siguientes aspectos:

- Implementación del lenguaje de programación Kotlin en cada componente UI de *Material Design* y *Jetpack Compose* integrado en la entrega de la experiencia de aprendizaje 1 (input, botones, tablas, grillas, vínculos, textos, combo box, check list y radio buttons).

---

## Requerimientos técnicos

- Desarrollar la aplicación con el Framework **Android Studio**.
- Generar y compartir el **repositorio Git** del proyecto.
- Integrar el lenguaje de programación **Kotlin** al código fuente de la app móvil.

---

## Requerimientos en esta entrega

- La aplicación móvil debe ser adaptativa a múltiples dispositivos Android que cuenten con una conexión activa a internet.

---

## Entrega del encargo

- Una vez desarrollado el proyecto desde Android Studio, se deberá comprimir la carpeta del código del proyecto completo en formato `.zip` desde Git y enviarlo en forma digital al docente por la actividad habilitada en AVA.
