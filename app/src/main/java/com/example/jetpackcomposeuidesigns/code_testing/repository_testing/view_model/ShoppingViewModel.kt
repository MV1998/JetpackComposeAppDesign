package com.example.jetpackcomposeuidesigns.code_testing.repository_testing.view_model

import androidx.compose.ui.unit.Constraints
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeuidesigns.code_testing.repository_testing.Repository
import com.example.jetpackcomposeuidesigns.code_testing.room_database_testing_files.ShoppingItem
import com.example.jetpackcomposeuidesigns.other.Constants
import com.example.jetpackcomposeuidesigns.other.Resource
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShoppingViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {


    private val _insertShoppingItemStatus = MutableLiveData<Resource<ShoppingItem>>()
    val insertShoppingItemStatus = _insertShoppingItemStatus

    private fun insertShoppingItem(shoppingItem: ShoppingItem) = viewModelScope.launch {
        repository.insertShoppingItem(shoppingItem)
    }

    fun insertShoppingItemDB(name : String, amount : String, price : String) {

        if (name.isEmpty() || amount.isEmpty() || price.isEmpty()) {
            insertShoppingItemStatus.postValue(Resource.error("Fields should not be empty", null))
            return
        }

        if (amount.length > Constants.MAX_AMOUNT_LENGTH) {
            insertShoppingItemStatus.postValue(Resource.error("Amount length should be less than ${Constants.MAX_AMOUNT_LENGTH} characters", null))
            return
        }

        if (price.length > Constants.MAX_AMOUNT_LENGTH) {
            insertShoppingItemStatus.postValue(Resource.error("Price length should be less than ${Constants.MAX_PRICE_LENGTH} characters", null))
            return
        }

        val amt : Int = try {
            amount.toInt()
        }catch (e : Exception) {
            insertShoppingItemStatus.postValue(Resource.error("Price length should be less than ${Constants.MAX_PRICE_LENGTH} characters", null))
            return
        }

        val shoppingItem = ShoppingItem(name, amount = amt, price = price.toFloat(), imageUrl = "")
        insertShoppingItem(shoppingItem)
        insertShoppingItemStatus.postValue(Resource.success(shoppingItem))
    }

}