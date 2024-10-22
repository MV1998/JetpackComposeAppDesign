package com.example.jetpackcomposeuidesigns.daily_ui_designs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class Spending(
    val color : Color = Color.Gray,
    val percentage : Float,
    val startAngle : Float,
    val total : Float = 360f
)

val rotations = listOf(
    Spending(
        color = Color.Red,
        percentage = 81.6f,
        startAngle = 0f,
        total = 360f
    ),
    Spending(
        color = Color.Blue,
        percentage = 122.4f,
        startAngle = 92f,
        total = 360f
    ),
    Spending(
        color = Color.Magenta,
        percentage = 68f,
        startAngle = 225.4f,
        total = 360f
    ),
    Spending(
        color = Color.Yellow,
        percentage = 40.2f,
        startAngle = 305.4f,
        total = 360f
    )
)

@Composable
fun Arc22Oct2024(modifier: Modifier = Modifier) {
    Surface(modifier = modifier.fillMaxSize()) {
        Column(modifier = modifier.padding(top = 10.dp).fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Canvas(
                modifier = Modifier
                    .size(250.dp)
            ) {

                repeat(4) { it ->
                    drawArc(
                        color = rotations[it].color,
                        startAngle = rotations[it].startAngle,
                        sweepAngle = rotations[it].percentage,
                        useCenter = false,
                        style = Stroke(
                            width = 60f,
                            cap = StrokeCap.Round,
//                            join = StrokeJoin.Round
                        )
                    )
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun Arc22Oct2024Preview() {
    Arc22Oct2024()
}