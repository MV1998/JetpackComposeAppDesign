package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.repository

import android.icu.util.Calendar
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.dao.ReportDAO
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities.toReport
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.toReportEntity
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.ReportRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ReportRepositoryImpl @Inject constructor(private val reportDAO: ReportDAO) : ReportRepository {

    override suspend fun insertReport(report: Report) {
        reportDAO.insertReport(report.toReportEntity())
    }

    override suspend fun updateReport(report: Report) {
        reportDAO.updateReport(report.toReportEntity())
    }

    override suspend fun upsertReport(report: Report) {
        reportDAO.upsertReport(report.toReportEntity())
    }

    override suspend fun deleteReport(report: Report) {
        reportDAO.deleteReport(report.toReportEntity())
    }

    override suspend fun deleteReportById(reportId: Int) {
        reportDAO.deleteReportById(reportId)
    }

    override suspend fun deleteProductByReportId(reportId: Int) {
        reportDAO.deleteProductByReportId(reportId)
    }

    override fun getAllReport(): Flow<List<Report>> {
        return reportDAO.getAllReport().map {
            it.map { reportEntity ->
                reportEntity.toReport()
            }
        }
    }

}