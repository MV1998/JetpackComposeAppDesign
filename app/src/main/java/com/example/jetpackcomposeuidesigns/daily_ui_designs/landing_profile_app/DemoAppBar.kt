package com.example.jetpackcomposeuidesigns.daily_ui_designs.landing_profile_app

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoAppBar(onClickBack: () -> Unit,
               pageName : String,
               modifier: Modifier = Modifier) {
    TopAppBar(
        title = {
        Text(pageName, style = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        ))
    }, navigationIcon = {
        IconButton(onClick = onClickBack) {
            Icon(Icons.Filled.ArrowBackIosNew, contentDescription = "",
                tint = Color.Black)
        }
    })
}
