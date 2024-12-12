package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.ui.screens.reports

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.ReportRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

@HiltViewModel
class ReportViewModel @Inject constructor(private val reportRepository: ReportRepository) :
    ViewModel() {

    private val _reportList = MutableStateFlow(mutableListOf<Report>())
    val reportList = _reportList.asStateFlow()

    init {
        fetchReports()
    }

    private fun fetchReports() {
        viewModelScope.launch {
            reportRepository.getAllReport().collect {
                _reportList.value = it.toMutableList()
            }
        }
    }

    fun addNewReport(date: Date?) {
        date?.let {
            viewModelScope.launch {
                reportRepository.insertReport(
                    Report(
                        createdAt = date,
                        modifiedAt = date,
                        totalProfit = 0.0,
                        totalRevenue = 0.0
                    )
                )
            }
        }
    }

    fun deleteReport(reportId: Int) {
        viewModelScope.launch {
            reportRepository.deleteProductByReportId(reportId = reportId)
            reportRepository.deleteReportById(reportId = reportId)
        }
    }

    fun updateReport() {

    }
}