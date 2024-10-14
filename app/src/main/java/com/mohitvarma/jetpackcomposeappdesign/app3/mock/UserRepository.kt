package com.example.compose.rally.app3.mock

import android.content.Context

class UserRepository {

    private val users = listOf(
        User(1, "Mohit", "mohit@user.com", "135246"),
        User(2, "Ranjan", "ranjan@user.com", "654321"),
        User(3, "Rohan", "Rohan@user.com", "123456")
    )

    fun loginUser(username : String, password : String) : LOGIN_STATUS {
        val user = users.filter { it.username == username }

        return if (user.size == 1) {
            if (user[0].password == password) {
                LOGIN_STATUS.SUCCESS
            }else{
                LOGIN_STATUS.INVALID_PASSWORD
            }
        } else {
            LOGIN_STATUS.INVALID_USER
        }
    }

    fun add(num1 : Int, num2 : Int) : Int {
        return num1 + num2
    }

    fun getJson(context: Context, fileName : String) : String {
       val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size = size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        return json
    }
}