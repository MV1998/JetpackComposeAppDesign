package com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.ui.screens.merge_report

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.models.Report
import com.example.jetpackcomposeuidesigns.daily_ui_designs.kirana_shop_inventory_system.domain.repository.MergeRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

@HiltViewModel(assistedFactory = MergeScreenViewModel.MergeScreenViewModelFactory::class)
class MergeScreenViewModel @AssistedInject constructor(
    private val mergeRepository: MergeRepository,
    @Assisted private val toReportId: Int
) : ViewModel() {

    private val _reportList = MutableStateFlow(mutableListOf<Report>())
    val reportList = _reportList.asStateFlow()

    @AssistedFactory
    interface MergeScreenViewModelFactory {
        fun create(reportId: Int) : MergeScreenViewModel
    }

    init {
        fetchReports()
    }

    private fun fetchReports() {
        viewModelScope.launch {
            mergeRepository.getReportsExcludingById(toReportId).collect {
                _reportList.value = it.toMutableList()
            }
        }
    }

    fun mergeReport(fromReportId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            mergeRepository.mergeRepository(toReportId, fromReportId)
        }
    }
}