package cl.duocuc.lumina2.ui.screens.lumina

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp


// TopBar reutilizable (muestra botón "Atrás" cuando no estamos en Login)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleTopBar(
    title: String,
    showBack: Boolean,
    onBack: (() -> Unit)? = null,
    onSettings: (() -> Unit)? = null,
    onMenu: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(
                title,
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold
            )
        },
        navigationIcon = {
            if (showBack) {
                IconButton(onClick = { onBack?.invoke() }) {
                    Icon(Icons.Filled.ArrowBack, contentDescription = "Atrás")
                }
            } else {
                IconButton(onClick = { onMenu?.invoke() }) {
                    Icon(Icons.Filled.Menu, contentDescription = "Menú")
                }
            }
        },
        actions = {
            IconButton(onClick = { onSettings?.invoke() }) {
                Icon(Icons.Filled.Settings, contentDescription = "Ajustes")
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.onSecondary,    // primary
            titleContentColor = MaterialTheme.colorScheme.secondary,  // onPrimary
            navigationIconContentColor = MaterialTheme.colorScheme.secondary, //onPrimary
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary
        )
    )
}
