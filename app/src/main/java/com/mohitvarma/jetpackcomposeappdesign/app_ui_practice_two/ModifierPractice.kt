package com.mohitvarma.jetpackcomposeappdesign.app_ui_practice_two

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTime
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.PieChart
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohitvarma.jetpackcomposeappdesign.R


@Composable
fun ModifierPractice(
    @DrawableRes image: Int,
    color1: Color,
    color2: Color,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier.fillMaxSize()) {
        Row(modifier = modifier.matchParentSize()) {
            Spacer(
                modifier = modifier
                    .weight(3f)
                    .fillMaxSize()
                    .background(color = color1)
            )
            Spacer(
                modifier = modifier
                    .weight(1f)
                    .fillMaxSize()
                    .background(color = color2)
            )
        }
        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Filled.ArrowBackIosNew, contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(30.dp)
            )
            Icon(
                Icons.Default.HeartBroken, contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(30.dp)
            )
        }

        Column(
            modifier = modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.8f)
                .background(color = Color.White, shape = RoundedCornerShape(10.dp))
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(image),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth(1f)
                    .fillMaxHeight(.6f)
                    .clip(shape = RoundedCornerShape(10.dp)),
                contentScale = ContentScale.Crop
            )
            Text(
                "Tempeh Lettuce Wraps",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black,
                    baselineShift = BaselineShift(.3f)
                )
            )
            Row(modifier = modifier.padding(bottom = 30.dp)) {
                Icon(Icons.Default.StarRate, contentDescription = null)
                Icon(Icons.Default.StarRate, contentDescription = null)
                Icon(Icons.Default.StarRate, contentDescription = null)
                Icon(Icons.Default.StarRate, contentDescription = null)
                Icon(Icons.Default.StarOutline, contentDescription = null)
            }
            Text(
                "These easy lettuce wraps are a fresh simple choice to add protien and flavor to your day.",
                style = TextStyle(
                    fontWeight = FontWeight.Normal,
                    color = Color.LightGray,
                ),
                modifier = modifier.fillMaxWidth(.6f),
                textAlign = TextAlign.Center
            )
            Row(
                modifier = modifier.padding(top = 30.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        Icons.Filled.AccessTime,
                        tint = color1,
                        contentDescription = null,
                        modifier = modifier
                            .size(40.dp)
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        "10 Minutes", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }
                Spacer(modifier = modifier.fillMaxWidth(.15f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Filled.PieChart,
                        tint = color1,
                        contentDescription = null,
                        modifier = modifier
                            .size(40.dp)
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        "2-4 Portions", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.Black
                        )
                    )
                }
            }
        }
    }
}


@Composable
fun ModifierPractice3(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(modifier = modifier.fillMaxSize()) {
            Spacer(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(.7f)
                    .background(color = Color(0xffCC3844))
            )
            Spacer(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(color = Color.White)
            )
        }

        Row(
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                Icons.Filled.ArrowBackIosNew, contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(30.dp)
            )
            Icon(
                Icons.Default.HeartBroken, contentDescription = null,
                tint = Color.White,
                modifier = modifier.size(30.dp)
            )
        }
        Column(
            modifier = modifier
                .fillMaxWidth(.9f)
                .fillMaxHeight(.9f)
                .padding(top = 10.dp)
                .align(alignment = Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                "Berry Oatmeal",
                style = TextStyle(
                    fontSize = 28.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White,
                    baselineShift = BaselineShift(.3f)
                )
            )
            Row(modifier = modifier.padding(bottom = 20.dp)) {
                Icon(
                    Icons.Default.StarRate, contentDescription = null,
                    tint = Color.White
                )
                Icon(
                    Icons.Default.StarRate, contentDescription = null,
                    tint = Color.White
                )
                Icon(
                    Icons.Default.StarRate, contentDescription = null,
                    tint = Color.White
                )
                Icon(
                    Icons.Default.StarRate, contentDescription = null,
                    tint = Color.White
                )
                Icon(
                    Icons.Default.StarOutline, contentDescription = null,
                    tint = Color.White
                )
            }
            Row(
                modifier = modifier.padding(top = 5.dp)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Icon(
                        Icons.Filled.AccessTime,
                        tint = Color.White,
                        contentDescription = null,
                        modifier = modifier
                            .size(40.dp)
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        "10 Minutes", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
                Spacer(modifier = modifier.fillMaxWidth(.4f))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Icon(
                        Icons.Filled.PieChart,
                        tint = Color.White,
                        contentDescription = null,
                        modifier = modifier
                            .size(40.dp)
                            .padding(bottom = 5.dp)
                    )
                    Text(
                        "2 Portions", style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }
            }

            Image(
                painter = painterResource(R.drawable.veg4),
                contentDescription = null,
                modifier = modifier
                    .fillMaxWidth(.6f)
                    .fillMaxHeight(.4f)
                    .padding(top = 20.dp)
            )

            Spacer(
                Modifier
                    .height(30.dp)
                    .width(2.dp)
                    .background(color = Color.LightGray)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "1/2 c.", modifier = modifier.weight(.5f),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(R.drawable.veg4),
                    contentDescription = null, modifier = modifier
                        .size(70.dp)
                        .weight(1f),
                    contentScale = ContentScale.Inside
                )
                Text(
                    "Quick and easy oatmeal",
                    textAlign = TextAlign.Center,
                    modifier = modifier.weight(.5f)
                )
            }

            Spacer(
                Modifier
                    .height(30.dp)
                    .width(2.dp)
                    .background(color = Color.LightGray)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "1/2 tbsp.", modifier = modifier.weight(.5f),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(R.drawable.veg4),
                    contentDescription = null, modifier = modifier
                        .size(70.dp)
                        .weight(1f),
                    contentScale = ContentScale.Inside
                )
                Text(
                    "Walnuts",
                    textAlign = TextAlign.Center,
                    modifier = modifier.weight(.5f)
                )
            }

            Spacer(
                Modifier
                    .height(30.dp)
                    .width(2.dp)
                    .background(color = Color.LightGray)
            )

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    "1/2 tbsp.", modifier = modifier.weight(.5f),
                    textAlign = TextAlign.Center
                )
                Image(
                    painter = painterResource(R.drawable.veg4),
                    contentDescription = null, modifier = modifier
                        .size(70.dp)
                        .weight(1f),
                    contentScale = ContentScale.Inside
                )
                Text(
                    "Berries to taste",
                    textAlign = TextAlign.Center,
                    modifier = modifier.weight(.5f)
                )
            }
        }
    }
}

@Preview
@Composable
private fun ModifierPracticePreview3() {
    ModifierPractice3()
}

@Preview
@Composable
private fun ModifierPracticePreview1() {
    ModifierPractice(
        image = R.drawable.veg1,
        color1 = Color(0xff6FC14A),
        color2 = Color(0xffCC3844)
    )
}

@Preview
@Composable
private fun ModifierPracticePreview2() {
    ModifierPractice(
        image = R.drawable.veg2,
        color1 = Color(0xffCC3844),
        color2 = Color(0xffF5AF3B)
    )
}