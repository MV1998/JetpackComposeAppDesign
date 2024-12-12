package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Product
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import kotlinx.coroutines.flow.Flow

interface MergeRepository {
    fun getReportsExcludingById(reportId : Int) : Flow<List<Report>>
    suspend fun mergeRepository(toReportId: Int, fromReportId : Int)
}