package com.example.jetpackcomposeuidesigns.daily_ui_designs

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsTopHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.BookmarkBorder
import androidx.compose.material.icons.filled.FormatPaint
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.SignLanguage
import androidx.compose.material.icons.filled.VideogameAsset
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FinancialMobileApp22Oct2024(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier
            .fillMaxSize()
    ) {
        val offset = remember {
            mutableStateOf(Offset(0f, 150f))
        }
        val clickedArcId = remember {
            mutableIntStateOf(-1)
        }
        val canvasSize = remember {
            mutableStateOf(Size(0f, 0f))
        }
        val selectedTransactionTenure = remember {
            mutableStateOf(transactionTenureList[transactionTenureList.size - 1])
        }
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(
                modifier = modifier
                    .windowInsetsTopHeight(insets = WindowInsets.statusBars)
            )
            Row(
                modifier = modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(onClick = {}) {
                    Icon(Icons.Default.ArrowBackIosNew, contentDescription = null)
                }
                Text(
                    "Analytics",
                    style = boldTextStyle
                )
                IconButton(onClick = {}) {
                    Icon(Icons.Default.Settings, contentDescription = null)
                }
            }
            Box(
                modifier = modifier.safeContentPadding()
            ) {
                Canvas(
                    modifier = Modifier
                        .size(220.dp)
                        .pointerInput(Unit) {
                            detectTapGestures(
                                onTap = { offset ->
                                })
                        }
                ) {
                    canvasSize.value = size
                    repeat(rotations.size) { it ->
                        drawArc(
                            color = rotations[it].color,
                            startAngle = rotations[it].startAngle,
                            sweepAngle = rotations[it].sweepAngle,
                            useCenter = false,
                            style = Stroke(
                                width =
                                if (it == clickedArcId.intValue) 80f else 60f
                            )
                        )
                    }
                }
                Text(
                    "\$12,459.54", modifier = modifier.align(Alignment.Center),
                    style = TextStyle(
                        fontSize = 28.sp, color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                )
            }

            LazyRow(
                modifier = modifier.padding(bottom = 10.dp)
            ) {
                items(transactionTenureList) { item ->
                    Box(
                        modifier = modifier
                            .padding(5.dp)
                            .background(
                                color =
                                if (selectedTransactionTenure.value == item)
                                    Color.Black else Color(0xffF5F3F3), shape = CircleShape
                            )
                            .padding(horizontal = 20.dp, vertical = 15.dp)
                            .clickable {
                                selectedTransactionTenure.value = item
                            }
                    ) {
                        Text(
                            item.tenure,
                            style = TextStyle(
                                color =
                                if (selectedTransactionTenure.value == item)
                                    Color.White else Color.Black
                            )
                        )
                    }
                }
            }

//            Canvas(
//                modifier = Modifier
//                    .padding(top = 50.dp)
//                    .fillMaxWidth()
//                    .height(200.dp)
//            ) {
//
//                var from = offset.value
//                var end = Offset(50f, 0f)
//                repeat(25) {
//                    if (it >= 1) {
//                        end = Offset(
//                            from.x + 50,
//                            Random.nextInt(0, 300).toFloat()
//                        )
//                    }
//                    drawLine(
//                        start = from, end = end, color = Color.Blue,
//                        strokeWidth = 5f, cap = StrokeCap.Square
//                    )
//                    from = end
//                }
//            }

//            Button(
//                onClick = {
//                    offset.value = Offset(
//                        0f,
//                        Random.nextInt(0, 300).toFloat()
//                    )
//                }) { Text("Change") }

            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text("Transactions", style = boldTextStyle)
                Text(
                    "See All", style = boldTextStyle.copy(
                        color = Color.LightGray,
                        fontSize = 18.sp
                    )
                )
            }

            LazyColumn {
                items(transactionList) { item ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp, vertical = 10.dp)
                    ) {
                        Row(
                            modifier = modifier.wrapContentSize(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                item.icon, contentDescription = null,
                                modifier = modifier.padding(end = 10.dp)
                            )
                            Text(
                                item.title, style = boldTextStyle.copy(
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.Normal
                                )
                            )
                        }
                        Text(
                            item.expense, style = boldTextStyle.copy(
                                fontSize = 18.sp
                            )
                        )
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun FinancialMobileApp22Oct2024Preview() {
    FinancialMobileApp22Oct2024()
}

data class ArcData(
    val id: Int,
    val color: Color = Color.Gray,
    val sweepAngle: Float,
    val startAngle: Float,
    val total: Float = 360f
)

val rotations = listOf(
    ArcData(
        id = 0,
        color = Color(0xff3DFFC8),
        sweepAngle = 81.6f,
        startAngle = 0f,
        total = 360f
    ),
    ArcData(
        id = 1,
        color = Color(0xffAFFF6D),
        sweepAngle = 122.4f,
        startAngle = 83f,
        total = 360f
    ),
    ArcData(
        id = 2,
        color = Color(0xffF5D179),
        sweepAngle = 68f,
        startAngle = 206.4f,
        total = 360f
    ),
    ArcData(
        id = 3,
        color = Color(0xff7994F5),
        sweepAngle = 40.2f,
        startAngle = 275.4f,
        total = 360f
    ),
    ArcData(
        id = 4,
        color = Color(0xffA179F5),
        sweepAngle = 42f,
        startAngle = 317f,
        total = 360f
    )
)

data class TransactionTenure(
    val tenure: String,
    val id: Int,
)

val transactionTenureList = listOf(
    TransactionTenure(
        tenure = "1 Week",
        id = 0
    ),
    TransactionTenure(
        tenure = "1 Month",
        id = 1
    ),
    TransactionTenure(
        tenure = "6 Months",
        id = 2
    ),
    TransactionTenure(
        tenure = "1 Year",
        id = 3
    ),
    TransactionTenure(
        tenure = "3 Years",
        id = 4
    ),
    TransactionTenure(
        tenure = "All",
        id = 5
    )
)

val boldTextStyle = TextStyle(
    fontWeight = FontWeight.Bold,
    color = Color.Black,
    fontSize = 24.sp
)

data class Transaction(
    val icon: ImageVector,
    val title: String,
    val expense: String
)

val transactionList = listOf(
    Transaction(
        Icons.Default.BookmarkBorder,
        "Skylight Book",
        "\$455.23"
    ),
    Transaction(
        Icons.Default.ShoppingCart,
        "Walmart",
        "\$25.87"
    ),
    Transaction(
        Icons.Default.VideogameAsset,
        "Xbox Game",
        "\$45.12"
    ),
    Transaction(
        Icons.Default.SignLanguage,
        "Langer's",
        "\$55.89"
    ),
    Transaction(
        Icons.Default.FormatPaint,
        "Soho Art",
        "\$2,455.67"
    )
)