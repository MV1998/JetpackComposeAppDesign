package com.example.jetpackcomposeuidesigns.services.foreground_services

import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext

@Composable
fun TimerServiceUI(modifier: Modifier = Modifier) {

    val context = LocalContext.current

    val intent = Intent(context, TimerService::class.java)

    Surface(modifier = modifier.fillMaxSize()) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(onClick = {
                context.startService(intent)
            }) {
                Text("Start Timer")
            }

            Button(onClick = {
                context.stopService(intent)
            }) {
                Text("Stop Timer")
            }
        }
    }
}