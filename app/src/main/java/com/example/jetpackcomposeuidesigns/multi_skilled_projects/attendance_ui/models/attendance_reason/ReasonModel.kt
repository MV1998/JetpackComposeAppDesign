package com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.models.attendance_reason

data class ReasonModel(
    val AttendanceAbsentReasonsList: List<AttendanceAbsentReasons>,
    val errorCode: Int,
    val errorMessage: String
)
