package com.example.compose.rally.app5.models

import androidx.compose.runtime.snapshots.SnapshotStateList

data class Group(
    val customers: SnapshotStateList<Customer>,
    val groupDue: Int,
    val groupId: String,
    val groupName: String,
    val noOfCustomers: Int,
    var isExpanded : Boolean = false,
    val noOfLans: Int
)