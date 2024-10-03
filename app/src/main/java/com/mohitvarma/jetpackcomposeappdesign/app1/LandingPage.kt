package com.mohitvarma.jetpackcomposeappdesign.app1

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mohitvarma.jetpackcomposeappdesign.R

@Composable
fun LandingPage(
    onSignUpClick: () -> Unit,
    onLoginClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Surface(color = Color(0xffF5F5F5)) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.fillMaxSize()
        ) {

            Text(
                "Get Started",
                modifier = modifier.padding(top = 20.dp),
                style = TextStyle(
                    fontSize = 24.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )

            Image(
                painter = painterResource(R.drawable.landing_background),
                "background_image", modifier = modifier
                    .padding(top = 40.dp)
                    .height(375.dp)
                    .fillMaxWidth(),
                contentScale = ContentScale.Crop
            )

            Text("Track Job Pro",
                modifier = modifier.padding(top = 20.dp),
                style = TextStyle(
                fontSize = 28.sp,
                color = Color.Black,
                fontWeight = FontWeight.ExtraBold
            ))

            Text("Get the Job Instantly Based On Your Need",
                style = TextStyle(
                fontSize = 18.sp,
                color = Color.Black,
                fontWeight = FontWeight.Normal,
                baselineShift = BaselineShift(.5f),
                textAlign = TextAlign.Center,
            ), modifier = modifier
                .padding(top = 20.dp)
                .width(240.dp)
            )

            Button(onClick = onSignUpClick,
                shape = CircleShape,
                modifier = modifier
                    .padding(top = 40.dp)
                    .width(150.dp)
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xffCAFB5C)
                )) {
                Text("SignUp", style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold
                ))
            }

            Row(
                modifier = modifier.padding(top = 40.dp)
            ) {
                Text("Already have an account? ", style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Normal
                ))
                Text("Login", style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                ), modifier = modifier.clickable { onLoginClick() })
            }
        }
    }
}