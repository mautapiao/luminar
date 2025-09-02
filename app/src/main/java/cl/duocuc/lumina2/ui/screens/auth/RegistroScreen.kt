package cl.duocuc.lumina2.ui.screens.auth


/* para quitar los errores de it (delegates)*/

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.duocuc.lumina2.data.model.User
import cl.duocuc.lumina2.data.repository.UserRepository
import cl.duocuc.lumina2.ui.screens.lumina.SimpleTopBar
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT
import cl.duocuc.lumina2.ui.theme.FontSizes.BUTTON_TEXT_LABEL
import cl.duocuc.lumina2.ui.theme.FontSizes.TEXT_SIZE_INPUT
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegistroScreen(onRegisterDone: () -> Unit, onBack: () -> Unit) {

    var nombre by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var pais by remember { mutableStateOf("") }
    var aceptarTerminos by remember { mutableStateOf(false) }
    // Combo (dropdown) accesible
    val paises = listOf("Chile", "Argentina", "Perú", "México")
    var paisExpanded by remember { mutableStateOf(false) }
    var paisSelected by remember { mutableStateOf(paises.first()) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = { SimpleTopBar(title = "Regresar", showBack = true, onBack = onBack) },
        snackbarHost = { SnackbarHost(snackbarHostState) }

    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {

            // espacio que ayuda que no quede debajo de la topbar
            Spacer(
                Modifier
                    .height(85.dp)
                    .fillMaxWidth()
            )

            // titulo del compose al usuario
            Text("Registro de Usuario", style = MaterialTheme.typography.headlineMedium)

            // entrada del campo nombre completo
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre", fontSize = BUTTON_TEXT_LABEL.sp) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(fontSize = TEXT_SIZE_INPUT.sp)
            )

            // espacio entre cmapos de entrada
            Spacer(Modifier.height(20.dp))

            // entrada del campo email
            OutlinedTextField(
                value = email,
                onValueChange = { email = it.lowercase() },
                label = { Text("Correo electrónico", fontSize = BUTTON_TEXT_LABEL.sp) },
                modifier = Modifier.fillMaxWidth(),
                textStyle = LocalTextStyle.current.copy(fontSize = TEXT_SIZE_INPUT.sp)
            )

            // espacio entre los campos
            Spacer(Modifier.height(20.dp))

            /**
             * Entrada de contraseña:
             * Falta un campo adicional para repetir contraseña
             * Falta un switch para mostrar u ocultar contraseña
             */

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text("Contraseña", fontSize = BUTTON_TEXT_LABEL.sp) },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                textStyle = LocalTextStyle.current.copy(fontSize = TEXT_SIZE_INPUT.sp)
            )

            // espacio entre los campos
            Spacer(Modifier.height(20.dp))

            // Combo simple para país
            ExposedDropdownMenuBox(
                expanded = paisExpanded,
                onExpandedChange = { paisExpanded = !paisExpanded }
            ) {
                OutlinedTextField(
                    value = paisSelected,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("País", fontSize = BUTTON_TEXT_LABEL.sp) },
                    trailingIcon = {
                        ExposedDropdownMenuDefaults.TrailingIcon(expanded = paisExpanded)
                    },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth(),

                    textStyle = LocalTextStyle.current.copy(fontSize = TEXT_SIZE_INPUT.sp)
                )
                ExposedDropdownMenu(
                    expanded = paisExpanded,
                    onDismissRequest = { paisExpanded = false }
                ) {
                    paises.forEach { opcion ->
                        DropdownMenuItem(
                            text = { Text(opcion, fontSize = BUTTON_TEXT_LABEL.sp) },
                            onClick = {
                                paisSelected = opcion
                                paisExpanded = false
                            }
                        )
                    }
                }
            }

            // espacio entre los elementos
            Spacer(Modifier.height(20.dp))

            //  checkbox para aceptar los terminos
            Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Checkbox(
                    checked = aceptarTerminos,
                    onCheckedChange = { aceptarTerminos = it }
                )
                Text("Acepto los términos y condiciones", style = MaterialTheme.typography.headlineMedium)
            }

            // espacio entre elementos
            Spacer(Modifier.height(20.dp))

//            // boton Registrarse, todos los campos son requeridos
//            Button(
//                onClick = {
//
//                    // INICIO DE LA VALIDACIÓN
//                    if (nombre.isBlank() || email.isBlank() || password.isBlank() || pais.isBlank()) {
//                        // si algún campo está vacío o solo tiene espacios en blanco
//                        scope.launch {
//                            snackbarHostState.showSnackbar("Por favor, completa todos los campos")
//                        }
//                        return@Button // detenemos la ejecución aquí
//                    }
//                    // FIN DE LA VALIDACIÓN
//
//                    // creamos el objeto usurio
//                    val nuevoUsuario = User(
//                        name = nombre,
//                        email = email,
//                        password = password,
//                        country = pais
//                    )
//                    // registramos y esperamos el resultado
//                    val registrado = UserRepository.register(nuevoUsuario)
//
//                    scope.launch {
//                        if (registrado) {
//                            snackbarHostState.showSnackbar("Usuario registrado con éxito")
//
//                            onRegisterDone() // acción de callback por ejemplo navegar a otra pantalla
//                        } else {
//                            snackbarHostState.showSnackbar("El correo ya existe")
//                        }
//                    }
//                },
//                modifier = Modifier.fillMaxWidth(),
//                enabled = aceptarTerminos
//            ) {
//                Text("Registrarse", fontSize = 18.sp)
//            }


            Button(
                onClick = {

                    // INICIO DE LA VALIDACIÓN
                    if (nombre.isBlank() || email.isBlank() || password.isBlank() || pais.isBlank()) {
                        // si algún campo está vacío o solo tiene espacios en blanco
                        scope.launch {
                            snackbarHostState.showSnackbar("Por favor, completa todos los campos")
                        }
                        return@Button // detenemos la ejecución aquí
                    }
                    // FIN DE LA VALIDACIÓN

                    // creamos el objeto usurio
                    val nuevoUsuario = User(
                        name = nombre,
                        email = email,
                        password = password,
                        country = pais
                    )
                    // registramos y esperamos el resultado
                    val registrado = UserRepository.register(nuevoUsuario)

                    scope.launch {
                        if (registrado) {
                            snackbarHostState.showSnackbar("Usuario registrado con éxito")

                            onRegisterDone() // acción de callback por ejemplo navegar a otra pantalla
                        } else {
                            snackbarHostState.showSnackbar("El correo ya existe")
                        }
                    }
                },
                //  modifier = Modifier.fillMaxWidth()
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                enabled = aceptarTerminos,
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 8.dp)
            ) {
                Text("Registrarse", fontSize = BUTTON_TEXT.sp)
            }


        }
    }
}