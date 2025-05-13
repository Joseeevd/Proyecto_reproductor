package com.joseee.prueba_video2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import androidx.compose.runtime.getValue

import com.joseee.prueba_video2.ui.theme.Prueba_video2Theme

@ExperimentalMaterial3Api
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            App()
        }
    }
}

@ExperimentalMaterial3Api
@Composable
fun App() {

    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route ?: ""

    NavHost(navController, startDestination = "home") {
        composable("home") {
            Scaffold (
                bottomBar = { NavigationBar1(navController, currentRoute = currentRoute) }
            ) { innerPadding ->
                HomeScreen(navController = navController, modifier = Modifier.padding(innerPadding))
            }
        }

        composable(
            "video/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getInt("videoId") ?: 0
            VideoScreen(videoId = videoId, navController = navController)
        }

        composable("galeria"){

            Scaffold (
                bottomBar = { NavigationBar1(navController, currentRoute = currentRoute) }
            ) { innerPadding ->
                ArtistsGallery(navController = navController, modifier = Modifier.padding(innerPadding))
            }

        }

        composable("audio"){
            Scaffold (
                bottomBar = { NavigationBar1(navController, currentRoute = currentRoute) }
            ) { innerPadding ->
                AudioListScreen(navController = navController, modifier = Modifier.padding(innerPadding))
            }
        }

        composable("audio/{audioIndex}") { backStackEntry ->
            val index = backStackEntry.arguments?.getString("audioIndex")?.toInt() ?: 0
            AudioPlayerScreen(audioIndex = index, navController)
        }
    }
}



