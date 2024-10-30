package com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ShoppingItem::class], version = 1, exportSchema = false)
abstract class ShoppingDatabase : RoomDatabase() {
    abstract fun shoppingDao() : ShoppingDao
}