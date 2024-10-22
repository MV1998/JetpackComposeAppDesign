package com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    val name : String,
    val amount : Int,
    val price : Float,
    var imageUrl : String,
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null
)