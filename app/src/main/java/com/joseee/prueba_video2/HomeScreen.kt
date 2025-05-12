package com.joseee.prueba_video2

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun HomeScreen(navController: NavController) {
    val videoTitles = listOf("Video 1", "Video 2", "Video 3", "Video 4")

    Column (modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Selecciona un video", style = MaterialTheme.typography.headlineMedium)

        LazyRow (
            contentPadding = PaddingValues(horizontal = 8.dp, vertical = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(videoTitles.size) { index ->
                Card(
                    modifier = Modifier
                        .width(200.dp)
                        .height(150.dp)
                        .clickable { navController.navigate("video/$index") },
                    shape = RoundedCornerShape(16.dp),
                    elevation = CardDefaults.cardElevation(8.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Text(text = videoTitles[index], fontSize = 20.sp, modifier = Modifier.padding(8.dp))
                    }
                }
            }
        }
    }
}
