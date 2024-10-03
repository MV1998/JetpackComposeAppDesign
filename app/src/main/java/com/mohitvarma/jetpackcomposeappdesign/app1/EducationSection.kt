package com.mohitvarma.jetpackcomposeappdesign.app1

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class Education(
    val year: String,
    val degree: String,
    val university: String,
    val address: String,
    val note: String
)

@Composable
fun EducationSection(
    education: Education = Education(
        year = "2008 - 2010",
        degree = "Master of Computer Science",
        university = "UNIVERSITY OF NORTH CAROLINA",
        address = "North Carolina, USA",
        note = "Duis aute irure dolor in reprehenderit in vol patate velit esse cillum dolore eu fugiat nulla pari. Excepteur sint occana inna tecat cupidatat non proident."
    ), modifier: Modifier = Modifier
) {
    Surface(color = Color.White) {
        Column(modifier = modifier) {
            Text(
                education.year, style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 18.sp
                )
            )
            Text(
                education.degree,
                modifier = modifier.padding(top = 10.dp)
            )
            Row(
                modifier = modifier.padding(top = 20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(
                    modifier = modifier
                        .height(10.dp)
                        .width(10.dp)
                        .background(color = Color.Black, shape = CircleShape)
                )
                HorizontalDivider(
                    modifier = modifier.padding(start = 5.dp),
                    thickness = 1.dp, color = Color.Gray
                )
            }
            Text(
                education.university,
                modifier = modifier.padding(top = 20.dp),
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            )
            Text(
                education.address,
                modifier = modifier.padding(top = 5.dp)
            )
            Text(
                education.note,
                modifier = modifier.padding(top = 15.dp),
                style = TextStyle(
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal,
                    fontSize = 14.sp
                )
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun EducationSectionPreview() {
    EducationSection()
}