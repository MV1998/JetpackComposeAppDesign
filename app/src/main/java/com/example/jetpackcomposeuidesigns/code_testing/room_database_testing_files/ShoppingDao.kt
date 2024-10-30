package com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

// all the test cases have been written so that we can test
// there functions are working as expected.

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

    @Update
    suspend fun updateShoppingItem(shoppingItem: ShoppingItem)

    @Delete
    suspend fun deleteShoppingItem(shoppingItem: ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun observeAllShoppingItems() : LiveData<List<ShoppingItem>>

    @Query("SELECT SUM(price * amount) FROM shopping_items")
    fun observeTotalPrice() : LiveData<Float>

}