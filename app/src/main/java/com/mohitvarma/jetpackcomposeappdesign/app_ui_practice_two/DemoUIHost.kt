package com.mohitvarma.jetpackcomposeappdesign.app_ui_practice_two

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun DemoUIHost(navHostController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navHostController,
        startDestination = "LandingPage1",
        modifier = modifier) {
        composable(route = "LandingPage1") {

        }
    }
}