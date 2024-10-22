package com.example.jetpackcomposeuidesigns.code_testing.junit_testing_file

object RegistrationUtil {

    val users = listOf("Mohit", "Akshay")

    fun registerUser(
        username : String,
        password : String,
        confirmedPassword : String
    ) : Boolean {
        if (username.isEmpty()) return false
        if (password.isEmpty() || confirmedPassword.isEmpty()) return false
        if (users.contains(username)) return false
        if (password != confirmedPassword) return false
        if (password.count { it.isDigit() } < 2) return false

        return true
    }

}