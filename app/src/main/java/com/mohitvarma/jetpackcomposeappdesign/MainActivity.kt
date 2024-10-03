package com.mohitvarma.jetpackcomposeappdesign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.mohitvarma.jetpackcomposeappdesign.app1.DemoUIHost
import com.mohitvarma.jetpackcomposeappdesign.ui.theme.JetpackComposeAppDesignTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemoUIApp()
        }
    }
}

@Composable
fun DemoUIApp() {
    JetpackComposeAppDesignTheme {
        val navController = rememberNavController()

        Scaffold { padding ->
            DemoUIHost(navController, modifier = Modifier.padding(padding))
        }
    }
}