package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.db.AppDatabase
import cl.duocuc.lumina2.data.repository.UserRepository
import cl.duocuc.lumina2.ui.screens.auth.LoginScreen
import cl.duocuc.lumina2.ui.screens.auth.RecuperarPasswordScreen
import cl.duocuc.lumina2.ui.screens.auth.RegistroScreen
import cl.duocuc.lumina2.utils.Globals

@Composable
fun MyApp() {

    val navController = rememberNavController()
    val context = LocalContext.current
    // cargo los 5 usuarios creados por defectos en el array modelo User repo User
    androidx.compose.runtime.LaunchedEffect(Unit) {
        // repository funcion para crear usuarios por defecto
        val db = AppDatabase.getDatabase(context )
        val userRepository = UserRepository(db.userDao())

        userRepository.seedDefaults()

    }
    /**
     * Sistema de navegación
     *
     * navController: Controle la navegación entre pantallas
     * navHost: Contenedor que define todas las rutas de navegación
     * startDestination = "login": La app inicia en la pantalla de login
     */
    NavHost(
        navController = navController,
        startDestination = "login"
    ) {
        composable("login") {
            LoginScreen(
                onLogin = { navController.navigate("home") },
                onRegister = { navController.navigate("registro") },
                onForgotPassword = { navController.navigate("recuperar") }
            )
        }

        composable("registro") {
            RegistroScreen(
                onRegisterDone = { navController.popBackStack() },
                onBack = { navController.popBackStack() })
        }
        composable("recuperar") { RecuperarPasswordScreen(onBack = { navController.popBackStack() }) }

        // Todo lo que está después de autenticación
        composable("home") {
            DashboardScreen(
                navController = navController,
                onBack = { navController.popBackStack() })
        }

        // destinos

        /**
         * Inicialmente la app busca mostrar de forma facil
         * los inidicadores economicos del día
         * para personas con discapacidad visual
         *
         * En nuevas versiones la app debe mostrar diferentes
         * botones de opción con otro tipo de información
         *
         */

        // La otra forma a la anterior ?: = "si es null, usa este otro valor".

        // Se optimizo esta sección pasando el parametro del indicador en la ruta
        composable("indicador/{tipo}") { backStackEntry ->

            val indicador = backStackEntry.arguments?.getString("tipo")

            IndicatorScreen(navController, indicador ?: "No actualizado")
        }

        // otras opciones que no son indicadores
        composable("calc") {
            Calculadora(onBack = { navController.popBackStack() })
        }

        composable("info") {
            Info(
                userName = Globals.userName ?: "Invitado",
                onBack = { navController.popBackStack() })
        }

        composable("analisis") {
            ListaEjemplos(onBack = { navController.popBackStack() })
        }

        composable("weather") {
            Weather(onBack = { navController.popBackStack() })

        }

        composable("textsizeselector") {
            TextSizeSelector (onBack = { navController.popBackStack() })

        }

        composable("colortestcard") {
            ColorTestCard (onBack = { navController.popBackStack() })

        }




    }
}
