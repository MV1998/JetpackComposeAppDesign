package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities.ReportEntity
import java.util.Date

data class Report(
    val id: Int = 0,
    val name: String = "REPORT",
    val createdAt: Date = Date(),
    val modifiedAt : Date = Date(),
    val modifiedBy : String = "Mobile User",
    val totalRevenue : Double,
    val totalProfit : Double
)

fun Report.toReportEntity() : ReportEntity {
    return ReportEntity(
        id = this.id,
        name = this.name,
        createdAt = this.createdAt,
        modifiedAt = this.modifiedAt,
        modifiedBy = this.modifiedBy,
        grandTotalRevenue = this.totalRevenue,
        grandTotalProfit = this.totalProfit
    )
}