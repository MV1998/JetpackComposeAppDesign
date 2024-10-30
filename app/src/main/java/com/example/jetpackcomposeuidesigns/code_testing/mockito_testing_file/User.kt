package com.example.jetpackcomposeuidesigns.code_testing.mockito_testing_file

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