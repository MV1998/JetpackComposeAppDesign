package com.example.compose.rally.app3.mock

data class User(
    val id : Int,
    val name : String,
    val username : String,
    val password : String
)


enum class LOGIN_STATUS {
    INVALID_USER,
    INVALID_PASSWORD,
    UNKNOWN_ERROR,
    SUCCESS
}