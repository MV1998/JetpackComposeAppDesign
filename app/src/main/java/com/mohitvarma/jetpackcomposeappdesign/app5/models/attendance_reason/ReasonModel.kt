package com.example.compose.rally.app5.models.attendance_reason

data class ReasonModel(
    val AttendanceAbsentReasonsList: List<AttendanceAbsentReasons>,
    val errorCode: Int,
    val errorMessage: String
)
