package com.example.jetpackcomposeuidesigns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.AttendanceUI
import com.example.jetpackcomposeuidesigns.daily_ui_designs.recipe_app.ModifierPractice
import com.example.jetpackcomposeuidesigns.daily_ui_designs.recipe_app.ModifierPractice3
import com.example.jetpackcomposeuidesigns.dagger_based_projects.Car
import com.example.jetpackcomposeuidesigns.dagger_based_projects.DaggerCarFactory

import com.example.jetpackcomposeuidesigns.ui.theme.JetpackComposeUIDesignsTheme
import dagger.Lazy
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var car : Lazy<Car>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerCarFactory.create().inject(this)


        car.get().speedUp()
            setContent {
                //RallyApp()
                // DemoUIApp()
//            Surface(modifier = Modifier.fillMaxSize()) {
//                AppUI()
//            }

                //MultiHeaderView()

                JetpackComposeUIDesignsTheme {
                   AttendanceUI()

                   // FileCleanerAnimationView()

                   // FileCleanerAnimationScaffoldView()
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
