package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import cl.duocuc.lumina2.data.local.FakeIndicators
import cl.duocuc.lumina2.data.repository.UserRepository
import cl.duocuc.lumina2.ui.screens.auth.LoginScreen
import cl.duocuc.lumina2.ui.screens.auth.RecuperarPasswordScreen
import cl.duocuc.lumina2.ui.screens.auth.RegistroScreen

@Composable
fun MyApp() {
    val navController = rememberNavController()

    // cargo los 5 usuarios creados por defectos en el array modelo User repo User
    androidx.compose.runtime.LaunchedEffect(Unit) {
        // repository funcion para crear usuarios por defecto
        UserRepository.seedDefaultsIfEmpty()
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
        composable("uf") {

            // fecha del dia
            val todayIndicator = FakeIndicators.getTodayIndicator()

            // si la fecha es distinta a null enviar array
            if (todayIndicator != null) {
                UfScreen(navController, todayIndicator)
            } else {
                // último disponible o mensaje no deberia ocurrir
                UfScreen(navController, FakeIndicators.indicators.last())
            }

        }

        //  la otra opcion ?: = "si es null, usa este otro valor".
        composable("ipc") {
            val todayIndicator = FakeIndicators.getTodayIndicator()
            IpcScreen(navController, todayIndicator ?: FakeIndicators.indicators.last())
        }
        composable("utm") {
            val todayIndicator = FakeIndicators.getTodayIndicator()
            UtmScreen(navController, todayIndicator ?: FakeIndicators.indicators.last())
        }
        composable("dolar") {
            val todayIndicator = FakeIndicators.getTodayIndicator()
            DolarScreen(navController, todayIndicator ?: FakeIndicators.indicators.last())
        }

        // recfactorizar una vez analizados que otros "widget" que son necesarios
    }

}
