package com.mohitvarma.jetpackcomposeappdesign.app1

import android.util.Log
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun DemoUIHost(controller: NavHostController, modifier: Modifier) {
    NavHost(
        navController = controller,
        startDestination = "LandingPage",
        modifier = modifier
    ) {
        composable(route = "LandingPage", enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(600)
            )
        }, exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.Right,
                animationSpec = tween(600)
            )
        }) {
            LandingPage(onSignUpClick = {
                controller.navigate(route = "ProfilePage") {
                    launchSingleTop = true
                    restoreState = true
                }
            }, onLoginClick = {
                Log.d("TAG", "onLoginClick: ")
            })
        }

        composable(
            route = "ProfilePage"
        ) {
            ProfilePage(
                onClickBack = {
                    controller.popBackStack(route = "LandingPage", inclusive = false)
                }, navigateToAccountSetting = {
                    controller.navigate(route = "AccountSettingPage") {
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }

        composable(
            route = "AccountSettingPage"
        ) {
            AccountSettingPage(onClickBack = {
                controller.popBackStack(route = "ProfilePage", inclusive = false)
            })
        }
    }
}