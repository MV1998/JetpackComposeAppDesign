package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.usecase.product_usecase

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Product
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.ProductRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddProductUseCase @Inject constructor(private val productRepository: ProductRepository) {
    suspend fun execute(product: Product) {
        productRepository.insertProduct(product)
    }
}