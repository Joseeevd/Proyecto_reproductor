package com.joseee.prueba_video2



import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController


@Composable
fun NavigationBar1(navController: NavController, currentRoute: String) {
    NavigationBar {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Videos") },
            label = { Text("Videos") },
            selected = currentRoute == "home",
            onClick = {
                if (currentRoute != "home") {
                    navController.navigate("home") {
                        popUpTo(navController.graph.startDestinationId) { inclusive = true }
                        launchSingleTop = true
                    }
                }
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Favorite, contentDescription = "Audio") },
            label = { Text("Audio") },
            selected = currentRoute == "audio",
            onClick = {
                navController.navigate("audio")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.AccountCircle, contentDescription = "Artistas") },
            label = { Text("Artistas") },
            selected = currentRoute == "galeria",
            onClick = {
                if (currentRoute != "galeria") {
                    navController.navigate("galeria") {
                        launchSingleTop = true
                    }
                }
            }
        )
    }
}

