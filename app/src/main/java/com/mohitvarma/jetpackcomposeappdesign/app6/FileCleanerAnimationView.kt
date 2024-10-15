package com.example.compose.rally.app6

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun FileCleanerAnimationView(modifier: Modifier = Modifier) {

    val transition = rememberInfiniteTransition(label = "circular animation")
    val radius = transition.animateFloat(
        initialValue = 300f,
        targetValue = 350f,
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
        Column(
            modifier = modifier.padding(10.dp)
        ) {
            Text(
                "Cleaner", style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                )
            )

            Box {
                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
                ) {
                    drawCircle(
                        radius = 300f,
                        brush = Brush.linearGradient(colors = listOf(Color.Red, Color.Yellow)),
                        style = Stroke(
                            width = 5f
                        )
                    )
                }

                Canvas(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp)
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
}


@Preview
@Composable
private fun FileCleanerAnimationViewPreview() {
    FileCleanerAnimationView()
}
