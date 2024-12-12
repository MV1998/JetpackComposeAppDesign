package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.ui.screens.productaddedit

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Product

data class ProductAddEditUiState(
    val name: String = "",
    val reportId: Int = 0,
    val purchaseCost: String = "",
    val sellingCost: String = "",
    val transportCost: String = "",
    val quantitySold: String = "",
    val totalRevenue: String = "",
    val totalProfit: String = "",
    val productAction: ProductAction = ProductAction.ADD
)

fun ProductAddEditUiState.toProduct(): Product {
    return Product(
        name = this.name,
        reportId = this.reportId,
        purchaseCost = this.purchaseCost.toDoubleOrNull() ?: 0.0,
        sellingCost = this.sellingCost.toDoubleOrNull() ?: 0.0,
        transportCost = this.transportCost.toDoubleOrNull() ?: 0.0,
        quantitySold = this.quantitySold.toDoubleOrNull() ?: 0.0,
        totalRevenue = this.totalRevenue.toDoubleOrNull() ?: 0.0,
        totalProfit = this.totalProfit.toDoubleOrNull() ?: 0.0
    )
}