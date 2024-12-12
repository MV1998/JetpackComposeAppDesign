package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository

import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import kotlinx.coroutines.flow.Flow

interface ReportRepository {
    suspend fun insertReport(report: Report)
    suspend fun updateReport(report: Report)
    suspend fun upsertReport(report: Report)
    suspend fun deleteReport(report: Report)
    suspend fun deleteReportById(reportId: Int)
    suspend fun deleteProductByReportId(reportId: Int)
    fun getAllReport() : Flow<List<Report>>
}