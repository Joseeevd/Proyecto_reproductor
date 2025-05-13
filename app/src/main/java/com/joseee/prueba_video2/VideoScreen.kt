package com.joseee.prueba_video2

import android.net.Uri
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@ExperimentalMaterial3Api
@Composable
fun VideoScreen(videoId: Int, navController: NavController) {
    val context = LocalContext.current

    val videoTitles = listOf(
        "Video 1", "Video 2", "Video 3", "Video 4",
        "De música ligera - Soda Stereo", "Flaca - Andrés Calamaro", "Lucha de gigantes - Nacha pop")
    val videoResIds = listOf(
        R.raw.video1, R.raw.video2, R.raw.video3, R.raw.video4,
        R.raw.video5, R.raw.video6, R.raw.video7
    )

    val videoUri = Uri.parse("android.resource://${context.packageName}/${videoResIds[videoId]}")

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(videoTitles[videoId]) },
                navigationIcon = {
                    IconButton (onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) {
        Column (
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            VideoPlayer(uri = videoUri, modifier = Modifier.fillMaxWidth().height(200.dp))

            Text("Estás viendo: ${videoTitles[videoId]}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}
