package com.example.jetpackcomposeuidesigns.daily_ui_designs.landing_profile_app

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CastForEducation
import androidx.compose.material.icons.filled.KeyboardDoubleArrowRight
import androidx.compose.material.icons.filled.ProductionQuantityLimits
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuidesigns.R
import com.example.jetpackcomposeuidesigns.ui.theme.JetpackComposeUIDesignsTheme

@Composable
fun ProfilePage(
    onClickBack: () -> Unit,
    navigateToAccountSetting: () -> Unit,
    modifier: Modifier = Modifier
) {

    Surface(
        color = Color(0xffF5F5F5),
        modifier = modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DemoAppBar(onClickBack = onClickBack, "Profile")

            PersonDesignationSection(
                R.drawable.profile_person,
                "Exodus Trivellan",
                "Product Manager"
            )

            Row(
                modifier = modifier
                    .padding(top = 40.dp)
                    .fillMaxWidth()
            ) {
                Statistic(
                    "28",
                    "Applied",
                    modifier = modifier.weight(.3f)
                )
                Statistic(
                    "78",
                    "Reviewed",
                    modifier = modifier.weight(.3f)
                )
                Statistic(
                    "16",
                    "Contacted",
                    modifier = modifier.weight(.3f)
                )
            }

            CompleteProfileSection("Complete Profile")

            Spacer(
                modifier = modifier
                    .padding(horizontal = 20.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
            )


            Row(
                modifier = modifier
                    .padding(top = 10.dp)
                    .clickable {
                        navigateToAccountSetting()
                    }
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "Account Setting", style =
                    TextStyle(
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                )
                Icon(
                    Icons.Default.Settings, contentDescription = null,
                    tint = Color.Black
                )
            }

            Spacer(
                modifier = modifier
                    .padding(top = 10.dp)
                    .padding(horizontal = 20.dp)
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Color.LightGray)
            )
        }


    }
}

@Composable
fun Statistic(
    number: String,
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            number, style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                baselineShift = BaselineShift(.2f)
            )
        )
        Text(
            text, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        )
    }
}

@Composable
fun CompleteProfileSection(
    text: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(30.dp)
    ) {
        Text(
            text, style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                color = Color.Black,
                baselineShift = BaselineShift(.5f)
            )
        )
        Row {
            CompleteProfileSectionPart(
                "Education",
                "03 Steps Left",
                Color(0xffCAFB5C),
                imageVector = Icons.Filled.CastForEducation,
                modifier = Modifier
                    .weight(.5f)
                    .padding(end = 5.dp)
            )
            CompleteProfileSectionPart(
                "Professional",
                "04 Steps Left",
                Color(0xFF9C9DF3),
                imageVector = Icons.Filled.ProductionQuantityLimits,
                modifier = Modifier
                    .weight(.5f)
                    .padding(start = 5.dp)
            )
        }
    }
}

@Composable
fun CompleteProfileSectionPart(
    text: String,
    subText: String,
    color: Color,
    imageVector: ImageVector,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .height(150.dp)
            .background(color = color, shape = RoundedCornerShape(10.dp)),
        horizontalAlignment = Alignment.Start
    ) {
        Icon(
            imageVector, contentDescription = text,
            Modifier
                .height(50.dp)
                .width(50.dp)
                .padding(10.dp),
            tint = Color.Black
        )
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text, modifier = modifier.padding(start = 10.dp),
            style = TextStyle(
                color = Color.Black
            )
        )
        Text(
            subText, style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black,
                baselineShift = BaselineShift(.4f)
            ),
            modifier = modifier.padding(start = 10.dp)
        )
        Icon(
            Icons.Filled.KeyboardDoubleArrowRight, contentDescription = text,
            modifier = modifier.padding(start = 10.dp, bottom = 10.dp),
            tint = Color.Black
        )
    }
}

@Preview
@Composable
private fun CompleteProfileSectionPartPreview() {
    CompleteProfileSectionPart(
        "Education", "03 Steps Left", Color(0xffCAFB5C),
        imageVector = Icons.Filled.CastForEducation
    )
}

@Preview
@Composable
private fun ProfilePagePreview() {
    JetpackComposeUIDesignsTheme {
        ProfilePage(onClickBack = {}, navigateToAccountSetting = {})
    }
}
