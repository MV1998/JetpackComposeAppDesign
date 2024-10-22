package com.example.jetpackcomposeuidesigns.code_testing.retrofit_testing

import retrofit2.Response
import retrofit2.http.GET

interface PostAPI {

    @GET("/posts")
    suspend fun getAllPosts() : Response<Posts>

}