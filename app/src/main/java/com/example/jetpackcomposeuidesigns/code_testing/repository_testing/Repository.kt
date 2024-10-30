package com.example.jetpackcomposeuidesigns.code_testing.repository_testing

import androidx.lifecycle.LiveData
import com.example.jetpackcomposeuidesigns.code_testing.retrofit_testing.Posts
import com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files.ShoppingItem
import com.example.jetpackcomposeuidesigns.other.Resource
import retrofit2.Response

interface Repository {

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    suspend fun updateShoppingItem(shoppingItem: ShoppingItem)

    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    fun observeAllShoppingItems() : LiveData<List<ShoppingItem>>

    fun observeTotalPrice() : LiveData<Float>

    suspend fun getAllPosts() : Resource<Posts>

}