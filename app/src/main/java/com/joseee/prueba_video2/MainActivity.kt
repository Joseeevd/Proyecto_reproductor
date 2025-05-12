package com.joseee.prueba_video2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

//import com.joseee.prueba_video2.ui.theme.Prueba_video2Theme

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

    NavHost(navController, startDestination = "home") {
        composable("home") {
            HomeScreen(navController)
            NavigationBar1(navController = navController)
        }
        composable(
            "video/{videoId}",
            arguments = listOf(navArgument("videoId") { type = NavType.IntType })
        ) { backStackEntry ->
            val videoId = backStackEntry.arguments?.getInt("videoId") ?: 0
            VideoScreen(videoId = videoId, navController = navController)
        }
        composable("galeria"){
            ArtistsGallery()
            NavigationBar1(navController = navController)
        }
    }
}


@ExperimentalMaterial3Api
@Preview
@Composable
fun preview(){
    App()
}



