package com.example.compose.rally.app6

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.ArrowDropUp
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Circle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Stuff(
    val icon: Int,
    val name: String,
    val totalCalculationUnits: String
)

data class StuffCategories(
    val id: Int,
    val totalCalculationUnits: String,
    val name: String,
    val isExpanded: Boolean,
    val list: MutableList<Stuff>? = null
)

@SuppressLint("DefaultLocale")
val data = listOf(
    StuffCategories(
        1,
        "1.8GB",
        "Cache files",
        false,
        list = MutableList(10) { Stuff(1, "Google $it", "${String.format("%.2f", it * 1.2)}GB") }
    ),
    StuffCategories(
        2,
        "0B",
        "Obsolete files",
        false
    ),
    StuffCategories(
        3,
        "0B",
        "Packages",
        false
    ),
    StuffCategories(
        4,
        "0B",
        "Residuals",
        false
    ),
    StuffCategories(
        5,
        "189MB",
        "Memory",
        false,
        list = MutableList(10) { Stuff(1, "Google $it", "${String.format("%.2f", it * 1.2)}GB") }
    )
)

const val circleSize: Int = 400

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FileCleanerAnimationScaffoldView(modifier: Modifier = Modifier) {

    val snapshotList = data.toMutableStateList()

    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    val transition = rememberInfiniteTransition(label = "circular animation")
    val radius = transition.animateFloat(
        initialValue = circleSize.toFloat(),
        targetValue = circleSize.toFloat() + 70f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        ), label = "Radius"
    )

    val alpha = transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        ), label = "Alpha"
    )

    Scaffold(
        containerColor = Color.White,
        modifier = modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            LargeTopAppBar(
                scrollBehavior = scrollBehavior,
                expandedHeight = circleSize.dp,
                collapsedHeight = 0.dp,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = Color.White
                ),
                title = {
                    Column {
                        Text(
                            "Cleaner", style = TextStyle(
                                fontSize = 24.sp,
                                color = Color.Black,
                                fontWeight = FontWeight.Normal
                            ),
                            modifier = modifier.padding(top = 20.dp)
                        )
                        Box {
                            Canvas(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(circleSize.dp)
                            ) {
                                drawCircle(
                                    radius = circleSize.toFloat(),
                                    brush = Brush.linearGradient(
                                        colors = listOf(
                                            Color.Red,
                                            Color.Yellow
                                        )
                                    ),
                                    style = Stroke(
                                        width = 5f
                                    )
                                )
                            }

                            Canvas(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(circleSize.dp)
                            ) {
                                drawCircle(
                                    radius = radius.value,
                                    alpha = alpha.value,
                                    brush = Brush.linearGradient(
                                        colors = listOf(Color.Red, Color.Yellow),
                                        tileMode = TileMode.Repeated
                                    ),
                                    style = Stroke(
                                        width = 2f
                                    )
                                )
                            }

                            Column(
                                modifier = modifier.align(alignment = Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    "208 MB", style = TextStyle(
                                        fontSize = 28.sp,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text("Trash Size")
                            }


                        }
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = modifier
                .padding(padding)
                .padding(10.dp)
        ) {
            itemsIndexed(
                snapshotList,
                key = { _,
                        stuffCategories ->
                    stuffCategories.id
                }) { stuffCategoriesIndex, stuffCategories ->
                CalculatedStuffUnit(stuffCategories.name,
                    stuffCategories.totalCalculationUnits, onRowClick = {
                        snapshotList[stuffCategoriesIndex] =
                            stuffCategories.copy(isExpanded = !stuffCategories.isExpanded)
                    }, isExpanded = stuffCategories.isExpanded
                )
                if (stuffCategories.isExpanded) {
                    stuffCategories.list?.forEach { stuff ->
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(
                                    vertical = 5.dp,
                                    horizontal = 10.dp
                                )
                        ) {
                            Row(verticalAlignment = Alignment.CenterVertically) {
                                Box(
                                    modifier = modifier
                                        .size(50.dp)
                                        .background(
                                            color = Color.LightGray,
                                            shape = RoundedCornerShape(5.dp)
                                        )
                                )
                                Column(
                                    verticalArrangement = Arrangement.Center,
                                    modifier = modifier.padding(start = 10.dp)
                                ) {
                                    Text(
                                        "Google Play Service", overflow = TextOverflow.Ellipsis,
                                        modifier = modifier.paddingFromBaseline(bottom = 10.dp),
                                        style = TextStyle(fontWeight = FontWeight.Bold)
                                    )
                                    Text("Clean")
                                }
                            }

                            Row(
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    stuff.totalCalculationUnits,
                                    style = TextStyle(color = Color.Black)
                                )
                                Icon(
                                    Icons.Filled.CheckCircle,
                                    tint = Color(0xffE84E0A), contentDescription = "",
                                    modifier = modifier.padding(start = 10.dp)
                                )
                            }
                        }
//                        CalculatedStuffUnit(stuff.name, stuff.totalCalculationUnits, onRowClick = {},
//                            isExpanded = true)
                    }
                }
            }
        }
    }
}

@Composable
fun CalculatedStuffUnit(
    stuffName: String,
    stuffUnits: String,
    onRowClick: () -> Unit,
    modifier: Modifier = Modifier,
    isExpanded: Boolean = false
) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp, vertical = 15.dp)
            .clickable { onRowClick() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row {
            Text(
                stuffName,
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
            Icon(
                if (isExpanded) Icons.Filled.ArrowDropUp else Icons.Filled.ArrowDropDown,
                contentDescription = "",
                tint = Color.Gray,
                modifier = modifier.padding(start = 10.dp)
            )
        }
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                stuffUnits,
                style = TextStyle(color = Color.Black)
            )
            Icon(
                if (stuffUnits == "0B") Icons.Filled.Circle else Icons.Filled.CheckCircle,
                tint = if (stuffUnits == "0B") Color.LightGray else Color(0xffE84E0A), contentDescription = "",
                modifier = modifier.padding(start = 10.dp)
            )
        }
    }
}

@Composable
fun FileCleanerAnimationView(modifier: Modifier = Modifier) {

    val transition = rememberInfiniteTransition(label = "circular animation")
    val radius = transition.animateFloat(
        initialValue = circleSize.toFloat(),
        targetValue = circleSize.toFloat() + 100f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        ), label = "Radius"
    )

    val alpha = transition.animateFloat(
        initialValue = 1f,
        targetValue = 0f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1000),
            repeatMode = RepeatMode.Restart
        ), label = "Alpha"
    )

    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = modifier.padding(10.dp)
        ) {
            item {
                Text(
                    "Cleaner", style = TextStyle(
                        fontSize = 24.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.Normal
                    )
                )
            }

            item {
                Box {
                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(circleSize.dp)
                    ) {
                        drawCircle(
                            radius = circleSize.toFloat(),
                            brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow)),
                            style = Stroke(
                                width = 5f
                            )
                        )
                    }

                    Canvas(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(circleSize.dp)
                    ) {
                        drawCircle(
                            radius = radius.value,
                            alpha = alpha.value,
                            brush = Brush.linearGradient(
                                colors = listOf(Color.Red, Color.Yellow),
                                tileMode = TileMode.Repeated
                            ),
                            style = Stroke(
                                width = 2f
                            )
                        )
                    }

                    Column(
                        modifier = modifier.align(alignment = Alignment.Center),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "208 MB", style = TextStyle(
                                fontSize = 28.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text("Trash Size")
                    }


                }
            }
            items(100) {
                Text(it.toString())
            }
        }
    }
}


@Preview
@Composable
private fun FileCleanerAnimationViewPreview() {
    FileCleanerAnimationView()
}

@Preview
@Composable
private fun FileCleanerAnimationScaffoldViewPreview() {
    FileCleanerAnimationScaffoldView()
}
