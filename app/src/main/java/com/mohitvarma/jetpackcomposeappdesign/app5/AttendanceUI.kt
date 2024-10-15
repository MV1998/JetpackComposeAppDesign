package com.example.compose.rally.app5

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.toSize
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.compose.rally.app5.models.Customer
import com.example.compose.rally.app5.models.Group
import com.example.compose.rally.app5.models.attendance_reason.AttendanceAbsentReasons
import com.example.compose.rally.app5.view_model.AttendanceViewModel

val customerHeaderUITextStyle = TextStyle(
    color = Color.Gray
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AttendanceUI(modifier: Modifier = Modifier) {
    val attendanceViewModel = viewModel<AttendanceViewModel>()
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("Attendance") }
        )
    }, bottomBar = {
        Button(
            onClick = {}, enabled = attendanceViewModel.validate, modifier = modifier
                .fillMaxWidth()
                .navigationBarsPadding()
        ) { Text("Submit") }
    }) { padding ->
        Surface(modifier = modifier.padding(padding)) {
            AttendanceMainComponent(
                attendanceViewModel.attendance,
                attendanceViewModel.reasons,
                onGroupClick = { index, group ->
                    attendanceViewModel.onGroupClick(groupIndex = index, group = group)
                },
                onPresentAbsentClick = { index, customerIndex, customer, isPresent ->
                    attendanceViewModel.onPresentAbsentClick(
                        index,
                        customerIndex,
                        customer,
                        isPresent
                    )
                },
                onSpinnerHideAndShowClick = { index, customerIndex, customer, spinnerShouldShow ->
                    attendanceViewModel.onSpinnerHideAndShowClick(
                        index,
                        customerIndex,
                        customer,
                        spinnerShouldShow
                    )
                },
                onDropDownMenuItemClick = { index, customerIndex, customer, reason ->
                    attendanceViewModel.onDropDownMenuItemClick(
                        index,
                        customerIndex,
                        customer,
                        reason
                    )
                })
        }
    }
}


@Composable
fun AttendanceMainComponent(
    attendance: SnapshotStateList<Group>,
    reasons: List<AttendanceAbsentReasons>,
    onGroupClick: (Int, Group) -> Unit,
    onPresentAbsentClick: (Int, Int, Customer, Boolean) -> Unit,
    onSpinnerHideAndShowClick: (Int, Int, Customer, Boolean) -> Unit,
    onDropDownMenuItemClick: (Int, Int, Customer, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val mTextFieldSize = remember { mutableStateOf(Size.Zero) }

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
                    GroupHeaderUI(
                        group = group, onGroupClick = { onGroupClick(index, group) },
                        isOpen = group.isExpanded
                    )
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

                                PresentView(
                                    customer,
                                    modifier = modifier
                                        .weight(1f)
                                        .clickable {
                                            onPresentAbsentClick(
                                                index,
                                                customerIndex,
                                                customer,
                                                true
                                            )
                                        }
                                )

                                AbsentView(
                                    customer,
                                    modifier = modifier
                                        .weight(1f)
                                        .clickable {
                                            onPresentAbsentClick(
                                                index,
                                                customerIndex,
                                                customer,
                                                false
                                            )
                                        }
                                )
                            }
                            if (customer.isPresent == false) {
                                AbsentReasonView(
                                    reasons,
                                    mTextFieldSize,
                                    index,
                                    customerIndex,
                                    customer,
                                    onSpinnerHideAndShowClick,
                                    onDropDownMenuItemClick
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
fun PresentView(
    customer: Customer,
    modifier: Modifier = Modifier
) {
    Icon(
        if (customer.isPresent == null || customer.isPresent == false)
            Icons.Outlined.Circle
        else Icons.Default.CheckCircle, contentDescription = "Present",
        tint = if (customer.isPresent == null || customer.isPresent == false) Color.Gray
        else Color(0xff00B601),
        modifier = modifier
    )
}

@Composable
fun AbsentView(
    customer: Customer,
    modifier: Modifier = Modifier
) {
    Icon(
        if (customer.isPresent == null || customer.isPresent == true) Icons.Outlined.Circle
        else Icons.Default.CheckCircle,
        contentDescription = "Absent",
        tint = if (customer.isPresent == null || customer.isPresent == true) Color.Gray
        else Color.Red, modifier = modifier
    )
}

@Composable
fun AbsentReasonView(
    reasons: List<AttendanceAbsentReasons>,
    mTextFieldSize: MutableState<Size>,
    groupIndex: Int,
    customerIndex: Int,
    customer: Customer,
    onSpinnerHideAndShowClick: (Int, Int, Customer, Boolean) -> Unit,
    onDropDownMenuItemClick: (Int, Int, Customer, String) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier
        .fillMaxWidth()
        .onGloballyPositioned { coordinates ->
            mTextFieldSize.value = coordinates.size.toSize()
        }
        .padding(10.dp)
        .border(
            1.dp,
            color = Color.Black,
            shape = RoundedCornerShape(10.dp)
        )
        .clickable {
            onSpinnerHideAndShowClick(
                groupIndex,
                customerIndex,
                customer,
                true
            )
        },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            if (!customer.reason.isNullOrEmpty()) customer.reason!!
            else "Select Reason", modifier = modifier.padding(10.dp)
        )
        Icon(
            Icons.Default.KeyboardArrowUp, contentDescription = "",
            tint = Color.Red, modifier = modifier.padding(end = 20.dp)
        )
    }
    DropdownMenu(
        expanded = customer.isClick,
        modifier = modifier.width(with(LocalDensity.current) { mTextFieldSize.value.width.toDp() }),
        onDismissRequest = {
            onSpinnerHideAndShowClick(
                groupIndex,
                customerIndex,
                customer,
                false
            )
        }
    ) {
        reasons.forEach { absentReasons ->
            DropdownMenuItem(onClick = {
                onDropDownMenuItemClick(
                    groupIndex,
                    customerIndex,
                    customer,
                    absentReasons.absentReason
                )
            }, text = {Text(absentReasons.absentReason)})
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

@Preview
@Composable
private fun AttendanceUIPreview() {
    AttendanceUI()
}