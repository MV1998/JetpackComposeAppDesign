package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities

import android.icu.util.Calendar
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import java.util.Date

@Entity(tableName = "reports")
data class ReportEntity(
    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    @ColumnInfo(name = "report_name")
    val name: String = "",

    @ColumnInfo(name = "createdAt")
    val createdAt: Date = Date(),

    @ColumnInfo(name = "modifiedAt")
    val modifiedAt : Date = Date(),

    @ColumnInfo(name = "modifiedBy")
    val modifiedBy : String = "",

    @ColumnInfo(name = "grand_total_revenue")
    var grandTotalRevenue : Double,

    @ColumnInfo(name = "grand_total_profit")
    var grandTotalProfit : Double,

    @ColumnInfo(name = "month")
    val month : Int = Calendar.getInstance().get(Calendar.MONTH)
)

fun ReportEntity.toReport() : Report {
    return Report(
        id = this.id,
        name = this.name,
        createdAt = this.createdAt,
        modifiedAt = this.modifiedAt,
        modifiedBy = this.modifiedBy,
        totalRevenue = this.grandTotalRevenue,
        totalProfit = this.grandTotalProfit
    )
}