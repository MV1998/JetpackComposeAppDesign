package com.example.jetpackcomposeuidesigns.code_testing.retrofit_testing

data class Posts(
    val limit: Int,
    val posts: List<Post>,
    val skip: Int,
    val total: Int
)