package com.example.jetpackcomposeuidesigns.daily_ui_designs.landing_profile_app

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposeuidesigns.R

@Composable
fun PersonDesignationSection(
    @DrawableRes imageId: Int,
    name: String,
    designation: String,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(imageId), name,
            modifier = modifier
                .padding(top = 20.dp)
                .height(100.dp)
                .width(100.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            name, style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                baselineShift = BaselineShift(.5f)
            ),
            modifier = modifier.padding(top = 20.dp)
        )
        Text(
            designation, style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black
            )
        )
    }
}

@Preview
@Composable
private fun ProfileSectionPreview() {
    PersonDesignationSection(
        R.drawable.profile_person,
        "Exodus Trivellan",
        "Product Manager"
    )
}