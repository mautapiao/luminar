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

Se cumple con lo solicitado en cuanto a aplicar los senetencias solicitadas, 
la mayoría de ellas se realiza en AnalisisScreen.kt, se refactorizo IndicatorScreen.kt
de tal forma que existe solo un compose para visualizar los indicadores:

Dashboard -> BotonCard -> (BotonMenuData) -> BotonCard.kt -> MyApp.kt( rutas )
 
Existen dos tipo de botones de menú: los indicadores que utilizan  un parametro en la ruta y 
las rutas "estaticas" donde cada "boton" es un módulo como : Calculadora.

AnalisisScreen: se puede visualizar los diferentes análisis de información relacionada
a los indicadores económicos y se hace uso de :

- Funciones de orden superior
- Filter
- Funciones inline
- Lambdas
- Lambda con etiqueta
- Funciones de extensión
- Propiedades de extensión
- Excepciones
- Try/Catch

(EjemplosData, Hepers)

## Revisar 

- utils -> Globals (variables globales)
- utils -> Helpers (funciones globales)
- Olvidé mi contraseña (algunas funciones y validaciones)
- Calculadora (minimalista)
- Pass Generación de contraseñas, relacionado a lo solcitado
- Análisis de indicadores económicos

## Descripción de la actividad

En esta quinta semana, se realizará la actividad sumativa 2, llamada 
"Integrando Kotlin a la aplicación móvil con Android Studio", 
donde deberán integrar a la app creada en el framework Android Studio,
las funcionalidades básicas y avanzadas del lenguaje de programación Kotlin,
con una entrega de encargo que contenga la documentación del desarrollo y 
código del proyecto comprimido en ZIP.

---

## Características del producto

- Adaptar al lenguaje de programación Kotlin la aplicación móvil de accesibilidad
  para personas con discapacidad sensorial visual desarrollada en la experiencia de aprendizaje 1.
- La aplicación móvil deberá ser desarrollada específicamente para personas 
  con discapacidad sensorial visual, facilitando a los usuarios su comunicación 
  (escribir y leer) en su entorno cotidiano, mejorando su calidad de vida al transformar 
  sus dispositivos móviles en una herramienta que los integra al mundo real y digital.

---

## Requerimientos generales

Para el desarrollo de la entrega solicitada considerar los siguientes aspectos:

- Implementación el lenguaje de programación Kotlin en cada componente UI de Material
  Design y Jetpack Compose integrado en entrega de la experiencia de aprendizaje 1
  (input, botones, tablas, grillas, vínculos, textos, combo box, check list y radio buttons).
  Adaptar las views de Login, Registro y Recuperar contraseña al lenguaje de programación Kotlin.
- Generar un array en Kotlin que almacene los datos de 5 usuarios y sus contraseñas, 
  registrados previamente desde el formulario de la view de Registro.

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
