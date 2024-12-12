package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Product
import kotlinx.coroutines.flow.Flow

interface ProductRepository {
    suspend fun insertProduct(product: Product)
    suspend fun updateProduct(product: Product)
    suspend fun upsertProduct(product: Product)
    suspend fun deleteProduct(product: Product)
    suspend fun deleteProductById(productId: Int)
    fun getAllProduct() : Flow<List<Product>>
    fun getAllProductBasedOnReportId(id : Int) : Flow<List<Product>>
}