package com.mohitvarma.jetpackcomposeappdesign.app1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohitvarma.jetpackcomposeappdesign.R

@Composable
fun AccountSettingPage(
    onClickBack: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(
        color = Color(0xffF5F5F5),
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DemoAppBar(onClickBack = onClickBack, "Get Pro")


            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold, fontSize = 18.sp,
                        color = Color.Black
                    )
                ) {
                    append("$8.5 USD / ")
                }
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal, fontSize = 18.sp,
                        color = Color.Gray
                    )
                ) {
                    append("Limited Offer")
                }
            }, modifier = modifier.padding(top = 40.dp))


            Text(
                "Finding The Right Job Made Easy With Tract Job",
                modifier = modifier
                    .padding(top = 60.dp)
                    .width(270.dp),
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 32.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.Black
                )
            )


            Spacer(
                modifier = modifier
                    .padding(top = 60.dp)
                    .padding(horizontal = 20.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
            )


            Row(
                modifier = modifier
                    .padding(top = 5.dp)
                    .padding(horizontal = 20.dp)
            ) {
                Statistic(
                    "8K",
                    "Top Mnc",
                    modifier = modifier.weight(.5f)
                )
                HorizontalDivider(
                    modifier = modifier
                        .fillMaxHeight(.1f)
                        .width(1.dp),
                    color = Color.Gray
                )
                Statistic(
                    "54K",
                    "Jobs Inside",
                    modifier = modifier
                        .weight(.5f)
                )
            }

            Spacer(
                modifier = modifier
                    .padding(top = 5.dp)
                    .padding(horizontal = 20.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
            )

            PersonDesignationSection(
                R.drawable.account_setting_profile,
                "Jr. Emma Anniston",
                "Customer Support"
            )

            Button(
                onClick = {},
                shape = CircleShape,
                modifier = modifier
                    .padding(top = 40.dp)
                    .width(150.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF9C9DF3)
                )
            ) {
                Text(
                    "Activated", style = TextStyle(
                        fontSize = 18.sp,
                        color = Color.Black,
                        fontWeight = FontWeight.ExtraBold
                    )
                )
            }

            Text(buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Bold, fontSize = 18.sp,
                        color = Color.Black,
                        textDecoration = TextDecoration.Underline
                    )
                ) {
                    append("See How It Works")
                }
            }, modifier = modifier.padding(top = 40.dp))
        }
    }
}


@Preview
@Composable
private fun AccountSettingPagePreview() {
    AccountSettingPage(onClickBack = {})
}