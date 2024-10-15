package com.example.compose.rally.app5.models

data class Customer(
    val customerId: String,
    val customerName: String,
    val isClick: Boolean,
    var isPresent: Boolean?,
    val lans: List<Any>,
    var reason: String?
)