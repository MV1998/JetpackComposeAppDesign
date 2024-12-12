package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.usecase.product_usecase

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CalculateTotalProfitUseCase @Inject constructor() {
    fun execute(
        totalRevenue: Double,
        purchaseCost: Double,
        transportCost: Double,
        quantitySold: Double
    ): Double {
        return (totalRevenue - ((purchaseCost + transportCost) * quantitySold))
    }
}