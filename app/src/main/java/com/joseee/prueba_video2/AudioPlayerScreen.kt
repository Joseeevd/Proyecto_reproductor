package com.joseee.prueba_video2

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.media3.common.MediaItem
import androidx.media3.exoplayer.ExoPlayer
import androidx.navigation.NavController

@Composable
fun AudioPlayerScreen(audioIndex: Int, navController: NavController) {
    val context = LocalContext.current

    val audioTitles = listOf("Canción 1", "Canción 2", "Canción 3")
    val audioResIds = listOf(R.raw.track1)

    val player = remember {
        ExoPlayer.Builder(context).build().apply {
            val mediaItem = MediaItem.fromUri(
                "android.resource://${context.packageName}/${audioResIds[audioIndex]}"
            )
            setMediaItem(mediaItem)
            prepare()
            play()
        }
    }

    DisposableEffect(Unit) {
        onDispose { player.release() }
    }

    var isPlaying by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Reproduciendo:",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = audioTitles[audioIndex],
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(32.dp))

        Row (horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            Button(onClick = {
                player.play()
                isPlaying = true
            }) {
                Text("▶️ Play")
            }

            Button(onClick = {
                player.pause()
                isPlaying = false
            }) {
                Text("⏸️ Pause")
            }

            Button(onClick = {
                player.seekTo(0)
                player.pause()
                isPlaying = false
            }) {
                Text("⏹️ Stop")
            }
        }

        Spacer(modifier = Modifier.height(40.dp))

        Button(onClick = { navController.popBackStack() }) {
            Text("⬅️ Regresar")
        }
    }
}

