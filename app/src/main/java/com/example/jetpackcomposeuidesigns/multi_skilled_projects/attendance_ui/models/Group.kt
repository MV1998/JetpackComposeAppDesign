package com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.models

import androidx.compose.runtime.snapshots.SnapshotStateList
import com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.models.Customer

data class Group(
    val customers: SnapshotStateList<Customer>,
    val groupDue: Int,
    val groupId: String,
    val groupName: String,
    val noOfCustomers: Int,
    var isExpanded : Boolean = false,
    val noOfLans: Int
)