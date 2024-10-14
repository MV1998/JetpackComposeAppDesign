package com.example.compose.rally.app3.mock

import android.content.Context

class UserService(private val userRepository: UserRepository) {

    fun loginUser(username: String, password: String): String {
        val status = userRepository.loginUser(username, password)
        return when (status) {
            LOGIN_STATUS.INVALID_USER -> "User does not exists."
            LOGIN_STATUS.INVALID_PASSWORD -> "Password is invalid."
            LOGIN_STATUS.UNKNOWN_ERROR -> "Unknown Error."
            LOGIN_STATUS.SUCCESS -> "Logged in successfully."
        }
    }

    fun add(num1 : Int, num2 : Int) : Int {
       return userRepository.add(num1, num2)
    }

    fun getOutput(context: Context, fileName: String) : String {
        return userRepository.getJson(context, fileName)
    }
}