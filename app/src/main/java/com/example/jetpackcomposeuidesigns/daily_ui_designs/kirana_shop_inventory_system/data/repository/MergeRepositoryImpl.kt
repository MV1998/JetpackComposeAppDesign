package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.repository

import android.util.Log
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.dao.ReportDAO
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.data.local.entities.toReport
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.MergeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MergeRepositoryImpl @Inject constructor(private val reportDAO: ReportDAO) : MergeRepository {
    override fun getReportsExcludingById(reportId: Int): Flow<List<Report>> {
        Log.d("TAG", "getReportsExcludingById: $reportId")
        return reportDAO.getReportsExcludingById(reportId).map {
            it.map { reportEntity ->
                reportEntity.toReport()
            }
        }
    }

    override suspend fun mergeRepository(toReportId: Int, fromReportId: Int) {
        reportDAO.mergeRepository(toReportId, fromReportId)
    }

}