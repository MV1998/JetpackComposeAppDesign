package com.example.compose.rally.app5.models

import androidx.compose.runtime.snapshots.SnapshotStateList

data class Attendance(
    val centerId: String,
    val centerName: String,
    val errorCode: Any,
    val errorMessage: Any,
    val groups: SnapshotStateList<Group>,
    val lans: List<Any>,
    val nextMeetingDate: String
)