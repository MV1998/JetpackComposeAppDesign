package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities.ProductEntity
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.ui.screens.productaddedit.ProductAddEditUiState

data class Product(
    val id : Int = 0,
    val reportId: Int = 0,
    val name: String = "",
    val purchaseCost: Double = 0.0,
    val sellingCost: Double = 0.0,
    val transportCost: Double = 0.0,
    val quantitySold: Double = 0.0,
    val totalRevenue: Double = 0.0,
    val totalProfit: Double = 0.0
)

fun Product.toProductEntity() : ProductEntity {
    return ProductEntity(
        id = this.id,
        reportId = this.reportId,
        name = this.name,
        purchaseCost = this.purchaseCost,
        sellingCost = this.sellingCost,
        transportCost = this.transportCost,
        quantitySold = this.quantitySold,
        totalRevenue = this.totalRevenue,
        totalProfit = this.totalProfit
    )
}

fun Product.toProductUiState(): ProductAddEditUiState {
    return ProductAddEditUiState(
        name = this.name,
        purchaseCost = this.purchaseCost.toString(),
        sellingCost = this.sellingCost.toString(),
        transportCost = this.transportCost.toString(),
        quantitySold = this.quantitySold.toString(),
        totalRevenue = this.totalRevenue.toString(),
        totalProfit = this.totalProfit.toString()
    )
}