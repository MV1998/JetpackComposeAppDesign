package com.example.compose.rally.app5

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import com.example.compose.rally.app5.models.Attendance
import com.example.compose.rally.app5.models.Group
import com.google.gson.Gson


data class MultiHeaderViewModel(
    val id: Int,
    val name: String,
    val type: String
)

val customerHeaderUITextStyle = TextStyle(
    color = Color.Gray
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

val attendance = Gson().fromJson(LocalDB.jsonData, Attendance::class.java)

@Composable
fun AttendanceUI(modifier: Modifier = Modifier) {
    AttendanceMainComponent(
        attendance.groups.toMutableStateList()
    )

}

@Composable
fun AttendanceMainComponent(
    attendance: SnapshotStateList<Group>,
    modifier: Modifier = Modifier
) {
    Log.d("TAG", "AttendanceMainComponent: Recomposition")

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(color = Color(0xffD6DAE6))
    ) {
        GroupUI()
        LazyColumn(
            modifier = modifier
                .padding(top = 10.dp)
                .fillMaxSize()
                .background(color = Color.White)
                .padding(10.dp)
        ) {
            attendance.forEachIndexed { index, group ->
                item {
                    GroupHeaderUI(group = group, onGroupClick = {
                        attendance[index] = group.copy(isExpanded = !group.isExpanded)
                    }, isOpen = group.isExpanded)
                }
                if (group.isExpanded) {
                    item {
                        CustomerHeaderUI()
                    }

                    itemsIndexed(
                        group.customers,
                        key = { _, customer -> customer.customerId }) { customerIndex, customer ->
                        Column(modifier = modifier.fillMaxWidth()) {
                            Row(modifier = modifier.padding(horizontal = 10.dp, vertical = 5.dp)) {
                                Text(
                                    customer.customerName, modifier.weight(2f),
                                    style = TextStyle(
                                        color = Color.Black,
                                        fontWeight = FontWeight.Bold
                                    )
                                )
                                Text(
                                    customer.customerId, modifier.weight(1f),
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    if (customer.isPresent == null || customer.isPresent == false)
                                        Icons.Outlined.Circle
                                    else Icons.Default.CheckCircle, contentDescription = "Present",
                                    tint = if (customer.isPresent == null || customer.isPresent == false) Color.Gray
                                    else Color(0xff00B601), modifier = modifier
                                        .weight(1f)
                                        .clickable {
                                            Log.d(
                                                "TAG",
                                                "AttendanceMainComponent: Present Before $customer"
                                            )
                                            if (customer.isPresent == null) {
                                                attendance[index].customers[customerIndex] =
                                                    customer.copy(isPresent = true)
                                                Log.d(
                                                    "TAG",
                                                    "AttendanceMainComponent: Present After ${attendance[index].customers[customerIndex]}"
                                                )
                                                return@clickable
                                            }
                                            attendance[index].customers[customerIndex] =
                                                customer.copy(isPresent = true)
                                            Log.d(
                                                "TAG",
                                                "AttendanceMainComponent: Present After ${attendance[index].customers[customerIndex]}"
                                            )
                                        }
                                )

                                Icon(
                                    if (customer.isPresent == null || customer.isPresent == true) Icons.Outlined.Circle
                                    else Icons.Default.CheckCircle,
                                    contentDescription = "Absent",
                                    tint = if (customer.isPresent == null || customer.isPresent == true) Color.Gray
                                    else Color.Red, modifier = modifier
                                        .weight(1f)
                                        .clickable {
                                            Log.d(
                                                "TAG",
                                                "AttendanceMainComponent: Absent Before $customer"
                                            )
                                            if (customer.isPresent == null) {
                                                attendance[index].customers[customerIndex] =
                                                    customer.copy(isPresent = false)
                                                Log.d(
                                                    "TAG",
                                                    "AttendanceMainComponent: Absent After ${attendance[index].customers[customerIndex]}"
                                                )
                                                return@clickable
                                            }
                                            attendance[index].customers[customerIndex] =
                                                customer.copy(isPresent = false)
                                            Log.d(
                                                "TAG",
                                                "AttendanceMainComponent: Absent After ${attendance[index].customers[customerIndex]}"
                                            )
                                        }
                                )
                            }
                            if (customer.isPresent == false) {
                                OutlinedTextField(
                                    value = "Select Reason",
                                    onValueChange = { },
                                    modifier = Modifier
                                        .padding(vertical = 5.dp, horizontal = 10.dp)
                                        .fillMaxWidth()
                                        .onGloballyPositioned { coordinates ->
                                            // This value is used to assign to
                                            // the DropDown the same width
                                            //  mTextFieldSize = coordinates.size.toSize()
                                        },
                                    trailingIcon = {
                                        Icon(Icons.Filled.KeyboardArrowUp,"contentDescription",
                                            Modifier.clickable {})
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun GroupUI(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(color = Color.White)
            .padding(10.dp)
            .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(6.dp))
            .padding(10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Group 1", style = TextStyle(
                fontSize = 28.sp,
                color = Color.Black
            )
        )
        Text(
            "Next Meeting : 2024-10-10", style = TextStyle(
                fontSize = 12.sp,
                color = Color.Gray
            )
        )
    }
}

@Composable
fun CustomerHeaderUI(modifier: Modifier = Modifier) {
    Row(
        modifier = modifier.padding(
            horizontal = 10.dp,
            vertical = 5.dp
        )
    ) {
        Text("Customer Name", modifier.weight(2f), style = customerHeaderUITextStyle)
        Text(
            "Cust ID",
            modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = customerHeaderUITextStyle
        )
        Text(
            "Present", modifier.weight(1f),
            textAlign = TextAlign.Center, style = customerHeaderUITextStyle
        )
        Text(
            "Absent", modifier.weight(1f),
            textAlign = TextAlign.Center, style = customerHeaderUITextStyle
        )
    }
}

@Composable
fun GroupHeaderUI(
    group: Group,
    onGroupClick: () -> Unit,
    isOpen: Boolean,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .toggleable(
                value = isOpen,
                onValueChange = {
                    onGroupClick()
                },
                role = Role.Button
            ),
        // .border(width = 1.dp, color = Color.LightGray, shape = RoundedCornerShape(6.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = modifier
                .background(color = Color.White)
                .padding(10.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                group.groupId, style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    color = Color.Black
                )
            )
            Text(
                group.groupName, style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Icon(
            if (isOpen) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
            contentDescription = "arrow-up",
            modifier = modifier.padding(end = 30.dp),
            tint = Color(0xffFA6A0B)
        )
    }
}

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
//            Canvas(modifier = modifier.fillMaxSize()) {
//                val height = size.height
//                val width = size.width
//                drawLine(
//                    color = Color.Red,
//                    start = Offset(0f, 0f),
//                    end = Offset(width, height)
//                )
//            }
//
//            Canvas(modifier = modifier.fillMaxSize()) {
//                val height = size.height
//                val width = size.width
//                drawLine(
//                    color = Color.Red,
//                    start = Offset(0f, height),
//                    end = Offset(width, 0f)
//                )
//            }

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


@Preview
@Composable
private fun MultiHeaderViewPreview() {
    //MultiHeaderView()
    AttendanceUI()
}