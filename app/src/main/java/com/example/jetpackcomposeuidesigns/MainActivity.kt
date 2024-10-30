package com.example.jetpackcomposeuidesigns

import android.Manifest
import android.annotation.SuppressLint
import android.app.job.JobInfo
import android.app.job.JobScheduler
import android.content.ComponentName
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.jetpackcomposeuidesigns.broadcast_receivers.WiFiBroadCastListener
import com.example.jetpackcomposeuidesigns.daily_ui_designs.recipe_app.ModifierPractice
import com.example.jetpackcomposeuidesigns.daily_ui_designs.recipe_app.ModifierPractice3
import com.example.jetpackcomposeuidesigns.dagger_based_projects.Car
import com.example.jetpackcomposeuidesigns.dagger_based_projects.DaggerCarFactory
import com.example.jetpackcomposeuidesigns.daily_ui_designs.FinancialMobileApp22Oct2024
import com.example.jetpackcomposeuidesigns.daily_ui_designs.MyntraProductUI23Oct2024
import com.example.jetpackcomposeuidesigns.services.foreground_services.TimerServiceUI

import com.example.jetpackcomposeuidesigns.ui.theme.JetpackComposeUIDesignsTheme
import dagger.Lazy
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var car : Lazy<Car>

    @SuppressLint("NewApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        DaggerCarFactory.create().inject(this)


        car.get().speedUp()
            setContent {
                //window.isNavigationBarContrastEnforced = false
                //RallyApp()
                // DemoUIApp()
//            Surface(modifier = Modifier.fillMaxSize()) {
//                AppUI()
//            }

                //MultiHeaderView()

                JetpackComposeUIDesignsTheme {
                   //AttendanceUI()
                    MyntraProductUI23Oct2024()
                    //FinancialMobileApp22Oct2024()
                   // FileCleanerAnimationView()

                   // FileCleanerAnimationScaffoldView()
                   // TimerServiceUI()
                }


            }
    }
}


@Composable
fun DemoUIApp() {
    JetpackComposeUIDesignsTheme {
        val pagerState = rememberPagerState(pageCount = { 3 })
        val list = listOf(
            listOf(R.drawable.veg1, Color(0xff6FC14A), Color(0xffF5AF3B)),
            listOf(R.drawable.veg2, Color(0xffF5AF3B), Color(0xffCC3844))
        )
        HorizontalPager(state = pagerState) { page ->
            if (page == 2) {
                ModifierPractice3()
            } else {
                ModifierPractice(
                    image = list[page][0] as Int,
                    color1 = list[page][1] as Color,
                    color2 = list[page][2] as Color
                )
            }
        }
    }
}


fun NavHostController.navigateSingleTopTo(route: String) {
    this.navigate(route) {
        popUpTo(this@navigateSingleTopTo.graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
}

fun fetchMobileList(name : (String) -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed(
         {
             Log.d("TAG", "Print: ")
         }, 1000
    )
}