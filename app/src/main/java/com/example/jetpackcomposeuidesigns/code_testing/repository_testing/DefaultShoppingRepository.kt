package com.example.jetpackcomposeuidesigns.code_testing.repository_testing

import androidx.lifecycle.LiveData
import com.example.jetpackcomposeuidesigns.code_testing.retrofit_testing.PostAPI
import com.example.jetpackcomposeuidesigns.code_testing.retrofit_testing.Posts
import com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files.ShoppingDao
import com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files.ShoppingItem
import com.example.jetpackcomposeuidesigns.other.Resource
import javax.inject.Inject

class DefaultShoppingRepository @Inject constructor(
    private val shoppingDao: ShoppingDao,
    private val postAPI: PostAPI
) : Repository {

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.insertShoppingItem(shoppingItem)
    }

    override suspend fun updateShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.updateShoppingItem(shoppingItem)
    }

    override suspend fun deleteShoppingItem(shoppingItem: ShoppingItem) {
        shoppingDao.deleteShoppingItem(shoppingItem)
    }

    override fun observeAllShoppingItems(): LiveData<List<ShoppingItem>> {
        return shoppingDao.observeAllShoppingItems()
    }

    override fun observeTotalPrice(): LiveData<Float> {
        return shoppingDao.observeTotalPrice()
    }

    override suspend fun getAllPosts(): Resource<Posts> {
        return try {
            val result = postAPI.getAllPosts()
            if (result.isSuccessful) {
                result.body()?.let {
                    return@let Resource.success(it)
                } ?: Resource.error("Couldn't get the data", null)
            }else {
                Resource.error("Couldn't get the data", null)
            }
        }catch (e : Exception) {
            Resource.error("Couldn't reach the server, Please check you internet connection", null)
        }
    }

}