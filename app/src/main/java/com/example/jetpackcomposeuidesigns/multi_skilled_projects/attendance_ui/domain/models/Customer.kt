package com.example.jetpackcomposeuidesigns.multi_skilled_projects.attendance_ui.domain.models

data class Customer(
    val customerId: String,
    val customerName: String,
    val isClick: Boolean,
    var isPresent: Boolean?,
    val lans: List<Any>,
    var reason: String?
)