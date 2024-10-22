package com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.selection.toggleable
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class MultiHeaderViewModel(
    val id: Int,
    val name: String,
    val type: String
)

val listOfMultiHeader = listOf(
    MultiHeaderViewModel(1, "Lion", "Animal"),
    MultiHeaderViewModel(2, "Horse", "Animal"),
    MultiHeaderViewModel(3, "Dog", "Animal"),
    MultiHeaderViewModel(4, "Cat", "Animal"),
    MultiHeaderViewModel(5, "Watch", "Goods"),
    MultiHeaderViewModel(6, "Bottle", "Goods"),
    MultiHeaderViewModel(7, "Laptop", "Goods"),
    MultiHeaderViewModel(8, "Bag", "Goods"),
    MultiHeaderViewModel(9, "Water ", "Drinks"),
    MultiHeaderViewModel(10, "Thumbs Up", "Drinks"),
    MultiHeaderViewModel(11, "Coca Cola", "Drinks"),
    MultiHeaderViewModel(12, "Maja", "Drinks"),

    )

@Composable
fun MultiHeaderView(modifier: Modifier = Modifier) {
    val groupedByType = listOfMultiHeader.groupBy { it.type }
    val isOpen = remember {
        mutableStateMapOf<String, Boolean>()
    }
    Surface(modifier = modifier.fillMaxSize()) {
        Box(modifier = modifier.fillMaxSize()) {
            Row(modifier = modifier.fillMaxSize()) {
                Spacer(
                    modifier = modifier
                        .fillMaxHeight()
                        .weight(3f)
                        .background(color = Color.Red)
                )
                Spacer(
                    modifier = modifier
                        .fillMaxHeight()
                        .weight(1f)
                        .background(color = Color.Yellow)
                )
            }

            LazyColumn(modifier = modifier.fillMaxSize()) {
                groupedByType.forEach { (type, items) ->
                    item {
                        Row(
                            modifier = modifier
                                .fillMaxWidth()
                                .padding(horizontal = 10.dp)
                                .toggleable(
                                    role = Role.Button,
                                    value = isOpen[type] == true,
                                    onValueChange = {
                                        isOpen[type] = it
                                    }
                                ),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                type, style = TextStyle(fontSize = 18.sp, color = Color.Black),
                                fontWeight = FontWeight.Bold
                            )
                            IconButton(onClick = {
                                // isOpen[type] = isOpen[type] != true
                            }) {
                                Icon(
                                    if (isOpen[type] == true)
                                        Icons.Default.KeyboardArrowDown
                                    else Icons.Default.KeyboardArrowUp,
                                    contentDescription = "arrow-up"
                                )
                            }
                        }
                    }
                    if (isOpen[type] == true) {
                        items(items) { item ->
                            Text(
                                item.name, modifier = modifier.padding(
                                    horizontal = 10.dp,
                                    vertical = 2.dp
                                ), style = TextStyle(fontSize = 14.sp, color = Color.Black)
                            )
                        }
                    }
                }
            }
        }
    }
}
